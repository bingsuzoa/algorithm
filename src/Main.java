import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    static long[] lens;
    static long[] sums;
    static int[] array;

    public static void main(String[] args) {
//        int[] arr = new int[]{16952, 70276, 16771, 37992, 87549, 54906, 36718, 20478, 57088, 27916, 51509, 83422, 51707, 18807, 80859, 2673, 37734, 93380};
//        long l = 149845;
//        long r = 228204 ;
        int[] arr = new int[]{3,2,3,1,1};
        long l = 5;
        long r = 7;
//        int[] arr = new int[]{2,2,2};
//        long l = 2;
//        long r = 2;
        Solution s = new Solution();
        long[] answer = s.solution(arr, l, r);
        System.out.println(answer[0] + " " + answer[1]);
    }

    public long[] solution(int[] arr, long l, long r) {
        array = arr;
        lens = new long[arr.length];
        sums = new long[arr.length];

        lens[0] = array[0];
        sums[0] = (long)array[0] * array[0];

        for(int i = 1; i < array.length; i++) {
            lens[i] = array[i] + lens[i-1];
            sums[i] = ((long)array[i] * array[i]) + sums[i-1];
        }
        long[] answer = new long[2];
        answer[0] = getSum(r) - getSum(l-1);


        /////////////step 1
        long W = r - l + 1;
        long totalLen = lens[lens.length -1];
        long limitP = totalLen - W + 1;

        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(limitP + 1);

        for(int i = 0; i < lens.length - 1; i++) {
            long changePos = lens[i] + 1;

            list.add(changePos);
            list.add(changePos - W + 1);
        }
        Collections.sort(list);

        //////////////step2
        long count = 0;
        for(int i = 0; i < list.size() -1; i++) {
            long left = list.get(i);
            long right = list.get(i+1);
            if(left == right) continue;

            if(left + W - 1 >= array.length || left - 1 < 0) {
                continue;
            }
            long initSum = getSum(left + W -1) - getSum(left -1);


            int out = array[getGroup(left)];
            int in = left + W >= array.length ? 0 : array[getGroup(left + W)];
            int diff = in - out;

            if(diff == 0) {
                if(initSum == answer[0]) {
                    count += (right - left);
                }
            } else {
                long remain = answer[0] - initSum;
                if(remain % diff == 0) {
                    long n = remain / diff;
                    if(n >= 0 && n < right - left) {
                        count++;
                    }
                }
            }
        }

        return new long[]{answer[0], count};
    }

    private long getSum(long goal) {
        int lastIdx = getGroup(goal);

        long lastLot = lens[lastIdx];
        long sum = sums[lastIdx];

        long diff = lastLot - goal;
        long num = array[lastIdx] * diff;
        return sum - num;
    }

    private int getGroup(long goal) {
        int start = 0;
        int end = array.length -1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(lens[mid] == goal) {
                return mid;
            }
            if(lens[mid] < goal) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end + 1;
    }
}
