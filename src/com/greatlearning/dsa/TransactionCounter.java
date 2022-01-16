package com.greatlearning.dsa;

import java.util.Scanner;

public class TransactionCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the size of transaction array");
        int noOfTransactions = sc.nextInt();
        int arr[] = new int[noOfTransactions];
        System.out.println("Enter the values of array");
        for(int i=0;i<arr.length;i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the total no of targets that needs to be achieved");
        int noOfTargets = sc.nextInt();
        while(noOfTargets-- != 0) {
            System.out.println("\nEnter the value of target");
            long targetValue = sc.nextInt();
            boolean isTargetAchieved = false;
            int count = 0;
            for(int i=0;i<arr.length;i++) {
                if(arr[i] >= targetValue) {
                    count++;
                    System.out.println("Target achieved after " + count + " transactions");
                    isTargetAchieved = true;
                    break;
                } else if(arr[i] < targetValue) {
                    targetValue -= arr[i];
                    count++;
                }
            }
            if(isTargetAchieved==false) {
                System.out.println("Given target is not achieved");
            }
        }
        System.out.println();
    }
}
