impl Solution {
    pub fn number_of_special_chars(word: String) -> i32 {
        let mut lowercase : i32 = 1 << 31;
        let mut uppercase : i32 = 1 << 31;

        for char in word.chars() {
            if char.is_uppercase() {
                uppercase |= 1 << (char as u32 - 'A' as u32) as i32;
            } else {
                lowercase |= 1 << (char as u32 - 'a' as u32) as i32;
            }
        }
        let answer = (uppercase & lowercase).count_ones() - 1;
        return answer as i32;
    }
}
