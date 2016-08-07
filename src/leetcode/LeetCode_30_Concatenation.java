package leetcode;

import java.util.*;

/**
 * Created by liuyang on 16/8/7.
 */
public class LeetCode_30_Concatenation {

    dictTree tree;
    //int wordLength,subLength;
    public List<Integer> findSubstring(String s, String[] words) {//164
        List<Integer> ans = new ArrayList<>();
        int wordLength = words[0].length(),subLength = wordLength * words.length;
        tree = new dictTree(words);
        for (int i = 0; i <= s.length() - subLength; i++) {
            for (int j = i; j < i + subLength; j += wordLength) {
                if (!tree.find(s.substring(j,j+wordLength), 0))
                    break;
            }
            if (tree.check()){
                ans.add(i);
                //System.out.println("success : " + s.substring(i,i+subLength));
            }
        }
        return ans;
    }

    public static void test(){
        LeetCode_30_Concatenation contatenation = new LeetCode_30_Concatenation();
        {
            String s = "barfoothefoobarman";
            String[] words = {"foo", "bar"};
            System.out.println(contatenation.findSubstring(s,words));
        }
        {
            String s = "wordgoodgoodgoodbestword";
            String[] words = {"word","good","best","good"};
            System.out.println(contatenation.findSubstring(s,words));
        }
        {
            String s = "aaa";
            String[] words = {"a","b"};
            System.out.println(contatenation.findSubstring(s,words));
        }
    }

}

class dictTree{

    static Set<dictTree> endWords = new HashSet<>();

    Map<Character, dictTree> map = new HashMap<>(26);
    int count = 0;
    int curCount = 0;

    public dictTree(){
        super();
    }

    public dictTree(String[] words){
        super();
        endWords.clear();
        for (String word : words) {
            addWord(word,0);
        }
    }

    public void addWord(String word, int index){
        if (index == word.length()){
            count++;
            endWords.add(this);
            return;
        }
        char ch = word.charAt(index);
        if (!map.containsKey(ch)){
            map.put(ch, new dictTree());
        }
        map.get(ch).addWord(word,index+1);
    }

    public boolean find(String word, int index){

        if (index == word.length()){
            //System.out.println("--------" + word + " : " + (curCount < count) + " , curCount : " + (curCount+1));
            return ++curCount <= count;
        }

        char ch = word.charAt(index);
/*        if (!map.containsKey(ch)){
            //System.out.println("--------" + word + " , no '" + ch + "'");
            return false;
        }
        return map.get(ch).find(word,index+1);*/
        return map.containsKey(ch) ? map.get(ch).find(word,index+1) : false;
    }

    public boolean check(){
        boolean flag = true;
        for (dictTree endWord : endWords) {
            if (endWord.curCount != endWord.count)
                flag = false;
            endWord.curCount = 0;
        }
        return flag;
    }
}
