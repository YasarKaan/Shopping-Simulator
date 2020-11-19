package Menu;

import Bank.User;
import DistributationCenter.DistributationCenter;
import Exceptions.ContainerAlreadyHereException;
import Exceptions.ContainerIsNotHereException;
import Exceptions.ParkingZoneIsEmptyException;
import Factory.*;
import Helpers.TakeInput;
import Storage.Containers;
import Transportation.Transfer;
import Warehouse.Warehouse;
import Warehouse.*;

import java.util.InputMismatchException;


public class TransferMenu<T> {
    public void transferMenu(Warehouse warehouse, Factory factory, DistributationCenter distributationCenter, Containers containers, User user, Menus menus, TakeInput takeInput, Transfer transfer) {
        System.out.println( "Warehouse:\n" + warehouse.parkingZone.toString() );
        System.out.println( "Factory:\n" + factory.parkingZone.toString() );
        System.out.println( "Distribution:\n" + distributationCenter.parkingZone.toString() );
        menus.fourthList();
        int input5 = takeInput.getInput();
        if (input5 == 1) {
            try {
                menus.secondList();

                int inputIngredients = takeInput.getInput();
                if ((inputIngredients > 4) || (inputIngredients<=0)) {
                    throw new InputMismatchException();
                }
                Ingredients ingredients = takeInput.getIngredients( inputIngredients, warehouse );
                menus.containerList();
                int inputContainer = takeInput.getInput();
                transfer.transferHelper.doIngredientsTransfer( transfer, inputContainer, warehouse, factory, containers, ingredients, user, inputIngredients );

            }catch (InputMismatchException e){
                e.getMessage();}
        }else if (input5 == 2) {
            menus.thirdList();
            int inputProducts = takeInput.getInput();
            Products products = takeInput.getProducts( inputProducts, factory );
           menus.containerList();
            int inputContainer = takeInput.getInput();

                transfer.transferHelper.doProductTransfer( transfer, inputContainer, factory, distributationCenter, 1000, containers, products, user, inputProducts );
        }else if (input5 == 3) {
            menus.trasferList();
            int inputTransfer = takeInput.getInput();
            if (inputTransfer == 1) {
               try {
                   if (factory.parkingZone.isHave( containers.openTopContainer )) {
                       if(user.bankAccount.getBalance()>100) {
                           transfer.transferHelper.move( containers.openTopContainer, factory.parkingZone, warehouse.parkingZone, user );
                       }
                       } else {
                       throw new ContainerIsNotHereException();
                   }
               }catch (ContainerIsNotHereException e){
                   System.out.println(e.getMessage());
               }
            } else if (inputTransfer == 2) {
              try {
                  if (factory.parkingZone.isHave( containers.tankContainer )) {
                      transfer.transferHelper.move( containers.tankContainer, factory.parkingZone, warehouse.parkingZone, user );
                  } else {
                      throw new ContainerIsNotHereException();
                  }
              }catch (ContainerIsNotHereException e){
                  System.out.println(e.getMessage());
              }
            } else if (inputTransfer == 3) {
                try {
                    if (factory.parkingZone.isHave( containers.dryStorageContainer )) {
                        throw new ContainerAlreadyHereException();
                    } else {
                        transfer.transferHelper.move( containers.dryStorageContainer, distributationCenter.parkingZone, factory.parkingZone, user );
                    }
                }catch (ContainerAlreadyHereException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    }


