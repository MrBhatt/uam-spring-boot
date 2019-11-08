# UAM (User Access Management) template using spring boot security, web and data-jpa
1. Download / clone repo
2. change database details in application.properties
3. `gradle bootRun` - this will also create a new database - based on the `spring.jpa.hibernate.ddl-auto` setting in application.prooerties (set as create-drop in this repo)
3. create a record in database for user (enter username, bcrypted password, add flags for enabled etc -refer to fields in User entity)

Testing results: 

1. Access `http://localhost:8080/v1/users` without any other authentication information - you should recieve 403 Forbidden http status code in response
2. Add basic authorization header (with the username and the decoded password(not in bcrypt format)) to your http request (using postman/curl etc). The request should succeed now (http status 200 OK)
