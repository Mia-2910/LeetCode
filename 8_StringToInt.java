class Solution {
    public int myAtoi(String s) {
        long result = 0;
        // Remove leading space
        s = s.trim();

        // check sign
        int sign = 1;

        if (s.isEmpty() == true){
            return 0;
        }
        if (s.charAt(0) == '-'){
            sign = -1;
            s = s.substring(1);
        } else if (s.charAt(0) == '+'){
            sign = 1;
            s = s.substring(1);
        }

        // Check digits
        for (int i = 0; i < s.length(); i++){
            char check = s.charAt(i);
            if (check < '0' || check > '9') break; // Stop at non-numeric character

            result = result * 10 + (check - 0x30);
            if (sign * result > Integer.MAX_VALUE) return Integer.MAX_VALUE; // Handle overflow
            if (sign * result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        

        return (int ) (result * sign);
    }
   
}