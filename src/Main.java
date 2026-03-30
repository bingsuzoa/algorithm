import java.util.*;
import java.io.*;

class Main {
    static char[][] graph;
    static int[][] jihoons;
    static int[][] fires;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int answer = Integer.MAX_VALUE;
    static Queue<int[]> fireQueue = new LinkedList<>();
    static Queue<int[]> jihoonQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        jihoons = new int[R][C];
        fires = new int[R][C];

        for(int i =0 ; i < R; i++) {
            Arrays.fill(jihoons[i], Integer.MAX_VALUE);
            Arrays.fill(fires[i], Integer.MAX_VALUE);
        }


        int sx = 0;
        int sy = 0;
        for(int i = 0; i < graph.length; i++) {
            String s = br.readLine();
            for(int j = 0; j < graph[i].length; j++) {
                graph[i][j] = s.charAt(j);
                if(graph[i][j] == 'J') {
                    jihoons[i][j] = 0;
                    sx = i;
                    sy = j;
                }
                if(graph[i][j] == 'F') {
                    fires[i][j] = 0;
                    fireQueue.add(new int[]{i, j, 0});
                }
            }
        }
        init();


        jihoonQueue.add(new int[]{sx, sy, 0});
        while(!jihoonQueue.isEmpty()) {
            int[] cur = jihoonQueue.poll();
            int x = cur[0];
            int y = cur[1];
            int time = cur[2];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= graph.length || nx < 0 || ny >= graph[0].length || ny < 0) {
                    answer = Math.min(time + 1, answer);
                    break;
                } else {
                    if(graph[nx][ny] == '#') continue;
                    if(fires[nx][ny] > time + 1 && jihoons[nx][ny] > time + 1) {
                        jihoons[nx][ny] = time + 1;
                        jihoonQueue.add(new int[]{nx, ny, time + 1});
                    }
                }
            }
        }
        if(answer == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(answer);
        }
    }


    private static void init() {
        while(!fireQueue.isEmpty()) {
            int[] cur = fireQueue.poll();
            int x = cur[0];
            int y = cur[1];
            int time = cur[2];

            for(int i =0 ; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= graph.length || nx < 0 || ny >= graph[0].length || ny < 0)continue;

                if(graph[nx][ny] != '.') continue;
                if(fires[nx][ny] > time + 1) {
                    fires[nx][ny] = time + 1;
                    fireQueue.add(new int[]{nx, ny, time + 1});
                }
            }
        }
    }
}