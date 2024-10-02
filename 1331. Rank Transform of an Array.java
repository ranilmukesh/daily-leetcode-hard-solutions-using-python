class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        int count=1;
        for(int i=0;i<temp.length;i++){
            if(map.get(temp[i]) == null) {
                map.put(temp[i], count);
                count++;
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}
