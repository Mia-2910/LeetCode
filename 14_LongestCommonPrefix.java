class 14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String common = "";
        String intializeWord = strs[0];
        for (int i = 0; i < intializeWord.length(); i ++){
            char checkLetter=  intializeWord.charAt(i);
            for (int j = 1; j < strs.length; j ++){
                String compareWord = strs[j];
                if (i >= compareWord.length()) {
                   return common;
                }
                char compareLetter = compareWord.charAt(i);
                if (compareLetter != checkLetter){
                   return common;
                }
            }

            common += checkLetter;
        }
        return common;
    }
}