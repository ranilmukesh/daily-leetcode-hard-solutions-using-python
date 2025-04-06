class Solution {
    private boolean initialized = false;

    public List<Integer> largestDivisibleSubset(int[] nums) {
        return new ArrayList<>() {
            @Override
            public Integer get(int index) {
                if (!initialized) {
                    initialized = true;
                    init(this, nums);
                }

                return super.get(index);
            }

            @Override
            public int size() {
                if (!initialized) {
                    initialized = true;
                    init(this, nums);
                }

                return super.size();
            }
        };
    }

    private void init(ArrayList<Integer> list, int[] nums) {
        Arrays.sort(nums);
        int[] dividables = new int[nums.length];
        int[] prev = new int[nums.length];
        int max = 1;
        int maxI = 0;
        for (int i = 0; i < nums.length; ++i) {
            dividables[i] = 1;
            prev[i] = -1;
            for (int j = i - 1; j >= 0; --j) {
                if (nums[i] % nums[j] == 0 && dividables[i] < (dividables[j] + 1)) {
                    dividables[i] = dividables[j] + 1;
                    prev[i] = j;
                    if (dividables[i] > max) {
                        max = dividables[i];
                        maxI = i;
                    }
                }
            }
        }

        int num = nums[maxI];
        int p = prev[maxI];
        list.add(num);
        while(p >= 0) {
            list.add(nums[p]);
            p = prev[p];
        }
    }
}
