import java.io.*;
import java.util.*;

public class Main {
    static class Emoji {
        int clipboard;
        int emojiCnt;
        int depth;
        public Emoji(int clipboard, int emojiCnt, int depth) {
            this.clipboard = clipboard;
            this.emojiCnt = emojiCnt;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        final int maxEmoji = 2001;
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        boolean[][] visit = new boolean[maxEmoji][maxEmoji]; // [Clipboard][EmojiCnt]

        // BFS
        Queue<Emoji> q = new LinkedList<>();
        q.add(new Emoji(0, 1, 0));
        visit[0][1] = true;
        while (!q.isEmpty()) {
            Emoji now = q.poll();

            if (now.emojiCnt == s) {
                System.out.print(now.depth);
                break;
            }

            int paste = now.emojiCnt + now.clipboard;
            if (now.clipboard > 0 && maxEmoji > paste && !visit[now.clipboard][paste]) {
                q.add(new Emoji(now.clipboard, paste, now.depth+1));
                visit[now.clipboard][paste] = true;
            }

            if (maxEmoji > now.emojiCnt*2 && !visit[now.emojiCnt][now.emojiCnt]) {
                q.add(new Emoji(now.emojiCnt, now.emojiCnt, now.depth+1));
                visit[now.emojiCnt][now.emojiCnt] = true;
            }

            if (now.emojiCnt > 0 && !visit[now.clipboard][now.emojiCnt-1]) {
                q.add(new Emoji(now.clipboard, now.emojiCnt-1, now.depth+1));
                visit[now.clipboard][now.emojiCnt-1] = true;
            }
        }
    }
}