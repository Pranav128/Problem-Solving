class Solution {
    public int longestSubstring(String s, int k) 
    {
 if (s == null || s.isEmpty() || k > s.length()) {
            return 0;
        }

        return longestSubstring(s, 0, s.length() - 1, k);
        
    }
     private static int longestSubstring(String s, int start, int end, int k) {
        if (end - start + 1 < k) {
            return 0; // length of substring s[start..end] is less than k
        }

        int[] map = new int[26]; // letter -> freq
        for (int i = start; i <= end; i++) {
            map[s.charAt(i) - 'a']++;
        }

        Set<Character> delimiters = new HashSet<>(); // set of infrequent letters
        for (int i = start; i <= end; i++) {
            char ch = s.charAt(i);
            if (0 < map[ch - 'a'] && map[ch - 'a'] < k) { // map[ch - 'a'] = 0 means this letter doesn't appear in current substring
                delimiters.add(ch);
            }
        }

        if (delimiters.isEmpty()) {
            return end - start + 1; // there's no infrequent letters in current substring
        }

        // split current substring at each delimiter
        int max = 0;      // length of longest substring T in the range s[start..end]
        int left = start; // left end of splitted substring
        for (int right = start; right <= end; right++) {
            if (delimiters.contains(s.charAt(right))) {
                max = Math.max(max, longestSubstring(s, left, right - 1, k));
                left = right + 1;
            }
        }

        // Don't forget the last splitted substring after the last delimiter
        max = Math.max(max, longestSubstring(s, left, end, k));
        return max;
    }
}