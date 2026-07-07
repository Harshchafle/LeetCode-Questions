class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n == 1) return 1;
        Arrays.sort(intervals, (a,b) -> {
            if(a[0]==b[0]){
                return b[1] - a[1];
            }
            else return a[0] - b[0];
        });
        
        // for(int i = 0; i < n; i++){
        //     System.out.println(intervals[i][0]+" "+intervals[i][1]);
        // }

        int count = 0;
        int prevEnd = 0;
        for(int i = 0; i < n; i++){
            int currEnd = intervals[i][1];
            if(currEnd > prevEnd){
                prevEnd = currEnd;
                count++;
            }
        }

        return count;
    }
}