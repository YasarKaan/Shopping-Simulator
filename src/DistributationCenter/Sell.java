package DistributationCenter;

import Bank.User;
import Exceptions.HaveNotEnoughProductException;
import Helpers.TakeInput;
import Storage.StorageArea;

public class Sell {
    TakeInput takeInput = new TakeInput();
    public void sellProducts(StorageArea boxedMilkStorageArea, StorageArea chocolateStorageArea, StorageArea yogurtStorageArea, User user){
        System.out.println("Boxed Milk = " + boxedMilkStorageArea.toString() + "\n" +"Chocolate = " + chocolateStorageArea.toString()+ "\n" +"Yogurt = " + yogurtStorageArea.toString() + "\n");
        System.out.println("Select your product: " + "\n" + "Press 1 for Boxed Milk" + "\n" + "Press 2 for Chocolate" + "\n" + "Press 3 for Yogurt");
        int orderInput= takeInput.getInput();
        System.out.println("Select Amount");
        int amount= takeInput.getInput();
        try {
            if(amount<user.bankAccount.getBalance()){
                if(orderInput==1) {
                    boxedMilkStorageArea.removeStorage( amount );
                    user.bankTransaction.buytransaction( user.calculateCost.boxedMilkCalculateCost( amount ),user.bankAccount);
                    System.out.println("Profit is: "+amount*0.75);
                }else if(orderInput==2){
                    chocolateStorageArea.removeStorage( amount );
                    user.bankTransaction.buytransaction( user.calculateCost.chocolateCost( amount ),user.bankAccount );
                    System.out.println("Profit is: "+amount*1.70);
                }else if(orderInput==3){
                    yogurtStorageArea.removeStorage( amount );
                    user.bankTransaction.buytransaction( user.calculateCost.yogurtCost( amount ),user.bankAccount );
                    System.out.println("Profit is: "+amount*2.75);
                }
            }else{
                throw new HaveNotEnoughProductException();
            }
        }catch (HaveNotEnoughProductException e){
            System.out.println(e.getMessage());
        }
    }
}