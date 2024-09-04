class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Point> set = new HashSet<>();
        for (int[] obs : obstacles) {
            set.add(new Point(obs[0], obs[1]));
        }
        int maxDistance = 0;
        Point point = new Point(0, 0);
        int dir = 0;
        for (int command : commands) {
            if (command < 0) {
                dir = changeDirection(dir, command);
            } else {
                if (dir == 0 || dir == 2) {
                    int mul = dir == 0 ? 1 : -1;
                    for (int i = 0; i < command; i++) {
                        point.y += mul;
                        if (set.contains(point)) {
                            point.y -= mul;
                            i = command;
                        }
                    }
                } else {
                    int mul = dir == 3 ? 1 : -1;
                    for (int i = 0; i < command; i++) {
                        point.x += mul;
                        if (set.contains(point)) {
                            point.x -= mul;
                            i = command;
                        }
                    }
                }
            }
            maxDistance = Math.max(maxDistance, (int) Math.pow(point.x, 2) + (int) Math.pow(point.y, 2));
        }
        return maxDistance;
    }

    private int changeDirection(int dir, int command) {
        if (command == -2) {
            return (dir + 1) % 4;
        } else {
            if (dir == 0)
                return 3;
            return dir - 1;
        }
    }

    class Point {
        int x;
        int y;

        Point(int a, int b) {
            x = a;
            y = b;
        }

        @Override
        public boolean equals(Object p) {
            if (this == p)
                return true;
            Point point = (Point) p;
            return point.x == this.x && point.y == this.y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public String toString() {
            return this.x + " " + this.y;
        }

    }
}
