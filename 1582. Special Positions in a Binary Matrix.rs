use std::collections::HashSet;

impl Solution {
    pub fn num_special(mat: Vec<Vec<i32>>) -> i32 {
        let mut rows:Vec<(usize,(usize,usize))> = vec![(0,(0,0));mat.len()];
        let mut cols:Vec<(usize,(usize,usize))> = vec![(0,(0,0));mat[0].len()];
        for row in 0..mat.len() {
            for col in 0..mat[row].len() {
                if mat[row][col] == 1 {
                    rows[row].0 += 1;
                    rows[row].1 = (row,col);
                    cols[col].0 += 1;
                    cols[col].1 = (row,col);
                }                
            }
        }
        let rows:HashSet<(usize,usize)> = HashSet::from_iter(rows.iter().filter(|row| row.0 == 1).map(|row| row.1));
        let cols:HashSet<(usize,usize)> = HashSet::from_iter(cols.iter().filter(|col| col.0 == 1).map(|col| col.1));
        let (first,second) = if rows.len() > cols.len() {(rows,cols)} else {(cols,rows)};
        let mut result = 0;
        for (row,col) in first {
            if second.contains(&(row,col)) { result += 1;}
        }
        result
    }
}
