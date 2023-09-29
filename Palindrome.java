class Solution {
    public boolean isPalindrome(int x) {
        int input = Math.abs(x), reversedInput = 0, remainder;
        while (x != 0) {
            remainder = x % 10;
            reversedInput = reversedInput * 10 + remainder;
            x /= 10;
        }

        return input == reversedInput ? true : false;
    }
}
