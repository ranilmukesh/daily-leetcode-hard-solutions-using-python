impl Solution {
    pub fn max_walls(robots: Vec<i32>, distance: Vec<i32>, walls: Vec<i32>) -> i32 {
        #[derive(Debug, Clone, Copy, PartialEq, Eq, PartialOrd, Ord)]
        struct Robot {
            pos: i32,
            dist: i32,
        }

        impl Robot {
            #[inline]
            fn left_bound(self) -> i32 {
                self.pos - self.dist
            }

            #[inline]
            fn right_bound(self) -> i32 {
                self.pos + self.dist
            }
        }

        #[derive(Debug, Default, Clone, Copy)]
        struct MaxDestroyedWallsByDir {
            left_left: i32,
            left_right: i32,
            right_left: i32,
            right_right: i32,
        }

        impl MaxDestroyedWallsByDir {
            #[inline]
            fn max_element(self) -> i32 {
                self.left_left
                    .max(self.left_right)
                    .max(self.right_left)
                    .max(self.right_right)
            }

            #[inline]
            fn shift_state_before_next_robot(&mut self) {
                let best_left = self.left_left.max(self.right_left);
                let best_right = self.left_right.max(self.right_right);

                self.left_left = best_left;
                self.left_right = best_left;
                self.right_left = best_right;
                self.right_right = best_right;
            }

            #[inline]
            fn process_wall(&mut self, left_bot: Robot, right_bot: Robot, wall: i32) {
                self.left_left += (wall >= right_bot.left_bound()) as i32;
                self.left_right += (wall == right_bot.pos) as i32;
                self.right_left +=
                    (wall <= left_bot.right_bound() || wall >= right_bot.left_bound()) as i32;
                self.right_right += (wall <= left_bot.right_bound() || wall == right_bot.pos) as i32;
            }
        }

        let robots = {
            let mut robots = std::iter::once(Robot {
                pos: 0, // Left-most dummy robot
                dist: 0,
            })
            .chain(
                robots
                    .into_iter()
                    .zip(distance)
                    .map(|(pos, dist)| Robot { pos, dist }),
            )
            .chain(std::iter::once(Robot {
                pos: i32::MAX, // Right-most dummy robot
                dist: 0,
            }))
            .collect::<Vec<_>>();
            robots.sort_unstable();
            robots
        };

        let walls = {
            let mut walls = walls;
            walls.sort_unstable();
            walls
        };

        let mut max_destroyed_walls_by_dir = MaxDestroyedWallsByDir::default();

        let mut windows = robots.windows(2);

        // Initial window creation.
        // Guaranteed to exist since we added dummy robots at both ends.
        let mut current_window = windows
            .next()
            .expect("robots array has at least 2 dummy elements");

        for wall in walls {
            // Moving the window.
            // The loop will always terminate before exhausting the iterator
            // because the right-most dummy robot is placed at `i32::MAX`.
            while current_window[1].pos < wall {
                current_window = windows
                    .next()
                    .expect("Right-most dummy robot at i32::MAX prevents iterator exhaustion");
                max_destroyed_walls_by_dir.shift_state_before_next_robot();
            }

            // Slice pattern matching
            // `windows(2)` guarantees that the yielded slice has a length of exactly 2.
            // We copy the values directly since `Robot` implements `Copy`.
            let &[left_bot, right_bot] = current_window else {
                unreachable!("windows(2) guarantees slice length of 2")
            };

            max_destroyed_walls_by_dir.process_wall(left_bot, right_bot, wall);
        }

        max_destroyed_walls_by_dir.max_element()
    }
}
