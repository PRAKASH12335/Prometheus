package Others;// 134. Gas Station

public class L134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for(int i=0;i<gas.length;i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalCost > totalGas)
            return -1;

        int current = 0, start = 0;
        for(int i=0;i<gas.length;i++){
            current += gas[i]-cost[i];
            if(current < 0){
                start = i+1;
                current = 0;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5}, cost = {3,4,5,1,2};
        L134 obj = new L134();
        System.out.println(obj.canCompleteCircuit(gas, cost));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)