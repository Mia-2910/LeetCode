class 16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
       
        int sum = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(sum - target);

        for (int i = 0 ; i < nums.length - 2; i ++){
            int firstValue = nums[i];
            for (int k = i + 1;  k < nums.length - 1 ; k ++){
                int secondValue = nums[k];
            
                for (int j = k + 1 ; j < nums.length ; j ++){
                    int thirdValue = nums[j];
                    int tmpSum = firstValue + secondValue + thirdValue;
                    int subT = Math.abs(tmpSum - target);

                    if (subT <= diff){
                        sum = tmpSum;
                        diff = subT;
                    }
                }
            }
        
        }

        return sum;
    }
}