package DP.Medium;

//Count Number of Teams
//There are n soldiers standing in a line. Each soldier is assigned a unique rating value.
//You have to form a team of 3 soldiers amongst them under the following rules:
//
//Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
//A team is valid if: (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
//Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).

public class L1395 {

    public static int numTeams(int[] rating) {
        int count = 0;

        for(int i=1;i<rating.length-1;i++){
            int leftSmall=0, leftLarge=0, rightSmall=0, rightLarge=0;
            for(int j=0;j<i;j++){
                if(rating[j] < rating[i])
                    leftSmall++;
                else
                    leftLarge++;
            }
            for(int j=i+1;j<rating.length;j++){
                if(rating[j] < rating[i])
                    rightSmall++;
                else
                    rightLarge++;
            }
            count += leftSmall*rightLarge+rightSmall*leftLarge;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] rating = new int[]{2,5,3,4,1};
        System.out.println(numTeams(rating));
    }
}

// Time Complexity - O(n^2)
// Space Complexity - O(1)