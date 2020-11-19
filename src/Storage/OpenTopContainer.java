package Storage;

import Exceptions.EmptyStorageException;
import Exceptions.StorageFullException;

import java.util.Stack;

public class OpenTopContainer<T> implements IContainer<T>{
    int capacity= 1000;
    Stack<Powder> containerStack = new Stack<>();
    @Override
    public void addStorage (T object) {
            Powder<T> powder = (Powder) object;

            if (containerStack.size() == 0 && powder.getAmount() <= capacity) {
                containerStack.push( powder );

            } else if (!isFull() && getSize() + powder.getAmount() <= capacity) {
                containerStack.get( 0 ).setAmount( containerStack.get( 0 ).getAmount() + powder.getAmount() );

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
        return "Open Top Container";
    }
}
