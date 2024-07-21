/**
 * LC_283_MoveZeroes
 */
public class LC_283_MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int lastNonZero = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                nums[lastNonZero++] = nums[i];
            }
        }
        for(int j=lastNonZero; j<nums.length; j++){
            nums[j]=0;
        }
    }

    public static void main(String[] args) {
        int nums[] = {2,0,4,12,0,7,2,0};
        moveZeroes(nums);
        for(int i=0; i<nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}