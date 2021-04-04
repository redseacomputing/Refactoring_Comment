package comment;

class Transaction {
    private final float amount;
    private final boolean recorded;

    public Transaction(boolean recorded, float amount) {
        this.amount = amount;
        this.recorded = recorded;
    }
}
