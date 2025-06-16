import java.io.*;
import java.util.*;

public class Main {
    private static final int MAX_KEY_COUNT = 6;

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

        char[][] map = new char[height][width];
        boolean[][][] isVisited = new boolean[height][width][1 << MAX_KEY_COUNT];

        Location minsikLocation = null;

        for (int h=0; h<height; h++) {
            String str = reader.readLine();
            for (int w=0; w<width; w++) {
                map[h][w] = str.charAt(w);
                if (map[h][w] == '0') minsikLocation = new Location(w, h);
            }
        }

        return new MazeContext(width, height, map, isVisited, minsikLocation);
    }

    private static int findShortestPath(MazeContext context) {
        Queue<Minsik> q = new LinkedList<>();

        Location minsikLocation = context.getMinsikLocation();
        q.offer(new Minsik(minsikLocation, 0, 1));
        context.setVisited(minsikLocation, 0);

        while (!q.isEmpty()) {
            Minsik minsik = q.poll();
            Location currentLocation = minsik.getLocation();

            for (int i=0; i<4; i++) {
                int nextX = currentLocation.x + dx[i];
                int nextY = currentLocation.y + dy[i];
                Location nextLocation = new Location(nextX, nextY);

                if (!context.canMove(minsik, nextLocation)) continue; // 이동 가능한가?

                int nextKeySet = context.tryGetKey(nextLocation, minsik.keySet);

                if (context.isVisited(nextLocation, nextKeySet)) continue; // 방문한 적 있나?

                if (context.isDestination(nextLocation)) return minsik.depth; // 도착했나?

                q.offer(new Minsik(nextLocation, nextKeySet, minsik.depth+1));
                context.setVisited(nextLocation, nextKeySet);
            }
        }

        return -1;
    }
}

enum KeyMask {
    A(1 << 0), B(1 << 1), C(1 << 2), D(1 << 3), E(1 << 4), F(1 << 5);

    private final int mask;

    KeyMask(int mask) {
        this.mask = mask;
    }

    public int getMask() {
        return mask;
    }

    public static boolean hasKey(int keySet, char doorOrKey) {
        KeyMask keyMask = KeyMask.valueOf(String.valueOf(Character.toUpperCase(doorOrKey)));
        return (keySet & keyMask.getMask()) != 0;
    }

    public static int addKey(int keySet, char key) {
        KeyMask keyMask = KeyMask.valueOf(String.valueOf(Character.toUpperCase(key)));
        return keySet | keyMask.getMask();
    }
}

class Location {
    public final int x, y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Minsik {
    private final Location location;
    public final int keySet, depth;

    public Minsik(Location location, int keySet, int depth) {
        this.location = location;
        this.keySet = keySet;
        this.depth = depth;
    }

    public Location getLocation() { return location; }
}

class MazeContext {
    public final int width, height;
    private final char[][] map;
    private final boolean[][][] isVisited;
    private final Location minsikLocation;

    public MazeContext(int width, int height, char[][] map, boolean[][][] isVisited, Location minsikLocation) {
        this.width = width;
        this.height = height;
        this.map = map;
        this.isVisited = isVisited;
        this.minsikLocation = minsikLocation;
    }

    public int tryGetKey(Location loc, int keySet) {
        char cell = map[loc.y][loc.x];
        if (Character.isLowerCase(cell)) {
            return KeyMask.addKey(keySet, cell);
        }
        return keySet;
    }
    public boolean canMove(Minsik minsik, Location loc) {
        if (!inBounds(loc)) return false;

        char cell = map[loc.y][loc.x];
        if (cell == '#') return false;

        if (Character.isUpperCase(cell)) {
            return KeyMask.hasKey(minsik.keySet, cell);
        }

        return true;
    }
    public boolean inBounds(Location loc) { return loc.x >= 0 && loc.x < width && loc.y >= 0 && loc.y < height; }
    public boolean isDestination(Location loc) { return map[loc.y][loc.x] == '1'; }
    public boolean isVisited(Location loc, int keySet) { return isVisited[loc.y][loc.x][keySet]; }
    public void setVisited(Location loc, int keySet) { isVisited[loc.y][loc.x][keySet] = true; }
    public Location getMinsikLocation() { return minsikLocation; }
}