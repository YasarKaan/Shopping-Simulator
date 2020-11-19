package Storage;

import java.util.Stack;

public interface IContainer<T>{
    public Stack containerStack = new Stack<>();
    void addStorage(T object);
    void removeStorage();
    boolean isFull();
    int getSize();
    int capacity=1000;
    String toString();
    public String getName();
}
