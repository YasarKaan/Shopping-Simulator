package Storage;

public interface Liquid<T> {
    public String getName();
    public int getAmount();
    void setAmount(int index);
}
