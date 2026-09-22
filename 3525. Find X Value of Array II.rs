#[derive(Copy, Clone, Default)]
pub struct Node {
	pub pref: [usize; 5],
	pub tot_prod: usize,
}

impl Node {
	pub fn new(val: usize, k: usize) -> Node {
		let mut pref: [usize; 5] = [0; 5];
		pref[val % k] += 1;
		Node {
			pref,
			tot_prod: val % k,
		}
	}

	pub fn merge(l: &Node, r: &Node, k: usize) -> Node {
		let mut pref: [usize; 5] = l.pref;
		for i in 0..k {
			pref[(l.tot_prod * i) % k] += r.pref[i];
		}
		let tot_prod = (l.tot_prod * r.tot_prod) % k;

		Node {pref, tot_prod}
	}
}

impl Solution {

	fn build_tree(l: usize, r: usize, seg_ind: usize, tree: &mut [Node], nums: &[i32], k: usize) {
		if l == r {
			tree[seg_ind] = Node::new(nums[l] as usize, k);
			return;
		}

		let (mid, seg_l, seg_r) = ((l + r) >> 1, seg_ind << 1, (seg_ind << 1) | 1);

		Self::build_tree(l, mid, seg_l, tree, nums, k);
		Self::build_tree(mid + 1, r, seg_r, tree, nums, k);

		tree[seg_ind] = Node::merge(&tree[seg_l], &tree[seg_r], k);
	}

	fn update_tree(l: usize, r: usize, seg_ind: usize, target: usize, value: usize, tree: &mut [Node], k: usize) {
		if l == r {
			tree[seg_ind] = Node::new(value, k);
			return;
		}
		let (mid, seg_l, seg_r) = ((l + r) >> 1, seg_ind << 1, (seg_ind << 1) | 1);
		if target <= mid {
			Self::update_tree(l, mid, seg_l, target, value, tree, k);
		} else {
			Self::update_tree(mid + 1, r, seg_r, target, value, tree, k);
		}
		tree[seg_ind] = Node::merge(&tree[seg_l], &tree[seg_r], k);
	}

	fn get_res(ls: usize, rs: usize, lt: usize, rt: usize, seg_ind: usize, tree: &[Node], k: usize) -> Node {
		if ls == lt && rs == rt {
			return tree[seg_ind];
		}

		let (mid, seg_l, seg_r) = ((ls + rs) >> 1, seg_ind << 1, (seg_ind << 1) | 1);

		if rt <= mid {
			Self::get_res(ls, mid, lt, rt, seg_l, tree, k)
		} else if lt > mid {
			Self::get_res(mid + 1, rs, lt, rt, seg_r, tree, k)
		} else {
			let l_res = Self::get_res(ls, mid, lt, mid, seg_l, tree, k);
			let r_res = Self::get_res(mid + 1, rs, mid + 1, rt, seg_r, tree, k);
			Node::merge(&l_res, &r_res, k)
		}

	}

    pub fn result_array(nums: Vec<i32>, k: i32, queries: Vec<Vec<i32>>) -> Vec<i32> {
        let mut ans: Vec<i32> = vec!();

		let n = nums.len();
		let seg_n = 2 << (32 - (n as i32 - 1).leading_zeros());
		let mut tree: Vec<Node> = vec!(Node::default(); seg_n as usize);

		Self::build_tree(0, n - 1, 1, &mut tree, &nums, k as usize);

		for elem in queries {
			let (ind, value, st, x) = (elem[0] as usize, elem[1] as usize, elem[2] as usize, elem[3] as usize);
			Self::update_tree(0, n - 1, 1, ind, value, &mut tree, k as usize);
			let result = Self::get_res(0, n - 1, st, n - 1, 1, &tree, k as usize);
			ans.push(result.pref[x] as i32);
		}

		ans
    }
}
