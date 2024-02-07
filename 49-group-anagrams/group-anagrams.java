class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //HashMap <String, List<String>> looks like word, freq ==> <e1a1t1, <eat> >

        HashMap<String , List<String>> hm = new HashMap<>();

        for(String str: strs){
            String freq = check(str);
            if(hm.containsKey(freq)){
                hm.get(freq).add(str);
            }
            else{
                ArrayList<String> temp = new ArrayList<>();
                temp.add(str);
                hm.put(freq, temp);
            }
        }

        return new ArrayList<>(hm.values());
    }

    public String check(String str){
        int freq[] = new int[26];
        char ch[] = str.toCharArray();
        
       for(char c : ch){
           freq[c - 'a']++;
       }
       
       StringBuilder sb = new StringBuilder();

       for(int i = 0 ; i < 26; i++){
           if(freq[i] != 0){
               sb.append((char)('a' + i)).append(freq[i]);
           }
       }

       return sb.toString();
    }
}