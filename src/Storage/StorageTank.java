package Storage;

import Exceptions.EmptyStorageException;
import Exceptions.StorageFullException;
import Warehouse.Ingredients;

import java.util.ArrayList;
import java.util.List;

public class StorageTank<T>implements IStorage<T>{
    public List<Ingredients>  ingredients = new ArrayList<>();
    int capacity=10000;
    private void create(T object){
        try{
            Ingredients ingredient = (Ingredients) object;
            if (ingredient.getAmount()<capacity) {
                ingredients.add( ingredient );
            }else{
                throw new StorageFullException();
            }
        }catch (ClassCastException e){
                System.out.println(e.getMessage());
        }catch (StorageFullException e){
            System.out.println(e.getMessage());
        }
    }
    public void addStorage(T object) {
        try {
            Ingredients ingredient = (Ingredients) object;
            if(ingredients.size()==0){
                create( object );
            }
            else if(!isFull()&& getSize()+ ingredient.getAmount()<=capacity) {
                ingredients.get(0).setAmount(ingredients.get(0).getAmount()+ingredient.getAmount());
                //ingredient.setAmount(0);
            }
        }catch(ClassCastException e){
            System.out.println(e.getMessage());
        }
    }
    public void removeStorage(int amount){
        if(!isEmpty()){
            ingredients.get(0).setAmount( ingredients.get(0).getAmount()-amount);
        }
        else{
            try {
                throw new EmptyStorageException();
            } catch (EmptyStorageException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean isEmpty(){
        if(ingredients.size()==0){
            return true;
        }
        return ingredients.get(0).getAmount()==0;
    }
    public boolean isFull(){
        return ingredients.get( 0 ).getAmount()>=capacity;
    }
    public int getSize() {
        try {
            if (ingredients.size() == 0) {
                throw new EmptyStorageException();
            }

            return ingredients.get( 0 ).getAmount();
        }catch (EmptyStorageException e){
            return 0;
        }
    }

    public String toString(){
        if(ingredients.size()==0){
            return "0";
        }
        return ingredients.get(0).getName()+" "+ingredients.get(0).getAmount();
    }
}
