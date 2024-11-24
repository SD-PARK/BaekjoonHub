import java.util.*;

class Solution {
    public enum Direction {
        EAST, WEST, SOUTH, NORTH;
    }

    class Node {
        private int x, y, price;
        private Direction direction;

        public Node(int x, int y, int price, Direction direction) {
            this.x = x;
            this.y = y;
            this.price = price;
            this.direction = direction;
        }
    }

    public int solution(int[][] board) {
        int boardHeight = board.length;
        int boardWidth = board[0].length;
        boolean[][][] visited = new boolean[boardHeight][boardWidth][Direction.values().length];
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.price));

        // 상하좌우 방향 계산
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Direction[] directions = {Direction.EAST, Direction.WEST, Direction.SOUTH, Direction.NORTH};

        pq.add(new Node(0, 0, 0, null));
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int x = node.x, y = node.y;
            int directionIndex = Arrays.asList(directions).indexOf(node.direction);

            if (directionIndex >= 0) {
                if (visited[y][x][directionIndex]) continue;
                visited[y][x][directionIndex] = true;
            }

            if (x == boardWidth - 1 && y == boardHeight - 1)
                return node.price;

            for (int i=0; i<4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (isValidMove(board, visited, nextX, nextY, i)) {
                    Direction nextDirection = directions[i];
                    int nextPrice = (node.direction == null || node.direction == nextDirection)
                            ? node.price + 100
                            : node.price + 600;
                    pq.add(new Node(nextX, nextY, nextPrice, nextDirection));
                }
            }
        }

        return -1;
    }

    private boolean isValidMove(int[][] board, boolean[][][] visited, int x, int y, int direction) {
        return x >= 0 && x < board[0].length
                && y >= 0 && y < board.length
                && !visited[y][x][direction]
                && board[y][x] == 0;
    }
}