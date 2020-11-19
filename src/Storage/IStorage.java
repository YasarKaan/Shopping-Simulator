package Storage;



public interface IStorage<T> {
    void addStorage(T object);
    void removeStorage(int amount);
    boolean isFull();
    int getSize();
    boolean isEmpty();
    String toString();
}
