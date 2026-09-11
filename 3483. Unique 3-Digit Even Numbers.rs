impl Solution {
    pub fn total_numbers(digits: Vec<i32>) -> i32 {
        let mut set = [false; 999];

        for i in 0..digits.len(){
            for j in i+1..digits.len(){
                for k in j+1..digits.len(){
                    let mut combinations = [
                        (i, j, k),
                        (i, k, j),
                        (j, i, k),
                        (k, i, j),
                        (j, k, i),
                        (k, j, i)
                    ];

                    for (first, second, third) in combinations{
                        if digits[first]!=0 && digits[third]&1 == 0{
                            set[
                                ((digits[first] * 100) + (digits[second] * 10) + digits[third]) as usize
                            ] = true;
                        }
                    }
                }
            }
        }

        set
            .into_iter()
            .filter(|&present| present)
            .count() as i32
    }
}
