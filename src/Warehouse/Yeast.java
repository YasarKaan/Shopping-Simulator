package Warehouse;

import Storage.Powder;

public class Yeast extends Ingredients implements Powder {

    private double price;
    private String name= "Yeast";

    public Yeast(int Amount){
        super(Amount);
    }
    public double calculateCost(){
        price=getAmount()*5;
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

}