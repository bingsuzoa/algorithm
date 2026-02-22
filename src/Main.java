import java.util.*;
import java.io.*;

class Main {
    static Set<Character> set;
    static Word[] graph;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        set = new HashSet<>();
        answer = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        graph = new Word[N];

        for(int i =0 ; i < N; i++) {
            graph[i] = new Word(br.readLine());
        }

        for(Word word : graph) {
            if(isStep1(word)) continue;
            if(isStep2(word)) continue;
            answer.append(word.input).append("\n");
        }
        System.out.println(answer);
    }
    private static boolean isStep2(Word word) {
        String[] words = word.words;

        for(int i =0 ; i < words.length; i++) {
            String w = words[i];
            for(int j = 0; j < w.length(); j++) {
                char c = Character.toUpperCase(w.charAt(j));
                if(set.contains(c)) continue;
                set.add(c);
                makeResult(word, i, j);
                return true;
            }
        }
        return false;
    }
    private static boolean isStep1(Word word) {
        String[] words = word.words;

        for(int i =0 ; i < words.length; i++) {
            String w = words[i];
            char c = Character.toUpperCase(w.charAt(0));
            if(!set.contains(c)) {
                set.add(c);
                makeResult(word, i, 0);
                return true;
            }
        }
        return false;
    }

    private static void makeResult(Word word, int idx, int iidx) {
        StringBuilder sb = new StringBuilder();

        String[] words = word.words;
        for(int i = 0; i < words.length; i++) {
            String w = words[i];
            if(i == idx) {
                sb.append(getWord(w, iidx)).append(" ");
            } else {
                sb.append(w).append(" ");
            }
        }
        answer.append(sb).append("\n");
    }

    private static String getWord(String w, int idx) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < w.length(); i++) {
            if(i == idx) {
                sb.append("[");
                sb.append(w.charAt(i));
                sb.append("]");
            } else {
                sb.append(w.charAt(i));
            }
        }
        return sb.toString();
    }
}

class Word {
    String input;
    String[] words;

    public Word(String input) {
        this.input = input;
        words = input.split(" ");
    }
}