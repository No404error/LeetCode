class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len=nums1.length+nums2.length;
        int left=(len+1)/2;
        int right=(len+2)/2;
        return (getKth(nums1,0,nums1.length,nums2,0,nums2.length,left)+getKth(nums1,0,nums1.length,nums2,0,nums2.length,right))/2.0;
    }

    int getKth(int[] a,int as,int ae,int[] b,int bs,int be,int k){
        int len1=ae-as;
        int len2=be-bs;
        if(len1>len2)
            return getKth(b,bs,be,a,as,ae,k);
        if(len1==0)
            return b[bs+k-1];
        else if(k==1)
            return Math.min(a[as],b[bs]);

        int act1=as+Math.min(len1,k/2)-1;
        int act2=bs+Math.min(len2,k/2)-1;

        if(a[act1]>b[act2]){
            return getKth(a,as,ae,b,act2+1,be,k-(act2-bs+1));
        }else
            return getKth(a,act1+1,ae,b,bs,be,k-(act1-as+1));

    }
}
