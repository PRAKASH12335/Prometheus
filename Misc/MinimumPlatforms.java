package Misc;

// Minimum Platforms

import java.util.Arrays;
import java.util.PriorityQueue;

class TrainSchedule{
    int arrivalTime;
    int deptTime;
    TrainSchedule(int arrivalTime, int deptTime){
        this.arrivalTime = arrivalTime;
        this.deptTime = deptTime;
    }

}

public class MinimumPlatforms {

    public static int countPlatformsPQ(int n, int arr[], int dep[]){
        TrainSchedule[] trainSchedules = new TrainSchedule[n];
        for(int i=0;i<n;i++){
            trainSchedules[i] = new TrainSchedule(arr[i], dep[i]);
        }
        Arrays.sort(trainSchedules, (a, b) -> a.arrivalTime - b.arrivalTime);
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        int count = 1;
        minPQ.add(trainSchedules[0].deptTime);
        for(int i=1;i<n;i++){
            if(trainSchedules[i].arrivalTime <= minPQ.peek()){
                count++;
            }else{
                minPQ.poll();
            }
            minPQ.add(trainSchedules[i].deptTime);
        }
        return count;
    }

    public static int countPlatforms(int n, int arr[], int dep[]){
        Arrays.sort(arr);
        Arrays.sort(dep);


        int i=1, j=0;
        int platformNeeded = 1, maxPlatform = 1;
        while(i<n && j<n){
            if(arr[i] <= dep[j]){
                platformNeeded++;
                i++;
            }else{
                platformNeeded--;
                j++;
            }
            if(maxPlatform < platformNeeded)
                maxPlatform = platformNeeded;
        }
        return maxPlatform;
    }

    public static void main(String[] args) {
        int arr[]={900,945,955,1100,1500,1800};
        int dep[]={920,1200,1130,1150,1900,2000};
        int n = arr.length;
        System.out.println(countPlatforms(n, arr, dep));

        System.out.println(countPlatformsPQ(n, arr, dep));
    }
}

// Time Complexity - O(N*logN)
// Space Complexity - O(1)