package Misc;

// Job Sequencing Problem

import java.util.Arrays;

class Job{
    int id;
    int deadline;
    int profit;
    Job(int id, int deadline, int profit){
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencingProblem {

    public static int[] jobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        int maxi = 0;
        for(int i=0;i< arr.length;i++){
            if(arr[i].deadline > maxi){
                maxi = arr[i].deadline;
            }
        }
        int[] result = new int[maxi+1];
        Arrays.fill(result, -1);

        int countJobs = 0, maxProfit = 0;
        for(int i=0;i<n;i++){
            for(int j=arr[i].deadline;j>0;j--){
                if(result[j] == -1){
                    result[j] = arr[i].id;
                    countJobs += 1;
                    maxProfit += arr[i].profit;
                    break;
                }
            }
        }
        int[] res = new int[2];
        res[0] = countJobs;
        res[1] = maxProfit;
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        Job[] arr = new Job[4];
        arr[0] = new Job(1, 4, 20);
        arr[1] = new Job(2, 1, 10);
        arr[2] = new Job(3, 2, 40);
        arr[3] = new Job(4, 2, 30);

        int[] res = jobScheduling(arr, n);
        System.out.println("Job count : "+res[0] + " with profit : "+ res[1]);
    }
}

// Time Complexity - O(N log N) + O(N*M)
// O(N log N ) for sorting the jobs in decreasing order of profit. O(N*M) since we are iterating through all N jobs and
// for every job we are checking from the last deadline, say M deadlines in the worst case.

// Space Complexity: O(M) for an array that keeps track of which day job is performed if M is the maximum deadline available.