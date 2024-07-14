class Solution {
    int i = 0;
    int n;
    public String countOfAtoms(String f) {
        n = f.length();
        Map<String, Integer> ans = dfs(f);
        List<String> list = new ArrayList();
        for (String element : ans.keySet()) {
            list.add(element);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (String element : list) {
            int cnt = ans.get(element);
            sb.append(element);
            if (cnt > 1) {
                sb.append(cnt);
            }
        }
        return sb.toString();
    }
    public Map<String, Integer> dfs(String f) {
        Map<String, Integer> ans = new HashMap();
        while (i < n && f.charAt(i) != ')') {
            char cur = f.charAt(i);
            if (cur == '(') {
                i++;
                Map<String, Integer> list = dfs(f);
                i++;
                int cnt = 0;
                while (i < n && isNumber(f.charAt(i))) {
                    cnt *= 10;
                    cnt += f.charAt(i++) - '0';
                }
                if (cnt == 0) cnt = 1;
                for (String element : list.keySet()) {
                    ans.put(element, ans.getOrDefault(element, 0) + cnt * list.get(element)); 
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(f.charAt(i++));
                while (i < n && isLetter(f.charAt(i))) {
                    sb.append(f.charAt(i++));
                }
                int cnt = 0;
                while (i < n && isNumber(f.charAt(i))) {
                    cnt *= 10;
                    cnt += f.charAt(i++) - '0';
                }
                if (cnt == 0) cnt = 1;
                String element = sb.toString();
                ans.put(element, ans.getOrDefault(element, 0) + cnt); 
            }
        }
        return ans;        
    }
    public boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }
    public boolean isLetter(char ch) {
        return ch >= 'a' && ch <= 'z';
    }
}
