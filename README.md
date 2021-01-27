# cereb_Interview

## Starting the server
```
cd ./cereb-interview
./mvnw clean spring-boot:run
```

Initially two users would created, 
`GET /users`


```
[
    {
        "id": "8c00f966-4cb1-47d2-81db-583744756a26",
        "email": "test@test.ca",
        "password": "Abc123#"
    },
    {
        "id": "57af19eb-b8a8-4be4-ab1e-dcb5a5487aef",
        "email": "fds@fds.ss",
        "password": "sfdaH33"
    }
]
```

### User (`POST /users`)
Input JSON: 
  - email: String
  - password: String 
  
Given user's email and password as input and retrn the user signIn auth token as a UUID

#### Validation
EmailNotValidInput: Throw new EmailNotValidInput Expection when input email is not a valid email input

PasswordNotValidInput: Throw new PasswordNotValidInput Expection when there are validate the role od password input(at least 8 character, at least one upper/lower/number/special character)

UserNotFound: Throw new UserNotFound Expection when there email and password do not contain in the database


### UserSession ('POST /userSession)
Input JSON: 
  - from: String
  - to: String
 
Given two input of validate date, return the list of user session info within te given input date range

#### Validation
InputDateInvalid: throw this expection when the input date(from/to) is not a validate date format.

