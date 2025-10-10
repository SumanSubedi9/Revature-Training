# Spring JPA REST Application

## Setup Instructions

### Database Configuration

This application requires a MySQL database. To set up your local database configuration:

1. **Create a `.env` file in the project root:**

   ```bash
   DB_URL=jdbc:mysql://localhost:3306/game_collection
   DB_USERNAME=root
   DB_PASSWORD=your_password_here
   ```

2. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```
   or
   ```bash
   .\mvnw.cmd spring-boot:run
   ```

### Alternative: Using System Environment Variables

You can also set system environment variables instead of using a `.env` file:

**Windows (PowerShell):**

```powershell
$env:DB_URL="jdbc:mysql://localhost:3306/game_collection"
$env:DB_USERNAME="root"
$env:DB_PASSWORD="your_password"
mvn spring-boot:run
```

**Linux/Mac:**

```bash
export DB_URL=jdbc:mysql://localhost:3306/game_collection
export DB_USERNAME=root
export DB_PASSWORD=your_password
mvn spring-boot:run
```

### Security Note

⚠️ **Never commit sensitive database credentials to version control!**

- `.env` file is included in `.gitignore` and should NOT be committed
- Use environment variables in production
- The main `application.properties` uses environment variable placeholders for security

## Running the Application

The application will start on `http://localhost:8080`

## Prerequisites

- Java 21 or higher
- MySQL 8.0 or higher
- Maven 3.6+ (or use the included Maven wrapper)

## Technologies Used

- Spring Boot 3.5.6
- Spring Data JPA
- MySQL Connector
- Hibernate 6.x
- Maven
