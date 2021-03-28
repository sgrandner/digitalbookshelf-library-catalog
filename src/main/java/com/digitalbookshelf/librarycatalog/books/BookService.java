package com.digitalbookshelf.librarycatalog.books;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    private String authUser = "user";
    private String password = "password";
    private String hostName = "localhost";
    private String port = "27017";
    private String databaseName = "library-catalog";

    public String addBook(Book book) throws UnsupportedEncodingException {

        String passwordEncoded = "";
        try {
            passwordEncoded = URLEncoder.encode(password, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            // TODO logger
            throw new UnsupportedEncodingException(e.toString());   // TODO rethrow exception !?
        }

        String connectionString = "mongodb://" + authUser + ":" + passwordEncoded +
                "@" + hostName + ":" + port + "/" + databaseName;
        
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);

        MongoDatabase database = mongoClient.getDatabase("library-catalog");

        MongoCollection<Document> collection = database.getCollection("test");
        Document document = new Document();
        document.put("title", book.getTitle());
        document.put("author", book.getAuthor());
        collection.insertOne(document);

        mongoClient.close();

        return "";
    }
}
