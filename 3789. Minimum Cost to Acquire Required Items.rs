impl Solution {
    pub fn minimum_cost(
        cost1: i32,
        cost2: i32,
        cost_both: i32,
        need1: i32,
        need2: i32,
    ) -> i64 {
        if cost_both > cost1 + cost2 {
            return cost1 as i64 * need1 as i64
                + cost2 as i64 * need2 as i64;
        }

        let common = need1.min(need2);
        let mut res = cost_both.min(cost1 + cost2) as i64
            * common as i64;

        let remaining = (need1 - need2).abs();

        if need1 > need2 {
            res += cost_both.min(cost1) as i64
                * remaining as i64;
        } else if need2 > need1 {
            res += cost_both.min(cost2) as i64
                * remaining as i64;
        }

        res
    }
}
