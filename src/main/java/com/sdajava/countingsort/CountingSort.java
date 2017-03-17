package com.sdajava.countingsort;

import java.util.Random;

/**
 * Created by User on 2017-03-17.
 */
public class CountingSort {
    int[] tablica = new int[10];

    public void createRandomArray() {
        Random generator = new Random();
        for (int i = 0; i < tablica.length; i++) { // ustalany randomowe wartości tablicy
            tablica[i] = generator.nextInt(10);
            System.out.print(tablica[i] + " ");
        }
    }

    public void sortIt() {
//MIN, MAX
        int min = tablica[0];
        int max = tablica[0];
        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] < min) {
                min = tablica[i];
            } else if (tablica[i] > max) {
                max = tablica[i];
            }
        }
        System.out.print("\nMin: " + min + " Max: " + max + "\n");

//tablica count
        int[] count = new int[max + 1]; // zerujemy
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < tablica.length; i++) { // dodajemy liczniki
            for (int j = 0; j < count.length; j++) {
                if (tablica[i] == j) {
                    count[j]++;
                }
            }
        }
// tablica sumująca
        int[] sumCount = new int[max + 1];
        sumCount[0] = count[0];
        for (int i = 1; i < sumCount.length; i++) {
            sumCount[i] = sumCount[i - 1] + count[i];
        }
//tablica sortująca
        int[] sortedInput = new int[tablica.length];
        for (int i = 0; i < tablica.length; i++) {
            for (int j = 0; j < sumCount.length; j++) {
                if (tablica[i] == j) {
                    int a = sumCount[j];
                    sortedInput[a - 1] = tablica[i];
                    sumCount[j]--;
                }
            }
        }
        for (int i = 0; i < sortedInput.length; i++) {
            System.out.print(sortedInput[i] + " ");
        }
    }
}
