impl Solution {
    pub fn max_ice_cream(costs: Vec<i32>, mut coins: i32) -> i32 {
        let mut count = vec![0;1_00_001];
        let mut max = 0;

        for cost in costs{
            count[cost as usize] +=1;
            if max < cost{
                max = cost;
            }
        }

        count.truncate(max as usize+1);

        let mut max = 0;
        let mut i = 0usize;

        while coins!=0 && coins >=i as i32 && i<count.len(){
            if count[i]!=0{
                let total_cost = (count[i] * i) as i32;

                if total_cost > coins{
                    max += coins / i as i32;
                    break;
                }

                coins -= total_cost;
                max += count[i] as i32;
            }

            i+=1;
        }

        max
    }
}
