import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode1282 {
    public static List<List<Integer>> groupThePeople(int[] gs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < gs.length; i++) {
            List<Integer> list = map.getOrDefault(gs[i], new ArrayList<>());
            list.add(i);
            map.put(gs[i], list);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int k : map.keySet()) {
            List<Integer> list = map.get(k), cur = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                cur.add(list.get(i));
                if (cur.size() == k) {
                    ans.add(cur);
                    cur = new ArrayList<>();
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] a = {1,3,3,3,3,3,3,3,3,3};
        List<List<Integer>> ans = groupThePeople(a);
        System.out.println(ans);
    }
}
