db.auth('admin', 'password')

libraryCatalog = db.getSiblingDB('library-catalog')

libraryCatalog.createUser({
    user: 'user',
    pwd: 'password',
    roles: [
        {
            role: 'readWrite',
            db: 'library-catalog'
        }
    ]
})
