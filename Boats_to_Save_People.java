// LeetCode:881. Boats to Save People 
// You are given an array people where people[i] is the weight of the ith person,
//  and an infinite number of boats where each boat can carry a maximum weight of limit. 
//  Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
// Return the minimum number of boats to carry every given person.

class Solution {
    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);
        int ans=0;
        int i=0;
        int j=people.length-1;
        while(i<=j){
            if(people[i]==limit){            
                i++;
            }
            else if(people[j]==limit){               
                j--;
            }
            else if(people[i]+people[j]>limit){
                j--;
            }
            else{
                i++;
                j--;
            }
             ans++;
        }
        return ans;
        
    }
}