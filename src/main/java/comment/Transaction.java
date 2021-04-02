package comment;

class Transaction {
    private float amount;
    private boolean recorded;

    public Transaction(boolean recorded, float amount) {
        this.amount = amount;
        this.recorded = recorded;
    }
}
