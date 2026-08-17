// Leetcode :56. Merge Intervals

// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
//  and return an array of the non-overlapping intervals that cover all the intervals in the input.
class Solution {
    public int[][] merge(int[][] nums) {
        Arrays.sort(nums, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {

            if (merged.isEmpty() || merged.getLast()[1] < nums[i][0]) {
                
                merged.add(nums[i]);
            } else {
                merged.getLast()[1] =Math.max(merged.getLast()[1], nums[i][1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
