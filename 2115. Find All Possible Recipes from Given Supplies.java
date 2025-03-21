class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> s = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < recipes.length; i++) {
            q.add(i);
        }
        Set<String> set = new HashSet<>();
        for (String sup : supplies) {
            set.add(sup);
        }
        int last = -1;
        while (set.size() > last) {
            last = set.size();
            int size = q.size();
            while (size-- > 0) {
                boolean flag = true;
                int idx = q.poll();
                for (String str : ingredients.get(idx)) {
                    if (!set.contains(str)) {
                        flag = false;
                        break;
                    }
                }
                if (!flag)
                    q.add(idx);
                else {
                    set.add(recipes[idx]);
                    s.add(recipes[idx]);
                }
            }
        }
        return s;
    }
}
