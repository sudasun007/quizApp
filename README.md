# Quiz Application (Spring Boot)

This is a **Quiz Application** built using **Spring Boot**, which allows users to manage questions and quizzes with full CRUD operations. The application supports features like filtering by category or difficulty, quiz generation, and result submission.

## 🛠️ Technologies Used

- Java 17+
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL / MySQL (Database)
- Maven
- Lombok

---

---

## ✅ Features

### Question Management
- `GET /question/allQuestions` – Fetch all questions.
- `GET /question/category/{category}` – Filter questions by category.
- `GET /question/difficultyLevel/{difficultyLevel}` – Filter questions by difficulty.
- `POST /question/addQuestion` – Add a single question.
- `POST /question/addMultipleQuestions` – Add multiple questions at once.
- `PUT /question/updateQuestion` – Update an existing question.
- `PUT /question/updateQuestionById/{id}` – Update question by ID.
- `POST /question/deleteQuestion` – Delete a question (with full body).
- `DELETE /question/deleteQuestionById/{id}` – Delete question by ID.

### Quiz Management
- `POST /quiz/create` – Create a quiz based on category and number of questions.
- `GET /quiz/get/{id}` – Fetch quiz questions by quiz ID.
- `POST /quiz/submit/{id}` – Submit quiz and get result.

---
## 🧪 How to Run

1. Clone this repository:
   ```bash
   git clone https://github.com/sudasun007/quizApp.git
   cd quizApp
   ```

2. Configure your `application.properties` with the correct database credentials.

3. Build the project using:
   ```bash
   mvn clean install
   ```

4. Run the app using:
   ```bash
   mvn spring-boot:run
   ```

5. The API will be available at:  
   [http://localhost:8080](http://localhost:8080)

---
📦 Database Dump

The `questiondb` PostgreSQL dump is included in the `db/` folder.

To restore:

```bash
psql -U your_username -d questiondb -f db/questiondb_dump.sql



