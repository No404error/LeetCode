class Solution {
    public void reverseString(char[] s) {
        int slow=0,fast=s.length-1;
        while(slow<fast){
            char tmp=s[slow];
            s[slow]=s[fast];
            s[fast]=tmp;
            slow++;
            fast--;
        }
    }
}