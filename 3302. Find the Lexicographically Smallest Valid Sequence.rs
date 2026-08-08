impl Solution {
    pub fn valid_sequence(word1: String, word2: String) -> Vec<i32> {
        let mut last = vec![usize::MAX; word2.len()];
        let mut index2 = word2.len() - 1;

        for (index1, char1) in word1.bytes().enumerate().rev() {
            if char1 == word2.as_bytes()[index2] {
                last[index2] = index1;
                if index2 == 0 {
                    break;
                } else {
                    index2 -= 1;
                }
            }
        }

        let mut result = Vec::with_capacity(word2.len());
        let mut skipped = false;
        index2 = 0;
        for (index1, char1) in word1.bytes().enumerate() {
            let char2 = word2.as_bytes()[index2];
            if char1 == char2 || !skipped  && (index2 == word2.len() - 1 || index1 < last[index2 + 1] && last[index2 + 1] != usize::MAX) {
                skipped |= char1 != char2;
                result.push(index1 as i32);
                index2 += 1;
                if index2 == word2.len() {
                    break;
                }
            } 
        }

        if index2 < word2.len() {
            vec![]
        } else {
            result
        }
    }
}
