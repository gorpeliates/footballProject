# Football Player Statistics Tracker

This Spring Boot application tracks football player statistics by importing data from a CSV file and persisting it to a PostgreSQL database. The application leverages OpenCSV for CSV parsing and JPA for data persistence, providing a seamless integration of data management functionalities.

## Features

- **Data Import**: Automatically reads player statistics from a CSV file.
- **Database Integration**: Stores player information in a PostgreSQL database using JPA.
- **Command-Line Runner**: Initializes data import on application startup.
- **Object-Oriented Design**: Utilizes Java classes to represent player data, ensuring a structured and maintainable codebase.

## Technologies Used

- **Java**: The core programming language for application development.
- **Spring Boot**: Framework used for building the application.
- **PostgreSQL**: Relational database for storing player statistics.
- **OpenCSV**: Library for reading and writing CSV files in Java.

## Getting Started

To get a local copy up and running, follow these steps:

1. Clone the repository:
  
2. Navigate to the project directory:
   ```bash
   cd backEnd
   ```
3. Configure your PostgreSQL database connection in `application.properties`.
4. Build and run the application:
   ```bash
   ./gradlew build
   ./gradlew bootRun
   ```

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any features or improvements.
