class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int i = 0, j = 0;
        int[][] directions = { {0,1}, {1,0}, {0,-1}, {-1,0} };
        int currDir = 0;
        int maxDistance = 0;

        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        for (int command : commands) {
            if (command > 0) {
                for (int step = 0; step < command; step++) {
                    int nextX = i + directions[currDir][0];
                    int nextY = j + directions[currDir][1];
                    // Check if next position is an obstacle
                    if (obstacleSet.contains(nextX + "," + nextY)) {
                        break; 
                    }
                    i = nextX;
                    j = nextY;
                    maxDistance = Math.max(maxDistance, i * i + j * j);
                }
            } else if (command == -1) {
                currDir = (currDir + 1) % 4;
            } else if (command == -2) {
                currDir = (currDir + 3) % 4;
            }
        }

        return maxDistance;
    }
}
