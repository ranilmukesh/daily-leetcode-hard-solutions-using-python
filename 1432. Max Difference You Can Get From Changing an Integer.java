class Solution {
    public int get(int val, int y, int arr[]) {
        int copy[] = arr.clone();
        
        for(int i=0; i<copy.length; i++) {
            if(copy[i] == val) {
                copy[i] = y; 
            }
        }

        int ans = 0;
        for(int i : copy) {
            ans = ans * 10 + i;
        }

        return ans;
    }

    public int maxDiff(int num) {
        int cnt = 0;
        int temp = num;
        while(temp > 0) {
            cnt++;
            temp /= 10; 
        }

        temp = num;
        int arr[] = new int[cnt];
        for(int i=cnt-1; i>=0; i--) {
            arr[i] = temp % 10;
            temp /= 10;
        }

        int x = -1;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != 9) {
                x = arr[i];
                break;
            }
        }
        if(x == -1) x = arr[0];
        int max = get(x, 9, arr);
        int y = -1;
        if(arr[0] != 1) {
            y = arr[0];
            int min = get(y, 1, arr);
            return max - min;
        } else {
            for(int i=1; i<arr.length; i++) {
                if(arr[i] != 0 && arr[i] != 1) {
                    y = arr[i];
                    break;
                }
            }
            if(y == -1) {
                return max - num; 
            }
            int min = get(y, 0, arr);
            return max - min;
        }
    }
}
