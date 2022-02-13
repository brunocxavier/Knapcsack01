package model;

public class GreedyResponse {
    private int value;
    private long time;

    public GreedyResponse(int value, long time) {
        this.value = value;
        this.time = time;
    }

    @Override
    public String toString() {
        return "GreedyResponse{" +
                "value=" + value +
                ", time=" + time +
                '}';
    }
}
