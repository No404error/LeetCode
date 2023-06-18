class Solution {
    public int search(int[] nums, int target) {
        return search(nums,0,nums.length,target);
    }
    int search(int[] nums,int s,int e,int target){
        if(s>=e)
            return -1;
        int pos=(s+e)/2;
        if(target==nums[pos])
            return pos;
        else if(target<nums[pos])
            return search(nums,s,pos,target);
        else
            return search(nums,pos+1,e,target);
    }
}