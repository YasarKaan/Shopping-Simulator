package Transportation;

import Bank.User;
import Exceptions.DifferentUncountableItemsException;
import Exceptions.ItemNotCountableException;
import Exceptions.ItemNotUncountableException;
import Factory.Products;
import Storage.*;

public class Transfer<T> {
    public TransferHelper transferHelper = new TransferHelper();

    public void openTopTransfer(StorageTank storageTank1, StorageTank storageTank2, T object, IContainer container, ParkingZone parkingZone1, ParkingZone parkingZone2, User user) {
        try {
            Powder powder = (Powder) object;
            if (parkingZone1.isHave( container ) && storageTank2.getSize() + powder.getAmount() < 10000 && container.getSize() + powder.getAmount() <= container.capacity) {
                transferHelper.addingOpenTopContainer( storageTank1, storageTank2, powder, container, parkingZone1 );
                transferHelper.move( container, parkingZone1, parkingZone2, user );
                transferHelper.removingContainer( storageTank2, object, container, 1 );
            }

        } catch (ClassCastException e) {
            System.out.println( e.getMessage() );
        }
    }

    public void TankTransfer(StorageTank storageTank1, StorageTank storageTank2, T object, IContainer container, ParkingZone parkingZone1, ParkingZone parkingZone2, User user) {
        try {
            Liquid liquid = (Liquid) object;
            if (parkingZone1.isHave( container ) && storageTank2.getSize() + liquid.getAmount() < 10000 && container.getSize() + liquid.getAmount() <= container.capacity) {
                transferHelper.addingTankContainer( storageTank1, storageTank2, liquid, container, parkingZone1 );
                transferHelper.move( container, parkingZone1, parkingZone2, user );
                transferHelper.removingContainer( storageTank2, object, container, 1 );
            }
        } catch (ClassCastException e) {
            System.out.println( e.getMessage() );
        }
    }

    public void dryTransfer(StorageArea storageArea1, StorageArea storageArea2, T object, int amount, IContainer container, ParkingZone parkingZone1, ParkingZone parkingZone2, User user) {
        try {
            Products products = (Products) object;
            if (parkingZone1.isHave( container ) && storageArea1.getSize() + products.getAmount() < 10000 && container.getSize() + products.getAmount() <= container.capacity) {
                transferHelper.addingDryStorageContainer( storageArea1, storageArea2, products, amount, container, parkingZone1 );
                transferHelper.move( container, parkingZone1, parkingZone2, user );
                transferHelper.removingContainer( storageArea2, object, container, amount );
            }
        } catch (ClassCastException e) {
            System.out.println( e.getMessage() );
        }
    }
}