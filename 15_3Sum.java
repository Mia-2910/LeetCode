class 15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the given list
        Arrays.sort(nums);
        Set<List<Integer>> unique = new HashSet<>();
       List<List<Integer>> result = new ArrayList<>();

        for (int count = 0 ; count < nums.length; count ++){
            int value = nums[count];

            //Creating list beside first, second value
            Map<Integer, Integer> right = new HashMap<>();
            // Since already sorted the array, skip duplicates.
            if (count > 0 && nums[count] == nums[count - 1]) {
                continue;
            }
            // Build element for list once
            for (int k = count + 1; k < nums.length; k++) {
                right.put(nums[k], right.getOrDefault(nums[k], 0) + 1);
            }

            for (int i = count + 1; i < nums.length; i ++){
                // Since already sorted the array, skip duplicates.
                if (i > count + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }

                // Remove current secondValue for rightHand list
                right.put(nums[i], right.get(nums[i]) - 1);
                if (right.get(nums[i]) == 0) {
                    right.remove(nums[i]);
                }

                int secondValue = nums[i];
                int thirdValue = 0 - secondValue - value;

                if (right.containsKey(thirdValue) ) {
                    List<Integer> triplet =
                            Arrays.asList(value, secondValue,thirdValue);

                    Collections.sort(triplet);

                    if (unique.add(triplet)) {
                        result.add(triplet);
                    }
                }
            }
        }
        return result;
    }
}