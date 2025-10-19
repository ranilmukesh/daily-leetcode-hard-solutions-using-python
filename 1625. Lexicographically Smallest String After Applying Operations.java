class Solution {
    public String findLexSmallestString(String str, int addVal, int rotStep) {
        char[] s = str.toCharArray();
        int n = s.length;
        char[] temp = new char[n];
        int step = gcd(rotStep, n);
        int group = gcd(addVal, 10);
        String res = null;

        for (int i = 0; i < n; i += step) {
            System.arraycopy(s, i, temp, 0, n - i);
            System.arraycopy(s, 0, temp, n - i, i);
            addDigits(temp, 1, group);

            if (step % 2 != 0) {
                addDigits(temp, 0, group);
            }

            String curr = new String(temp);
            if (res == null || curr.compareTo(res) < 0) {
                res = curr;
            }
        }

        return res;
    }

    private void addDigits(char[] arr, int start, int group) {
        int digit = arr[start] - '0';
        int inc = digit % group - digit + 10; 
        for (int i = start; i < arr.length; i += 2) {
            arr[i] = (char) ('0' + (arr[i] - '0' + inc) % 10);
        }
    }

    private int gcd(int a, int b) {
        while (a != 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }
}
