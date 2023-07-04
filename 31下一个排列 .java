class Solution {
    int[] num;
    void swap(int l,int r){
        int tmp=num[l];
        num[l]=num[r];
        num[r]=tmp;
    }

    void reverse(int l){
        int r=num.length-1;
        while(l<r){
            swap(l++,r--);
        }
    }

    public void nextPermutation(int[] nums) {
        num=nums;
        int l=num.length-2;
        while(l>=0&&num[l]>=num[l+1]) l--;
        if(l>=0){
            int r=num.length-1;
            while(nums[l]>=nums[r]) r--;
            swap(l,r);
        }
        reverse(l+1);
    }
}