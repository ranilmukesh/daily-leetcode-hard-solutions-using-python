impl Solution {
    pub fn max_number_of_families(n: i32, reserved_seats: Vec<Vec<i32>>) -> i32 {
        use std::collections::*;
        // hashu mapu muta madre
        let mut seats = HashMap::new();

        const PADDING: i32 = i32::MAX << 10;
        const FAM: i32 = (1 << 4) - 1;
        for s in reserved_seats {
            let row = s[0];
            let occupied = s[1];
            *seats.entry(row as usize - 1).or_insert(0) |= (PADDING) | (1 << (10 - occupied));
        }
        seats.iter_mut().for_each(|(_, v)| *v = PADDING | !*v);

        const FAM_RIGHT: i32 = PADDING | FAM << 1;
        const FAM_LEFT: i32 = PADDING | FAM << 5;
        const FAM_MID: i32 = PADDING | FAM << 3;
        const FAM_TWO: i32 = FAM_LEFT | FAM_RIGHT;

        let mut ans = 0;
        for s in seats.values() {
            if FAM_TWO & s == FAM_TWO {
                ans += 2;
            } else if (FAM_RIGHT & s == FAM_RIGHT)
                || (FAM_LEFT & s == FAM_LEFT)
                || (FAM_MID & s == FAM_MID)
            {
                ans += 1
            }
        }
        ans + (n - seats.len() as i32) * 2
    }
}
