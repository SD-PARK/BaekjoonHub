import java.util.*;

class Solution {
    class Node {
        int x, y, depth;
        
        Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
    
    public int solution(int[][] maps) {
        int width = maps[0].length;
        int height = maps.length;
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visits = new boolean[height][width];
        
        queue.offer(new Node(0, 0, 1));
        visits[0][0] = true;
        
        System.out.println();
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            if (node.x == width-1 && node.y == height-1) {
                return node.depth;
            }
            
            if (node.y-1 >= 0 && !visits[node.y-1][node.x] && maps[node.y-1][node.x]>0) { // 상
                queue.offer(new Node(node.x, node.y-1, node.depth+1));
                visits[node.y-1][node.x] = true;
            }
            if (node.y+1 < height && !visits[node.y+1][node.x] && maps[node.y+1][node.x]>0) { // 하
                queue.offer(new Node(node.x, node.y+1, node.depth+1));
                visits[node.y+1][node.x] = true;
            }
            if (node.x-1 >= 0 && !visits[node.y][node.x-1] && maps[node.y][node.x-1]>0) { // 좌
                queue.offer(new Node(node.x-1, node.y, node.depth+1));
                visits[node.y][node.x-1] = true;
            }
            if (node.x+1 < width && !visits[node.y][node.x+1] && maps[node.y][node.x+1]>0) { // 우
                queue.offer(new Node(node.x+1, node.y, node.depth+1));
                visits[node.y][node.x+1] = true;
            }
        }
        
        return -1;
    }
}