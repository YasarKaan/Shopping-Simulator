package Storage;

import Exceptions.EmptyStorageException;

import java.util.Stack;

public class TankContainer<T> implements IContainer<T>{
    int capacity= 1000;
    Stack<Liquid> containerStack = new Stack<>();
    @Override
    public void addStorage (T object) {
        Liquid<T> liquid = (Liquid) object;

        if (containerStack.size() ==0 && liquid.getAmount()<=capacity) {
            containerStack.push(liquid);
        }
        else if(!isFull()&& getSize()+ liquid.getAmount()<=capacity){
                containerStack.get(0).setAmount(containerStack.get(0).getAmount()+liquid.getAmount());
            }
    }
    public void removeStorage(){
        if(!isEmpty()) {
            containerStack.pop();
        }
    }
    public int getSize() {
        try {
            if (containerStack.size() == 0) {
                throw new EmptyStorageException();
            }

            return containerStack.get( 0 ).getAmount();
        }catch (EmptyStorageException e){
            return 0;
        }
    }


    public boolean isEmpty(){
        return containerStack.isEmpty();
    }
    public boolean isFull(){
        return containerStack.get(0).getAmount()==capacity;
    }
    public String getName(){
        return "Tank Container";
    }

}
