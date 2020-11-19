package DistributationCenter;

import Bank.User;
import Storage.StorageArea;
import Transportation.ParkingZone;


public class DistributationCenter {
    public ParkingZone parkingZone = new ParkingZone();
    public StorageArea boxedMilkStorageArea = new StorageArea();
    public StorageArea chocolateStorageArea = new StorageArea();
    public StorageArea yogurtStorageArea = new StorageArea();
    Sell sell= new Sell();
    public StorageArea[] storageAreas={null,boxedMilkStorageArea,chocolateStorageArea,yogurtStorageArea};
    public void sell(User user){
        sell.sellProducts(boxedMilkStorageArea,chocolateStorageArea, yogurtStorageArea ,user);
    }
    public String toString(){
        return boxedMilkStorageArea.toString()+"\n"+chocolateStorageArea.toString()+"\n"+yogurtStorageArea.toString();
    }
}
