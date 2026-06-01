class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        if(n == 1) return cost[0];
        else if(n == 2) return cost[1]+cost[0];
        Arrays.sort(cost);
        int c1 = n-1;
        int c2 = n-2;

        int min = 0;
        while(c1 >= 0){
            // System.out.println(c2+" "+c1);
            min += cost[c1];
            if(c2 >= 0) min += cost[c2];
            c1 -= 3;
            c2 -= 3;
        }
        return min;
    }
}