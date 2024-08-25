package Others;

// 1366. Rank Teams by Votes

import java.util.Arrays;

public class L1366 {

    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        int[][] rt = new int[26][n];

        for(int i=0;i<votes.length;i++){
            for(int j=0;j<n;j++){
                char ch = votes[i].charAt(j);
                rt[ch-'A'][j]++;
            }
        }
//        for(int i=0;i<26;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(rt[i][j] + " ");
//            }
//            System.out.println();
//        }

        Character[] temp = new Character[n];
        for(int i=0;i<n;i++){
            temp[i] = votes[0].charAt(i);
        }

        Arrays.sort(temp, (a, b) -> {
            for(int i=0;i<n;i++)
                if(rt[a-'A'][i] != rt[b-'A'][i])
                    return rt[b-'A'][i] - rt[a-'A'][i];
            return a-b;
        });

        char[] res = new char[n];
        for(int i=0;i<n;i++){
            res[i] = temp[i];
        }
        return new String(res);
    }

    public static void main(String[] args) {
        String[] votes = {"ABC","ACB","ABC","ACB","ACB"};
        L1366 obj = new L1366();
        System.out.println(obj.rankTeams(votes));
    }
}

// Time Complexity - O(m*n + 26nlogn)
// Space Complexity - O(n)
