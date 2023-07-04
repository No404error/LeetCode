class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int res=0;
        while(left<right){
            res=Math.max(res,(right-left)*(Math.min(height[left],height[right])));
            if(height[left]<height[right]){
                int tmp=height[left];
                while(left<right&&height[left]<=tmp) left++;
            }else{
                int tmp=height[right];
                while(left<right&&height[right]<=tmp) right--;
            }
        }
        return res;
    }
}