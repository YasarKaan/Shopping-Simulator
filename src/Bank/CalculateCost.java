package Bank;

import Storage.StorageArea;
import Warehouse.Cacao;
import Warehouse.Cream;
import Warehouse.Milk;
import Warehouse.Yeast;

public class CalculateCost {
    BankTransaction bank = new BankTransaction();

    public double boxedMilkCalculateCost(int amount){
        return amount*1;
    }
    public double chocolateCost(int amount){
        return amount*4;
    }
    public double yogurtCost(int amount){
        return amount*2;
    }
    public double milkCost(Milk milk){
        return milk.calculateCost();
    }
    public double cacaoCost(Cacao cacao){
        return cacao.calculateCost();
    }
    public double creamCost(Cream cream){
        return cream.calculateCost();
    }
    public double yeastCost(Yeast yeast){
        return yeast.calculateCost();
    }
    public double transferCost(){
        return 100;
    }
}