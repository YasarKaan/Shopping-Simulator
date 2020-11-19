package Warehouse;

import Helpers.TakeInput;
import Storage.StorageTank;;
import Transportation.ParkingZone;

public class Warehouse {
    Buy buy = new Buy();
    public StorageTank cacaoStorageTank = new StorageTank();
    public StorageTank creamStorageTank = new StorageTank();
    public StorageTank milkStorageTank = new StorageTank();
    public StorageTank yeastStorageTank = new StorageTank();
    public ParkingZone parkingZone = new ParkingZone();
    public StorageTank[] storageTanks = {null,cacaoStorageTank,creamStorageTank,milkStorageTank,yeastStorageTank};

    public String toString(){
        return cacaoStorageTank.toString() +"\n"+ creamStorageTank.toString()+"\n"+ milkStorageTank.toString()+"\n"+ yeastStorageTank.toString();
    }
}
