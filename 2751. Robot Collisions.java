class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> ans = new ArrayList<Integer>();
        Stack<Triplet> stack = new Stack<>();
        Triplet[] arr = new Triplet[positions.length];
        for(int i=0;i<positions.length;i++){
            arr[i]= new Triplet(positions[i],healths[i],directions.charAt(i),i);
        }
        Arrays.sort(arr,new Comparator<Triplet>(){
            public int compare(Triplet a , Triplet b){
                return a.position - b.position;
            }
        });
        for(int i =0;i<positions.length;i++){
            if(stack.isEmpty()){
                stack.add(arr[i]);
            }
            else{
                while(i<positions.length && (stack.peek().direction==arr[i].direction || (stack.peek().direction=='L' && arr[i].direction=='R') )){
                    stack.add(arr[i]);
                    i++;
                }
                if(i==positions.length)
                    break;
                boolean val = false;
                while(stack.size()>0 && stack.peek().direction=='R' && arr[i].direction=='L'){
                    Triplet x = stack.pop();
                    val = false;
                    if(x.health==arr[i].health){
                        healths[x.index]=0;
                        healths[arr[i].index]=0;
                        break;
                    }
                    else if(x.health>arr[i].health){
                        x.health--;
                        healths[x.index]--;
                        healths[arr[i].index]=0;
                        stack.add(x);
                        break;
                    }
                    else{
                        healths[arr[i].index]--;
                        healths[x.index]=0;
                        arr[i].health--;
                        val = true;
                        continue;
                    }
                }
                if(val){
                    stack.add(arr[i]);
                }
               
            }
        }
        for(int i =0;i<healths.length;i++){
            if(healths[i]!=0)
            ans.add(healths[i]);
        }
        return ans;

    }
}
class Triplet{
    int position;
    int health;
    char direction;
    int index;
    Triplet(int position, int health, char direction,int index){
        this.position = position;
        this.health=health;
        this.direction = direction;
        this.index=index;
    }
}
