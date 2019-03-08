class Solution {
public:
   int cal(int n){
            int ret = 0;
            while(n){
                ret += pow(n%10,2);
                n /= 10;
            }
            return ret;
        }
    bool isHappy(int n) {
        int slow,fast;
        slow = fast = n;
        do{
            slow = cal(slow);
            fast = cal(cal(fast));
        }while(slow != fast);
        if(slow == 1)   return true;
            else    return false;
    }
};