package Warehouse;

import Bank.User;
import Exceptions.HaveNotEnoughMoneyException;
import Exceptions.StorageFullException;
import Helpers.TakeInput;
import Storage.StorageTank;


public class Buy {

    TakeInput takeInput = new TakeInput();

    public void takeOrder(StorageTank cacaoStorageTank, StorageTank creamStorageTank, StorageTank milkStorageTank, StorageTank yeastStorageTank, User user) {

        int orderInput = takeInput.getInput();
        System.out.println( "Select Amount" );
        int amount = takeInput.getInput();
        if (orderInput == 1) {
            try {
                Cacao cacao = new Cacao( amount );
                if (cacao.calculateCost() <= user.bankAccount.getBalance()) {
                    if (cacaoStorageTank.getSize() + cacao.getAmount() < 10000) {
                        cacaoStorageTank.addStorage( cacao );
                        user.bankTransaction.transaction( cacao.calculateCost(), user.bankAccount );
                    }else {
                        throw new StorageFullException();
                    }
                }else {
                    throw new HaveNotEnoughMoneyException();
                }
            } catch (HaveNotEnoughMoneyException e) {
                System.out.println( e.getMessage() );

            }catch (StorageFullException e){
                System.out.println(e.getMessage());
            }
        } else if (orderInput == 2) {
            try {
                Cream cream = new Cream( amount );
                if (cream.calculateCost() <= user.bankAccount.getBalance()) {
                    if (creamStorageTank.getSize() + cream.getAmount() < 10000) {
                        creamStorageTank.addStorage( cream );
                        user.bankTransaction.transaction( cream.calculateCost(), user.bankAccount );
                    }else {
                        throw new StorageFullException();
                    }
                }else {
                    throw new HaveNotEnoughMoneyException();
                }
            } catch (HaveNotEnoughMoneyException e) {
                System.out.println( e.getMessage() );

            }catch (StorageFullException e){
                System.out.println(e.getMessage());
            }

        } else if (orderInput == 3) {
            try {
                Milk milk = new Milk( amount );
                if (milk.calculateCost() <= user.bankAccount.getBalance()) {
                    if (milkStorageTank.getSize() + milk.getAmount() < 10000){
                    milkStorageTank.addStorage( milk );
                    user.bankTransaction.transaction( milk.calculateCost(), user.bankAccount );
                    }else{
                        throw new HaveNotEnoughMoneyException();
                    }
                }else {
                    throw new StorageFullException();
                }
            } catch (HaveNotEnoughMoneyException e) {
                System.out.println( e.getMessage() );

            }catch (StorageFullException e){
                System.out.println(e.getMessage());
            }
        } else if (orderInput == 4) {
            try {
                Yeast yeast = new Yeast( amount );
                if (yeast.calculateCost() <=user.bankAccount.getBalance()) {
                    if(yeastStorageTank.getSize() + yeast.getAmount() < 10000){
                    yeastStorageTank.addStorage( yeast );
                    user.bankTransaction.transaction( yeast.calculateCost(), user.bankAccount );
                    }else {
                        throw new StorageFullException();
                    }
                }else {
                    throw new HaveNotEnoughMoneyException();
                }
            } catch (HaveNotEnoughMoneyException e) {
                System.out.println( e.getMessage() );

            }catch (StorageFullException e){
                System.out.println( e.getMessage() );
            }

        }
    }
}
