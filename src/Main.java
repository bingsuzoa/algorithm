import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(solution(10, 18, 1, 5));
    }

    private static int solution(int S, int T, int X, int Y) {

        int min = Integer.MAX_VALUE;

        for(int attack = X; attack <= 1000; attack++) {
            int cost = attack - X;

            int needAttack = (T + attack -1) / attack;

            int required = Y * (needAttack - 1) + 1;

            int needCost = S >= required ? 0 : required - S;
            min = Math.min(min, cost + needCost);
        }
        return min;
    }

    private static int needAttack(int S, int T, int X, int Y) {
        int monster = T % X == 0 ? T / X : T / X + 1;

        int need = Y * monster;
        if(S >= need) return 0;
        return need - S;
    }


    private static boolean step2(int S, int T, int X, int Y) {
        int minseo = S % Y == 0 ? S / Y : S / Y + 1;
        int monster = T % X == 0 ? T / X : T / X + 1;

        if(minseo >= monster) {
            return true;
        }
        return false;
    }
}