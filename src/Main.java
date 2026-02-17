import java.util.*;
import java.io.*;

class Main {
    static Map<Character, Integer> index;
    static char[] goalArray;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        String goal = br.readLine();

        goalArray = new char[goal.length()];
        for(int i = 0; i < goalArray.length; i++) {
            goalArray[i] = goal.charAt(i);
        }
        Arrays.sort(goalArray);

        int answer = 0;
        for(int i = 1; i < N; i++) {
            String input = br.readLine();
            char[] pair = new char[input.length()];

            for(int j = 0; j < pair.length; j++) {
                pair[j] = input.charAt(j);
            }
            Arrays.sort(pair);

            if(goalArray.length == pair.length) {
                if(isSame(goalArray, pair)) {
                    answer++;
                }
                else if(isChange(goalArray, pair)) {
                    answer++;
                }
                continue;
            }
            if(check(goalArray, pair)) {
                answer++;
            }
        }
        System.out.println(answer);
    }
    private static boolean check(char[] goalArray, char[] pair) {
        if(Math.abs(goalArray.length - pair.length) != 1) {
            return false;
        }
        if(goalArray.length < pair.length) {
            return rotate(goalArray, pair);
        }
        return rotate(pair, goalArray);
    }
    private static boolean rotate(char[] min, char[] many) {
        boolean[] checked = new boolean[many.length];

        for(int i =0 ; i < min.length; i++) {
            char c = min[i];
            boolean isExist = false;
            for(int j = 0 ; j < many.length; j++) {
                if(!checked[j] && c == many[j]) {
                    isExist = true;
                    checked[j] = true;
                    break;
                }
            }
            if(!isExist) {
                return false;
            }
        }
        int count = 0;
        for(int i = 0; i < checked.length; i++) {
            if(!checked[i]) {
                count++;
            }
        }
        if(count == 1) return true;
        return false;
    }
    private static boolean isChange(char[] goalArray, char[] pair) {
        boolean[] checked = new boolean[goalArray.length];

        int diffCount = 0;
        int sameCount = 0;
        for(int i = 0; i < goalArray.length; i++) {
            boolean isExist = false;
            for(int j = 0; j < pair.length; j++) {
                if(goalArray[i] == pair[j]) {
                    if(!checked[j]) {
                        sameCount++;
                        checked[j] = true;
                        isExist = true;
                        break;
                    }
                }
            }
            if(!isExist) {
                diffCount++;
            }
        }
        if(diffCount == 1) {
            return true;
        }
        return false;
    }

    private static boolean isSame(char[] goalArray, char[] pair) {
        for(int i = 0; i < goalArray.length; i++) {
            if(goalArray[i] != pair[i]) {
                return false;
            }
        }
        return true;
    }
}