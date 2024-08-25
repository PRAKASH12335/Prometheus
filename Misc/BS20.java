package Misc;

import java.util.PriorityQueue;

// Minimise Maximum Distance between Gas Stations

public class BS20 {
    public static class Pair {
        double first;
        int second;

        Pair(double first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // Brute Force
    public static double maxDistanceGasStations(int[] nums, int k){
        int n = nums.length;
        int[] midStation = new int[n-1];

        for(int gasStation =1;gasStation<=k;gasStation++){
            double maxSection = -1;
            int maxInd = -1;
            for(int i=0;i<n-1;i++){
                double diff = nums[i+1]-nums[i];
                double sectionLength = diff/(double)(midStation[i]+1);
                if(sectionLength > maxSection){
                    maxSection = sectionLength;
                    maxInd = i;
                }
            }
            midStation[maxInd]++;
        }

        double maxAns = -1;
        for (int i = 0; i < n - 1; i++) {
            double diff = nums[i + 1] - nums[i];
            double sectionLength = diff / (double)(midStation[i] + 1);
            maxAns = Math.max(maxAns, sectionLength);
        }
        return maxAns;
    }
// Time Complexity: O(k*n) + O(n), n = size of the given array, k = no. of gas stations to be placed.
// Reason: O(k*n) to insert k gas stations between the existing stations with maximum distance. Another O(n) for finding the answer i.e. the maximum distance.
//
// Space Complexity: O(n-1)

    // Using PQ
    public static double maxDistanceGasStationsPQ(int[] nums, int k){
        int n = nums.length;
        int[] midStation = new int[n-1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.first, a.first));
        for(int i=0;i<n-1;i++){
            pq.add(new Pair(nums[i+1]-nums[i], i));
        }

        for(int gasStation =1;gasStation<=k;gasStation++){
            Pair p = pq.poll();
            int secInd = p.second;

            double iniDiff = nums[secInd+1]- nums[secInd];
            double newSecLen = iniDiff/(double)(midStation[secInd]+1);
            pq.add(new Pair(newSecLen, secInd));
        }
        return pq.peek().first;
    }

// Time Complexity: O(nlogn + klogn),  n = size of the given array, k = no. of gas stations to be placed.
// Reason: Insert operation of priority queue takes logn time complexity. O(nlogn) for inserting all the indices with distance values and O(klogn) for placing the gas stations.
//
// Space Complexity: O(n-1)+O(n-1)
// Reason: The first O(n-1) is for the array to keep track of placed gas stations and the second one is for the priority queue.

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5}; // {1,13,17,23}, k = 5
        int k = 4;
        System.out.println(maxDistanceGasStations(nums, k));
        System.out.println(maxDistanceGasStationsPQ(nums, k));
    }
}
