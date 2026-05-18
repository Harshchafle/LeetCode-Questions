class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean hasJumped[] = new boolean[n];
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);

        while(!que.isEmpty()){
            int rem = que.poll();
            hasJumped[rem] = true;
            if(arr[rem] == 0) return true;
            if(rem-arr[rem] >= 0 && !hasJumped[rem-arr[rem]]) que.offer(rem-arr[rem]);
            if(rem+arr[rem] < n && !hasJumped[rem+arr[rem]]) que.offer(rem+arr[rem]);
        }

        return false;
    }
}