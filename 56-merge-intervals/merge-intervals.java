class Solution {
    public int[][] merge(int[][] intervals) {
        // Tc : O(n * log(n)) ; Sc : O(n)
        Arrays.sort(intervals, new ArrayComparator());

        int n = intervals.length;
        int total = 1;

        for(int i = 0; i < n-1; i++){
            if(intervals[i][1] >= intervals[i+1][0]){
                intervals[i+1][0] = intervals[i][0];
                intervals[i+1][1] = Math.max(intervals[i][1], intervals[i+1][1]);
                intervals[i][0] = -1;
            }
            else{
                total++;
            }
        }
        int ans[][] = new int[total][2];
        int index = 0;

        for(int i = 0; i < n; i++){
            if(intervals[i][0] != -1){
                ans[index][0] = intervals[i][0];
                ans[index][1] = intervals[i][1];
                index++;
            }
        }
        
        return ans;
    }
}

class ArrayComparator implements Comparator<int[]>{
    public int compare(int first[], int second[]){
        if(first[0] < second[0]){
            return -1;
        }
        else if (first[0] > second[0]) {
            return 1;
        } else {
            return 0; // Handle the case of equality
        }
    }
}