package Menu;

import Exceptions.ItemNotUncountableException;
import Warehouse.*;
import Bank.User;
import DistributationCenter.DistributationCenter;
import Factory.Factory;
import Helpers.TakeInput;
import Storage.Containers;
import Transportation.Transfer;
import Warehouse.Warehouse;
import Warehouse.Buy;

public class BusinessApplication {
    public static void main(String[] args) {
        TransferMenu transferMenu = new TransferMenu();
        Containers containers = new Containers();
        Transfer transfer = new Transfer();
        Menus menus = new Menus();
        Warehouse warehouse = new Warehouse();
        TakeInput takeInput = new TakeInput();
        DistributationCenter distributationCenter = new DistributationCenter();
        Buy buy = new Buy();
        User user = new User();
        Factory factory = new Factory();
        boolean blean = true;
        factory.parkingZone.addContainer( containers.tankContainer );
        factory.parkingZone.addContainer( containers.dryStorageContainer );
        factory.parkingZone.addContainer( containers.openTopContainer );
        while (blean) {
            System.out.println( "Current Balance = " + user.bankAccount.getBalance() );
            menus.firstList();
            int input = takeInput.getInput();
            if (input == 0) {
                blean = false;
            } else if (input == 1) {
                menus.secondList();
                buy.takeOrder( warehouse.cacaoStorageTank, warehouse.creamStorageTank, warehouse.milkStorageTank, warehouse.yeastStorageTank, user );
            } else if (input == 2) {
                menus.thirdList();
                int input1 = takeInput.getInput();
                if (input1 == 1) {
                    System.out.println( "Boxed Milk amount" );
                    int amountInput = takeInput.getInput();
                    factory.produce.produceBoxedMilk( factory.boxedMilkStorageArea, factory.storageTanks[3], amountInput );
                } else if (input1 == 2) {
                    System.out.println( "Chocolate amount" );
                    int amountInput = takeInput.getInput();
                    factory.produce.produceChocolate( factory.chocolateStorageArea, factory.cacaoStorageTank, factory.creamStorageTank, factory.milkStorageTank, amountInput );
                } else if (input1 == 3) {
                    System.out.println( "Yogurt amount" );
                    int amountInput = takeInput.getInput();
                    factory.produce.produceYogurt( factory.yogurtStorageArea, factory.milkStorageTank, factory.yeastStorageTank, amountInput );
                } else {
                    System.out.println( "Error" );
                }

            } else if (input == 3) {
                distributationCenter.sell( user );
            } else if (input == 4) {
                System.out.println( "Warehouse: " );
                System.out.println( warehouse.toString() );
                System.out.println( "Factory Tanks:" );
                System.out.println( factory.toStringTanks() );
                System.out.println( "Factory Areas:" );
                System.out.println( factory.toStringAreas() );
                System.out.println( "Distribution Areas: " );
                System.out.println( distributationCenter.toString() );


            } else if (input == 5) {
                transferMenu.transferMenu( warehouse,factory,distributationCenter,containers,user,menus,takeInput,transfer );
            }

        }
    }
}
