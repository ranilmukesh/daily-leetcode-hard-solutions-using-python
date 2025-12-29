class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String,Set<String>> map = new HashMap<>();
        for(String a : allowed){
            String key = a.substring(0,2);
            if(!map.containsKey(key)) map.put(key, new HashSet<>());
            map.get(key).add(a.substring(2,3));
        }
        List<Set<String>> row = new ArrayList<>();
        for(int i=0;i<bottom.length()-1;i++){
            String curr = bottom.substring(i,i+2);
            if(!map.containsKey(curr)) return false;
            row.add(map.get(curr));
        }
        while(row.size()>1){
            List<Set<String>> nextRow = new ArrayList<>();
            Set<String> prev = new HashSet<>();
            for(int i=0;i<row.size()-1;i++){
                Set<String> currItem = new HashSet<>();
                Set<String> first = new HashSet<>();
                if(i==0){
                    first = row.get(i);
                }else{
                    first = new HashSet<>(prev);
                }
                for(String one : first){
                    prev = new HashSet<>();
                    for(String two : row.get(i+1)){
                        String nxt = one+two;
                        if(map.containsKey(nxt)){
                            prev.add(two);
                            currItem.addAll(map.get(nxt));
                        }
                    }
                }
                if(currItem.size()==0) return false;
                nextRow.add(currItem);
            }
            row = nextRow;
        }
        return row.size()>0;
    }
}
