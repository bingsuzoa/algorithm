import java.util.*;
import java.io.*;

class Main {
    static int R, C;
    static char[][] graph;
    static int[][] fires;
    static int[][] jihoons;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        fires = new int[R][C];
        jihoons = new int[R][C];

        for(int i = 0; i < graph.length; i++) {
            Arrays.fill(fires[i], Integer.MAX_VALUE);
            Arrays.fill(jihoons[i], Integer.MAX_VALUE);
        }

        Queue<int[]> fireQueue = new LinkedList<>();
        Queue<int[]> jihoonQueue = new LinkedList<>();

        for(int i = 0; i < graph.length; i++) {
            String input = br.readLine();
            for(int j = 0; j < graph[i].length; j++) {
                char c = input.charAt(j);
                graph[i][j] = c;

                if(c == 'F') {
                    fires[i][j] = 0;
                    fireQueue.add(new int[]{i,j, 0});
                }
                if(c == 'J') {
                    jihoons[i][j] = 0;
                    jihoonQueue.add(new int[]{i,j, 0});
                }
            }
        }

        while(!fireQueue.isEmpty()) {
            int[] cur = fireQueue.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];

            for(int i =0 ; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= graph.length || nx < 0 || ny >= graph[0].length || ny < 0) continue;

                if(graph[nx][ny] != '#') {
                    if(fires[nx][ny] > count + 1) {
                        fires[nx][ny] = count + 1;
                        fireQueue.add(new int[]{nx, ny, count + 1});
                    }
                }
            }
        }

        while(!jihoonQueue.isEmpty()) {
            int[] cur = jihoonQueue.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];

            for(int i =0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= graph.length || nx < 0 || ny >= graph[0].length || ny < 0) {
                    System.out.println(count +1);
                    return;
                }
                if(graph[nx][ny] != '#') {
                    if(fires[nx][ny] > count + 1 && jihoons[nx][ny] > count + 1) {
                        jihoons[nx][ny] = count + 1;
                        jihoonQueue.add(new int[]{nx, ny, count + 1});
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}