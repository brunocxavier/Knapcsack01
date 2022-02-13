import model.Instance;
import model.DynamicResponse;

import java.io.IOException;

public class Dynamic {
    private short[] weights;
    private short[] values;
    private int[][] k;

    public DynamicResponse calculate(Instance instance) throws IOException {
        int numberOfItem = instance.getNumberOfItems();
        int capacity = instance.getCapacity();
        this.weights = instance.getWeights();
        this.values = instance.getValues();
        long startTime = System.nanoTime();
        this.k = initialize(capacity, numberOfItem);

        for (int j = 1; j < numberOfItem; j++) {
            for (int w = 1; w < capacity; w++) {
                if (weights[j] > w) {
                    k[w][j] = k[w-1][j];
                } else {
                    k[w][j] = max(j, w);
                }
            }
        }
        long endTime = System.nanoTime();
        return new DynamicResponse(k[capacity - 1][numberOfItem - 1], endTime - startTime);
    }

    public int[][] initialize(int capacity, int numberOfItem) {
        int[][] k = new int[capacity][numberOfItem];
        for (int i = 0; i < capacity; i++) {
            k[i][0] = 0;
        }
        for (int j = 0; j < numberOfItem; j++) {
            k[0][j] = 0;
        }
        return k;
    }

    public int max(int j, int w) {
        int k1 = k[w][j-1];
        int k2 = k[w - weights[j]][j - 1] + values[j];
        if (k2 > k1) {
            return k2;
        }
        return k1;
    }
}
