import java.util.*;
import java.io.*;

class Main {
    static Info[] infos;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        infos = new Info[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st1.nextToken());
            Info info = new Info(country);
            infos[i] = info;

            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(st1.nextToken());
                info.setCounts(num, j);
            }
        }
        Arrays.sort(infos);

        if(infos[0].country == M) {
            System.out.println(1);
            return;
        }

        int prize = 1;
        for(int i = 1 ; i < infos.length;  i++) {
            if(infos[i].counts[0] == infos[i-1].counts[0] &&
                infos[i].counts[1] == infos[i - 1].counts[1] &&
                infos[i].counts[2] == infos[i - 1].counts[2]
            ) {

            } else {
                prize = i + 1;
            }
            if(infos[i].country == M) {
                System.out.println(prize);
                return;
            }
        }
    }
}


class Info implements Comparable<Info> {
    int country;
    int[] counts;

    public Info(int country) {
        this.country = country;
        counts = new int[3];
    }

    public void setCounts(int num, int idx) {
        counts[idx] = num;
    }

    @Override
    public int compareTo(Info o) {
        if(o.counts[0] == this.counts[0]) {
            if(o.counts[1] == this.counts[1]) {
                return o.counts[2] - this.counts[2];
            }
            return o.counts[1] - this.counts[1];
        }
        return o.counts[0] - this.counts[0];
    }
}