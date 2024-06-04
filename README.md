# IV1350-2024
# Seminar 4 - Point-of-Sale (POS) System

## Introduction

This project is part of the Object-Oriented Design course (IV1350) and focuses on developing a point-of-sale (POS) system for a retail store. The goal is to apply object-oriented programming principles to create a robust and maintainable software solution based on a given design model.

## Project Structure

The project is structured according to the Model-View-Controller (MVC) and Layer patterns, ensuring a clear separation of concerns and maintainability.


## Tasks

### Task 1: Exception Handling

- **Objective**: Implement exception handling for the `InventorySystem` class to handle item not found and database failure scenarios.
- **Implementation**: Custom exceptions are created and used in the `InventorySystem` class. The `Controller` and `View` classes handle these exceptions and log errors appropriately.
- **Sample Run**:
    ```
    Starting a new sale...
    Adding item: Milk - Running total: 11.2
    Error: Database connection failure for item identifier: 999
    Error: Item with identifier 003 not found.
    Total price: 11.2
    Logging sale...
    Printing receipt...
    Receipt:
    Date: 2024-06-04T13:10:57
    Milk x1: 11.2
    Total: 11.2
    ```

### Task 2 Part a: Observer Pattern

- **Objective**: Use the Observer pattern to implement functionality that shows the total amount paid for purchases since the program started.
- **Implementation**: 
  - `SaleObserver` interface is defined.
  - `TotalRevenueView` and `TotalRevenueFileOutput` classes are implemented as observers.
  - `Sale` class is updated to notify observers of total revenue.
  - `Controller` registers observers.
- **Sample Run**:
    ```
    Starting a new sale...
    Adding item: Milk - Running total: 11.2
    Error: Database connection failure for item identifier: 999
    Error: Item with identifier 003 not found.
    Total price: 11.2
    Logging sale...
    Printing receipt...
    Receipt:
    Date: 2024-06-04T13:10:57
    Milk x1: 11.2
    Total: 11.2
    Total Revenue: 11.2
    ```

## How to Run

### Prerequisites

- Java Development Kit (JDK)
- Apache Maven

### Steps

1. **Clone the repository**:
    ```sh
    git clone [https://github.com/an-iq/IV1350-2024.git]
    cd example
    ```

2. **Compile the project**:
    ```sh
    mvn compile
    ```

3. **Run the sample program**:
    ```sh
    mvn exec:java -Dexec.mainClass="com.example.POS_System.view.View"
    ```

4. **Run the tests**:
    ```sh
    mvn test
    ```

## Conclusion

This project demonstrates the application of object-oriented principles to develop a maintainable and robust POS system. The implementation and testing ensure that the system functions correctly, handling various scenarios effectively.



