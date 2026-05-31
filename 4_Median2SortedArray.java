class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Exchaneg so nums1 always smaller length
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        int l1 = nums1.length;
        int l2 = nums2.length;
        int halfIndex = (l1 + l2 ) / 2 - 1 ;

        // A shorter B longer array
        // i shorter pointer
        // j longer pointer
        int leftIndexA = -1; //taking 0 elements from nums1 into the left partition
        int rightIndexA = l1 - 1;

        while (leftIndexA <= rightIndexA) {
            int i = (leftIndexA + rightIndexA) / 2  ; // A
            int j = halfIndex - i - 1; // B

            /* total number taken from l1: i + 1  +  from l2: j + 1 = halfIndex + 1
            i + j + 2 = halfIndex + 1
            j = halfIndex - i - 1 */

            float nums1Left = (i >= 0) ? nums1[i] : Float.NEGATIVE_INFINITY;
            float nums1Right = (i + 1 < l1) ? nums1[i + 1] : Float.POSITIVE_INFINITY; // leave as its as inbound, otherwise let it be infinity
            float nums2Left = (j>=0) ? nums2[j] : Float.NEGATIVE_INFINITY;
            float nums2Right = (j+1 < l2) ? nums2[j+1] : Float.POSITIVE_INFINITY; 

            // Partition is correct
            if(nums1Left <= nums2Right && nums2Left <= nums1Right){
                // odd
                if ((l1 + l2) % 2 != 0) {
                     return Math.min(nums2Right, nums1Right);
                //even
                } else {
                    return ( (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0) ;
                }
            } else if (nums1Left > nums2Right){ // decrease size of right partition A
                rightIndexA = i - 1;
            } else { // increase the size of left partition A
                leftIndexA = i + 1;
            }
        }
        return 0.0;
    }
}