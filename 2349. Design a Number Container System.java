class NumberContainers {
    Map<Integer,Integer> map;
    Map<Integer, PriorityQueue<Integer>> res;
    public NumberContainers() {
        map = new HashMap<>();
        res = new HashMap<>();
    }
    
    public void change(int index, int number) {
        
        if(map.containsKey(index)){
            int val = map.get(index);
            if(val == number) return;
            res.get(val).remove(index);
        }

        res.computeIfAbsent(number,k->new PriorityQueue<>()).offer(index);
        map.put(index,number);
    }
    
    public int find(int number) {
        PriorityQueue<Integer> q = res.getOrDefault(number,new PriorityQueue<>());
        return q.isEmpty()?-1:q.peek();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
