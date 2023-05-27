
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DARRAY<T> implements Iterable {

    int size;
    int capacity = 10;
    private T[] array;

    public DARRAY() {

    }

    protected DARRAY(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public void add(T data) {
        if (size >= capacity) {
            expandTheSizeOfArray();
        }
        array[size] = data;
        size++;
    }

    private void expandTheSizeOfArray() {
        int newCapacity = capacity * 2;
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        capacity = newCapacity;
        array = newArray;
    }

    private void shrink() {
        int newCapacity = (capacity / 2);
        T[] newArray = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        capacity = newCapacity;
        array = newArray;
    }

    public void insert(int index, T data) {
        if (size >= capacity) {
            expandTheSizeOfArray();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = data;
        size++;
    }

    public void delete(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i] == data) {
                for (int j = 0; j < (size - i - 1); j++) {
                    array[i + j] = array[i + j + 1];
                }
                array[size - 1] = null;
                size--;
                if (size <= (int) (capacity / 3)) {
                    shrink();
                }
                break;
            }
        }
    }

    private void swap(int first, int last) {
        T temp = array[first];
        array[first] = array[last];
        array[last] = temp;
    }

    public String toString() {
        String string = " ";
        for (int i = 0; i < size; i++) {
            string += array[i] + ", ";
        }
        return string;
    }

    public void IncreaseSize(int newSize) {
        if (newSize <= size) {
            throw new IllegalArgumentException("NEW SIZE WILL BE GREATER THAN THE CURRENT.");
        }
        T[] newArray = (T[]) new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
        capacity = newSize;
    }

    @Override
    public Iterator<T> iterator() {
        return new DARRLTERATOR<>(0, size, array);
    }
}