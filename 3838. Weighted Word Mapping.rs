impl Solution {
    pub fn map_word_weights(words: Vec<String>, weights: Vec<i32>) -> String {

        words.into_iter().map(|w| {
            let idx: i32 = w.bytes().map(|b| weights[(b - b'a') as usize]).sum();
            (b'z' - (idx % 26) as u8) as char
        }).collect()
        
    }
}
