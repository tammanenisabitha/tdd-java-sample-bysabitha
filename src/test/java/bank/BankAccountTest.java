package bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void givenNewAccount_whenGetBalance_thenShouldBeZero() {
        // GIVEN a new bank account
        BankAccount account = new BankAccount();

        // WHEN checking the balance
        int balance = account.getBalance();

        // THEN balance should be 0
        assertEquals(0, balance);
    }

    @Test
    public void givenNewAccount_whenDeposit100_thenBalanceIs100() {
        // GIVEN a new bank account
        BankAccount account = new BankAccount();

        // WHEN depositing 100
        account.deposit(100);

        // THEN balance should be 100
        assertEquals(100, account.getBalance());
    }

    @Test
    public void givenBalance200_whenWithdraw50_thenBalanceIs150() {
        // GIVEN account with 200
        BankAccount account = new BankAccount();
        account.deposit(200);

        // WHEN withdrawing 50
        account.withdraw(50);

        // THEN balance should be 150
        assertEquals(150, account.getBalance());
    }

    @Test
    public void givenBalance50_whenWithdrawMoreThanAvailable_thenThrowException() {
        // GIVEN account with 50
        BankAccount account = new BankAccount();
        account.deposit(50);

        // WHEN trying to withdraw 100
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(100);
        });


        // THEN should throw insufficient balance exception
        assertEquals("Insufficient balance", exception.getMessage());
    }

    @Test
    public void givenNewAccount_whenDepositNegative_thenThrowException() {
        // GIVEN a new bank account
        BankAccount account = new BankAccount();

        // WHEN trying to deposit -10
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-10);
        });

        // THEN should throw exception with correct message
        assertEquals("Amount must be positive", exception.getMessage());
    }

    @Test
    public void givenNewAccount_whenCreated_thenObjectShouldNotBeNull() {
        // GIVEN a new bank account
        BankAccount account = new BankAccount();

        // THEN object should not be null
        assertNotNull(account);
    }

    @Test
    public void givenDepositAndWithdraw_whenCheckedAll_thenAssertAllConditions() {
        // GIVEN a new account with deposit 500
        BankAccount account = new BankAccount();
        account.deposit(500);

        // WHEN withdrawing 200
        account.withdraw(200);

        // THEN check multiple conditions using assertAll
        assertAll("Check after deposit and withdraw",
                () -> assertTrue(account.getBalance() > 0),
                () -> assertEquals(300, account.getBalance())
        );
    }

    @Test
    public void givenInvalidScenario_whenManualCheckFails_thenUseFail() {
        // GIVEN a new account
        BankAccount account = new BankAccount();

        // WHEN depositing 0
        try {
            account.deposit(0);
            // THEN fail if no exception
            fail("Deposit of 0 should throw exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Amount must be positive", e.getMessage());
        }
    }

    @Test
    public void givenNullReference_whenChecked_thenShouldBeNull() {
        // GIVEN null account
        BankAccount account = null;

        // THEN should be null
        assertNull(account);
    }

    @Test
    public void givenPositiveBalance_whenChecked_thenShouldBeTrue() {
        // GIVEN account with balance
        BankAccount account = new BankAccount();
        account.deposit(100);

        // THEN balance should be positive
        assertTrue(account.getBalance() > 0);
    }

    @Test
    public void givenZeroBalance_whenCheckedForPositive_thenShouldBeFalse() {
        // GIVEN new account with 0 balance
        BankAccount account = new BankAccount();

        // THEN balance should not be positive
        assertFalse(account.getBalance() > 0);
    }

}
