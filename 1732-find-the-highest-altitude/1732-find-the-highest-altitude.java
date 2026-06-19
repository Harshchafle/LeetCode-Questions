class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int track = 0;
        for(int i = 0; i < gain.length; i++){
            track += gain[i];
            ans = Math.max(ans, track);
        }
        return ans;
    }
}