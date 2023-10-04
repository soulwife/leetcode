class Solution {
    String[] phoneButtons = new String[] {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        getCombinations(digits, 0, new StringBuilder(), res);
        return res;
    }

    public void getCombinations(String digits, int index, StringBuilder sb, List<String> results) {
        if (index == digits.length()) {
            results.add(sb.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        char[] characters = phoneButtons[digit].toCharArray();
        for (char c : characters) {
            sb.append(c);
            getCombinations(digits, index+1, sb, results);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
