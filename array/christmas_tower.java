package array;

import java.util.*;

public class christmas_tower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] arr1 = new int[5];
        for (int i = 0; i < 5; i++) {
            arr1[i] = sc.nextInt();
        }
        Arrays.sort(arr1);
        int[] dp = new int[10001];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int b = 1; b <= a; ++b) {
            for (int c : arr1) {
                if (b - c >= 0 && dp[b - c] != -1) {
                    dp[b] = Math.max(dp[b], dp[b - c] + 1);
                }
            }
        }

        if (dp[a] == -1) {
            System.out.println("Impossible");
            return;
        }

        Map<Integer, Integer> arr3 = new HashMap<>();
        while (a > 0) {
            for (int c : arr1) {
                if (a - c >= 0 && dp[a] == dp[a - c] + 1) {
                    arr3.put(c, arr3.getOrDefault(c, 0) + 1);
                    a -= c;
                    break;
                }
            }
        }

        List<Map.Entry<Integer, Integer>> arr4 = new ArrayList<>(arr3.entrySet());
        arr4.sort((d, e) -> d.getValue().equals(e.getValue()) ? Integer.compare(d.getKey(), e.getKey())
                : Integer.compare(e.getValue(), d.getValue()));

        for (int i = 0; i < arr4.size(); ++i) {
            System.out.print(arr4.get(i).getKey());
            if (i < arr4.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}
