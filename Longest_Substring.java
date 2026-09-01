// Leetcode:3. Longest Substring Without Repeating Characters
// Given a string s, find the length of the longest substring without duplicate characters.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int c = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                i = Math.max(i, map.get(ch) + 1);
            }
            map.put(ch, j);
            c = Math.max(c, j - i + 1);

            j++;
        }

        return c;
    }
}
