package com.vodopolov.makeZigzag;

/**
 * Created by Anton on 08.02.2020.
 */
public class Zigzag {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] array2 = {9, 6, 1, 6, 2};
        int[] array3 = {2, 7, 10, 9, 8, 9};
        int[] array4 = {10, 4, 4, 10, 10, 6, 2, 3};

        Zigzag zigzag = new Zigzag();
        System.out.println(zigzag.checkForZigzagDifference(array1));
        System.out.println(zigzag.checkForZigzagDifference(array2));
        System.out.println(zigzag.checkForZigzagDifference(array3));
        System.out.println(zigzag.checkForZigzagDifference(array4));
    }

    private int checkForZigzagDifference(int[] nums) {
        EvenZigzagIterator evenIterator = new EvenZigzagIterator();
        OddZigzagIterator oddIterator = new OddZigzagIterator();
        evenIterator.process(nums);
        oddIterator.process(nums);
        return evenIterator.stepsToMakeCorrect > oddIterator.stepsToMakeCorrect ? oddIterator.stepsToMakeCorrect : evenIterator.stepsToMakeCorrect;
    }

    private class EvenZigzagIterator extends ZigzagIterator {
        @Override
        boolean checkIfPeak(int id) {
            return id % 2 == 0;
        }
    }

    private class OddZigzagIterator extends ZigzagIterator {
        @Override
        boolean checkIfPeak(int id) {
            return id % 2 == 1;
        }
    }

    private abstract class ZigzagIterator {
        int stepsToMakeCorrect;
        private int previous, current;

        abstract boolean checkIfPeak(int id);

        void process(int[] array) {
            previous = array[0];
            current = array[1];
            checkForDiff(1);
            if (array.length <= 2) return;
            for (int i = 2; i < array.length; i++) {
                previous = current;
                current = array[i];
                checkForDiff(i);
            }
        }

        void checkForDiff(int currentId) {
            if (checkIfPeak(currentId)) {
                if (current <= previous) {
                    int stepsForCurrentStage = (previous + 1) - current;
                    previous -= stepsForCurrentStage;
                    stepsToMakeCorrect += stepsForCurrentStage;
                }
            } else {
                if (current >= previous) {
                    int stepsForCurrentStage = (current + 1) - previous;
                    current -= stepsForCurrentStage;
                    stepsToMakeCorrect += stepsForCurrentStage;
                }
            }
        }
    }
}
