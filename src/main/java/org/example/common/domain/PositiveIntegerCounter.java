package org.example.common.domain;

public class PositiveIntegerCounter {

    private int count;

    public PositiveIntegerCounter() {
        this.count = 0;
    }

    public void increse() {
        this.count++;
    }

    public void decrease() {
        if (count <= 0) {
            return;
        }
        this.count--;
    }

    public int getCount() {
        return count;
    }
}
