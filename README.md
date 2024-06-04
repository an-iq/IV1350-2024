# IV1350-2024
# Point-of-Sale (POS) System

## Introduction

This project is part of the Object-Oriented Design course (IV1350) and focuses on developing a point-of-sale (POS) system for a retail store. The goal is to apply object-oriented programming principles to create a robust and maintainable software solution based on a given design model.

## Project Structure

The project is structured according to the Model-View-Controller (MVC) and Layer patterns, ensuring a clear separation of concerns and maintainability.


## Tasks

### Task 1: Implementation

- **Objective**: Implement the basic flow, startup scenario, and alternative flow 3-4b from the requirements.
- **Approach**:
  - **Model Layer**: Contains `Item`, `Sale`, and `Receipt` classes.
  - **Integration Layer**: Contains `InventorySystem` and `AccountingSystem` classes.
  - **Controller Layer**: Contains `Controller` class.
  - **View Layer**: Contains `View` class for simulating user interactions.
- **Sample Run**:
    ```
    Starting a new sale...
    Adding item: Milk - Running total: 11.2
    Adding item: Bread - Running total: 33.6
    Adding item: Bread - Running total: 56.0
    Total price: 56.0
    Logging sale...
    Printing receipt...
    Receipt:
    Date: 2024-06-04T13:10:57
    Milk x1: 11.2
    Bread x2: 44.8
    Total: 56.0
    ```

### Task 2: Unit Testing

- **Objective**: Write unit tests for key classes to ensure correctness and reliability.
- **Test Coverage**:
  - **SaleTest**: Tests adding new items and handling existing items.
  - **InventorySystemTest**: Tests adding, removing, retrieving, and updating items.
- **Framework**: JUnit

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


