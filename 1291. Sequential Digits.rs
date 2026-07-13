impl Solution {
    pub fn sequential_digits(low: i32, high: i32) -> Vec<i32> {
        let mut list = vec![];

        for i in 1..10{
            let mut j = i;
            loop{
                if j > high{ break; }
                if j >= low{ list.push(j); }
                if j % 10 == 9{ break; } 
                j = j * 10 + j % 10 + 1;
            }
        }
        list.sort();
        list
    }
}
