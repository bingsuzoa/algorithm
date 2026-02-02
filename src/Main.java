import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N == 1 || N == 3 || N == 5) {
            System.out.println("SK");
            return;
        }
        if(N == 2 || N == 4) {
            System.out.println("CY");
            return;
        }

        N = N % 6;

        if(N == 1 || N == 3 || N == 5) {
            System.out.println("SK");
            return;
        }
        if(N == 0 || N == 2 || N == 4) {
            System.out.println("CY");
            return;
        }
    }
}