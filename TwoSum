class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int i,j,ii,jj;
        vector<int> res;
        vector<int> sorted = nums;
        sort(sorted.begin(),sorted.end());
        for(i = 0,j = sorted.size()-1;i < j;){
            if(target == sorted[i] + sorted[j]){
                
                for(ii = 0;ii < sorted.size()-1;ii++){
                    if(nums[ii] == sorted[i])
                        break;
                }
                if(sorted[i] == sorted[j])
                    jj = ii+1;
                else
                    jj = 0;
                for(;jj < sorted.size()-1;jj++){
                    if(nums[jj] == sorted[j])
                        break;
                }
                if(ii<jj){
                    res.push_back(ii);
                    res.push_back(jj);
                }
                else{
                    res.push_back(jj);
                    res.push_back(ii);
                }
                break;
            }
            else if(target < (sorted[i] + sorted[j]))
                j--;
            else
                i++;
        }
        return res;
    }
};