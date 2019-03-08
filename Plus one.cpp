class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int p = 0;
        int sum = 0;
        sum = digits[digits.size()-1]+1;
        digits[digits.size()-1] = sum%10;
        p = sum/10;
        for(int i=digits.size()-2;i>=0;i--){
            sum = digits[i]+p;
            digits[i] = sum%10;
            p = sum/10;
        }
        if(digits[0]==0){
            digits.insert(digits.begin(), 1);
        }
        return digits;
    }
};