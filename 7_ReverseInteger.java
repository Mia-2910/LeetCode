class Solution {
    public int reverse(int x) {

        if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE){
                return 0;
        }

        // Use a long so it can hold numbers beyond 2 Billion without corrupting them
        long  value = 0;
        int sign = 0;

        // Handle 1 digits
        if (Math.abs(x) < 10){
            return x;
        }
        // Hanldle pos, neg
        if (x < 0){
            sign = -1;
            x = -x;
        } else {
            sign = 1;
        }

        while (x >= 10){
            value = value*10 + (x%10);
            x = x / 10;
        }
        // Handle last digits 
        if (x != 0) {
            value =  ( value*10 + x ) * sign;
        }

        //Check immediately if the value has broken the Integer limits
        if (value >= (Math.pow(2,31) - 1) || value <= (-1)*Math.pow(2,31)) {
            return 0; // Return 0 if it overflows
        }
        

        return (int) value;
    }
}