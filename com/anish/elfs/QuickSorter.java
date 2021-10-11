package com.anish.elfs;

public class QuickSorter<T extends Comparable<T>> implements Sorter<T>{
    private T[] a;
    private int low, high;
    
    

    public void load(T[] a) {
        this.a = a;
        this.low=0;
        this.high=a.length-1;
    }

    public void quickSortSort() {

    }

    private void swap(int i, int j) {
        T temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

    private String plan = "";

    private int partition(int low,int high){
        T x=a[low];
        int i=low;
        int j=high;
        while(i<j){
            while(i<j && a[j].compareTo(x)>=0)
                j--;
            while(i<j && a[i].compareTo(x)<0)
                i++;

            if(i!=j)
                swap(i,j);
        }
        swap(i,low);
        return i;


    }
    private void quicksort(int low,int high){
        if(low<high){
            int i=partition(low,high);
            quicksort(low,i-1);
            quicksort(i+1,high);
        }
    }

    @Override
    public void sort() {
        quicksort(this.low,this.high);
    }

    @Override
    public String getPlan() {
        return this.plan;
    }
    
}
