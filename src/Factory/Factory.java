package Factory;

import Storage.DryStorageContainer;
import Storage.StorageArea;
import Storage.StorageTank;
import Transportation.ParkingZone;

public class Factory {
        public ParkingZone parkingZone = new ParkingZone();
        public StorageTank cacaoStorageTank = new StorageTank();
        public StorageTank creamStorageTank = new StorageTank();
        public StorageTank milkStorageTank = new StorageTank();
        public StorageTank yeastStorageTank = new StorageTank();
        public StorageTank[] storageTanks ={null,cacaoStorageTank,creamStorageTank,milkStorageTank,yeastStorageTank};
        public StorageArea boxedMilkStorageArea = new StorageArea();
        public StorageArea chocolateStorageArea= new StorageArea();
        public StorageArea yogurtStorageArea = new StorageArea();
        public Produce produce = new Produce();
        public StorageArea[] storageAreas ={null,boxedMilkStorageArea,chocolateStorageArea,yogurtStorageArea};
        public String toStringTanks(){
                return cacaoStorageTank.toString()+"\n"+creamStorageTank.toString()+"\n"+milkStorageTank.toString()+"\n"+yeastStorageTank.toString();
        }
        public String toStringAreas() {
                return boxedMilkStorageArea.toString()+"\n"+chocolateStorageArea.toString()+"\n"+yogurtStorageArea.toString();
        }
}
