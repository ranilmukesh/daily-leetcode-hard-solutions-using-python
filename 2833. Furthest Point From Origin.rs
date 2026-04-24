impl Solution {
    pub fn furthest_distance_from_origin(moves: String) -> i32 {
        let mut temp = 0;
        let mut result: i32 = 0;
        for i in moves.chars(){
            if i == 'L'{
                result -=1;
            } else if i == 'R'{
                result += 1;
            } else{
                temp += 1
            }
        }
        (result + temp).abs().max((result - temp).abs())
    }
}
