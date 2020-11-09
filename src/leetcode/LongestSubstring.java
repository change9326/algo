package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yujiaqi
 * @date 2020-11-09 11:03
 * @description:无重复字符的最长子串
 * abcabcbb
 * 思路
 * 定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
 * 我们定义不重复子串的开始位置为 start，结束位置为 end
 * 随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
 * 无论是否更新 start，都会更新其 map 数据结构和结果 ans。
 * 时间复杂度：O(n)
 */
public class LongestSubstring {
    /**
     * 1.start不动，end向后移动
     * 2.当end遇到重复字符，start应该放在上一个重复字符的位置的后一位，同时记录最长的长度
     * 3.怎样判断是否遇到重复字符，且怎么知道上一个重复字符的位置？
     *   --用哈希字典的key来判断是否重复，用value来记录该字符的下一个不重复的位置。
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                // 存在重复的key,更新start指针
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            //key在map 中不存在（key 值为字符，value 值为字符位置 +1）
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
            // 遇到重复字符
            if(map.containsKey(m)){
                start=Math.max(start,map.get(m));
            }
            length=Math.max(length,end-start+1);
            map.put(s.charAt(end),end+1);
        }
        return length;
    }

}
