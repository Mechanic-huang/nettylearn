package org.hgz.netty.algorithms;

/**
 * @author huang_guozhong
 * @Description 排序算法延时
 * @Copyright 2015 © anzhi.com
 * @Created 2017/12/19 9:55
 */
public class Sort {


  /**
   * 选择排序
   * 每次找到数组剩下的数据最小的和当前的位置交换；
   * @param arr
   */
  public static void selectionSort (int[] arr){
    for(int i = 0; i < arr.length; i++) {
      int k = i;
      for (int j = k + 1; j < arr.length; j++) {
        if(arr[k] > arr[j]) {
          k = j;
        }
      }
      if (k != i) {
        int temp = arr[k];
        arr[k] = arr[i];
        arr[i] = temp;
      }
    }

  }


  /**
   * 插入排序
   * @param arr
   */
  public static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      for (int j = i; j > 0 ; j--) {
        if (arr[j] < arr[j-1]) {
          // 交换
          int tmp = arr[j];
          arr[j] = arr[j-1];
          arr[j-1] = tmp;
        } else {
          break;
        }
      }
    }
  }


  /**
   * 插入排序加强版
   * @param arr
   */
  public static void insertionSortPlus(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int e = arr[i];
      int j;
      for (j = i; j > 0 && arr[j-1] > e; j--) {
        arr[j] = arr[j-1];
      }
      arr[j] = e;
    }
  }


  /**
   * 冒泡排序
   * @param arr
   */
  public static void bubbleSort(int[] arr) {
    for (int i=0; i < arr.length -1; i++) {
      for(int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j + 1] = temp;
        }
      }
    }
  }

  /**
   * 归并排序
   * @param arr
   */
  public static void mergeSort(int[] arr) {

  }

  public static void main(String[] args) {
    int[] arr = {1,3,2,4,9,6,5};
    bubbleSort (arr);
    System.out.println("排序的结果是：");
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }


}