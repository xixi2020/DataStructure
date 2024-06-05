package dataStructure.stack;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class TwoKuohao {
    //用字符串的方法
    public boolean isValid(String s) {
        //将数组中一样的代替成空字符串
        int length = s.length()/2;
        s = s.replace("()", "").replace("{}", "").replace("[]", "");
        return s.length() == 0;

    }
    //用栈的方法
    public boolean isValid1(String s) {
        if(s.isEmpty())
            return true;
        Stack<Character> stack=new Stack<Character>();
        //注意这里使用了toCharArray
        for(char c:s.toCharArray()){
            if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            //将下一个字符与push进去的字符进行对比，有一个不对应的就返回false
            else if(stack.empty()||c!=stack.pop())
                return false;
        }
        if(stack.empty())
            return true;
        return false;
    }

}
