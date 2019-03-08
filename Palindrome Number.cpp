class Solution {
public:
    bool isPalindrome(int x) {
        int result = 0;
        int xx = x;
        if(x < 0){
            return false;
        }
        else{
            while(xx != 0){
                result = result*10 + xx%10;
                xx /= 10;
            }
            if(result == x){
                return true;
            }
            else
                return false;
        }
    }
};