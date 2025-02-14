class ProductOfNumbers {
    ArrayList<Integer> al;
    int lastZero = -1; 

    public ProductOfNumbers() {
        al = new ArrayList<>();
    }
    
    public void add(int num) {
        if(num == 0){
            lastZero = al.size();
            al.add(1);
            return;
        }
        
        if(lastZero == al.size() - 1)
            al.add(num);
        else
            al.add(al.get(al.size() - 1)*num);
    }
    
    public int getProduct(int k) {
        if((lastZero!=-1 && lastZero >= al.size()- k))
            return 0;
        

        if(k == al.size()) return al.get(al.size() - 1);
        
        return al.get(al.size()-1)/al.get(al.size() - k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */