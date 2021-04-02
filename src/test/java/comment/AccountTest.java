package comment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Account account;

    @BeforeEach
    void setUp() {
        account = new Account();
    }

    @Test
    void debit100ShouldMakeAnSaldoOf100() {
        account.debit(100);
        assertEquals(-100d, account.getBalance(), 0.01);
    }

    @Test
    void debit100AndCredit100ShouldReturnZero() {
        Account account = new Account();
        account.debit(100);
        account.credit(100);
        assertEquals(0, account.getBalance(), 0.01);
    }

    @Test
    void debitGreaterThan1000ShouldThrowAnIllegalArgumentException() {
        Account account = new Account();
        assertThrows(IllegalArgumentException.class, () -> account.debit(1001));
    }

    @Test
    void credits1000TimesWithValue1ShouldReturn1000() {
        Account account = new Account();
        for (int i = 0; i < 1000; i++) {
            account.credit(1);
        }
        assertEquals(1000d, account.getBalance());
    }

    @Test
    void transactionShouldBeStoredInCollection() {
        Account account = new Account();
        for (int i = 0; i < 1000; i++) {
            account.debit(100);
        }
        assertNotNull(account.getLastTransaction());
    }

    @Test
    void lastDebitDateShouldNotBeNull() {
        account.debit(10);
        assertNotNull(account.getLastDebitDate());
    }

}