package com.tgt.testapp.dataoperations;

/** countPartition(num, limit)
 * @param: num denotes the number to which the partitions to be counted.
 * @param: limit denotes the upper limit of part size.
 *
 * @return: number of ways in which num can be expressed as the
 * sum of positive integer parts upto m.
 *
 * countPartitions(6, 4)
 *  -> 2 + 4; 3 + 3; 1 + 1 + 4; 1 + 1 + 1 + 3; 1 + 1 + 1 + 1 + 2; 1 + 1..+ 1
 */

public class PartitionCount {

   int num;
   int limit;

   public int partitionCountMethod(int num, int limit) {
       if (num == 0) {
           return 1;
       } else if (num < 0 || limit == 0) {
           return 0;
       } else {
           return (partitionCountMethod((num - limit), limit)
                   + partitionCountMethod(num, (limit - 1)));
       }
   }

   public static void main(String[] args) {
       PartitionCount partitionCount = new PartitionCount();
       int result = partitionCount.partitionCountMethod(16, 8);
       System.out.println("total count: "+ result);
   }


}
