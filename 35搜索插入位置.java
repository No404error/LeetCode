class Solution {
    public int searchInsert(int[] nums, int target) {
        num=nums;
        tar=target;
        return search(0,nums.length);
    }

    int[] num;
    int tar;

    int search(int s,int e){
        if(s==e)
            return s;
        int pos=(s+e)/2;
        if(num[pos]==tar)
            return pos;
        else if(num[pos]>tar)
            return search(s,pos);
        else 
            return search(pos+1,e);
    }
}