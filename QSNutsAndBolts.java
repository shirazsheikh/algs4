/*
* Author: Shiraz Sheikh
* Date:   Jul 10, 2022
*
* A disorganized carpenter has a mixed pile of nn nuts and nn bolts. The goal is to find the
* corresponding pairs of nuts and bolts. Each nut fits exactly one bolt and each bolt fits
* exactly one nut. By fitting a nut and a bolt together, the carpenter can see which one is
* bigger (but the carpenter cannot compare two nuts or two bolts directly). Design an algorithm
* for the problem that uses at most proportional to n \log nnlogn compares (probabilistically).
*
* References:
* https://www.geeksforgeeks.org/nuts-bolts-problem-lock-key-problem/
*
 */

import edu.princeton.cs.algs4.StdRandom;

public class QSNutsAndBolts {

  private static void printArray(Comparable[] arr){
    for (Comparable ch : arr){
      System.out.print(ch + " ");
    }
    System.out.print("\n");
  }

  private static boolean less(Comparable One, Comparable Two) {
    return (One.compareTo(Two) < 0);
  }

  private static void exch(Comparable[] a, int i, int j) {
    Comparable swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  private static int partition(Comparable[] a, int low, int high) {
    int i = low, j = high+1;
    while (true) {
      while (less(a[++i], a[low]))
        if (i == high) break;
      while (less(a[low], a[--j]))
        if (j == low) break;
      if (i >= j) break;
      exch(a, i, j);
    }
    exch(a, low, j);
    return j;
  }

  private static int partition(Comparable[] a, int low, int high, Character pivot) {
    int i = low;
    int j = high;
    while (true) {
      while ((Character) a[i] < pivot)
        i++;
        if (i == high) break;
      while ((Character) a[j] > pivot)
        j--;
        if (j == low) break;
      if (i >= j) break;
      exch(a, i, j);
    }
    return j;
  }

  private static void sort(Comparable[] a, Comparable[] b, int low, int high){
    if (high <= low) return;
    int j = partition(a, low, high);
    Character x = (Character) a[j];
    int k = partition(b, low, high, x);
    sort(a, b, low, j-1);
    sort(a, b, j+1, high);
  }

  public static void sort(Comparable[] a, Comparable[] b){
    StdRandom.shuffle(a);
    StdRandom.shuffle(b);
    sort(a, b, 0, a.length-1);
  }

  public static void main(String[] args) {

    QSNutsAndBolts qsnb1 = new QSNutsAndBolts();

    Comparable[] nuts ={'@', '#', '$', '%', '^', '&'};
    Comparable[] bolts ={'$', '%', '&', '^', '@', '#'};

    Comparable[] nutsTwo = {'G', 'C', 'I', 'H', 'R', 'P', 'L'};
    Comparable[] boltsTwo ={'P', 'I', 'C', 'L', 'G', 'H', 'R'};

    System.out.print("The input list of nuts is  ");
    printArray(nutsTwo);
    System.out.print("The input list of bolts is ");
    printArray(boltsTwo);

    sort(nutsTwo, boltsTwo);
    printArray(nutsTwo);
    printArray(boltsTwo);
  }
}
