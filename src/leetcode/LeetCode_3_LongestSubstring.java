package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuyang on 16/5/3.
 */
public class LeetCode_3_LongestSubstring {

    /**
     * 找到长度最长的不带重复字符的子串
     * @param s 给定字符串
     * @return  最长字串的长度
     */
    public int lengthOfLongestSubstring(String s) { //hashMap保存重复字串 22ms
        Map<Character,Integer> map = new HashMap<>();
        int maxSize =  0;
        for (int i = 0,begin = 0,size = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){  //存在重复
                int duplicateIndex = map.get(s.charAt(i));
                for (int j = begin; j <= duplicateIndex; j++) //重复之前的移除
                    map.remove(s.charAt(j));
                begin = duplicateIndex +1;
                size = map.size();
            }
            map.put(s.charAt(i),i);
            maxSize = Math.max(maxSize,++size);
        }
        return maxSize;
    }

    public int lengthOfLongestSubstring2(String s){ //vote数组保存每个字符的索引,8ms
        int index[] = new int[128];
        Arrays.fill(index,-1);
        int maxSize = 0,begin = 0;
        for (int i = 0; i < s.length(); i++) {
            begin = Math.max(begin,index[s.charAt(i)]+1);
            index[s.charAt(i)] = i; //添加当前字符
            maxSize = Math.max(maxSize,i - begin + 1); //更新长度
        }
        return maxSize;
    }

    public static void main(String[] args) {
        LeetCode_3_LongestSubstring tool = new LeetCode_3_LongestSubstring();
        System.out.println(tool.lengthOfLongestSubstring2(""));
        System.out.println(tool.lengthOfLongestSubstring2("c"));
        System.out.println(tool.lengthOfLongestSubstring2("cd"));
        System.out.println(tool.lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(tool.lengthOfLongestSubstring2("bbbbb"));
        System.out.println(tool.lengthOfLongestSubstring2("pwwkew"));
    }
}
