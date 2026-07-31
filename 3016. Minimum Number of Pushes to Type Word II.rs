impl Solution {
    pub fn minimum_pushes(word: String) -> i32 {
    // Using an array of 255 elements instead of a HashMap.
    // This way, we avoid hashing and heap allocation.
    // This also allows better cache locality.
    let mut counts = [0; 255];

    // All characters are ASCII, thus size of one byte.
    for c in word.bytes() {
        counts[c as usize] += 1;
    }
    // Sorting the subarray instead of the whole.
    // This allows us to sort only 26 elements of it which the only one we care about.
    counts[(b'a' as usize)..=(b'z' as usize)].sort_by(|i1, i2| i1.cmp(i2).reverse());

    let mut cnt = 0;
    let mut res = 0;

    // Iterating through the subarray.
    for i in counts[(b'a' as usize)..=(b'z' as usize)].into_iter() {
	if *i == 0 {
            break;
        }

        let ii = cnt / 8 + 1;

        res += ii * i;
        cnt += 1;
    }

    res
}
}
