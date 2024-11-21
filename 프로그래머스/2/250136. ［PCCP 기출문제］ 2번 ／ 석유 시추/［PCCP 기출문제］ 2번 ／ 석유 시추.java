import java.util.*;

class Solution {
    class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] land) {
        int answer = 0;
        int width = land[0].length;
        int height = land.length;
        List<Integer> groupOils = new ArrayList<>();
        int[][] groups = oilGrouping(land, groupOils);

        for (int x=0; x<width; x++) {
            int oil = 0;
            boolean[] groupUsed = new boolean[groupOils.size()];

            for (int y=0; y<height; y++) {
                int group = groups[y][x];
                if (land[y][x] > 0 && !groupUsed[group]) {
                    groupUsed[group] = true;
                    oil += groupOils.get(group);
                }
            }

            answer = Math.max(answer, oil);
        }

        return answer;
    }

    public int[][] oilGrouping(int[][] land, List<Integer> groupOils) {
        int width = land[0].length;
        int height = land.length;
        int[][] result = new int[height][width];
        groupOils.add(0);

        for (int y=0; y<height; y++) {
            for (int x=0; x<width; x++) {
                if (land[y][x] > 0 && result[y][x] == 0) {
                    int groupNumber = groupOils.size();
                    int oil = mining(land, result, x, y, groupNumber);
                    groupOils.add(oil);
                }
            }
        }

        return result;
    }

    public int mining(int[][] land, int[][] groups, int rootX, int rootY, int groupNumber) {
        int result = 1;
        int width = land[0].length;
        int height = land.length;
        Stack<Node> stack = new Stack<>();

        groups[rootY][rootX] = groupNumber;
        stack.push(new Node(rootX, rootY));

        while(!stack.isEmpty()) {
            Node node = stack.pop();
            int x = node.x;
            int y = node.y;

            if (y-1 >= 0 && land[y-1][x] > 0 && groups[y-1][x] == 0) {
                groups[y-1][x] = groupNumber;
                stack.push(new Node(x, y-1));
                result++;
            }
            if (y+1 < height && land[y+1][x] > 0 && groups[y+1][x] == 0) {
                groups[y+1][x] = groupNumber;
                stack.push(new Node(x, y+1));
                result++;
            }
            if (x-1 >= 0 && land[y][x-1] > 0 && groups[y][x-1] == 0) {
                groups[y][x-1] = groupNumber;
                stack.push(new Node(x-1, y));
                result++;
            }
            if (x+1 < width && land[y][x+1] > 0 && groups[y][x+1] == 0) {
                groups[y][x+1] = groupNumber;
                stack.push(new Node(x+1, y));
                result++;
            }
        }

        return result;
    }
}