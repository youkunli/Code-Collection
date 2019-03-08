class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size()==0)  return 0;
        if(nums.size()==1)  return nums[0];
        if(nums.size()==2)  return max(nums[0],nums[1]);
        int twoDaysAgo = nums[0];
        int oneDayAgo = max(nums[0],nums[1]);
        int money = 0;
        for(int i=2;i<nums.size();i++){
            money = max(oneDayAgo,twoDaysAgo+nums[i]);
            twoDaysAgo = oneDayAgo;
            oneDayAgo = money;
        }
        return max(oneDayAgo,twoDaysAgo);
    }
};