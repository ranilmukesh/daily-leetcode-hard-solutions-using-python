impl Solution {
    pub fn asteroids_destroyed(start_mass: i32, mut asteroids: Vec<i32>) -> bool {
        asteroids.sort_unstable();

        let mut current_planet_mass = start_mass as i64;

        for &asteroid_mass in &asteroids {
            let asteroid_mass = asteroid_mass as i64;
            let asteroid_is_destroyed = current_planet_mass >= asteroid_mass;

            if asteroid_is_destroyed {
                current_planet_mass += asteroid_mass;
            } else {
                return false;
            }
        }

        true
    }
}
