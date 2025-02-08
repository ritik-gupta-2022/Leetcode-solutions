class NumberContainers {
    HashMap<Integer,Integer> map = new HashMap<>();
    HashMap<Integer,TreeSet<Integer>> idx = new HashMap<>();
    public NumberContainers() {
        
    }
    
    public void change(int index, int number) {
        int num = -1;
    
        if (map.containsKey(index)) {
            num = map.get(index);
        }

        map.put(index, number);

        if (!idx.containsKey(number)) {
            idx.put(number, new TreeSet<>());
        }
        
        TreeSet<Integer> set = idx.get(number);
        set.add(index);

        if (num != -1 && num != number) {
            TreeSet<Integer> oldSet = idx.get(num);
            oldSet.remove(index); 
            if (oldSet.isEmpty()) {
                idx.remove(num);
            } else {
                idx.put(num, oldSet); 
            }
        }
    }
    
    public int find(int number) {
        if(!idx.containsKey(number)) return -1;
        TreeSet<Integer> set = idx.get(number);
        if(set.size()==0) return -1;
        return set.first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */