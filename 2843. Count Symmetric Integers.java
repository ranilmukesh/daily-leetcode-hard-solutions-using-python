class Solution {
    int getCombo(int sum) {
        if (sum <= 9) {
            return  sum+1; 
        } else {
            return 19 - sum; 
        }
    }

    int sym(int num) {
        int ans = 0;
        if (num >= 10) {
            if (num >= 100)  {
                ans += 9;
                if (num >= 1000 && num <= 10000) {
                   int d43 = num/100, d21=num%100;
                   for (int i=10; i<d43; i++) {
                        int sum = i/10 + i%10;
                        ans += getCombo(sum);
                   }
                   int sum = d43/10 + d43%10;
                    for (int i=0; i<=9; i++) {
                        int j = sum-i;
                        if (j>=0 && j<=9 && (i*10+j) <=d21) ans++;
                    }
                }
            } else {
                int d2 = num/10, d1=num%10;
                ans += d2;
                ans -= d1 >= d2? 0 : 1;
            }
        }
        return ans;
    }
    public int countSymmetricIntegers(int low, int high) {
        return sym(high) - sym(low-1);
    }
}
