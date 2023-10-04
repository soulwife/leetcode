class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] initialStringSet = s.toCharArray();
        StringBuilder temporarySet = new StringBuilder();
        String currentItem = new String(), nonRepeatingStringSet = new String(), substring = new String();
        int index = 0, temporarySetlength = 0;
        if (s.isEmpty()) return 0;
        for (int i = 0; i< initialStringSet.length; i++) {
            currentItem = Character.toString(initialStringSet[i]);
            if (temporarySet.indexOf(currentItem) < 0) 
                temporarySet.append(currentItem);
            else {
                if (temporarySet.length() > 0) {
                    index = temporarySet.indexOf(currentItem)+1;
                    temporarySetlength = temporarySet.length();
                    substring = temporarySet.substring(index, temporarySet.length());
                    temporarySet.setLength(0); 
                    if (index < temporarySetlength)
                        temporarySet.append(substring);
                }
                if(nonRepeatingStringSet.compareTo(temporarySet.toString()) == 0)
                nonRepeatingStringSet = "";

                if (temporarySet.indexOf(currentItem) < 0) {
                    temporarySet.append(currentItem);
                }
            }
            if (nonRepeatingStringSet.length() < temporarySet.length())
                nonRepeatingStringSet = temporarySet.toString();
        }

        return nonRepeatingStringSet.length() > 0 ? nonRepeatingStringSet.length() : 1;

    }
}
