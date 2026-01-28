import java.util.*;
import java.io.*;

class Main {
    static int N,M,P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        List<Game> games = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            games.add(new Game(st1.nextToken()));
            for(int j = 0; j < M; j++) {
                games.get(i).add(Integer.parseInt(st1.nextToken()));
            }
        }
        Collections.sort(games);


        StringBuilder sb = new StringBuilder();
        int finishCount = 0;
        while(finishCount < N) {
            long[] board = new long[games.size()];
            long min = Long.MAX_VALUE;
            int idx = 0;
            for(int i = 0; i < games.size(); i++) {
                Game game = games.get(i);
                if(game.isOut) continue;
                long num = game.peekNum();
                board[i] = num;
                if(min > num) {
                    idx = i;
                    min = num;
                }
            }
            for(int i = 0; i < games.size(); i++) {
                Game game = games.get(i);
                if(game.isOut) continue;
                if(idx == i) {
                    game.pollNum();
                    if(game.isEmpty()) {
                        sb.append(game.name).append(" ");
                        game.isOut = true;
                        finishCount++;
                    }
                } else {
                    game.pollNum();
                    long newNum = board[i] + P;
                    game.add(newNum);
                }
            }
        }
        System.out.println(sb);
    }
}

class Game implements Comparable<Game> {
    String name;
    PriorityQueue<Long> pq;
    boolean isOut = false;

    public Game(String name) {
        this.name = name;
        pq = new PriorityQueue<>((o1,o2) -> {
            return Long.compare(o1,o2);
        });
    }

    public void add(long num) {
        pq.add(num);
    }

    public boolean isEmpty() {
        return pq.isEmpty();
    }
    public long peekNum() {
        return pq.peek();
    }
    public long pollNum() {
        return pq.poll();
    }

    @Override
    public int compareTo(Game o) {
        return this.name.compareTo(o.name);
    }
}