class Solution {
    public int[] searchRange(int[] nums, int target) {
        num=nums;
        tar=target;
        return new int[]{searchLeft(),searchRight()};
    }
    int[] num;
    int tar;
    int searchLeft(){
        int l=0,r=num.length-1;
        while(l<=r){
            int pos=l+(r-l)/2;
            if(num[pos]>=tar)
                r=pos-1;
            else 
                l=pos+1;
        }
        if(l>=num.length||num[l]!=tar)
            return -1;
        return l;
    }   
    int searchRight(){
        int l=0,r=num.length-1;
        while(l<=r){
            int pos=l+(r-l)/2;
            if(num[pos]<=tar)
                l=pos+1;
            else 
                r=pos-1;
        }
        if(r<0||num[r]!=tar)
            return -1;
        return r;
    }   
}