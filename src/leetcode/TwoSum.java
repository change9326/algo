package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yujiaqi
 * @date 2020-11-11 14:09
 * @description
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6};
        System.out.println(Arrays.toString(twoSum(a,9)));
    }

    public static int[] twoSum(int[] a,int target){
        int n=a.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(target-a[i])){
                return new int[] {map.get(target-a[i]),i};
            }
            map.put(a[i],i);
        }
        throw new IllegalArgumentException("input illegal..");
    }
}
