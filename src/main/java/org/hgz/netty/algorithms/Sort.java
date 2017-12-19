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
   */
  public static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int k = i;
      for (int j = k + 1; j < arr.length; j++) {
        if (arr[k] > arr[j]) {
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
   */
  public static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      for (int j = i; j > 0; j--) {
        if (arr[j] < arr[j - 1]) {
          // 交换
          int tmp = arr[j];
          arr[j] = arr[j - 1];
          arr[j - 1] = tmp;
        } else {
          break;
        }
      }
    }
  }


  /**
   * 插入排序加强版
   */
  public static void insertionSortPlus(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int e = arr[i];
      int j;
      for (j = i; j > 0 && arr[j - 1] > e; j--) {
        arr[j] = arr[j - 1];
      }
      arr[j] = e;
    }
  }


  /**
   * 冒泡排序
   */
  public static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }

  /**
   * 归并排序 很重要 本质是递归的排序过程
   */
  public static void mergeSort(int[] arr) {

    __mergeSort (arr, 0, arr.length - 1);

  }

  /**
   * 对 arr数组进行 前闭后闭的范围进行排序
   *
   * @param r 最后一个元素的位置
   */
  private static void __mergeSort(int[] arr, int l, int r) {
    if (l >= r) {
      return;
    }
    int mid = (l + r) / 2;
    __mergeSort (arr, l, mid);
    __mergeSort (arr, mid + 1, r);

    // 进行merge操作
    __merge (arr, l, mid, r);
  }

  /**
   * 将arr[l...mid]和arr[mid+1...r]两部分进行归并
   *
   * @param l 左边
   * @param mid 中间
   * @param r 右边
   */
  private static void __merge(int[] arr, int l, int mid, int r) {
    // 临时空间； 要处理的arr空间一样大
    int[] aux = new int[r - l + 1];

    /**
     * 要处理的元素复制到aux
     */
    for (int i = l; i <= r; i++) {
      aux[i - l] = arr[i];
    }

    /**
     * 两个索引，指向排好序的两部分
     */
    int i = l,  // 左边的索引

        j = mid + 1; // 右边的索引

    // 遍历 l --> r 判断k的位置应该是谁
    for (int k = l; k <= r; k++) {
      // 判断索引的合法性
      if (i > mid) {
        arr[k] = aux[j - l];
        j++;
      } else if (j > r) {
        arr[k] = aux[i - l];
        i++;
      } else if (aux[i - l] < aux[j - l]) {        // 查看两边的第一个元素哪个大
        arr[k] = aux[i - l];
        i++;
      } else {
        arr[k] = aux[j - l];
        j++;
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, 3, 2, 4, 9, 6, 5};
    mergeSort (arr);
    System.out.println ("排序的结果是：");
    for (int i : arr) {
      System.out.print (i + " ");
    }


  }


}