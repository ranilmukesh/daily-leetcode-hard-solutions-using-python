impl Solution {
    pub fn max_number_of_balloons(text: String) -> i32 {
        text.as_bytes()
            .into_iter()
            .fold([0; 5], |mut acc, &c| {
                match c {
                    b'b' => acc[0] += 2,
                    b'a' => acc[1] += 2,
                    b'l' => acc[2] += 1,
                    b'o' => acc[3] += 1,
                    b'n' => acc[4] += 2,
                    _ => {},
                }
                acc
            })
            .iter()
            .min()
            .unwrap()
            / 2
    }
}
