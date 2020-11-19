package Factory;

import Exceptions.StorageFullException;
import Storage.StorageArea;
import Storage.StorageTank;

public class Produce {
    public StorageArea produceChocolate(StorageArea chocolateStorageArea,StorageTank cacaoStorageTank ,StorageTank creamStorageTank ,StorageTank milkStorageTank, int amount){
            amount=Math.round(amount/8)*8;
        if(calculateChocolate(cacaoStorageTank,creamStorageTank,milkStorageTank,amount )) {
            try {
                if (chocolateStorageArea.getSize() + amount <= 10000) {
                    removeForChocolate( cacaoStorageTank, creamStorageTank, milkStorageTank, amount );
                    while (amount > 0) {
                        Chocolate chocolate = new Chocolate();
                        chocolateStorageArea.addStorage( chocolate );
                        amount--;
                    }
                } else {
                    throw new StorageFullException();
                }
            } catch (StorageFullException e) {
                System.out.println( e.getMessage() );
            }
        }
        return chocolateStorageArea;
    }
    private boolean calculateChocolate(StorageTank cacaoStorageTank ,StorageTank creamStorageTank,StorageTank milkStorageTank, int amount){
        return  (amount*3)/8<=cacaoStorageTank.getSize()&& (amount*2)/8<=creamStorageTank.getSize()&& (amount*5)/8<=milkStorageTank.getSize();
    }
    private void removeForChocolate(StorageTank cacaoStorageTank , StorageTank creamStorageTank, StorageTank milkStorageTank, int amount){
        cacaoStorageTank.removeStorage( (amount*3)/8);
        creamStorageTank.removeStorage( (amount*2)/8);
        milkStorageTank.removeStorage( (amount*5)/8);
    }



    public StorageArea produceBoxedMilk(StorageArea boxedMilkArea ,StorageTank milkStorageTank ,int amount) {
        if(calculateBoxedMilk(milkStorageTank,amount)) {
            try {
                if(boxedMilkArea.getSize()+amount<=10000) {
                    removeForBoxedMilk( milkStorageTank, amount );
                    while (amount > 0) {
                        BoxedMilk boxedMilk = new BoxedMilk();
                        boxedMilkArea.addStorage( boxedMilk );
                        amount--;
                    }
                }else {
                    throw new StorageFullException();
                }
            }catch (StorageFullException e) {
                System.out.println(e.getMessage());
            }
        }
        return boxedMilkArea;
    }
    private boolean calculateBoxedMilk(StorageTank milkStorageTank,int amount){
        return  amount<=  milkStorageTank.getSize();
    }
    private void removeForBoxedMilk(StorageTank milkStorageTank,int amount){
        milkStorageTank.removeStorage(amount);
    }



    public StorageArea produceYogurt(StorageArea yogurtStorageArea,StorageTank milkStorageTank, StorageTank yeastStorageTank, int amount) {
        amount=Math.round(amount/14)*14;
        if (calculateYogurt( milkStorageTank, yeastStorageTank, amount )) {
            try{
                if(yogurtStorageArea.getSize()+amount<=10000) {
                    removeForYogurt( milkStorageTank, yeastStorageTank, amount );
                    while (amount > 0) {
                        Yogurt yogurt = new Yogurt();
                        yogurtStorageArea.addStorage( yogurt );
                        amount--;
                    }
                }else{
                    throw new StorageFullException();
                }
            }catch (StorageFullException e){
                System.out.println(e.getMessage());
            }

        }
        return yogurtStorageArea;
    }
    private boolean calculateYogurt(StorageTank milkStorageTank, StorageTank yeastStorageTank, int amount){
        return (amount*15)/14<=milkStorageTank.getSize() && (amount)/14<= yeastStorageTank.getSize();
    }
    private void  removeForYogurt(StorageTank milkStorageTank, StorageTank yeastStorageTank, int amount){
        milkStorageTank.removeStorage( (amount*15)/14 );
        yeastStorageTank.removeStorage( (amount)/14 );
    }
}
