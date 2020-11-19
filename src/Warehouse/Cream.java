package Warehouse;

import Storage.Liquid;

public class Cream extends Ingredients implements Liquid {

    private double price;
    private String name="Cream";

    public Cream(int Amount){
        super(Amount);
    }

    public double calculateCost(){
        price=getAmount()*0.30;
        return price;
    }

    public String getName() {
        return name;
    }
}