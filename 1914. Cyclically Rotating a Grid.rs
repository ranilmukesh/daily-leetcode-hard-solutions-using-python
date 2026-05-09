impl Solution {
    pub fn rotate_grid(mut grid: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
        fn get_layer(num:usize,grid:&Vec<Vec<i32>>) -> Vec<i32> {
            let mut result = vec![];
            let (rows,cols) = (grid.len(),grid[0].len());
            println!("{}",num);
            for col in num..cols-num {
                result.push(grid[num][col]);
            }
            for row in num+1..rows-num {
                result.push(grid[row][cols-num-1]);
            }
            for col in (num..cols-num-1).rev() {
                result.push(grid[rows-num-1][col]);
            }
            for row in (num+1..rows-num-1).rev() {
                result.push(grid[row][num]);
            }
            result
        }
        fn rotate_layer(arr: &mut Vec<i32>,k: usize) {
            for _ in 0..(k % arr.len()) {
                let item = arr.remove(0);
                arr.push(item);
            }
        }
        fn set_layer(num:usize,layer:&Vec<i32>,grid:&mut Vec<Vec<i32>>) {
            let mut idx = 0;
            let (rows,cols) = (grid.len(),grid[0].len());
            for col in num..cols-num {
                grid[num][col] = layer[idx];idx+=1;
            }
            for row in num+1..rows-num {
                grid[row][cols-num-1] = layer[idx];idx+=1;
            }
            for col in (num..cols-num-1).rev() {
                grid[rows-num-1][col] = layer[idx];idx+=1;
            }
            for row in (num+1..rows-num-1).rev() {
                grid[row][num] = layer[idx];idx+=1;
            }
        }
        for num in 0..grid.len().min(grid[0].len())/2 {
            let mut layer = get_layer(num,&grid);
            rotate_layer(&mut layer, k as usize);
            set_layer(num,&mut layer,&mut grid);
        }       
        grid
    }
}
