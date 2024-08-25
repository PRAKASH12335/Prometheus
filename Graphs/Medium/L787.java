package Graphs.Medium;

// 787. Cheapest Flights Within K Stops

import java.util.*;

class StopCost{
    int node;
    int cost;
    StopCost(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
}

class Flight{
    int stop;
    int node;
    int cost;
    Flight(int stop, int node, int cost){
        this.stop = stop;
        this.node = node;
        this.cost = cost;
    }
}

public class L787 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<StopCost>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] flight : flights){
            adjList.get(flight[0]).add(new StopCost(flight[1], flight[2]));
        }

        Queue<Flight> q = new LinkedList<>();
        q.add(new Flight(0, src, 0));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        while(!q.isEmpty()){
            Flight fl = q.poll();
            int node = fl.node;
            int cost = fl.cost;
            int stop = fl.stop;
            for(StopCost adjNode : adjList.get(node)){
                int newNode = adjNode.node;
                int newCost = adjNode.cost;
                if(cost + newCost < dist[newNode] && stop <= k){
                    dist[newNode] = cost + newCost;
                    q.add(new Flight(stop+1, newNode, dist[newNode]));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }

    public static void main(String[] args) {
        L787 obj = new L787();
        int n = 4;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, dst = 3, k = 1;
        System.out.println(obj.findCheapestPrice(n, flights, src, dst, k));
    }
}

//Time Complexity - O( N ) { Additional log(N) of time eliminated here because we’re using a simple queue rather than a priority queue which is usually used in Dijkstra’s Algorithm }.
//Where N = Number of flights / Number of edges.
//Space Complexity -  O( |E| + |V| ) { for the adjacency list, priority queue, and the dist array }.
//Where E = Number of edges (flights.size()) and V = Number of Airports.