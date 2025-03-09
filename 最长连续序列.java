import java.util.HashMap;
import java.util.Map;

public class 最长连续序列 {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                int cur = left + right + 1;
                map.put(num, cur);
                res = Math.max(res, cur);
                map.put(num - left, cur);
                map.put(num + right, cur);
            }
        }
        return res;
    }
}
