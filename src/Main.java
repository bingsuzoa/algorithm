import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    static long[] lens;
    static long[] sums;
    static int[] array;

    // public static void main(String[] args) {
    //     int[] arr = new int[]{16952, 70276, 16771, 37992, 87549, 54906, 36718, 20478, 57088, 27916, 51509, 83422, 51707, 18807, 80859, 2673, 37734, 93380};
    //     long l = 149845;
    //     long r = 228204 ;
    //    int[] arr = new int[]{3,2,3,1,1};
    //    long l = 5;
    //    long r = 7;
    //    int[] arr = new int[]{2,2,2};
    //    long l = 2;
    //    long r = 2;
    //     Solution s = new Solution();
    //     long[] answer = s.solution(arr, l, r);
    //     System.out.println(answer[0] + " " + answer[1]);
    // }

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

        List<Long> list = getDiffPos(answer[0], l, r);
        long W = r - l + 1;
        long count = 0;

        for(int i = 0; i < list.size() - 1; i++) {
            long left = list.get(i);
            long right = list.get(i+1);
            if(left == right) continue;

            long startP = left;
            long endP = left + W - 1;

            long initSum = getSum(endP) - getSum(startP -1);
            long totalLen = lens[lens.length -1];

            int endLen = endP + 1 > totalLen ? 0 : getGroupIdx(endP + 1);
            long d = array[endLen] - array[getGroupIdx(startP)];
            if(d == 0) {
                if(initSum == answer[0]) {
                    count += (right - left);
                }
            } else {
                long remain = answer[0] - initSum;
                if(remain % d == 0) {
                    long n = remain / d;
                    if(n >= 0 && n < (right - left)) {
                        count++;
                    }
                }
            }

        }
        answer[1] = count;
        return answer;
    }

    private List<Long> getDiffPos(long goal, long l, long r) {
        long diff = r - l + 1;
        List<Long> list = new ArrayList<>();
        list.add(1L);

        long totalLen = lens[lens.length-1];
        long definedLen = totalLen - diff + 1;
        list.add(definedLen + 1);
        for(long len : lens) {
            long endP = len + 1;
            long startP = endP - diff + 1;
            if(endP <= totalLen && startP >= 1 && startP <= totalLen) {
                list.add(startP);
            }

            long startPP = len + 1;
            long endPP = startPP + diff -1;
            if(endPP <= totalLen && startPP >= 1 && startPP <= totalLen) {
                list.add(startPP);
            }
        }
        Collections.sort(list);
        return list;
    }


    private long getSum(long l) {
        int groupIdx = getGroupIdx(l);

        long initLen = lens[groupIdx];
        long initSum = sums[groupIdx];

        long diff = initLen - l;
        return initSum - array[groupIdx] * diff;

    }

    private int getGroupIdx(long l) {
        int start = 0;
        int end = lens.length -1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(lens[mid] == l) {
                return mid;
            }
            if(lens[mid] < l) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return end + 1;
    }
}
