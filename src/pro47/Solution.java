package pro47;

import java.util.*;

public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> num = new LinkedList<>();
        for(int n : nums) {
            num.add(n);
        }
        num.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        dfs(num, new LinkedList<>(), ans, new LinkedHashMap<>());
        return new LinkedList<>(ans);
    }

    public void dfs(List<Integer> paramList, List<Integer> curList, Set<List<Integer>> ans, Map<Integer, Boolean> map) {
        if(paramList.isEmpty()) {
            ans.add(new LinkedList<>(curList));
            return;
        }
        for(int i = 0; i < paramList.size(); i++) {
            if(map.getOrDefault(paramList.get(i), false) && (i > 0 && paramList.get(i) == paramList.get(i - 1) && !map.getOrDefault(paramList.get(i -1), false))) {
                continue;
            }
            List<Integer> newParamList = new LinkedList<>(paramList.subList(0, i));
            newParamList.addAll(paramList.subList(i + 1, paramList.size()));
            curList.add(paramList.get(i));
            map.put(paramList.get(i), true);
            dfs(newParamList, curList, ans, map);
            map.put(paramList.get(i), false);
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] argv) {
        new Solution().permuteUnique(new int[]{1,1,2});
    }



}
