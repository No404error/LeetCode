class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> collect = Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
            int[] arr=new int[26];
            for(int i=0;i<str.length();i++)
                arr[str.charAt(i)-'a']++;
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<26;i++)
                if(arr[i]!=0)
                    sb.append((char)('a'+i)).append(arr[i]);
            return sb.toString();
        }));

        return new ArrayList<>(collect.values());
    }
}