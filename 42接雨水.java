class Solution {
    public int trap(int[] height) {
        int left=0,right=height.length-1;
        int res=0;
        int ln=0,rn=0;
        while(left<=right){
            while(ln<=rn&&left<=right){
                if(height[left]>ln)
                    ln=height[left];
                res+=(ln-height[left]);
                left++;
            }
            while(rn<=ln&&left<=right){
                if(height[right]>rn)
                    rn=height[right];
                res+=(rn-height[right]);
                right--;
            }
        }
        return res;
    }
}