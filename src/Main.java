import java.util.*;

class Solution {
    static long[] graph;
    static List<Long> list;

    public long[] solution(int[] arr, long l, long r) {
        long K = getK(arr, l, r);
        long count = 0;

        //숫자가 바뀌는 인덱스를 저장한 배열 만들기(Long)
        graph = new long[arr.length - 1];
        for(int i = 0; i < graph.length; i++) {
            if(i == 0) {
                graph[i] = arr[i];
            } else {
                graph[i] = graph[i-1] + arr[i];
            }
        }
        //왼쪽 포인터 또는 오른쪽 포인터가 숫자가 바뀌는 지점에 있는 시작점 저장하기(리스트 Long)
        list = new ArrayList<>();
        Set<Long> set = new HashSet<>();
        list.add(0L);

        //합을 모두 나열했을 때의 크기 구하기
        long sum = 0;
        for(int value : arr) {
            sum += value;
        }

        for(int i = 0; i < graph.length ; i ++) {
            if(graph[i] + (r - l) < sum) {
                if(set.contains(graph[i])) continue;
                list.add(graph[i]);
                set.add(graph[i]);
            }

            long pointer = graph[i] - (r - l);
            if(pointer >= 0 && !set.contains(pointer)) {
                list.add(pointer);
                set.add(pointer);
            }
        }
        Collections.sort(list);

        //리스트에서 for문 돌리면서 start, end
        for(long start : list) {
            long end = start + (r - l);
            int dist = getNum(arr, end) - getNum(arr, start);
            long initSum = getK(arr, start, end);
            System.out.println("start :" + start + " end : " + end + "initSum : " + initSum);
            System.out.println(K + " " + initSum + " " + dist);
            if(dist == 0 && initSum == K) {
                count += r - l;
            }
            else if(dist != 0) {
                if((K - initSum) % dist == 0) {
                    long x = (K - initSum) / dist;
                    if(x <= r - l) {
                        count += 1;
                    }
                }
            }
        }
        return new long[]{K, count};
    }
    private int getNum(int[] arr, long l) {
        long cur = 0;
        int idx = 0;
        while(cur + arr[idx] <= l) {
            cur += arr[idx];
            idx++;
        }
        return arr[idx];
    }
    private long getK(int[] arr, long l, long r) {
        return getSum(arr, r) - getSum(arr, l - 1);
    }


    private long getSum(int[] arr, long goal) {
        long sum = 0;
        long cur = 0;
        int idx = 0;

        while(cur + arr[idx] < goal) {
            sum += arr[idx] * (long)arr[idx];
            cur += arr[idx];
            idx++;
        }
        long remain = goal - cur;
        sum += arr[idx] * remain;
        return sum;
    }
}