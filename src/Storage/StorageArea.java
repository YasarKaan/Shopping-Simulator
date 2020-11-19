package Storage;

import Exceptions.EmptyStorageException;
import Factory.*;
import java.util.LinkedList;
import java.util.Queue;


public class StorageArea<T> implements IStorage<T> {
    public Queue<Products> storageQueue = new LinkedList<>();
    double amount=0;

    public void addStorage(T object) {
        try {
            Products products = (Products) object;
            if (!isFull()){
                storageQueue.offer(products);
                amount=products.getAmount()+amount;
            }
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }
    }


    public void removeStorage(int amount) {
        try {
            int sizeAtFirst=storageQueue.size();
            while(getSize()>sizeAtFirst-amount){
                if (storageQueue.isEmpty()) {
                    throw new EmptyStorageException();
                } else {
                    storageQueue.poll();
                }
            }
        }catch(EmptyStorageException e){
            System.out.println(e.getMessage());
        }
    }
    public boolean isEmpty(){
        return amount==0;
    }

    public int getSize(){
        if(storageQueue.size()==0){
            return 0;
        }
        return (int) (storageQueue.peek().getAmount()*storageQueue.size());
    }

    public boolean isFull() {
        return (getSize() > 10000);
    }

    public String toString(){
        if(storageQueue.size()==0){
            return "0";
        }
        String product = storageQueue.peek().getName();
        return product + " " + storageQueue.size();
    }


}