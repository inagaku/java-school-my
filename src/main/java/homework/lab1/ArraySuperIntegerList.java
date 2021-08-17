package homework.lab1;

import java.util.Arrays;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class ArraySuperIntegerList implements SuperIntegerList {
    private int[] arrayInts;
    private int currentPos;

    ArraySuperIntegerList() {
        this.arrayInts = new int[1];
        this.currentPos = 0;
    }

    ArraySuperIntegerList(List<Integer> realList) {
        int listSize = realList.size();
        this.arrayInts = new int[listSize];
        this.currentPos = listSize;

        for (int i = 0; i < listSize; ++i) {
            this.arrayInts[i] = realList.get(i).intValue();
        }
    }

    @Override
    public void add(int number) {
        if (currentPos == arrayInts.length) {
            int[] tmpArray = arrayInts.clone();
            arrayInts = new int[currentPos * 2];
            System.arraycopy(tmpArray,0, arrayInts, 0, currentPos);
        }

        arrayInts[currentPos++] = number;
    }

    @Override
    public void removeByIndex(int index) {
        if (index >= currentPos || index < 0) {
            System.out.println("Index is out of array size");
            return;
        }

        System.arraycopy(arrayInts,index+1, arrayInts, index, currentPos-index-1);
        currentPos--;
    }

    @Override
    public void removeByValue(int value) {
        for (int i = 0; i < currentPos; ++i) {
            if (arrayInts[i] == value) {
                System.arraycopy(arrayInts,i+1, arrayInts, i, currentPos-i-1);
                currentPos--;
            }
        }
    }

    @Override
    public int get(int index) {
        if (index >= currentPos || index < 0) {
            System.out.println("Index is out of array size");
            return -1;
        }

        return arrayInts[index];
    }

    @Override
    public void printAll() {
        for (int i = 0; i < currentPos; ++i) {
            System.out.print(arrayInts[i] + " ");
        }
        System.out.println();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArraySuperIntegerList that = (ArraySuperIntegerList) o;

        if (currentPos != that.currentPos) return false;
        return Arrays.equals(arrayInts, that.arrayInts);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(arrayInts);
        result = 31 * result + currentPos;
        return result;
    }
}
