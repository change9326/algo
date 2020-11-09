package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yujiaqi
 * @date 2020-11-09 11:03
 * @description:���ظ��ַ�����Ӵ�
 * abcabcbb
 * ˼·
 * ����һ�� map ���ݽṹ�洢 (k, v)������ key ֵΪ�ַ���value ֵΪ�ַ�λ�� +1���� 1 ��ʾ���ַ�λ�ú�һ���ſ�ʼ���ظ�
 * ���Ƕ��岻�ظ��Ӵ��Ŀ�ʼλ��Ϊ start������λ��Ϊ end
 * ���� end ���ϱ�����󣬻������� [start, end] �������ַ���ͬ���������ʱ���ַ���Ϊ key ֵ����ȡ�� value ֵ�������� start����ʱ [start, end] �����ڲ������ظ��ַ�
 * �����Ƿ���� start����������� map ���ݽṹ�ͽ�� ans��
 * ʱ�临�Ӷȣ�O(n)
 */
public class LongestSubstring {
    /**
     * 1.start������end����ƶ�
     * 2.��end�����ظ��ַ���startӦ�÷�����һ���ظ��ַ���λ�õĺ�һλ��ͬʱ��¼��ĳ���
     * 3.�����ж��Ƿ������ظ��ַ�������ô֪����һ���ظ��ַ���λ�ã�
     *   --�ù�ϣ�ֵ��key���ж��Ƿ��ظ�����value����¼���ַ�����һ�����ظ���λ�á�
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                // �����ظ���key,����startָ��
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            //key��map �в����ڣ�key ֵΪ�ַ���value ֵΪ�ַ�λ�� +1��
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        // key    : a b c | a b c
        // value  : 1 2 3 | 4 5
        // start  : 0     | 1 2 3
        // length : 3     | 3 3
    }

    public int lengthOfLongestSubString(String s){
        int n=s.length();
        int length=0;
        Map<Character, Integer> map=new HashMap<>();
        for(int start=0,end=0;end<n;end++){
            char m=s.charAt(end);
            // �����ظ��ַ�
            if(map.containsKey(m)){
                start=Math.max(start,map.get(m));
            }
            length=Math.max(length,end-start+1);
            map.put(s.charAt(end),end+1);
        }
        return length;
    }

}
