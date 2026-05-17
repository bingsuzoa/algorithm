import java.util.*;

class Solution {
    static int[] graph;
    static long[] tmp;
    static long[] tmptmp;
    public long[] solution(int[] arr, long l, long r) {
        graph = arr;

        //int[] temp;
        tmp = new long[arr.length - 1];
        for(int i =0 ; i < arr.length - 1; i++) {
            if(i - 1 >= 0) {
                tmp[i] = tmp[i-1] + arr[i];
            } else {
                tmp[i] = arr[i];
            }
        }
        for(int i =0 ; i < tmp.length; i++) {
            tmp[i]++;
        }

        tmptmp = new long[arr.length];
        for(int i =0 ; i  < tmptmp.length; i++) {
            if(i - 1>= 0) {
                tmptmp[i] = tmptmp[i-1] + ((long)arr[i] * arr[i]);
            } else {
                tmptmp[i] = (long)arr[i] * arr[i];
            }
        }
        long K = getDuration(l, r);
        //list구하기
        List<Long> list = new ArrayList<>();
        Set<Long> set = new HashSet<>();
        long dist = r - l;
        long totalCount = getTotalCount();

        //1 넣을 수 있는지 확인
        if(1 + dist <= totalCount) {
            list.add(1L);
            set.add(1L);
        }
        //last 넣어주기
        list.add(totalCount - dist + 1);
        set.add(totalCount - dist + 1);

        for(long value : tmp) {
            if(value + dist <= totalCount && !set.contains(value)) {
                set.add(value);
                list.add(value);
            }
            if(value - dist >= 1 && !set.contains(value - dist)) {
                set.add(value - dist);
                list.add(value - dist);
            }
        }
        Collections.sort(list);

        long answer = 0;
        //start
        for(int i =0 ; i < list.size() - 1; i++) {
            long value = list.get(i);
            long startNum = getNum(value);
            long endNum = getNum(value + dist);
            long count = list.get(i+1) - list.get(i);

            long tmpSum = getDuration(value, value+dist);

            long diff = endNum - startNum;
            if(diff == 0 && tmpSum == K) {
                answer+= count;
            }
            else if(diff != 0) {
                if((K - tmpSum) % diff == 0) {
                    long tmpCount = (K - tmpSum) / diff;
                    if(tmpCount >= 0 && tmpCount < count) {
                        answer++;
                    }
                }
            }
        }

        return new long[]{K, answer};

    }
    private long getTotalCount() {
        long sum = 0;
        for(int value : graph) {
            sum += (value);
        }
        return sum;
    }
    private long getDuration(long l, long r) {
        return getSum(r) - getSum(l-1);
    }

    //어느 위치에서의 합
    private long getSum(long pos) {
        int start = 0;
        int end = tmp.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(tmp[mid] <= pos) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        int idx = end + 1;

        long count = 0;
        long sum = 0;

        if(idx - 1 >= 0) {
            count += (tmp[idx - 1] - 1);
            sum += tmptmp[idx - 1];
        }
        long remain = pos - count;
        sum += (long)remain * getNum(pos);
        return sum;
    }

    //어느 위치에서의 숫자
    private int getNum(long pos) {

        int start = 0;
        int end = tmp.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(tmp[mid] <= pos) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return graph[end + 1];
    }
}