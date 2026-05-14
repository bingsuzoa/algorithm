import java.util.*;

class Solution {
    public long[] solution(int[] arr, long l, long r) {
        long K = getDurationSum(arr, l, r);


        //arr의 숫자가 바뀌는 순간의 인덱스를 저장한 배열만들기
        long[] graph = getChangeArr(arr);

        //변화가 있는 구간의 시작 인덱스를 저장한 리스트를 만들기
        List<Long> list = getList(arr, graph, l, r);

        //리스트 순회하면서 공차 확인
        //sum getDurationSum(arr, start, end);
        //start 1 end 3 : getNum(end) - getNum(start);
        long answer = 0;
        for(int i = 0; i < list.size() - 1; i++) {
            long count = list.get(i +1) - list.get(i);

            long start = list.get(i);
            long end = start + (r - l);
            long sum = getDurationSum(arr, start, end);

            long dist = getNum(arr, end) - getNum(arr, start);

            if(dist == 0 && K == sum) {
                answer += count;
            }
            else if(dist != 0 && (K - sum) % dist == 0) {
                long x = (K - sum) / dist;
                if(x < count) {
                    answer += 1;
                }
            }
        }

        return new long[]{K, answer};
    }

    private List<Long> getList(int[] arr, long[] graph, long l, long r) {
        Set<Long> set = new HashSet<>();
        List<Long> list = new ArrayList<>();

        long dur = r - l;
        long lastPos = getLast(arr);

        if(1 + dur <= lastPos) {
            list.add(1L);
            set.add(1L);
        }

        if(lastPos - dur >= 0 && !set.contains(lastPos - dur + 1)) {
            set.add(lastPos - dur + 1);
            list.add(lastPos - dur + 1);
        }

        for(int i = 0; i < graph.length; i++) {
            long pos = graph[i];

            if(pos - dur >= 0 && !set.contains(pos - dur)) {
                set.add(pos - dur);
                list.add(pos - dur);
            }
            if(pos + dur <= lastPos && !set.contains(pos)) {
                set.add(pos);
                list.add(pos);
            }
        }
        Collections.sort(list);
        return list;
    }


    private long[] getChangeArr(int[] arr) {
        long[] tmp = new long[arr.length - 1];
        for(int i = 0; i < arr.length - 1; i++) {
            if(i - 1 >= 0) {
                tmp[i] = arr[i] + tmp[i-1];
            } else {
                tmp[i] = arr[i];
            }
        }
        for(int i =0 ; i < tmp.length; i++) {
            tmp[i] += 1;
        }
        return tmp;
    }


    //어떤 인덱스에서의 숫자를 구한다.
    private long getNum(int[] arr, long goal) {
        long cur = 0;


        for(int i = 0; i < arr.length; i++) {
            if(cur + arr[i] < goal) {
                cur += arr[i];
            } else {
                return arr[i];
            }
        }
        return arr[arr.length - 1];
    }





    private long getDurationSum(int[] arr, long l, long r) {
        return getSum(arr, r) - getSum(arr, l - 1);
    }

    ///구간의 합을 구한다.
    private long getSum(int[] arr, long pos) {
        long sum = 0;
        long cur = 0;
        for(int i =0 ; i < arr.length; i++) {
            int num = arr[i];

            if(cur + num <= pos) {
                sum += (long)num * num;
                cur += num;
            } else {
                long remain = pos - cur;
                sum += ((long)remain * num);
                break;
            }
        }
        return sum;
    }

    private long getLast(int[] arr) {
        long sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}