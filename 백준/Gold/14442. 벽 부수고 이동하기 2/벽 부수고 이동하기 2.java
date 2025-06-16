import java.io.*;
import java.util.*;

public class Main {
    private static class Location {
        private final int x, y, depth, brokenCount;

        public Location(int x, int y, int depth, int brokenCount) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.brokenCount = brokenCount;
        }
    }

    private static class MazeContext {
        private final int width, height, breakLimit;
        private final boolean[][] map;
        private final boolean[][][] isVisited;

        public MazeContext(int width, int height, int breakLimit, boolean[][] map, boolean[][][] isVisited) {
            this.width = width;
            this.height = height;
            this.breakLimit = breakLimit;
            this.map = map;
            this.isVisited = isVisited;
        }

        public boolean isWall(int x, int y) { return map[y][x]; }
        public boolean inBounds(int x, int y) { return x >= 0 && x < width && y >= 0 && y < height; }
        public boolean isDestination(Location loc) { return loc.x == width-1 && loc.y == height-1; }
        public boolean isVisited(int x, int y, int brokenCount) { return isVisited[y][x][brokenCount]; }
        public void setVisited(int x, int y, int brokenCount) { isVisited[y][x][brokenCount] = true; }
    }

    private static final int[] dx = {0, 0, -1, +1};
    private static final int[] dy = {-1, +1, 0, 0};

    public static void main(String[] args) throws IOException {
        MazeContext context = loadMazeContext();
        int shortestPath = findShortestPath(context);
        System.out.print(shortestPath);
    }

    private static MazeContext loadMazeContext() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] dims = reader.readLine().split("\\s+");
        int height = Integer.parseInt(dims[0]);
        int width = Integer.parseInt(dims[1]);
        int breakLimit = Integer.parseInt(dims[2]);

        boolean[][] map = new boolean[height][width];
        boolean[][][] isVisited = new boolean[height][width][breakLimit+1];

        for (int h=0; h<height; h++) {
            String str = reader.readLine();
            for (int w=0; w<width; w++) {
                map[h][w] = (str.charAt(w) == '1');
            }
        }

        return new MazeContext(width, height, breakLimit, map, isVisited);
    }

    private static int findShortestPath(MazeContext context) {
        Queue<Location> q = new LinkedList<>();

        q.offer(new Location(0, 0, 1, 0));
        context.setVisited(0, 0, 0);

        while (!q.isEmpty()) {
            Location now = q.poll();

            if (context.isDestination(now)) return now.depth;

            for (int i=0; i<4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (!context.inBounds(nextX, nextY)) continue;

                if (context.isWall(nextX, nextY)) {
                    if (now.brokenCount < context.breakLimit && !context.isVisited(nextX, nextY, now.brokenCount+1)) {
                        q.offer(new Location(nextX, nextY, now.depth+1, now.brokenCount+1));
                        context.setVisited(nextX, nextY, now.brokenCount+1);
                    }
                } else {
                    if (!context.isVisited(nextX, nextY, now.brokenCount)) {
                        q.offer(new Location(nextX, nextY, now.depth+1, now.brokenCount));
                        context.setVisited(nextX, nextY, now.brokenCount);
                    }
                }
            }
        }

        return -1;
    }
}