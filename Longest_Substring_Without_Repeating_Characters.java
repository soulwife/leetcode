class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] initialStringSet = s.toCharArray();
        String nonRepeatingStringSet = new String(), temporarySet = new String(), currentItem = new String();
        int index = 0;
        if (s.isEmpty()) return 0;
        for (int i = 0; i< initialStringSet.length; i++) {
            currentItem = Character.toString(initialStringSet[i]);
            if (temporarySet.indexOf(initialStringSet[i]) < 0) 
                temporarySet = temporarySet.concat(currentItem);
            else {
                if (!temporarySet.isEmpty()) {
                    index = temporarySet.indexOf(initialStringSet[i])+1;
                    if (index < temporarySet.length())
                        temporarySet = temporarySet.substring(index, temporarySet.length());
                    else 
                        temporarySet = "";   
                }
                if(nonRepeatingStringSet.compareTo(temporarySet) == 0)
                nonRepeatingStringSet = "";

                if (temporarySet.indexOf(initialStringSet[i]) < 0) {
                    temporarySet = temporarySet.concat(currentItem);
                }
            }
            if (nonRepeatingStringSet.length() < temporarySet.length())
                nonRepeatingStringSet = temporarySet;
        }

        return nonRepeatingStringSet.length() > 0 ? nonRepeatingStringSet.length() : 1;

    }
}
