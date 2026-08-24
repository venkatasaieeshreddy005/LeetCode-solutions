// leet code :14. Longest Common Prefix
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".
class Solution {

    class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        int childCount = 0;
    }

    Node root = new Node();

    public void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
                curr.childCount++;
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public String find() {
        Node curr = root;
        StringBuilder ans = new StringBuilder();

        while (curr.childCount == 1 && !curr.eow) {

            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    ans.append((char) ('a' + i));
                    curr = curr.children[i];
                    break;
                }
            }
        }

        return ans.toString();
    }

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        for (String str : strs) {
            insert(str);
        }

        return find();
    }
}
