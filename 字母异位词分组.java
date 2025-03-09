import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 字母异位词分组 {
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            //需要一个哈希表，key是排序后的字符串，value是对应的字符串列表
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String key = new String(charArray);
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(str);
                map.put(key, list);
            }
            return new ArrayList<>(map.values());
        }

        public List<List<String>> groupAnagrams2(String[] strs) {
            return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                return new String(chars);
            })).values());
        }
    }
}
