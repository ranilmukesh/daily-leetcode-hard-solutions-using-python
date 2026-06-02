impl Solution {
    fn solve(start1: &Vec<i32>, duration1: &Vec<i32>, start2: &Vec<i32>, duration2: &Vec<i32>) -> i32 {
        let mut finish1 = i32::MAX;
        for i in 0..start1.len() {
            finish1 = finish1.min(start1[i] + duration1[i]);
        }
        let mut finish2 = i32::MAX;
        for i in 0..start2.len() {
            finish2 = finish2.min(start2[i].max(finish1) + duration2[i]);
        }
        finish2
    }

    pub fn earliest_finish_time(landStartTime: Vec<i32>, landDuration: Vec<i32>, waterStartTime: Vec<i32>, waterDuration: Vec<i32>) -> i32 {
        let land_water = Self::solve(&landStartTime, &landDuration, &waterStartTime, &waterDuration);
        let water_land = Self::solve(&waterStartTime, &waterDuration, &landStartTime, &landDuration);
        land_water.min(water_land)
    }
}
