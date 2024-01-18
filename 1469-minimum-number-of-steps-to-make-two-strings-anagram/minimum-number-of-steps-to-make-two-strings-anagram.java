class Solution {
    public int minSteps(String s, String t) {
        
        int freq[] = new int[26];
        
        int n = s.length();
        int m = t.length();

        for(int i = 0; i < n; i++){
            char schar = s.charAt(i);
            char tchar = t.charAt(i);
            freq[schar - 'a']++;
            freq[tchar - 'a']--;
        }

        int total =0;

        for(int i = 0; i < 26; i++){
            total += (Math.abs(freq[i]));
        }

        return total/2;


    }
}