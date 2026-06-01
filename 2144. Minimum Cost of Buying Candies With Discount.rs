impl Solution {
    pub fn minimum_cost(mut cost: Vec<i32>) -> i32 {
        let mut answer : i32 = 0;

        cost.sort();
        for i in 0..cost.len(){
            if i%3 == 2 {
                continue
            }
            answer += cost[cost.len()-i-1];
        }
        answer
    }
}
