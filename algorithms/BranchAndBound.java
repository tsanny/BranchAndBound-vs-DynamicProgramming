package algorithms;

import java.util.Arrays;

/* Reference: Rod Stephens (csharphelper.com) - Use branch and bound to solve the partitioning problem in C#
 * http://www.csharphelper.com/howtos/howto_partition_branch_and_bound.html
 */

public class BranchAndBound {

    private static boolean[] bestAssignment;
    private static int bestErr;

    // Partition the values. Return an array with entry i = true if
    // value i belongs in the first set of the partition.
    public static boolean[] findPartition(int[] values) {
        // Make variables to track the best solution and a test solution.
        bestAssignment = new boolean[values.length];
        boolean[] testAssignment = new boolean[values.length];

        // Get the total of all values.
        int totalValue = Arrays.stream(values).sum();

        // Partition the values starting with index 0.
        bestErr = totalValue;
        partitionValuesFromIndex(values, 0, totalValue, totalValue, testAssignment, 0);

        // Return the result.
        return bestAssignment;
    }

    // Partition the values keeping those before index startIndex fixed.
    // testAssignment is the test assignment so far.
    // testValue is the total value of the first set in the test assignment.
    // Initially best assignment and its error are in bestAssignment and bestErr.
    // Update those to reflect any improved solution we find.
    private static void partitionValuesFromIndex(int[] values, int startIndex, int totalValue, int unassignedValue,
                                          boolean[] testAssignment, int testValue) {
        if (bestErr <= 1) return;
        // If startIndex is beyond the end of the array, then all entries have been assigned.
        if (startIndex >= values.length) {
            // We're done. See if this assignment is better than what we have so far.
            int testErr = Math.abs(2 * testValue - totalValue);
            if (testErr < bestErr) {
                // This is an improvement. Save it.
                bestErr = testErr;
                System.out.println(bestErr);
                System.arraycopy(testAssignment, 0, bestAssignment, 0, testAssignment.length);
            }
        } else {
            // See if there's any way we can assign the remaining items to improve the solution.
            int testErr = Math.abs(2 * testValue - totalValue);
            if (testErr - unassignedValue < bestErr) {
                // There's a chance we can make an improvement.
                // We will now assign the next item.
                unassignedValue -= values[startIndex];

                // Try adding values[startIndex] to set 1.
                testAssignment[startIndex] = true;
                partitionValuesFromIndex(values, startIndex + 1, totalValue, unassignedValue,
                                         testAssignment, testValue + values[startIndex]);

                // Try adding values[startIndex] to set 2.
                testAssignment[startIndex] = false;
                partitionValuesFromIndex(values, startIndex + 1, totalValue, unassignedValue,
                                         testAssignment, testValue);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 1, 2, 2, 1};
        findPartition(arr);
        System.out.println(bestErr == 0 ? "Can be divided into two subsets of equal sum" : "Cannot be divided into two subsets of equal sum");
    }
}

