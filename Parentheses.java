//Idress ahmadzai 11/17
//this program checks if the parentheses in a given string are valid or not

public class Parentheses{
        
    public static boolean isValid(String s){
        java.util.Stack<Character> stack = new java.util.Stack<>();
        
        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push to stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // If it's a closing bracket, check if it matches the most recent opening bracket
            else if (c == ')' || c == '}' || c == ']') {
                // If stack is empty, there's no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                
                // Check if the closing bracket matches the opening bracket
                if ((c == ')' && top != '(') || 
                    (c == '}' && top != '{') || 
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        // If stack is empty, all brackets were matched; otherwise, there are unmatched opening brackets
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(isValid("(){}[]")); //true
        System.out.println(isValid("(]")); //false
        System.out.println(isValid("([{({})}])")); //true
        System.out.println(isValid("(([]){})")); //true
        System.out.println(isValid("{}[())()(]")); //false
        System.out.println(isValid("(){}{")); //false   
        System.out.println(isValid("([)]")); //false
        System.out.println(isValid("([{}([)])]")); //false  
        
    }
}