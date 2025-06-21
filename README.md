# TDD with Java JUnit
Let's take the example of a BankAccount and cover the TDD cycle with it.

## What is TDD?

**TDD (Test-Driven Development)** means writing tests before writing the code/logic.

### The TDD Cycle
1. 🔴 Red – Write a failing test
2. 🟢 Green – Write the minimal code to make it pass
3. 🔁 Refactor – Clean the code without breaking the test

### ✅ What are the steps to follow to write a test?

Before we start writing any test, let's follow these simple steps:

1. **Write down what we want to test as TODOs**
   - This gives us clarity on what behavior we are going to write.
   - Example:
     ```
     ✅ Below are the basic functionalities we want to test:
     - Balance should be 0 for a new account
     - Deposit should add money to the balance
     - Withdraw should reduce the balance
     - Should not allow withdrawing more than balance
     - Should not allow depositing a negative amount
     ```

2. **Pick one point and write the test (Red phase)**
   - Just write the test first — it should fail

3. **Write only the code needed to pass the test (Green phase)**

4. **Refactor if needed (clean the code)**

5. **Repeat for the next TODO**

### Approach to Write the Test – Using Given, When, Then

It helps us clearly describe the behavior we want to test in a readable and structured way.

---

####  What is Given–When–Then?

- **Given** – the starting condition or setup
- **When** – the action you perform
- **Then** – the expected result

#### Example:
Writing a test for depositing money in a bank account.

- **Given** a new bank account with zero balance
- **When** the user deposits ₹100
- **Then** the account balance should be ₹100

---

## 📘 Example: BankAccount TDD Journey

We'll build a simple `BankAccount` class using TDD.

### Our BankAccount should:
- [x] Start with zero balance
- [x] Allow deposits
- [x] Allow withdrawals
- [x] Prevent overdrafts
- [x] Reject negative deposits
- [x] Handle edge cases properly

## Let's See TDD in Action

### RED Phase - Write a Failing Test
Look at the first test in `BankAccountTest.java`:
- `givenNewAccount_whenGetBalance_thenShouldBeZero()`
- This test will fail initially because `BankAccount` class doesn't exist yet!

### GREEN Phase - Make It Pass
Check `BankAccount.java` to see the minimal implementation that makes this test pass.

### REFACTOR Phase - Clean Up
Notice how we keep the code clean as we add more functionality.


## Step-by-Step with TDD

1. **Start here:** [`BankAccountTest.java`](src/test/java/bank/BankAccountTest.java) – See all our test cases
2. **Then check:** [`BankAccount.java`](src/main/java/bank/BankAccount.java) – The implementation that evolved from tests
3. **Run tests:** `./gradlew test` to see them all pass

### Test Cases We Cover:
- ✅ New account has zero balance
- ✅ Deposit increases balance
- ✅ Withdraw decreases balance
- ✅ Cannot withdraw more than balance
- ✅ Cannot deposit negative amounts
- ✅ Object creation validation
- ✅ Multiple assertion groups
- ✅ Exception handling scenarios

## 📁 Project Structure
```
src/
├── main/java/bank/
│   └── BankAccount.java       # Implementation driven by tests
└── test/java/bank/
    └── BankAccountTest.java   # Complete test suite
```

## Common JUnit Assertions Cheat Sheet

| Assertion                             | Description                                      |
|--------------------------------------|--------------------------------------------------|
| `assertEquals(expected, actual)`     | Checks if two values are equal                   |
| `assertNotEquals(unexpected, actual)`| Opposite of `assertEquals`                       |
| `assertTrue(condition)`              | Passes if condition is true                      |
| `assertFalse(condition)`             | Passes if condition is false                     |
| `assertNull(object)`                 | Passes if the object is null                     |
| `assertNotNull(object)`              | Passes if the object is not null                 |
| `assertThrows(Exception.class, () -> code)` | Checks for expected exceptions         |
| `assertAll(...)`                     | Groups multiple assertions                       |
| `fail("message")`                    | Fails the test intentionally                     |
| `assertArrayEquals(expected, actual)`| Checks if arrays are equal                       |

## To Run Tests
```bash
./gradlew test
```
