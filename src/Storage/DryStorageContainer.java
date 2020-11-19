package Storage;

import Exceptions.EmptyStorageException;
import Factory.Products;

import java.util.Stack;

public class DryStorageContainer<T> implements IContainer<T> {
    int capacity= 1000;
    Stack<Products> containerStack = new Stack<>();
    @Override
    public void addStorage (T object) {
        Products products = (Products) object;

        if (!isFull()) {
            containerStack.push( products );
        }
    }

    public void removeStorage(){
        containerStack.removeAllElements();
    }
    public int getSize() {
        try {
            if (containerStack.size() == 0) {
                throw new EmptyStorageException();
            }

            return (int) (containerStack.size()*containerStack.get(0).getAmount());
        }catch (EmptyStorageException e){
            return 0;
        }
    }


    public boolean isEmpty(){
        return containerStack.isEmpty();
    }
    public boolean isFull(){
        return containerStack.size()>=capacity;
    }
    public String getName(){
        return "Dry Storage Container";
    }
}

