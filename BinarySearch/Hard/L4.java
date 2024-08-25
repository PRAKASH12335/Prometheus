package BinarySearch.Hard;

// 4. Median of Two Sorted Arrays

public class L4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if(m > n)
            return findMedianSortedArrays(nums2, nums1);
        if(m == 0){
            if(n%2 == 0)
                return (double)(nums2[(n-1)/2] + nums2[(n-1)/2+1])/2;
            else
                return nums2[n/2];
        }
        int low = 0, high = m;
        while(low <= high) {
            int partitionM = (low + high) / 2;
            int partitionN = (m + n + 1) / 2 - partitionM;
            int maxLeftM = partitionM == 0 ? Integer.MIN_VALUE : nums1[partitionM - 1];
            int minRightM = partitionM == m ? Integer.MAX_VALUE : nums1[partitionM];
            int maxLeftN = partitionN == 0 ? Integer.MIN_VALUE : nums2[partitionN - 1];
            int minRightN = partitionN == n ? Integer.MAX_VALUE : nums2[partitionN];

            if (maxLeftM <= minRightN && maxLeftN <= minRightM) {
                if ((m + n) % 2 == 0) {
                    return (double) (Math.max(maxLeftM, maxLeftN) + Math.min(minRightM, minRightN)) / 2;
                } else
                    return Math.max(maxLeftM, maxLeftN);
            } else if (maxLeftM > minRightN)
                high = partitionM - 1;
            else
                low = partitionM + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 ={1,2}, nums2 = {3,4};
        L4 obj = new L4();
        System.out.println(obj.findMedianSortedArrays(nums1, nums2));
    }
}

// Time Complexity - O(log(min(m,n)))
// Space Complexity - O(1)