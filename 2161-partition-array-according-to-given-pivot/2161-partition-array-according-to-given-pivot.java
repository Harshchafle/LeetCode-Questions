class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> sml = new ArrayList<>();
        List<Integer> lar = new ArrayList<>();
        int nump = 0;

        for(int num : nums){
            if(num < pivot){
                sml.add(num);
            }
            else if(num > pivot){
                lar.add(num);
            }
            else nump++;
        }

        int[] ans = new int[sml.size() + nump + lar.size()];
        int k = 0;
        for(int num : sml){
            ans[k++] = num;
        }
        while(nump > 0){
            ans[k++] = pivot;
            nump--;
        }
        for(int num : lar){
            ans[k++] = num;
        }

        return ans;
    }
}