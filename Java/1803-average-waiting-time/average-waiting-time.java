class Solution {
    public double averageWaitingTime(int[][] customers) {
        double totalWaitTime = 0;
        int currentTime = -1;

        for (int[] customer : customers) {
            int arrivalTime = customer[0];
            int serviceTime = customer[1];

            currentTime = Math.max(currentTime, arrivalTime);
            currentTime += serviceTime;
            totalWaitTime += currentTime - arrivalTime;
        }

        return totalWaitTime / customers.length;
    }
}
