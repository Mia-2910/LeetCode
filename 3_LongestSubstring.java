/*
// Version 1:
class Solution {
    public int lengthOfLongestSubstring(String s) {
       if (s.isEmpty()){
        return 0;
       } else {
            int longest = 1;
            for(int i = 0; i < s.length(); i++) {
                int count = 1;
                char startChar = s.charAt(i);
                ArrayList<Character> cList = new ArrayList<Character>(); 
                cList.add(startChar);
                for (int j = i + 1; j < s.length(); j++){
                    char compareValue = s.charAt(j);
                    if (  cList.contains(compareValue)  ){
                       
                        break;
                    } else {
                        count ++;
                    }
                    cList.add(compareValue);
                }
                 if (count > longest){
                    longest = count;
                    count = 1;
                }
            }
            return longest;
        }
    }
}
 */

// Version 2: Improved
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//        if (s.isEmpty()){
//         return 0;
//        } else {
//             int longest = 1;
//             Set<Character> cList = new HashSet<>();
//             for(int i = 0; i < s.length(); i++) {
//                 int count = 1;
//                 char startChar = s.charAt(i); 
//                 cList.add(startChar);
//                 for (int j = i + 1; j < s.length(); j++){
//                     char compareValue = s.charAt(j);
//                     if (  cList.contains(compareValue)  ){
//                         cList.clear();
//                         break;
//                     } else {
//                         count ++;
//                     }
//                     cList.add(compareValue);
//                 }
//                  if (count > longest){
//                     longest = count;
//                     count = 1;
//                 }

//                 cList.clear();
//             }
//             return longest;
//         }
//     }
// }

// Version3:
class Solution {
    public int lengthOfLongestSubstring(String s) {
    int left = 0, right = 0, max = 0;
    Set<Character> set = new HashSet<>();
    
    while (right < s.length()){
        if (!set.contains(s.charAt(right))) { // if not repeating
            set.add(s.charAt(right));
            max = Math.max(max, set.size());
            right ++;
        } else{
            set.remove(s.charAt(left)); 
            // Because right did not increment, the while loop runs again for the exact same right position
            left ++;
        }
    }
    
    return max;
    }
}
