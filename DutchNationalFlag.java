/**
 *  Author: Shiraz Sheikh
 *  Date:   July 3, 2022
 *
 *  Dutch national flag. Given an array of nn buckets, each containing a red, white, or blue pebble, sort them by color. The allowed operations are:
 *  swap(i, j)swap(i,j):  swap the pebble in bucket ii with the pebble in bucket jj.
 *  color(i)color(i): determine the color of the pebble in bucket ii.
 *
 *  The performance requirements are as follows:
 *  At most nn calls to color()color().
 *  At most nn calls to swap()swap().
 *  Constant extra space.
 *
 *  Reference: https://github.com/guibin/Knowledge/blob/master/libs/lib.algorithm/src/main/java/guibin/zhang/onlinecourse/DutchNationalFlag.java
 */

public class DutchNationalFlag {

  public void sort(Character[] inputArray) {

    int red = 0;
    int blue = inputArray.length - 1;
    int i = 0;

    while (i <= blue) {

      if (inputArray[i] == 'r') {
        swap(inputArray, red, i);
        red++;
        i++;
      }
      else if (inputArray[i] == 'b') {
        swap(inputArray, blue, i);
        blue--;
        //i++;
      }
      else i++;
    }
  }

  public void swap(Character[] tempArraySwap, int destination, int source) {
    Character tmp = tempArraySwap[destination];
    tempArraySwap[destination] = tempArraySwap[source];
    tempArraySwap[source] = tmp;
  }

  public static void printArray(Character[] tempArrayPrint) {
    for (char c : tempArrayPrint) {
      System.out.print(c);
    }
  }

  public static void main(String[]args) {
    DutchNationalFlag dutchNationalFlagOne = new DutchNationalFlag();

    Character[] inputArrayOne = {'w', 'b', 'r', 'b', 'b', 'r', 'w', 'w' };
    Character[] outputArrayOne = {};
    dutchNationalFlagOne.sort(inputArrayOne);
    System.out.print("The updated array structure is ");
    printArray(inputArrayOne);
  }

}
