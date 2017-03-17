package com.sdajava.countingsort;

public class Main {

    public static void main(String[] args) {

        CountingSort sortNumbers = new CountingSort();
        sortNumbers.createRandomArray();
        sortNumbers.sortIt();
    }
}
