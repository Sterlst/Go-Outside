package com.example.gooutside;

public class Challenge {
    private static int completed = 0;
    private static int failed = 0;

    public void setCompleted() {
        completed++;
    }

    public int getCompleted() {
        return completed;
    }

    public void setFailed() {
        failed++;
    }

    public int getFailed() {
        return failed;
    }
}
