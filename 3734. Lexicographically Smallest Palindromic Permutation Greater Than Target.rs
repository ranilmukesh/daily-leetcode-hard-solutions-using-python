impl Solution {
    pub fn lex_palindromic_permutation(original_s: String, original_target: String) -> String {
        if original_s.len() != original_target.len() {
            return String::new();
        }

        let s = original_s.as_bytes();
        let target = original_target.as_bytes();
        let mut s_map = [0; 26];
        let s_map_ref = &mut s_map;
        s.iter().for_each(|&c| s_map_ref[to_idx(c)] += 1);

        let mid = match can_be_palindrome(s_map_ref) {
            Err(()) => return String::new(),
            Ok(mid) => mid.map(from_idx),
        };
        s_map_ref.iter_mut().for_each(|count| *count /= 2);

        let left_target = &target[..target.len() / 2];
        let mid_idx = target.len() / 2;
        if map_equal_target(s_map_ref, left_target) {
            let form = match mid {
                m if m.is_none() || m == Some(target[mid_idx]) => {
                    left_target
                        .iter()
                        .rev()
                        .cmp(target[target.len() - target.len() / 2..].iter())
                        == std::cmp::Ordering::Greater
                }
                Some(m) => m > target[mid_idx],
                _ => false,
            };
            if form {
                let mut res = original_target;
                let r = unsafe { res.as_mut_vec() };
                let mut len_with_mid = mid_idx;
                if let Some(m) = mid {
                    r[mid_idx] = m;
                    len_with_mid += 1;
                }
                r.truncate(len_with_mid);
                r.extend_from_within(..mid_idx);
                r[len_with_mid..].reverse();

                return res;
            }
        }

        match find_pivot(
            &mut s_map_ref.clone(),
            left_target.iter().copied().enumerate(),
        ) {
            None => String::new(),
            Some((idx, replacement_char)) => {
                let mut result = original_s;
                let r = unsafe { result.as_mut_vec() };
                r.clear();
                let left = &target[..idx];
                r.extend(left);
                left.iter().for_each(|&c| s_map_ref[to_idx(c)] -= 1);
                r.push(replacement_char);
                s_map_ref[to_idx(replacement_char)] -= 1;
                s_map_ref.iter().enumerate().for_each(|(idx, &count)| {
                    for _ in 0..count {
                        r.push(from_idx(idx));
                    }
                });
                let len = r.len();
                if let Some(m) = mid {
                    r.push(m);
                }
                r.extend_from_within(..len);
                let right_side_start = r.len() - len;
                r[right_side_start..].reverse();

                result
            }
        }
    }
}

fn can_be_palindrome(map: &[u16; 26]) -> Result<Option<usize>, ()> {
    let mut odd_element = None;
    map.iter().enumerate().try_for_each(|(idx, &count)| {
        if count % 2 != 0 && odd_element.replace(idx).is_some() {
            return Err(());
        }
        Ok(())
    })?;

    Ok(odd_element)
}

fn map_equal_target(map: &[u16; 26], target: &[u8]) -> bool {
    let map = &mut map.clone();
    target.iter().all(|&c| {
        let m = &mut map[to_idx(c)];
        let b = *m > 0;
        *m = m.wrapping_sub(1);
        b
    })
}

fn find_pivot(
    s_map: &mut [u16; 26],
    mut target: impl Iterator<Item = (usize, u8)>,
) -> Option<(usize, u8)> {
    target.next().and_then(|(idx, c)| {
        let this_pivot = pivot_possible(s_map, c).map(|r| (idx, r));
        if s_map[to_idx(c)] > 0 {
            s_map[to_idx(c)] -= 1;
            find_pivot(s_map, target).or(this_pivot)
        } else {
            this_pivot
        }
    })
}

fn pivot_possible(s_map: &[u16; 26], c: u8) -> Option<u8> {
    s_map[to_idx(c) + 1..]
        .iter()
        .position(|&count| count > 0)
        .map(|pos| pos as u8 + 1 + c)
}

fn to_idx(c: u8) -> usize {
    (c - b'a') as usize
}

fn from_idx(idx: usize) -> u8 {
    idx as u8 + b'a'
}
