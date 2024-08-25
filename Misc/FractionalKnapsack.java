package Misc;

// Fractional Knapsack | Greedy Algo.

import java.util.Arrays;
import java.util.Comparator;

class Item{
    int value;
    int weight;
    Item(int value, int weight){
        this.value = value;
        this.weight = weight;
    }
}

class WeightComparator implements Comparator<Item> {
    @Override
    public int compare(Item i1, Item i2){
        double r1 = (double)i1.value/(double)i1.weight;
        double r2 = (double)i2.value/(double)i2.weight;
        if(r1 < r2) return 1;
        else if (r1 > r2) return -1;
        return 0;
    }
}

public class FractionalKnapsack {

    public static double fractionalKnapsack(Item[] items, int weight){
        Arrays.sort(items, new WeightComparator());
        int maxValue = 0, currWeight = 0;

        for(int i=0;i< items.length;i++){
            if(currWeight + items[i].weight <= weight){
                currWeight += items[i].weight;
                maxValue += items[i].value;
            }else{
                int remainWeight = weight - currWeight;
                maxValue += ((double)items[i].value/(double)items[i].weight) * (double)remainWeight;
                break;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Item[] items = new Item[3];
        items[0] = new Item(60, 10);
        items[1] = new Item(100, 20);
        items[2] = new Item(120, 30);

        System.out.println(fractionalKnapsack(items, 50));
    }
}
