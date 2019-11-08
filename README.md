# UAM (User Access Management) template using spring boot security, web and data-jpa

This is a template application based on Spring boot, web, data-jpa and spring security (deployable). 
The authentication uses `HTTP basic auth` which comes with spring security (activated automatically when spring-boot-starter-security dependency is added)

This works with users, groups and the corresponding authorities for the groups (think RBAC - groups as roles).

## Primary components
1. Controllers in the controller package
2. Service classes in the service package
3. JPA repositories in the repository package
4. Domain entities in the model package
5. application settings (like database to connect etc) in the application.properties file

The endpoints defined in the UserController are secured via basic auth strategy provided by Spring security. 

## Steps
1. Download / clone repo
2. change database details in application.properties
3. `gradle bootRun` - this will also create a new database - based on the `spring.jpa.hibernate.ddl-auto` setting in application.prooerties (set as create-drop in this repo)
3. create a record in database for user (enter username, bcrypted password, add flags for enabled etc -refer to fields in User entity)

## Testing results: 
1. Access `http://localhost:8080/v1/users` without any other authentication information - you should recieve 403 Forbidden http status code in response
2. Add basic authorization header (with the username and the decoded password(not in bcrypt format)) to your http request (using postman/curl etc). The request should succeed now (http status 200 OK)

## Remember
Once configured and executing succesfully as per created users, groups and authorities, remember to change the `spring.jpa.hibernate.ddl-auto` setting in application.properties to no recreate database on each run. That is only for development and testing purposes