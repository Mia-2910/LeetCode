
class Solution {
    public int[] twoSum(int[] nums, int target) {
       int[] indice = new int[2];
        for (int i = 0 ; i < nums.length; i++){
            int value1 = nums[i];
                for (int j = 1 ; j < nums.length; j++){
                    int value2 = nums[j];
                    if ((value1 + value2) == target && (i != j) ){
                       indice[0] = i;
                        indice[1] = j;
                        return indice;
                    }
                }
            
        }
        return indice;
    }
}