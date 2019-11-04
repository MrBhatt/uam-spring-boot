# UAM (User Access Management) scaffold using spring boot security, web and data-jpa

This branch (basic_auth) has scaffold for default basic auth which comes with spring security (activated automatically when spring-boot-starter-security dependency is added)

You will find UserController, UserService, User (model) and UserRepository to access details from database. The endpoints defined in the UserController are secured via basic auth strategy provided by Spring security.

*Uses gradle as build tool*

Download repo and `gradle bootRun`

**switch to db_authentication_jpa branch for authentication using database via spring-data-jpa**
