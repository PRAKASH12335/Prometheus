package Heap.Hard;

// 332. Reconstruct Itinerary

import java.util.*;

public class L332 {

    private void dfs(String airPort, HashMap<String, PriorityQueue<String>> graph, LinkedList<String> itinerary){
        PriorityQueue<String> nextAirports = graph.get(airPort);
        while(nextAirports != null && !nextAirports.isEmpty()){
            dfs(nextAirports.poll(), graph, itinerary);
        }
        itinerary.addFirst(airPort);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> ticket : tickets){
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        LinkedList<String> itinerary = new LinkedList<>();
        dfs("JFK", graph, itinerary);
        return itinerary;
    }

    public static void main(String[] args) {
        String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        List<List<String>> passes = new ArrayList<>();
        for(int i=0;i<tickets.length;i++){
            passes.add(new ArrayList<>());
        }
        for(int i=0;i<tickets.length;i++){
            passes.get(i).add(tickets[i][0]);
            passes.get(i).add(tickets[i][1]);
        }
        L332 obj = new L332();
        System.out.println(obj.findItinerary(passes));
    }
}

// Time Complexity - O(NlogN)
// Space Complexity - O(N)