class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder result = new StringBuilder();
        int total = a + b + c;

        while (total > 0) {
            if ((a >= b && a >= c && !(result.length() >= 2 && result.charAt(result.length() - 1) == 'a' && result.charAt(result.length() - 2) == 'a'))) {
                result.append('a');
                a--;
            } else if ((b >= a && b >= c && !(result.length() >= 2 && result.charAt(result.length() - 1) == 'b' && result.charAt(result.length() - 2) == 'b'))) {
                result.append('b');
                b--;
            } else if ((c >= a && c >= b && !(result.length() >= 2 && result.charAt(result.length() - 1) == 'c' && result.charAt(result.length() - 2) == 'c'))) {
                result.append('c');
                c--;
            } else {
               
                if (result.length() >= 2 && result.charAt(result.length() - 1) == 'a' && result.charAt(result.length() - 2) == 'a') {
                    if (b > 0) {
                        result.append('b');
                        b--;
                    } else if (c > 0) {
                        result.append('c');
                        c--;
                    } else {
                        break;
                    }
                } else if (result.length() >= 2 && result.charAt(result.length() - 1) == 'b' && result.charAt(result.length() - 2) == 'b') {
                    if (a > 0) {
                        result.append('a');
                        a--;
                    } else if (c > 0) {
                        result.append('c');
                        c--;
                    } else {
                        break;
                    }
                } else if (result.length() >= 2 && result.charAt(result.length() - 1) == 'c' && result.charAt(result.length() - 2) == 'c') {
                    if (a > 0) {
                        result.append('a');
                        a--;
                    } else if (b > 0) {
                        result.append('b');
                        b--;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            total--;
        }

        return result.toString();
    }
}
