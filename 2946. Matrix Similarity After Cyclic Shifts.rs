impl Solution {
    pub fn are_similar(mat: Vec<Vec<i32>>, k: i32) -> bool {
        let n=mat[0].len();
        let k=(k as usize)%n;
        mat.iter().enumerate().all(|(i,row)|{
            if i%2==0{
                row.iter().cycle().skip(k).take(n).eq(row.iter())
            }else{
                row.iter().cycle().skip(n-k).take(n).eq(row.iter())          
            }
        })
    }
}
