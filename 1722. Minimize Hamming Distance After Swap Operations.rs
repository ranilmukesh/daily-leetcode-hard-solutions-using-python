impl Solution {
    pub fn minimum_hamming_distance(source: Vec<i32>, target: Vec<i32>, allowed_swaps: Vec<Vec<i32>>) -> i32 {
        fn find(groups: &mut Vec<usize>, item: usize) -> usize {
            if groups[item] != item {
                groups[item] = find(groups, groups[item])
            }
            groups[item]
        }

        fn union(groups: &mut Vec<usize>, item1: usize, item2: usize) {
            let group1 = find(groups, item1);
            let group2 = find(groups, item2);
            if group1 != group2 {
                groups[group1] = group2
            }
        }

        let mut groups = (0..source.len()).collect::<Vec<_>>();

        for swap in allowed_swaps {
            union(&mut groups, swap[0] as usize, swap[1] as usize);
        }

        let mut groups_source = vec![Vec::new(); source.len()];
        let mut groups_target = vec![Vec::new(); source.len()];

        for index in 0..groups.len() {
            let group = groups[index];
            let group = find(&mut groups, group);
            groups_source[group].push(source[index]);
            groups_target[group].push(target[index]);
        }

        let mut result = 0;

        for (group_source, group_target) in groups_source.into_iter().zip(groups_target) {
            let mut source_set = std::collections::HashMap::with_capacity(group_source.len());
            for number in group_source {
                *source_set.entry(number).or_insert(0) += 1;
            }
            for number in group_target {
                *source_set.entry(number).or_insert(0) -= 1;
            }
            result += source_set.values().fold(0, |acc, &c| acc + c.max(0));
        }

        result
    }
}
