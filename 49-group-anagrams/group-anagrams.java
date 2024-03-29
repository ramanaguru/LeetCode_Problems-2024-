class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);

            String sorted_str = new String(ch);
            if(!hm.containsKey(sorted_str)){
                hm.put(sorted_str, new ArrayList<>());
            }

            hm.get(sorted_str).add(str);
        }

        return new ArrayList<>(hm.values());
    }
}

/*


Tc : O(NK log K) ; Sc : O(NK)


N represents the number of strings in the input array strs.
K represents the maximum length of a string in the array strs


   sortedStr  :  str

{
  "aet": ["eat", "tea", "ate"],
  "ant": ["tan", "nat"],
  "abt": ["bat"]
}

OUtput : 


[
  ["eat", "tea", "ate"],
  ["tan", "nat"],
  ["bat"]
]




*/
