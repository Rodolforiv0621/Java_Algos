

public class Main {

    public static void main(String[] args) {
        int[] array = new int[10000000];
        for(int i=0;i<100;i++){
            array[i] = ((int)(Math.random()*(100000)));
        }
        System.out.print("Unsorted Array:\n" );
        //print(array);
        mergeSort(array);
        System.out.println("Sorted Array");
        //print(array);

    }
    public static void mergeSort(int[] array){
        int length = array.length;
        if(length < 2){
            return;
        }
        int mid = length/2;
        int[] leftarr = new int[mid];
        int[] rightarr = new int[length-mid];
        for(int i= 0;i<mid;i++){
            leftarr[i] = array[i];
        }
        for(int i = mid;i<length;i++){
            rightarr[i-mid] = array[i];
        }

        mergeSort(leftarr);
        mergeSort(rightarr);

        merge(array, leftarr, rightarr);
    }
    public static void merge(int[] array, int[] leftarr, int[] rightarr){
        int i = 0, j = 0, k = 0;
        while(i<leftarr.length && j<rightarr.length){
            if(leftarr[i] <= rightarr[j]){
                array[k] = leftarr[i];
                i++;
            }else{
                array[k] = rightarr[j];
                j++;
            }
            k++;
        }
        while(i<leftarr.length){
            array[k] = leftarr[i];
            i++;
            k++;
        }
        while(j<rightarr.length){
            array[k] = rightarr[j];
            j++;
            k++;
        }

    }
    public static void print(int[] array){
        System.out.print("[");
        for(int i =0;i<array.length;i++){
            System.out.print(" "+array[i]+",");
        }
        System.out.print("]\n");
    }
}