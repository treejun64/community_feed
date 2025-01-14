package org.example.common.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositiveIntegerCounterTest {

    @Test
    void increase() {
        //given
        PositiveIntegerCounter counter = new PositiveIntegerCounter();

        //when
        counter.increse();

        //then
        assertEquals(1, counter.getCount());
    }

    @Test
    void decrease() {
        //given
        PositiveIntegerCounter counter = new PositiveIntegerCounter();
        counter.increse();

        //when
        counter.decrease();

        //then
        assertEquals(0, counter.getCount());
    }

    @Test
    void decreaseZero() {
        //given
        PositiveIntegerCounter counter = new PositiveIntegerCounter();

        //when
        counter.decrease();

        //then
        assertEquals(0, counter.getCount());
    }
}