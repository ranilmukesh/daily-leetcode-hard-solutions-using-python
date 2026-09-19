impl Solution {
    pub fn check_overlap(
        radius: i32,
        x_center: i32,
        y_center: i32,
        x1: i32,
        y1: i32,
        x2: i32,
        y2: i32,
    ) -> bool {
        match (
            x1 <= x_center && x_center <= x2,
            y1 <= y_center && y_center <= y2,
        ) {
            // if both x-axis and y-axis of the middle of the circle go through the square,
            // then middle of the circle is trivially contained inside the square.
            (true, true) => return true, // 1.
            (true, false) => return (y1 - y_center).abs().min((y2 - y_center).abs()) <= radius, // 2.
            (false, true) => return (x1 - x_center).abs().min((x2 - x_center).abs()) <= radius, // 3.
            // If neither axis of the middle of the circle goes through the square,
            // one of the corners is closest, and we need to calculate distance.
            (false, false) => (),
        }

        let (x_distance, y_distance) = ( // 4.
            (x1 - x_center).abs().min((x2 - x_center).abs()),
            (y1 - y_center).abs().min((y2 - y_center).abs()),
        );
        if x_distance >= radius || y_distance >= radius { // 5.
            return false;
        }
        // a^2 + b^2 = c^2
        // However, we don't have to do sqrt(a^2 + b^2),
        // we can just calculate radius^2 and compare.
        x_distance * x_distance + y_distance * y_distance <= radius * radius // 6.
    }
}
