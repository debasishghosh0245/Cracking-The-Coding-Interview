package unacademy;

import java.util.*;

public class SubsetString {
    public static void main(String[] args) {
        // ArrayList<Integer> outputlist = new ArrayList<>();
        int[] arr = { 1, 2,3 };
        printSumSubSet(arr,0,0);
        //List<List<Integer>> list1 = printSubsetArrayIterative(arr);
        //System.out.println(list1);
    }

    public static List<String> printSubSet(String originalString, String outputString) {
        ArrayList<String> list = new ArrayList<String>();
        if (originalString.isEmpty()) {
            list.add(outputString);
            return list;
        }
        char ch = originalString.charAt(0);
        List<String> list1 = printSubSet(originalString.substring(1), outputString + ch);
        List<String> list2 = printSubSet(originalString.substring(1), outputString);
        list1.addAll(list2);
        return list1;
    }

    public static void printSubsetArray(int[] arr, int index, ArrayList<Integer> outputlist) {
        if (arr.length == index) {
            System.out.println(outputlist);
            return;
        }
        printSubsetArray(arr, index + 1, new ArrayList<Integer>(outputlist));
        outputlist.add(arr[index]);
        printSubsetArray(arr, index + 1, new ArrayList<Integer>(outputlist));
    }

    public static List<List<Integer>> printSubsetArrayIterative(int[] arr) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(new ArrayList<Integer>());
        for (int num : arr) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                List<Integer> internalList = new ArrayList<Integer>(list.get(i));
                internalList.add(num);
                list.add(internalList);
                System.out.println(list);
            } 
        }
        return list;
    }

    public static void printSumSubSet(int[] arr,int index,int sum) {
        if (arr.length == index) {
            System.out.println(sum);
            return;
        }
        printSumSubSet(arr, index + 1,sum);
        sum=sum+arr[index];
        printSumSubSet(arr, index + 1,sum);
    }
}
