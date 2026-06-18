impl Solution {
    pub fn angle_clock(hour: i32, minutes: i32) -> f64 {
        let mut diff: f64 = (((hour % 12) * 30) as f64 - minutes as f64 * 5.5).abs();
        if diff > 180.0 {
            diff = 360.0 - diff;
        }
        diff
    }
}
