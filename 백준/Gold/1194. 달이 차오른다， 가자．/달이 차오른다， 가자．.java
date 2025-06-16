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

        int startX = 0;
        int startY = 0;

        for (int h=0; h<height; h++) {
            String str = reader.readLine();

            for (int w=0; w<width; w++) {
                map[h][w] = str.charAt(w);

                if (map[h][w] == '0') {
                    startX = w;
                    startY = h;
                }
            }
        }

        return new MazeContext(width, height, startX, startY, map, isVisited);
    }

    private static int findShortestPath(MazeContext context) {
        Queue<Minsik> q = new ArrayDeque<>();

        q.offer(new Minsik(context.startX, context.startY, 0, 1));
        context.setVisited(context.startX, context.startY, 0);

        while (!q.isEmpty()) {
            Minsik minsik = q.poll();

            for (int i=0; i<4; i++) {
                int nextX = minsik.x + dx[i];
                int nextY = minsik.y + dy[i];

                if (!context.canMove(minsik, nextX, nextY)) continue; // 이동 가능한가?

                int nextKeySet = context.tryGetKey(nextX, nextY, minsik.keySet);

                if (context.isVisited(nextX, nextY, nextKeySet)) continue; // 방문한 적 있나?

                if (context.isDestination(nextX, nextY)) return minsik.depth; // 도착했나?

                q.offer(new Minsik(nextX, nextY, nextKeySet, minsik.depth+1));
                context.setVisited(nextX, nextY, nextKeySet);
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

    private static final int ASCII_SIZE = 128;
    private static final KeyMask[] CACHE = new KeyMask[ASCII_SIZE];

    static {
        for (KeyMask key : values()) {
            CACHE[key.name().charAt(0)] = key;
        }
    }

    public static boolean hasKey(int keySet, char doorOrKey) {
        KeyMask keyMask = CACHE[Character.toUpperCase(doorOrKey)];
        return keyMask != null && (keySet & keyMask.mask) != 0;
    }

    public static int addKey(int keySet, char key) {
        KeyMask keyMask = CACHE[Character.toUpperCase(key)];
        return keyMask != null ? keySet | keyMask.mask : keySet;
    }
}

class Minsik {
    public final int x, y, keySet, depth;

    public Minsik(int x, int y, int keySet, int depth) {
        this.x = x;
        this.y = y;
        this.keySet = keySet;
        this.depth = depth;
    }
}

class MazeContext {
    public final int width, height, startX, startY;
    private final char[][] map;
    private final boolean[][][] isVisited;

    public MazeContext(int width, int height, int startX, int startY, char[][] map, boolean[][][] isVisited) {
        this.width = width;
        this.height = height;
        this.startX = startX;
        this.startY = startY;
        this.map = map;
        this.isVisited = isVisited;
    }

    public int tryGetKey(int x, int y, int keySet) {
        char cell = map[y][x];
        if (Character.isLowerCase(cell)) {
            return KeyMask.addKey(keySet, cell);
        }
        return keySet;
    }
    public boolean canMove(Minsik minsik, int x, int y) {
        if (!inBounds(x, y)) return false;

        char cell = map[y][x];
        if (cell == '#') return false;

        if (Character.isUpperCase(cell)) {
            return KeyMask.hasKey(minsik.keySet, cell);
        }

        return true;
    }
    public boolean inBounds(int x, int y) { return x >= 0 && x < width && y >= 0 && y < height; }
    public boolean isDestination(int x, int y) { return map[y][x] == '1'; }
    public boolean isVisited(int x, int y, int keySet) { return isVisited[y][x][keySet]; }
    public void setVisited(int x, int y, int keySet) { isVisited[y][x][keySet] = true; }
}