const MOD: i32 = 1_000_000_007;
impl Solution {
    pub fn paths_with_max_score(board: Vec<String>) -> Vec<i32> {
        let m = board.len();
        let n = board[0].len();
        let mut g = vec![vec![(0,1);n];m];
        for (i,s) in board.into_iter().enumerate().rev(){
            let bytes = s.into_bytes();
            for (j,b) in bytes.into_iter().enumerate().rev(){
                // println!("{}",b as char);
                if i == m-1 && j == n-1 {continue}
                let (mut mot, mut hai, mut ba) = (true,true,true);
                let mut dau = 0;
                let mut duoi = 0;
                if b == b'X'{
                    // g[i][j] = (-1,-1);
                }else if b== b'E' || b == b'S'{
                    
                    if i + 1 < m && g[i+1][j] != (-1,-1){
                        mot = false;
                        dau =  g[i+1][j].0;
                        duoi = g[i+1][j].1;

                    }
                    if j + 1 < n && g[i][j+1] != (-1,-1){
                        hai = false;
                        if dau == g[i][j+1].0{
                            duoi = (duoi+ g[i][j+1].1)%MOD;
                        }else if dau <  g[i][j+1].0{
                            duoi = g[i][j+1].1;
                            dau  =  g[i][j+1].0;
                        }
                        
                    }
                    if i + 1 < n && j + 1 < n && g[i+1][j+1] != (-1,-1){
                        ba = false;
                        if dau == g[i+1][j+1].0{
                            duoi = (duoi+ g[i+1][j+1].1)%MOD;
                        }else if dau <  g[i+1][j+1].0{
                            duoi = g[i+1][j+1].1;
                            dau =  g[i+1][j+1].0;
                        }
                    }
                }else{
                    let crr =  (b - b'0') as i32;
                    dau = 0;
                    duoi = 0;
                    if i + 1 < m && g[i+1][j] !=(-1,-1){
                        mot = false;
                        // dau = crr + g[i+1][j].0;
                        // duoi = g[i+1][j].1;
                        if dau == crr + g[i+1][j].0{
                            duoi = (duoi+ g[i+1][j].1)%MOD;
                        }else if dau < crr + g[i+1][j].0{
                            dau  =  crr + g[i+1][j].0;
                            duoi = g[i+1][j].1;
                        }
                    }
                    if j + 1 < n && g[i][j+1] != (-1,-1){
                        hai = false;
                       // println!(" {}   {} ",g[i][j+1].0 + crr, dau);
                        if dau == crr + g[i][j+1].0{
                            duoi = (duoi+ g[i][j+1].1)%MOD;
                        }else if dau <  crr + g[i][j+1].0{
                            dau  =  crr + g[i][j+1].0;
                            duoi = g[i][j+1].1;
                        }
                    }
                    if i + 1 < n && j + 1 < n && g[i+1][j+1] != (-1,-1){
                        ba = false;
                        if dau == crr + g[i+1][j+1].0{
                            duoi = (duoi+ g[i+1][j+1].1)%MOD;
                        }else if dau < crr + g[i][j+1].0{
                            dau  =  crr + g[i+1][j+1].0;
                            duoi = g[i+1][j+1].1;
                        }
                    }
                }
                //println!("{} {} {}",dau,duoi,b as char);
                if mot && hai && ba{
                    g[i][j] = (-1,-1);
                }else{
                    g[i][j] = (dau,duoi);
                }

            }
        }
        // for i in 0..m{
        //     println!("{:?}",g[i]);
        // }
        if g[0][0].1 == -1{
            return vec![0,0]
        }
        vec![g[0][0].0,g[0][0].1]
    }
}
