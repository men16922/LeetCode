package org.leetcode;

/**
 * packageName    : org.leetcode
 * fileName       : LongestCommonPrefix
 * author         : men16
 * date           : 2023-03-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-03-04        men16       최초 생성
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String result = "";
        char [] firstStr = strs[0].toCharArray();
        for(int i = 0; i < firstStr.length; i++) {
            char currentChar = firstStr[i];
            boolean isSame = true;
            boolean isBreak = false;
            for(int j = 1; j < strs.length; j++){
                if(i > strs[j].length() - 1) {
                    isBreak =true;
                    break;
                }
                if(strs[j].charAt(i) != currentChar) {
                    isBreak = true;
                    isSame = false;
                    break;
                }
            }
            if(isBreak) break;
            if(isSame) result += String.valueOf(currentChar);
        }
        return result;
    }

    public String longestCommonPrefix_chatGPT(String[] strs) {
        if (strs.length == 0) {  // if the array is empty, return an empty string
            return "";
        }
        String prefix = strs[0];  // initialize the prefix as the first string in the array
        for (int i = 1; i < strs.length; i++) {  // iterate over the remaining strings in the array
            while (!strs[i].startsWith(prefix)) {  // while the current string doesn't start with the prefix
                prefix = prefix.substring(0, prefix.length() - 1);  // remove the last character of the prefix
                if (prefix.isEmpty()) {  // if the prefix becomes empty, there is no common prefix
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String [] strs = {"ab","a"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }
}

