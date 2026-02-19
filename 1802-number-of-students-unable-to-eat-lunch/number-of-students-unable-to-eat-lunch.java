class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int ans=0;
        int arr[] = new int[2];
        for(int i: students){
            arr[i]++;
        }
        for(int i:sandwiches){
            if(arr[i]<=0) break;
            else arr[i]--;
            ans++;
        }
        return students.length-ans;
    }
}