class Solution {
    public double averageWaitingTime(int[][] customers) {
        int currentTime = 0;
        long waitTime = 0;

        for (int i = 0; i < customers.length; i++) {
            int arrivalTime = customers[i][0];
            int serviceDuration = customers[i][1];

            currentTime = Math.max(arrivalTime, currentTime) + serviceDuration;
            waitTime += currentTime - arrivalTime;
        }

        return (double) waitTime / customers.length;
    }
}
