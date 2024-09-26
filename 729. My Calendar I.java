class MyCalendar {

    List<int[]> cal;
    public MyCalendar() {
        cal = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        if(cal.isEmpty()) {
            cal.add(new int[]{start,end});
            return true;
        }

        int ind = -1;
        int s = 0;
        int e = cal.size()-1;
        while(s<=e) {
            int mid = s+(e-s)/2;
            int[] midArr = cal.get(mid);
            if(midArr[1]<=start) {
                if(mid==cal.size()-1) {
                    cal.add(new int[]{start,end});
                    return true;
                } else if(cal.get(mid+1)[0]>=end) {
                    cal.add(mid+1, new int[]{start,end});
                    return true;
                } else {
                    s = mid+1;
                }
            } else if(midArr[0]>=end) {
                if(mid==0) {
                    cal.add(0, new int[]{start,end});
                    return true;
                } else if(cal.get(mid-1)[1]<=start) {
                    cal.add(mid, new int[]{start,end});
                    return true;
                } else {
                    e = mid-1;
                }
            } else 
            break;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
