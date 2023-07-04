class Solution {
    int[] num;
    void swap(int a1,int a2){
        int tmp=num[a1];
        num[a1]=num[a2];
        num[a2]=tmp;
    }

    public void sortColors(int[] nums) {
        num=nums;
        int p0=0,p2=nums.length;
        int i=0;
        while(i<p2){
            if(nums[i]==0)
                swap(p0++,i++);
            else if(nums[i]==1)
                i++;
            else
                swap(--p2,i);
        }
    }
}