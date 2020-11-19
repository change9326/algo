package leetcode;

import java.util.Stack;

/**
 * @author yujiaqi
 * @date 2020-11-19 11:46
 * @description：给定一个只包括 ‘(’，’)’，’{’，’}’，’[’，’]’ 的字符串，判断字符串是否有效。
 *
 *  有3种括号类型，都是一一对应的，左括号要满足在右括号之前出现，我们可以把字符串的每一位进行处理，
 *  其中当是 ’ ( ’ 、 ’ [ ’ 、 ’ { '时，把它们对应的右括号入栈，，这样做是为了比较括号是否成对出现，
 *  其他情况也就是当出现右括号时，就出栈然后进行比较，如果不相等说明不是成对出现，返回false，
 *  直接结束。若每次出栈都是成功匹配，
 *  则此时的栈就为空栈，并且是满足条件的，返回true。可以把是否为空栈作为返回true的判断。
 */
public class ValidStr {


    public static void main(String[] args) {
         String s="([])";
        System.out.println(ckeckValidStr(s));
    }

    public static  boolean ckeckValidStr(String s){
        Stack<Character> stack = new Stack<>();
        for(Character c:s.toCharArray()) {
            if(c == '(') {
                stack.push(')');
            }else if(c == '[') {
                stack.push(']');
            }else if(c == '{') {
                stack.push('}');
            }else if(stack.isEmpty() || !stack.pop().equals(c)){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
