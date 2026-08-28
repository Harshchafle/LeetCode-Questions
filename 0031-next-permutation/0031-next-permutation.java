class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;
        while(i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }

        if(i >= 0) {
            int nextG = n-1;
            for(int j = n-1; j >= 0; j--){
                if(nums[j] > nums[i]){
                    nextG = j;
                    break;
                }
            }
            swap(nums, i, nextG);

            reverse(nums, i+1);
        }
        else reverse(nums, 0);
    }

    public void reverse(int[] arr, int st) {
        int i = st;
        int j = arr.length-1;
        while(i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}