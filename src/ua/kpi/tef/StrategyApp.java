package ua.kpi.tef;

import java.util.Arrays;

public class StrategyApp {
    public static void main(String[] args) {
        StrategyClient c = new StrategyClient();

        int[] arr0 = {1, 3, 2, 1};
        c.setStrategy(new BubbleSort());
        c.executeStrategy(arr0);

        int[] arr1 = {6, 3, 9, 0, 6, 7};
        c.setStrategy(new SelectionSort());
        c.executeStrategy(arr1);

        int[] arr2 = {9, 7, 9, 4, 2, 0, 3};
        c.setStrategy(new InsertingSort());
        c.executeStrategy(arr2);
    }
}

//Context
class StrategyClient{
    Sorting strategy;

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] arr){
        strategy.sort(arr);
    }
}

//Strategy
interface Sorting{
    void sort(int[] arr);
}

//Bubble sorting strategy
class BubbleSort implements Sorting{
    public void sort(int[] arr){
        System.out.println("Bubble sorting...");
        System.out.println("before:\t"+ Arrays.toString(arr));
        for (int barier=arr.length-1; barier>=0; barier--){
            for (int i=0; i<barier; i++){
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
        System.out.println("after:\t"+ Arrays.toString(arr));
    }
}

//Selection sorting strategy
class SelectionSort implements Sorting{
    public void sort(int[] arr){
        System.out.println("Selection sorting...");
        System.out.println("before:\t"+ Arrays.toString(arr));
        for (int barier=0; barier<=arr.length-1; barier++){
            for (int i=barier+1; i<arr.length; i++){
                if(arr[i]<arr[barier]){
                    int temp = arr[i];
                    arr[i] = arr[barier];
                    arr[barier] = temp;
                }
            }
        }
        System.out.println("after:\t"+ Arrays.toString(arr));
    }
}

//Inserting sorting strategy
class InsertingSort implements Sorting{
    public void sort(int[] arr){
        System.out.println("Inserting sorting...");
        System.out.println("before:\t"+ Arrays.toString(arr));
        for (int barier=1; barier<arr.length; barier++) {
            int index = barier;
            while (index-1 >= 0 && arr[index] < arr[index - 1]){
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
        System.out.println("after:\t"+ Arrays.toString(arr));
    }
}