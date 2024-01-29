import java.util.HashMap;

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        int n = matrix.length;
        int m = matrix[0].length + 1;
        int pf[][] = new int[n][m];

        // Calculate prefix sum for each row
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                pf[i][j] = pf[i][j - 1] + matrix[i][j - 1];
            }
        }

        // Iterate over all possible pairs of start and end columns
        for (int s = 0; s < m; s++) {
            for (int e = s + 1; e < m; e++) {
                int sum = 0;
                HashMap<Integer, Integer> hm = new HashMap<>();
                hm.put(0, 1);

                // Iterate over each row
                for (int i = 0; i < n; i++) {
                    // Calculate the cumulative sum for the current submatrix
                    sum += pf[i][e] - pf[i][s];

                    // Check if there is a submatrix with the target sum
                    int need = sum - target;
                    if (hm.containsKey(need)) {
                        ans += hm.get(need);
                    }

                    // Update the HashMap with the current cumulative sum
                    hm.put(sum, hm.getOrDefault(sum, 0) + 1);
                }
            }
        }

        return ans;
    }
}


//REFER THIS LINK ==> https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/solutions/803353/java-solution-with-detailed-explanation/