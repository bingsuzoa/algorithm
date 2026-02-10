import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Word[] words = new Word[N];
        Map<String, Integer> map = new HashMap<>();
        for(int i =0 ; i < N; i++) {
            words[i] = new Word(br.readLine());
            map.put(words[i].word, map.getOrDefault(words[i].word, 0) + 1);
        }

        for(Word word : words) {
            word.count = map.get(word.word);
        }
        Arrays.sort(words);

        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        for(Word word : words) {
            if(word.length < K) {
                continue;
            }
            if(!set.contains(word.word)) {
                set.add(word.word);
                sb.append(word.word).append("\n");
            }
        }
        System.out.println(sb);
    }
}

class Word implements Comparable<Word> {
    String word;
    int count;
    int length;

    public Word(String word) {
        this.word = word;
        this.length = word.length();
        this.count = 0;
    }

    @Override
    public int compareTo(Word o) {
        if(o.count == this.count) {
            if(o.length == this.length) {
                return this.word.compareTo(o.word);
            }
            return o.length - this.length;
        }
        return o.count - this.count;
    }
}