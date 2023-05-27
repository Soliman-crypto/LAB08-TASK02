

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DARRLTERATOR<T> implements Iterator<T> {
    private int currentIndex = 0;
    int size;
    T[] array;

    public DARRLTERATOR(int currentIndex, int size, T[] array) {
        this.currentIndex = currentIndex;
        this.size = size;
        this.array = array;
    }

    public DARRLTERATOR(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < size;
    }

    @Override
    public T next() {
        if (hasNext()) {
            T element = array[currentIndex];
            currentIndex++;
            return element;
        } else {
            throw new NoSuchElementException("THERE'S NO ANY ELEMENTS IN THE NEW ARRAY.");
        }
    }

    public void increaseSize(int newSize) {
        if (newSize <= size) {
            throw new IllegalArgumentException("NEW SHOULD BE BIGGER THAN THE CURRENT.");
        } else {
            size = newSize;
        }
    }
}