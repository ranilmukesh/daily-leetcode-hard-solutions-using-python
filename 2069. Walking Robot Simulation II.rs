use std::collections::HashMap;

struct Robot {
    field: HashMap<i32,(i32,i32,String)>,
    pos: i32,
    dir: String,
    width: i32,
    height: i32,
    moved: bool     
}

impl Robot {

    fn new(width: i32, height: i32) -> Self {
        let (mut cur_pos,mut x,mut y,mut dir) = (0,0,0,"East");
        let mut field:HashMap<i32,(i32,i32,String)> = HashMap::from_iter(vec![(0,(0,0,"South".to_string()))]);
        while cur_pos < width*2+height*2-3 {            
            cur_pos += 1;
            if dir == "East" {
                if x == width-1 { dir = "North";} else {x += 1;}
            }
            if dir == "North" {
                if y == height-1 {dir = "West";} else {y += 1;}
            }
            if dir == "West" {
                if x == 0 {dir = "South"} else {x -= 1;}
            }
            if dir == "South" {
                if y == 0 {dir = "East";} else {y -= 1;}
            }
            field.insert(cur_pos,(x,y,dir.to_string()));
        }      
        Robot{pos:0,dir:"East".to_string(),field:field,width,height,moved:false}
    }
    
    fn step(&mut self, num: i32) {
        self.pos = (self.pos + num) % (self.width*2+self.height*2-4);
        self.moved = true;
    }
    
    fn get_pos(&self) -> Vec<i32> {
        vec![self.field[&self.pos].0,self.field[&self.pos].1]
    }
    
    fn get_dir(&self) -> String {
        if self.pos == 0 { return (if self.moved {"South"} else {"East"}).to_string()};
        self.field[&self.pos].2.clone()
    }
}
