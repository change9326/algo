package leetcode;

import java.util.Stack;

/**
 * @author yujiaqi
 * @date 2020-11-19 11:46
 * @description������һ��ֻ���� ��(������)������{������}������[������]�� ���ַ������ж��ַ����Ƿ���Ч��
 *
 *  ��3���������ͣ�����һһ��Ӧ�ģ�������Ҫ������������֮ǰ���֣����ǿ��԰��ַ�����ÿһλ���д���
 *  ���е��� �� ( �� �� �� [ �� �� �� { 'ʱ�������Ƕ�Ӧ����������ջ������������Ϊ�˱Ƚ������Ƿ�ɶԳ��֣�
 *  �������Ҳ���ǵ�����������ʱ���ͳ�ջȻ����бȽϣ���������˵�����ǳɶԳ��֣�����false��
 *  ֱ�ӽ�������ÿ�γ�ջ���ǳɹ�ƥ�䣬
 *  ���ʱ��ջ��Ϊ��ջ�����������������ģ�����true�����԰��Ƿ�Ϊ��ջ��Ϊ����true���жϡ�
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
