import model.GreedyResponse;
import model.Instance;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Greedy {
    private short[] weights;
    private short[] values;

    public GreedyResponse calculate(Instance instance) throws IOException {
        int numberOfItem = instance.getNumberOfItems();
        int capacity = instance.getCapacity();
        this.weights = instance.getWeights();
        this.values = instance.getValues();
        long startTime = System.nanoTime();
        ItemValue[] cost = new ItemValue[numberOfItem];
        for (int i = 0; i < numberOfItem; i++) {
            cost[i] = new ItemValue(weights[i], values[i], i);
        }

        // sorting items by value;
        Arrays.sort(cost, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2)
            {
                return o2.cost.compareTo(o1.cost);
            }
        });

        int totalValue = 0;

        for (ItemValue itemValue : cost) {

            int curWt = itemValue.wt;
            int curVal = itemValue.val;

            if (capacity - curWt >= 0) {
                // this weight can be picked while
                capacity = capacity - curWt;
                totalValue += curVal;
            }
        }

        long endTime = System.nanoTime();
        return new GreedyResponse(totalValue, endTime - startTime);
    }

    static class ItemValue {
        int wt, val, ind;
        Double cost;
        public ItemValue(int wt, int val, int ind)
        {
            this.wt = wt;
            this.val = val;
            this.ind = ind;
            cost = (double) (val / wt);
        }
    }
}
