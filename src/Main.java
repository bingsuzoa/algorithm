import java.util.*;
import java.io.*;

class Main {
    static long[] roads;
    static long[] liters;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        roads = new long[N - 1];
        liters = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for(int i = 0; i < roads.length; i++) {
            roads[i] = Long.parseLong(st.nextToken());
        }
        for(int i =0 ; i < liters.length; i++) {
            liters[i] = Long.parseLong(st1.nextToken());
        }

        long answer = roads[0] * liters[0];
        long min = liters[0];

        for(int i = 1; i < liters.length - 1; i++) {
            long curCost = liters[i];
            if(min > curCost) {
                min = curCost;
            }
            answer += (min * roads[i]);
        }
        System.out.println(answer);
    }
}