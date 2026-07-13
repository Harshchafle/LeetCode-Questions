class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int max = 0;
        

        for(int i = 0; i < n; i++){
            Map<String, Integer> map = new HashMap<>();
            int x1 = points[i][0], y1 = points[i][1];
            int localMax = 0;
            for(int j = i+1; j < n; j++){
                int x2 = points[j][0], y2 = points[j][1];

                int x = x2-x1;
                int y = y2-y1;
                int gcd = gcd(Math.abs(x),Math.abs(y));
                x /= gcd;
                y /= gcd;

                if(x < 0){
                    x = -x;
                    y = -y;
                }
                else if (x == 0) {
                    y = 1;
                }

                String key = x+"-"+y;
                map.put(key, map.getOrDefault(key, 0) + 1);
                localMax = Math.max(localMax, map.get(key));
            }
            max = Math.max(max, localMax+1);
            //System.out.println(map);
        }
        return max;
    }

    public int gcd(int x, int y){
        while(y != 0){
            int temp = y;
            y = x % temp;
            x = temp;
        }
        return x;
    }
}