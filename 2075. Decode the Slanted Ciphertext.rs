impl Solution {
    pub fn decode_ciphertext(encoded_text: String, rows: i32) -> String {
        if rows == 1 || encoded_text.is_empty() {return encoded_text};
        let cols = encoded_text.len()/rows as usize;
        let mut m = vec![vec![' ';cols];rows as usize];
        let (mut row,mut col) = (0,0);
        for ch in encoded_text.chars() {
            if col > cols-1 { row += 1;col = 0;}
            m[row][col] = ch;
            col += 1;
        }
        let mut result = vec![];
        (row,col) = (0,0);
        let mut start_col = 0;
        loop {
            if row == 0 && col > cols-1 {
                break;
            }
            if row > rows as usize - 1 || col > cols-1 {
                row = 0;
                start_col += 1;
                col = start_col;
            }
            if row == 0 && col > cols-1 {
                break;
            }
            result.push(m[row][col].to_string());
            row += 1;
            col += 1;
        }        
        result.join("").trim_right().to_string()
    }
}
