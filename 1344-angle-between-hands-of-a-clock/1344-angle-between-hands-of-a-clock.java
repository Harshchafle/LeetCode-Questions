class Solution {
    public double angleClock(int hour, int minute) {
        double x = hour + minute / 60.0;
        double diff = (11.0 * x) % 12.0; 
        return Math.min(diff, 12.0-diff)*30;
    }
}