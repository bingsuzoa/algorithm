import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] board = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0; i < board.length; i++) {
            board[i] = Integer.parseInt(st1.nextToken());
            map.putIfAbsent(board[i], 0);
        }

        int left = 0;
        int right = 0;

        int max = 0;
        while(right < board.length) {
            int num = board[right];
            int count = map.get(num);
            map.put(num, count + 1);

            while(map.get(num) > K) {
                int value = board[left];
                map.put(value, map.get(value) -1);
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }

        System.out.println(max);
    }
}