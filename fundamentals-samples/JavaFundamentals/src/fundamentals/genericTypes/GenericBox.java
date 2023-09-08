package fundamentals.genericTypes;

public class GenericBox<T> {
    //    private String item;
    private T item;

    public GenericBox(T item) {
        this.item = item;
    }

    public T getItem() {
        return this.item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
