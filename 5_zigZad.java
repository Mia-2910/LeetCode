class Solution {
    public String convert(String s, int numRows) {
       StringBuilder [] start = new StringBuilder [numRows];

       for (int i = 0; i < numRows; i ++) {
        start[i] = new StringBuilder();
       }

       int index = 0;
       int length = s.length();

       while (index < length){
            for (int j = 0; j < numRows  && index < length; j ++){
                start[j].append(s.charAt(index));
                index ++;
            }

            for (int u = numRows - 2 ; u > 0 && index < length; u --) {
                start[u].append(s.charAt(index));
                index ++;
            }
       }

        StringBuilder finalResult = start[0] ;
        for (int k = 1; k < numRows; k ++){
            finalResult.append(start[k]);
        }

        return finalResult.toString();

    }
}