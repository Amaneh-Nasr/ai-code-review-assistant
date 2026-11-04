# AI Code Review Assistant

A Java code review assistant built with **Spring Boot**, **Spring AI** and **Ollama**. It sends Java code to a locally running language model and returns review feedback. No code leaves your machine.

## Features

- Code review feedback for Java code from a local language model
- Runs fully locally through Ollama
- Simple REST API: send Java source code as plain text, get the review back as plain text

## Technologies

Java 21 · Spring Boot 4.1.0 · Spring AI 2.0.0 · Ollama · Maven

## API

| Method | Endpoint           | Description                                          |
|--------|--------------------|------------------------------------------------------|
| POST   | `/api/review`      | Send Java code in the request body, get the review   |
| GET    | `/api/review/hello`| Test endpoint to check that the application is running |

Example request (the application runs on port 8080 by default):

```
curl -X POST http://localhost:8080/api/review \
  -H "Content-Type: text/plain" \
  --data-binary @MyClass.java
```

## Run the application

**Prerequisites:** JDK 21, Ollama (running on `http://localhost:11434`), the model `qwen2.5-coder:3b`

1. Clone the repository:

   ```
   git clone https://github.com/Amaneh-Nasr/ai-code-review-assistant.git
   cd ai-code-review-assistant
   ```
2. Start Ollama and pull the model:

   ```
   ollama pull qwen2.5-coder:3b
   ```
3. Start the application:

   ```
   ./mvnw spring-boot:run
   ```

   On Windows: `.\mvnw.cmd spring-boot:run`

## Limitations

Small local models are not always reliable, so review results should be checked by a developer.

## Author

**Amaneh Nasrramzy**