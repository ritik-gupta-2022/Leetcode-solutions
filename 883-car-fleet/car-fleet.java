
// class Solution {

//     public int carFleet(int target, int[] position, int[] speed) {

//         Map<Integer,Integer> map = new HashMap<>();

//         for(int i=0;i<position.length;i++){
//             map.put(position[i], speed[i]);
//         }

//         int fleets = 0;

//         while(!map.isEmpty()){

//             Map<Integer,Integer> next = new HashMap<>();
//             boolean reachedTarget = false;

//             for(int pos : map.keySet()){

//                 int sp = map.get(pos);
//                 int newPos = pos + sp;

//                 if(newPos >= target){
//                     reachedTarget = true;   // at least one fleet reaches target
//                     continue;
//                 }

//                 if(next.containsKey(newPos)){
//                     int prevSpeed = next.get(newPos);
//                     next.put(newPos, Math.min(prevSpeed, sp));
//                 }
//                 else{
//                     next.put(newPos, sp);
//                 }
//             }

//             if(reachedTarget) fleets++;

//             map = next;
//         }

//         return fleets;
//     }
// }

class Solution {
    public int carFleet(int target, int[] pos, int[] speed) {
        HashMap<Integer,Double> map = new HashMap<>();
        for(int i=0; i<pos.length; i++){
            map.put(pos[i],(target-pos[i])/(double)speed[i]);
        }
        Arrays.sort(pos);
        double arr[] = new double[pos.length];
        for(int i=0; i<pos.length; i++){
            int ele = pos[i];
            arr[i] = map.get(ele);
        }
        Stack<Double> st = new Stack<>();

        for(int i=pos.length-1; i>=0; i--){
            if(st.isEmpty() || st.peek()<arr[i]) st.push(arr[i]);
        }
        return st.size();

    }
}