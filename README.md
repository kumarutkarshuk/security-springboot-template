# Spring Security JWT Template

## Features

- JWT-based authentication
- Authenticated home route: `/`
- Public routes: `/login`, `/register`
- Easy configuration via environment variables

## Prerequisites

- IntelliJ IDEA (or any Java-supporting IDE)
- Java JDK (or at least JRE) (if not bundled with your IDE)
- Maven (if not bundled with your IDE)

## Configuration

Set the following environment variables for use in `application.properties`:

- `DB_URL`, `DB_USERNAME`, `DB_PASSWORD` for database connection (MySQL out of the box, another one can be configured since Spring Data JPA has been integrated)
- `JWT_SECRET_KEY` (at least 256 bits)
- `JWT_ISSUER` (JWT issuer name)
- `JWT_LIFETIME_MIN` (token lifetime in minutes)

Example for `application.properties`:
```
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

jwt.secret.key=${JWT_SECRET_KEY}
jwt.issuer=${JWT_ISSUER}
jwt.lifetime.min=${JWT_LIFETIME_MIN}
```

## Routes

- `POST /register` — Register a new user
- `POST /login` — Authenticate and receive a JWT
- `GET /` — Authenticated home route (requires valid JWT)

## Future Scope

- Add role-based authorization.
- Implement rate limiting, email verification, and CAPTCHA to prevent user registration abuse.
- Integrate cutting edge auth methods.