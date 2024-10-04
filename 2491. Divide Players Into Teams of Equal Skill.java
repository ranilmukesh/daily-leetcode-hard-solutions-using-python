class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        long totalSkill = 0;
        int[] count = new int[1001]; // Count array for skills (1 <= skill[i] <= 1000)
        
        // Count occurrences of each skill and calculate total skill
        for (int s : skill) {
            count[s]++;
            totalSkill += s;
        }
        
        // Check if it's possible to divide players equally
        if (totalSkill % (n / 2) != 0) {
            return -1;
        }
        
        long targetSkill = totalSkill / (n / 2);
        long totalChemistry = 0;
        
        // Pair players and calculate chemistry
        for (int i = 1; i <= 1000; i++) {
            if (count[i] > 0) {
                int complement = (int) (targetSkill - i);
                if (complement < i || complement > 1000 || count[complement] == 0) {
                    return -1;
                }
                if (i == complement) {
                    if (count[i] % 2 != 0) {
                        return -1;
                    }
                    totalChemistry += (long) i * complement * (count[i] / 2);
                } else {
                    if (count[i] != count[complement]) {
                        return -1;
                    }
                    totalChemistry += (long) i * complement * count[i];
                }
                count[complement] = 0;
            }
        }
        
        return totalChemistry;
    }
}
