package model;

public class DynamicResponse {
    private int value;
    private long time;

    public DynamicResponse(int value, long time) {
        this.value = value;
        this.time = time;
    }

    @Override
    public String toString() {
        return "DynamicResponse{" +
                "value=" + value +
                ", time=" + time +
                '}';
    }
}
