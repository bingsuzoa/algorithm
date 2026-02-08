import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        Set<String> set = new HashSet<>();

        while(N --> 0) {
            String input = br.readLine();
            set.add(input);
        }

        if(game.equals("Y")) {
            System.out.println(set.size());
            return;
        }
        if(game.equals("F")) {
            System.out.println(set.size() / 2);
            return;
        }
        if(game.equals("O")) {
            System.out.println(set.size()/3);
            return;
        }
    }
}