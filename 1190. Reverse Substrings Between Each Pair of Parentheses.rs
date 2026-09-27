class Solution {
     public static String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int arr[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char v = s.charAt(i);
            if (v == '(') {
                st.push(i);

            } else if (v == ')') {
                int ind = st.pop();
                arr[ind] = i;
                arr[i] = ind;
            }
        }
        int dir = 1;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);

            if (c == '(' || c == ')') {
                dir = -1 * dir;
                i = arr[i];
            } else {
                sb.append(c);
            }
            i += dir;
        }

        return sb.toString();
    }
}
// edelocte   
