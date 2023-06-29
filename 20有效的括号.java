class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('||c=='{'||c=='[')
                stk.push(c);
            else{
                if(!stk.isEmpty()&&getLeft(c)==stk.peek())
                    stk.pop();
                else    
                    return false;
            }
        }

        return stk.isEmpty();
    }

    char getLeft(char c){
        if(c==')')
            return '(';
        else if(c=='}')
            return '{';
        else
            return '[';
    }
}