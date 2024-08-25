package TwoPointer.Medium;

// 1423. Maximum Points You Can Obtain from Cards

public class L1423 {

    public int maxScore(int[] cardPoints, int k) {
        int maxScore = 0, score = 0, n = cardPoints.length;
        for(int i=0;i<k;i++){
            score += cardPoints[i];
        }
        maxScore = Math.max(maxScore, score);

        int nIndex = n-1;
        for(int i=k-1;i>=0;i--){
            score -= cardPoints[i];
            score += cardPoints[nIndex];
            maxScore = Math.max(maxScore, score);
            nIndex = nIndex-1;
        }
        return  maxScore;
    }

    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        L1423 obj = new L1423();
        System.out.println(obj.maxScore(cardPoints, k));
    }
}

// Time complexity - O(N)
// Space complexity - O(1)
