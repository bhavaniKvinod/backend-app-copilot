# Spring Boot Architecture Rules

## Architecture Style
Layered Architecture (Controller → Service → Repository → Model)

## Package Structure
com.example.demo
├── controller
├── service
├── service.impl
├── repository
├── model
├── dto
├── exception
├── config


## Rules
- Controllers: handle HTTP only
- Services: contain business logic
- Repositories: data access only
- No controller talks directly to repository
- Use constructor injection only
- No field injection (@Autowired on fields is forbidden)
- Use DTOs for request/response
- Entities must not be exposed directly
- Global exception handling with @ControllerAdvice
- Create a main class annotated with @SpringBootApplication

## Coding Style
- Clean Code principles
- Small methods
- Meaningful names
- No logic in controllers
