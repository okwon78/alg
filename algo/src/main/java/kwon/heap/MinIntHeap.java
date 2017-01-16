package kwon.heap;

import java.util.Arrays;

/**
 * Created by nhnent on 22/12/2016.
 */
public class MinIntHeap {
    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private int parent(int index) {
        return items[getParentIndex(index)];
    }

    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private void swap(int indexOne, int indexTwo) {
        int tmp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = tmp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            this.capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0)
            throw new IllegalStateException();

        return items[0];
    }

    public int poll() {
        if (size == 0 )
            throw new IllegalStateException();

        int item = items[0];
        items[0] = items[size-1];
        size--;
        
        heapifyDown();
        
        return item;
    }

    public void add(int value) {
        ensureExtraCapacity();
        items[size] = value;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;

        while(hasParent(index)) {

            if (parent(index) > items[index])
                break;

            int parentIndex = getParentIndex(index);
            swap(parentIndex, index);
            index = parentIndex;
        }

    }

    private void heapifyDown() {

        int index = 0;
        int value = items[0];

        while(hasLeftChild(index)) {

            int smallChildIndex = getLeftChildIndex(index);
            int leftValue = leftChild(index);

            if (hasRightChild(index)) {
                if (rightChild(index) < leftValue) {
                    smallChildIndex = getRightChildIndex(index);
                }
            }

            if (items[smallChildIndex] < items[index]) {
                break;
            }

            swap(smallChildIndex, index);
            index = smallChildIndex;
        }
    }
}
