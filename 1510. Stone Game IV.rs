impl Solution {
    pub fn winner_square_game(n: i32) -> bool {
        const MAX_N: usize = 100_000;
        #[allow(long_running_const_eval, reason = "it's okay")]
        const WIN_POSITIONS: [bool; MAX_N + 1] = {
            let mut win_positions = [false; MAX_N + 1];
            let mut n = 1;
            while n <= MAX_N {
                let mut d = n.isqrt();
                while d > 0 {
                    if !win_positions[n - d * d] {
                        win_positions[n] = true;
                        break
                    }
                    d -= 1;
                }
                n += 1;
            }
            win_positions
        };
        let Some(n @ (0..=MAX_N)) = usize::try_from(n).ok()
            else { panic!("invalid input") };
        WIN_POSITIONS[n]
    }
}
