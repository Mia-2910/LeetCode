class Solution {
    public int romanToInt(String s) {
        int result = 0;
       // char[] cArray = Integer.toString(num).toCharArray();
        char[] cArray = s.toCharArray();
        for (int i =0; i < cArray.length; i ++){
            char checkValue = cArray[i];
            int tmp = 0;
            if (checkValue == 'I'){
                if (((i+1) < cArray.length)  && cArray[i+1] == 'V'  ){
                    tmp = 4;
                    i++;
                } else if (((i+1) < cArray.length)  && cArray[i+1] == 'X'){
                    tmp = 9;
                    i++;
                } else {
                    tmp = 1;
                }
            } else if (checkValue == 'V'){
                tmp = 5;
            } else if (checkValue == 'X'){
                if (((i+1) < cArray.length)  && cArray[i+1] == 'L' ){
                    tmp = 40;
                    i++;
                } else if (((i+1) < cArray.length)  && cArray[i+1] == 'C' ){
                    tmp = 90;
                    i++;
                } else {
                    tmp = 10;
                }
            } else if (checkValue == 'L'){
                tmp = 50;
            } else if (checkValue == 'C'){
                if (((i+1) < cArray.length)  && cArray[i+1] == 'D' ){
                    tmp = 400;
                    i++;
                } else if (((i+1) < cArray.length)  && cArray[i+1] == 'M'){
                    tmp = 900;
                    i++;
                } else {
                    tmp = 100;
                }
            } else if (checkValue == 'D'){
                tmp = 500;
            } else if (checkValue == 'M'){
                tmp = 1000;
            }

            result += tmp;
        }
        return result;
    }
}