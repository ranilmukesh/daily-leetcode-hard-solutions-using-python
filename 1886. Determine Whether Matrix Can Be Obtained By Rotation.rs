impl Solution {
    pub fn find_rotation(mat: Vec<Vec<i32>>, target: Vec<Vec<i32>>) -> bool {
        let n = mat.len();

        //Check if it is directly equal (0 degrees == 360 degrees) 
        mat
            .iter()
            .enumerate()
            .all(|(row_index, row)| {
                *row == target[row_index]
            })
        ||
        //Check if it is 180 degrees equal
        mat
            .iter()
            .enumerate()
            .all(|(row_index, row)| {
                row.iter().eq(target[n - 1 - row_index].iter().rev())
            })
        ||
        //Check if it is 90 degrees equal
        mat
            .iter()
            .enumerate()
            .all(|(row_index, row)| {
                (0..n)
                    .all(|index| {
                        target[n - 1 - index][row_index] == row[index]
                    })
            })
        ||
        //Check if it is 270 degrees equal
        mat
            .iter()
            .enumerate()
            .all(|(row_index, row)| {
                (0..n)
                    .all(|index| {
                        target[index][n - 1 - row_index] == row[index]
                    })
            })
    }
}
