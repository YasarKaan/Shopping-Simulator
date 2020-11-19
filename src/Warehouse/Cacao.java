package Warehouse;


import Storage.Powder;

public class Cacao<T> extends Ingredients implements Powder {


    private String name = "Cacao";
    private double price;

    public <T> Cacao(int Amount) {
        super( Amount );
    }

    public double calculateCost() {
        price = getAmount();//getAmount()*1=getAmount()
        return price;
    }

    public String getName() {
        return name;
    }
}