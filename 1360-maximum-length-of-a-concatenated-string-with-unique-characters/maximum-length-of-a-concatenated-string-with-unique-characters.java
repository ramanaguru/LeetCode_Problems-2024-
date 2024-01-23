class Solution {
    
    public  int maxLength(List<String> arr) {
        String str = "";
        return backTracking(arr, 0, str);
    }

    private int backTracking(List<String> arr, int index,String current){
        if(!checkUnique(current)){
            return 0;
        }
        int maxLength = current.length();
        for (int i=index;i<arr.size();i++){
            maxLength = Math.max(maxLength, backTracking(arr, i+1, current.concat(arr.get(i))));
        }
        return maxLength;
    }

    private boolean checkUnique(String str){
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i=0;i<str.length();i++){
            if(hashMap.containsKey(str.charAt(i))){
                hashMap.put(str.charAt(i), hashMap.get(str.charAt(i))+1);
            }else {
                hashMap.put(str.charAt(i), 1);
            }
        }
        Set<Character> set = hashMap.keySet();
        for (char c: set){
            if(hashMap.get(c)>1){
                return false;
            }
        }
        return true;
    }
}