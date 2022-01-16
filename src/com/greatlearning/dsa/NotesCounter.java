package com.greatlearning.dsa;

import java.util.Scanner;

public class NotesCounter {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the size of currency denominations");
        int noOfDenominations = sc.nextInt();
        int arr[] = new int[noOfDenominations];
        System.out.println("Enter the currency denominations value");
        for(int i=0;i<arr.length;i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the amount you want to pay");
        int payment = sc.nextInt();
        doMergeSort(arr, 0, arr.length-1);
        countNotes(arr,payment);
        System.out.println();
    }
    private static void doMergeSort(int[] arr,int low,int high) {
        if(low<high) {
            int mid = (low+high)/2;
            doMergeSort(arr,low,mid);
            doMergeSort(arr,mid+1,high);
            mergeElements(arr,low,mid,high);
        }
    }
    private static void mergeElements(int[] arr,int low,int mid,int high) {
        int leftArraySize = mid-low+1;
        int rightArraySize = high-mid;
        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];
        for(int i=0;i<leftArraySize;i++) {
            leftArray[i] = arr[low+i];
        }
        for(int i=0;i<rightArraySize;i++) {
            rightArray[i] = arr[mid+1+i];
        }
        int i=0,j=0;
        int k = low;
        while(i<leftArraySize && j<rightArraySize) {
            if(leftArray[i]>=rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while(i<leftArraySize) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while(j<rightArraySize) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
    private static void countNotes(int[] arr,int payment) {
        int[] counter = new int[arr.length];
        try {
            for(int i=0;i<arr.length;i++) {
                if(arr[i]<=payment) {
                    counter[i] = payment/arr[i];
                    payment -= counter[i]*arr[i];
                }
            }
            if(payment>0) {
                System.out.println("\nYour payment cannot be achieved with the highest denomination");
            } else {
                System.out.println("\nYour payment approach in order to give min no of notes will be");
                for(int i=0;i<arr.length;i++) {
                    if(counter[i]>0) {
                        System.out.println(arr[i] + ":" + counter[i]);
                    }
                }
            }
        } catch(ArithmeticException e) {
            System.out.println("\nDenomination cannot be zero");
        }
    }
}
