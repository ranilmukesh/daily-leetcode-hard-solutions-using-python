// For each node, store a bitvector "path" where `path[i]` is set to 1
// iff there is a path to the node whose xor is `i`. To calculate the
// mask array for a node, first we OR the paths of the left and top cell.
// Then, if bit 0 of the node is set, we swap each pair of bits;
// if bit 1 is set, we swap each group of 2 bits; if bit 2 is set,
// we swap each group of 4 bits, etc.

#[derive(Clone)]
struct BitVec([u64; 32]);

impl BitVec {
    const fn zero() -> BitVec {
        BitVec([0; 32])
    }

    const fn of_bit(bit: i32) -> BitVec {
        let bit = bit as usize;
        let mut res = [0; 32];
        res[bit >> 6] |= 1 << (bit & 0x3F);
        BitVec(res)
    }
}

impl Solution {
    pub fn min_cost(grid: Vec<Vec<i32>>) -> i32 {
        let n = grid[0].len();
        let mut paths = vec![const { BitVec::zero() }; n];
        let mut xor = grid[0][0];
        paths[0] = BitVec::of_bit(xor);
        for c in 1..n {
            xor ^= grid[0][c];
            paths[c] = BitVec::of_bit(xor);
        }
        xor = grid[0][0];
        for row in grid[1..].iter() {
            xor ^= row[0];
            paths[0] = BitVec::of_bit(xor);
            for c in 1..n {
                for i in 0..32 {
                    paths[c].0[i] |= paths[c-1].0[i];
                }
                let mut path = &mut paths[c];
                let rowc = row[c];
                if rowc & (1 << 0) != 0 {
                    for x in path.0.iter_mut() {
                        *x = ((*x & 0x5555555555555555) << 1) | ((*x & 0xAAAAAAAAAAAAAAAA) >> 1);
                    }
                }
                if rowc & (1 << 1) != 0 {
                    for x in path.0.iter_mut() {
                        *x = ((*x & 0x3333333333333333) << 2) | ((*x & 0xCCCCCCCCCCCCCCCC) >> 2);
                    }
                }
                if rowc & (1 << 2) != 0 {
                    for x in path.0.iter_mut() {
                        *x = ((*x & 0x0F0F0F0F0F0F0F0F) << 4) | ((*x & 0xF0F0F0F0F0F0F0F0) >> 4);
                    }
                }
                if rowc & (1 << 3) != 0 {
                    for x in path.0.iter_mut() {
                        *x = ((*x & 0x00FF00FF00FF00FF) << 8) | ((*x & 0xFF00FF00FF00FF00) >> 8);
                    }
                }
                if rowc & (1 << 4) != 0 {
                    for x in path.0.iter_mut() {
                        *x = ((*x & 0x0000FFFF0000FFFF) << 16) | ((*x & 0xFFFF0000FFFF0000) >> 16);
                    }
                }
                if rowc & (1 << 5) != 0 {
                    for x in path.0.iter_mut() {
                        *x = ((*x & 0x00000000FFFFFFFF) << 32) | ((*x & 0xFFFFFFFF00000000) >> 32);
                    }
                }
                for i in 6..10 {
                    if rowc & (1 << i) != 0 {
                        let mut res = [0; 32];
                        let group_size = 1 << (i - 6);
                        for j in 0..32 {
                            res[j] = path.0[j ^ group_size];
                        }
                        *path = BitVec(res);
                    }
                }
            }
        }
        
        for i in 0..32 {
            let v = paths[n-1].0[i];
            if v != 0 {
                return (i*64) as i32 + ((v & (!v).wrapping_add(1)).trailing_zeros() as i32);
            }
        }
        unreachable!()
    }
}
