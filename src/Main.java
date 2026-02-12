import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String input = br.readLine();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        Queue<Integer> persons = new LinkedList<>();
        Queue<Integer> hams = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            char c = input.charAt(i);
            if(c == 'P') {
                persons.add(i);
            }
            if(c == 'H') {
                hams.add(i);
            }
        }

        int count = 0;

        while(!persons.isEmpty() && !hams.isEmpty()) {
            int person = persons.peek();
            int ham = hams.peek();

            if(ham < person) {
                if(person - ham <= K) {
                    count++;
                    persons.poll();
                }
                hams.poll();
            } else {
                if(ham - person <= K) {
                    count++;
                    hams.poll();
                }
                persons.poll();
            }
        }
        System.out.println(count);

    }
}