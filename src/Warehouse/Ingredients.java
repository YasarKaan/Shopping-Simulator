package Warehouse;

public abstract class Ingredients<T> {

    private int amount;
    private String name;

    public <T>Ingredients(int Amount){
        amount=Amount;
    }

    public int getAmount() { return amount; }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public abstract double calculateCost();

    public abstract String getName();
}