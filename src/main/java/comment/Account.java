package comment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Account {

    private float balance = 0;
    private final List<Transaction> transactions = new ArrayList<>();
    private String lastDebitDate;

    public void credit(float amount) {
        balance += amount;
    }

    public void debit(float amount) {

        //check amount does not exceed max allowed
        if (amount > 1000) {
            throw new IllegalArgumentException("Maximum debit amount exceeded");
        }

        // deduct amount from balance
        balance -= amount;

        // record transaction
        transactions.add(new Transaction(true, amount));

        //update last debit date
        Calendar calendar = Calendar.getInstance();

        lastDebitDate = calendar.get(Calendar.DATE) + "/" + calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.YEAR);
    }

    public float getBalance() {
        return balance;
    }

    public Transaction getLastTransaction() {
        return transactions.get(transactions.size() - 1);
    }

    public String getLastDebitDate() {
        return lastDebitDate;
    }

}