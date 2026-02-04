import java.util.*;
import java.io.*;

class Main {
    static char[] chars = new char[]{'a', 'e', 'i', 'o', 'u'};
    static Set<Character> set = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(char c : chars) {
            set.add(c);
        }

        while(true) {
            String input = br.readLine();

            if(input.equals("end")) {
                break;
            }
            if(isAvail(input)) {
                System.out.println("<" + input + "> is acceptable.");
            } else {
                System.out.println("<" + input + "> is not acceptable.");
            }

        }
    }
    private static boolean isAvail(String input) {

        char[] inputToChar = input.toCharArray();
        //모음 하나 반드시 포함
        boolean isContain = false;
        for(char c : chars) {
            for(int i = 0; i  < inputToChar.length; i++) {
                if(inputToChar[i] == c) {
                    isContain = true;
                    break;
                }
            }
        }
        if(!isContain) {
            return false;
        }
        //모음이 연속 3개, 자음이 연속 3개 불가
        int size = inputToChar.length;
        for(int i = 0; i < inputToChar.length; i++) {
            if(i + 1 < size && i + 2 < size) {
                char first = inputToChar[i];
                char second = inputToChar[i+1];
                char third = inputToChar[i+2];

                if(set.contains(first) && set.contains(second) && set.contains(third)) {
                    return false;
                }
                if(!set.contains(first) && !set.contains(second) && !set.contains(third)) {
                    return false;
                }
            }
        }

        //같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
        for(int i = 0; i < inputToChar.length - 1; i++) {
            char first = inputToChar[i];
            char second = inputToChar[i+1];
            if(first == second) {
                if(first != 'e' && first != 'o') {
                    return false;
                }
            }
        }
        return true;
    }
}