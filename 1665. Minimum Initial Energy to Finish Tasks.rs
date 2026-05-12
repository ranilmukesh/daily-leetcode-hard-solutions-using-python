impl Solution {
    pub fn minimum_effort(mut tasks: Vec<Vec<i32>>) -> i32 {
        let mut answer : i32 = 0;
        let mut current_energy : i32 = 0;

        tasks.sort_by_key(|t| t[0] - t[1]);

        for task in tasks {
            if current_energy < task[1] {
                answer += task[1] - current_energy;
                current_energy = task[1];
            } 
            current_energy -= task[0];
        }

        return answer;
    }
}
