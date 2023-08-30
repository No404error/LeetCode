class Solution {
    String[] arr={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    char[] str;
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if(digits.length()>0){
            str=new char[digits.length()];
            bfs(digits,0,res);
        }
        return res;
    }
    public void bfs(String digits,int now,List<String> res){
        if(now>=digits.length()){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<str.length;i++)
                sb.append(str[i]);
            res.add(sb.toString());
            return;
        }
        else{
            String nums=arr[digits.charAt(now)-'2'];
            for(int i=0;i<nums.length();i++){
                str[now]=nums.charAt(i);
                bfs(digits,now+1,res);
            }
        }
    }
}