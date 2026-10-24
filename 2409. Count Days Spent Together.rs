impl Solution {
    pub fn count_days_together(arrive_alice: String, leave_alice: String, arrive_bob: String, leave_bob: String) -> i32 {
        let aa = Date::parse(&arrive_alice);
        let la = Date::parse(&leave_alice);
        let ab = Date::parse(&arrive_bob);
        let lb = Date::parse(&leave_bob);
        let start = aa.numeric().max(ab.numeric());
        let end = la.numeric().min(lb.numeric());
        (end+1).checked_sub(start).unwrap_or(0) as i32
    }
}

struct Date {
    pub day: u32,
    pub month: u32,
}

impl Date {
    const TABLE: [u32; 13] = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    pub fn parse(date: &str) -> Date {
        let month = date[0..2].parse::<u32>().unwrap();
        let day = date[3..5].parse::<u32>().unwrap();

        Date { day, month }
    }

    fn numeric(&self) -> u32{
        self.day + self.offset()
    }
    
    fn offset(&self) -> u32 {
        (&Self::TABLE[1..(self.month as usize)]).iter().sum()
        
    }
}
