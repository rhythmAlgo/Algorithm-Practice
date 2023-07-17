package nahyeon.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2003_수들의합2 {

    static FastReader scan = new FastReader();

    static int N, M;
    static int A[];

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static void pro() {
        int R = 0, sum = 0, ans = 0;
        for (int L = 1; L <= N; L++) {
            // L - 1 구간을 뺀다.
            sum -= A[L-1];
            // R 을 조건에 만족할 때까지 넘긴다.
            while (R + 1 <= N && sum < M) {
                sum += A[++R];
            }
            if (sum == M)
                ans++;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
