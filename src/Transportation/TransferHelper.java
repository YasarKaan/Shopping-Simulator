package Transportation;

import Bank.User;
import DistributationCenter.DistributationCenter;
import Exceptions.DifferentUncountableItemsException;
import Exceptions.ItemNotCountableException;
import Exceptions.ItemNotUncountableException;
import Factory.Factory;
import Factory.Products;
import Storage.*;
import Warehouse.*;

public class TransferHelper<T> {

    public void addingOpenTopContainer(StorageTank storageTank1 , StorageTank storageTank2, Powder powder, IContainer container,ParkingZone parkingZone1) {
        if (container.getSize() != 0) {
            if (container.containerStack.get( 0 ).getClass().getName().equals( powder.getName() )) {
                storageTank1.removeStorage( powder.getAmount() );
                container.addStorage( powder );
            }
        }else{
            storageTank1.removeStorage( powder.getAmount() );
            container.addStorage( powder );
        }
    }


    public void removingContainer(IStorage storage, T object, IContainer container,int amount) {
        container.removeStorage();
        while (amount > 0) {
            storage.addStorage( object );
            amount--;
        }
    }

    public void addingTankContainer(StorageTank storageTank1 , StorageTank storageTank2, Liquid liquid, IContainer container,ParkingZone parkingZone1) {

        if (container.getSize() != 0) {
            if (container.containerStack.get( 0 ).getClass().getName().equals( liquid.getName() )) {
                storageTank1.removeStorage( liquid.getAmount() );
                container.addStorage( liquid );
            }
        }else{
            storageTank1.removeStorage( liquid.getAmount() );
            container.addStorage( liquid );
        }
    }

    public void addingDryStorageContainer(StorageArea storageArea1, StorageArea storageArea2, Products products,int amount, IContainer container,ParkingZone parkingZone1) {
        int twpAmount = amount;
        storageArea1.removeStorage( amount );
        while (twpAmount > 0) {
            container.addStorage( products );
            twpAmount--;
        }
    }

    public void move(IContainer container, ParkingZone parkingZone1 , ParkingZone parkingZone2, User user){
        parkingZone1.removeContainer( container );
        parkingZone2.addContainer( container);
        user.bankTransaction.transaction( user.calculateCost.transferCost(),user.bankAccount );

    }
    public void doIngredientsTransfer(Transfer transfer, int inputContainer, Warehouse warehouse, Factory factory, Containers containers, T ingredients, User user,int inputIngredients) {
        try {
            if (inputContainer == 1) {
                if (ingredients instanceof Powder) {
                    transfer.openTopTransfer( warehouse.storageTanks[inputIngredients], factory.storageTanks[inputIngredients], ingredients, containers.openTopContainer, warehouse.parkingZone, factory.parkingZone, user );
                } else {
                    throw new DifferentUncountableItemsException();
                }
            }
                else if (inputContainer == 2) {
                if (ingredients instanceof Liquid) {
                    transfer.TankTransfer( warehouse.storageTanks[inputIngredients], factory.storageTanks[inputIngredients], ingredients, containers.tankContainer, warehouse.parkingZone, factory.parkingZone, user );
                }else{
                    throw new DifferentUncountableItemsException();
                }
            }else if (inputContainer == 3) {
                throw new ItemNotCountableException();
            }
        } catch (ItemNotCountableException e) {
            System.out.println(e.getMessage());

        }catch (DifferentUncountableItemsException e){
            System.out.println( e.getMessage() );
        }
    }

    public void doProductTransfer(Transfer transfer, int inputContainer, Factory factory, DistributationCenter distributationCenter,int amount,Containers containers,T products, User user,int inputProduct){
        {
            amount=factory.storageAreas[inputProduct].storageQueue.size();
            try {
                if (inputContainer == 1) {
                    throw new ItemNotUncountableException();
                } else if (inputContainer == 2) {
                    throw new ItemNotUncountableException();
                } else if (inputContainer == 3) {
                    transfer.dryTransfer( factory.storageAreas[inputProduct],distributationCenter.storageAreas[inputProduct],products,amount,containers.dryStorageContainer,factory.parkingZone,distributationCenter.parkingZone,user );
                }
            } catch (ItemNotUncountableException e) {
                System.out.println(e.getMessage());

            }
        }
    }
}