import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[10000000];
        for(int i = 0;i<array.length;i++){
            array[i] = (int)(Math.random()*(100000));
        }
        System.out.println("Unsorted Array:");
        //print(array);
        QuickSort(array, 0, array.length-1);
        System.out.println("Sorted Array: ");
        //print(array);
    }
    public static void QuickSort(int[] array, int lowIndex, int highIndex){
        if(lowIndex>= highIndex) return;

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);

        int leftPointer = lowIndex, rightPointer = highIndex;

        while (leftPointer<rightPointer){
            while(array[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }
            while(array[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }
        swap(array, leftPointer, highIndex);

        QuickSort(array, lowIndex, leftPointer-1);
        QuickSort(array, leftPointer +1, highIndex);

    }
    public static void swap(int[] arr, int num1, int num2){
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }
    public static void print(int[] arr){
        for(int i: arr){
            System.out.println(i);
        }
    }
}