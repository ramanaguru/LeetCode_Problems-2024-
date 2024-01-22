class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < strs[0].length(); ++i){
            for(String s : strs){
                if(i == s.length() || s.charAt(i) != strs[0].charAt(i)){
                    return ans.toString();
                }
            }

            ans.append(strs[0].charAt(i));

        }

        return ans.toString();
    }
}