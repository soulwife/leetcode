class Solution {
    private int maxLength = 0, start = 0;
    
    public String longestPalindrome(String s) {
        int n = s.length(); 
        if (s == null || n < 2) {
            return s;
        }
        for (int i = 0; i < n; i++) {
            extendPalindrome(s, i, i);     // Check for odd-length palindrome
            extendPalindrome(s, i, i + 1); // Check for even-length palindrome
            if(maxLength == n) break;
        }
        return s.substring(start, start + maxLength);
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Calculate length of palindrome and update start and maxLength
        int length = right - left - 1;
        if (length > maxLength) {
            maxLength = length;
            start = left + 1;
        }
    }

}
