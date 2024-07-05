# Consultation API

## Overview
This is a simple REST API for consultation questions and answers to determine eligibility for a prescription.

## Project Structure
- `ConsultationApplication.java`: Main application class
- `controller/ConsultationController.java`: Contains API endpoints
- `models/Questions.java`: Model for questions
- `models/Answers.java`: Model for answers
- `models/ConsultationResponse.java`: Model for consultation response

## Endpoints
1. `GET /api/consultation/questions`
    - Retrieves the list of consultation questions.
    - Response: List of questions.
2. `POST /api/consultation/answers`
    - Submits the answers to the consultation questions.
    - Request Body: List of answers.
    - Response: Eligibility result.

## Running Tests
To run the tests, execute the following command:
Run `mvn test`.


## Running the Application
1. Clone the repository.
2. Navigate to the project directory.
3. Run `mvn spring-boot:run`.
4. The application will start on `http://localhost:8080`.

## API Documentation
The API documentation is available at `http://localhost:8080/swagger-ui.html` and `http://localhost:8080/v3/api-docs`.

## Example Requests
- **Get Questions:**
  ```sh
  curl -X GET "http://localhost:8080/api/consultation/questions" -H "accept: application/json"

- **POST Answers:**
  ```sh
  curl -X POST "http://localhost:8080/api/consultation/answers" -H "accept: application/json" -H "Content-Type: application/json" -d '[{"questionId":1,"answerText":"No"},{"questionId":2,"answerText":"No"},{"questionId":3,"answerText":"25"}]'

