class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String suffixStr) {
        char limitCh = (char) (limit + '0');
        long suffix = Long.parseLong(suffixStr);
        int numSuffixDigits = suffixStr.length();
        int numStartDigits = (int) Math.log10(start) + 1;
        int numFinishDigits = (int) Math.log10(finish) + 1;

        if (numFinishDigits < numSuffixDigits || finish < suffix) {
            return 0;
        }

        if (numFinishDigits == numSuffixDigits) {
            return 1;
        }

        long increment = (long) Math.pow(10, numSuffixDigits);

        // ensure start is set to the lowest number larger than or equal to start that ends with suffix
        if (numStartDigits < numSuffixDigits) {
            start = suffix;
        } else if (numStartDigits == numSuffixDigits) {
            start = start <= suffix ? suffix : (increment + suffix);
        } else if (start % increment > suffix) {
            start = (start / increment + 1) * increment + suffix;
        } else {
            start = (start / increment) * increment + suffix;
        }

        // exit condition
        if (finish < start) {
            return 0;
        }

        // ensure finish is set to the highest number smaller than or equal to finish that ends with suffix
        if ((finish % increment) >= suffix) {
            finish = (finish / increment) * increment + suffix;
        } else {
            finish = (finish / increment - 1) * increment + suffix;
        }

        // exit condition
        if (finish < start) {
            return 0;
        }

        // round finish down to the highest number containing only the allowed digits
        int idx = 0;
        char[] finishCh = String.valueOf(finish).toCharArray();
        while (idx < finishCh.length && finishCh[idx] <= limitCh) {
            idx++;
        }
        if (idx < finishCh.length) {
            finishCh[idx++] = limitCh;
            while (idx < finishCh.length) {
                finishCh[idx++] = (char) limitCh;
            }
            finish = Long.parseLong(String.valueOf(finishCh));
        }

        // exit condition
        if (finish < start) {
            return 0;
        }

        // round start up to the lowest number containing only the allowed digits
        idx = 0;
        char[] startCh = String.valueOf(start).toCharArray();
        while (idx < startCh.length && startCh[idx] <= limitCh) {
            idx++;
        }
        if (idx < startCh.length) {
            int incIdx = idx - 1;
            while (incIdx > -1 && startCh[incIdx] == limitCh) {
                incIdx--;
            }
            if (incIdx == -1) {
                start = (long) Math.pow(10, startCh.length);
            } else {
                startCh[incIdx++]++; 
                while (incIdx < startCh.length) {
                    startCh[incIdx++] = '0';
                }
                start = Long.parseLong(String.valueOf(startCh));
            }
        }

        if (finish < start) {
            return 0;
        }

        start = Long.parseLong(String.valueOf(start / increment), limit + 1);
        finish = Long.parseLong(String.valueOf(finish / increment), limit + 1);
        return 1 + finish - start;
    }
}
