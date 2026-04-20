impl Solution {
    pub fn max_distance(colors: Vec<i32>) -> i32 {
        let mut seen = [0; 101];
        let mut max_diff = 0;

        for i in 0..colors.len(){
            if seen[colors[i] as usize]!= 0 {
                continue
            }
            seen[colors[i] as usize]+=1;
            for j in i+1..colors.len(){
                if colors[j]!= colors[i]{
                    if j - i > max_diff {
                        max_diff = j-i;
                    }
                }
            }
        }     

        return max_diff as i32;
    }
}
