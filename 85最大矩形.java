class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int[] heights=new int[col+2];
        int res=0;
        for(int i=0;i<row;i++){
            Stack<Integer> stk=new Stack<>();
            for(int j=0;j<=col+1;j++){
                if(j>0&&j!=col+1)
                    heights[j]=matrix[i][j-1]=='0'?0:heights[j]+1;
                if(stk.isEmpty()||heights[j]>=heights[stk.peek()])
                    stk.push(j);
                else{
                    while(!stk.isEmpty()&&heights[j]<heights[stk.peek()]){
                        int height=heights[stk.pop()];
                        res=Math.max(res,(j-stk.peek()-1)*height);
                    }
                    stk.push(j);
                }
            }
            
        }
        return res;
    }
}