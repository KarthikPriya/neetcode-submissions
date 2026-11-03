class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '{')
            {
                stack.push(s.charAt(i));continue;}
            else if(s.charAt(i) == '[')
            {    stack.push(s.charAt(i));continue;}
            else if(s.charAt(i) == '(')
            {     stack.push(s.charAt(i));continue;}
            else if(s.charAt(i) == ')')
            {
                if(!stack.isEmpty() && stack.peek() =='(')
                    stack.pop();
                else 
                    return false;
            }else if(s.charAt(i) == ']')
            {
                if(!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else 
                    return false;
            }else if(s.charAt(i) == '}')
            {
                if(!stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else 
                    return false;
            }           
        }
        return stack.isEmpty();
    }

}
