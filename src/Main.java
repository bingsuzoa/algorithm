import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] requests = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int end = 0;
        for(int i = 0; i < requests.length; i++) {
            requests[i] = Integer.parseInt(st.nextToken());
            if(end < requests[i]) {
                end = requests[i];
            }
        }

        int total = Integer.parseInt(br.readLine());

        int start = 0;

        long max = -1;
        long temp = 0;
        while(start <= end) {
            int mid = (start + end) / 2;

            long sum = 0;
            for(int request : requests) {
                if(request > mid) {
                    sum += mid;
                } else {
                    sum += request;
                }
            }
            if(sum <= total) {
                if(max < sum) {
                    max = sum;
                    temp = mid;
                }
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(temp);
    }
}