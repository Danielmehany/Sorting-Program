public class SortingAlgorithmsDemo {

    public static void main(String[] args) {
        // Define an array with 100 different integers
        int numberArray[] = {23, 87, 12, 56, 99, 5, 41, 73, 18, 65, 9, 78, 25, 44, 67, 13, 30, 89, 34, 55, 22, 91, 76, 38, 10, 80, 47, 2, 81, 53, 14, 26, 49, 68, 1, 95, 39, 59, 7, 27, 82, 19, 35, 88, 50, 11, 20, 98, 37, 60, 15, 29, 48, 85, 6, 21, 42, 92, 66, 4, 54, 31, 83, 24, 40, 72, 16, 33, 46, 57, 3, 75, 8, 58, 90, 36, 63, 77, 32, 62, 84, 43, 51, 70, 17, 52, 61, 93, 45, 28, 71, 64, 94, 74, 79, 98, 69, 86, 97, 100};

        // Measure and print the time taken for selection sort
        long selectionStartTime = System.nanoTime();
        selectionSort(numberArray);
        long selectionEndTime = System.nanoTime();
        long selectionDuration = selectionEndTime - selectionStartTime;

        System.out.println("Selection Sort:");
        for (int num : numberArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println(selectionDuration + " nanoseconds");

        // Measure and print the time taken for insertion sort
        long insertionStartTime = System.nanoTime();
        insertionSort(numberArray);
        long insertionEndTime = System.nanoTime();
        long insertionDuration = insertionEndTime - insertionStartTime;

        System.out.println("Insertion Sort:");
        for (int num : numberArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println(insertionDuration + " nanoseconds");

        // Measure and print the time taken for merge sort
        long mergeStartTime = System.nanoTime();
        mergeSort(numberArray);
        long mergeEndTime = System.nanoTime();
        long mergeDuration = mergeEndTime - mergeStartTime;

        System.out.println("Merge Sort:");
        for (int num : numberArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println(mergeDuration + " nanoseconds");

        // Measure and print the time taken for bubble sort
        long bubbleStartTime = System.nanoTime();
        bubbleSort(numberArray);
        long bubbleEndTime = System.nanoTime();
        long bubbleDuration = bubbleEndTime - bubbleStartTime;

        System.out.println("Bubble Sort:");
        for (int num : numberArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println(bubbleDuration + " nanoseconds");
    }

    // Selection sort algorithm
    private static void selectionSort(int[] numArray) {
        for (int i = 0; i < numArray.length - 1; i++) {
            int minimum = i;
            for (int j = i + 1; j < numArray.length; j++) {
                if (numArray[minimum] > numArray[j]) {
                    minimum = j;
                }
            }

            int temp = numArray[i];
            numArray[i] = numArray[minimum];
            numArray[minimum] = temp;
        }
    }

    // Insertion sort algorithm
    private static void insertionSort(int[] numArray) {
        for (int i = 0; i < numArray.length; i++) {
            int temp = numArray[i];
            int j = i - 1;

            while (j >= 0 && numArray[j] > temp) {
                numArray[j + 1] = numArray[j];
                j--;
            }

            numArray[j + 1] = temp;
        }
    }

    // Merge sort algorithm
    private static void mergeSort(int[] numArray) {
        int numArrayLength = numArray.length;
        if (numArrayLength <= 1) return;

        int middleIndex = numArrayLength / 2;
        int[] firstHalf = new int[middleIndex];
        int[] secondHalf = new int[numArrayLength - middleIndex];

        int i = 0, j = 0;

        for (; i < numArrayLength; i++) {
            if (i < middleIndex) {
                firstHalf[i] = numArray[i];
            } else {
                secondHalf[j] = numArray[i];
                j++;
            }
        }

        mergeSort(firstHalf);
        mergeSort(secondHalf);
        merge(firstHalf, secondHalf, numArray);
    }

    // Helper method to merge two sorted arrays
    private static void merge(int[] firstHalf, int[] secondHalf, int[] numArray) {
        int firstLength = firstHalf.length;
        int secondLength = secondHalf.length;

        int i = 0, left = 0, right = 0;

        while (left < firstLength && right < secondLength) {
            if (firstHalf[left] < secondHalf[right]) {
                numArray[i] = firstHalf[left];
                left++;
            } else {
                numArray[i] = secondHalf[right];
                right++;
            }
            i++;
        }

        while (left < firstLength) {
            numArray[i] = firstHalf[left];
            left++;
            i++;
        }

        while (right < secondLength) {
            numArray[i] = secondHalf[right];
            right++;
            i++;
        }
    }

    // Bubble sort algorithm
    private static void bubbleSort(int[] numArray) {
        for (int i = 0; i < numArray.length; i++) {
            for (int j = 0; j < numArray.length - i - 1; j++) {
                if (numArray[j] > numArray[j + 1]) {
                    int temp = numArray[j];
                    numArray[j] = numArray[j + 1];
                    numArray[j + 1] = temp;
                }
            }
        }
    }
}
