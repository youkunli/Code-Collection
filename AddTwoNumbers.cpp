/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* result;
        if(l1 == NULL)
            return l2;
        else if(l2 == NULL)
            return l1;
        else{
            
            ListNode* p = l1;
            ListNode* q = l2;
            ListNode* now = result;
            
            
            int sum,digit,carry = 0;
            
            sum = p->val + q->val + carry;
            digit = sum%10;
            carry = sum/10;
            result = new ListNode(digit);
            now = result;
            p = p->next;
            q = q->next;
            if(p == NULL && q != NULL){
                ListNode* newp = new ListNode(0);
                p = newp;
                }
            else if(p != NULL && q == NULL){
                ListNode* newq = new ListNode(0);
                q = newq;
                }
            
            while(p != NULL && q != NULL){
                sum = p->val + q->val + carry;
                digit = sum%10;
                carry = sum/10;
                ListNode* newnode = new ListNode(digit);
                now->next = newnode;
                now = newnode;
                p = p->next;
                q = q->next;
                if(p == NULL && q == NULL)
                    break;
                else if(p == NULL && q != NULL){
                    ListNode* newp = new ListNode(0);
                    p = newp;
                }
                else if(p != NULL && q == NULL){
                    ListNode* newq = new ListNode(0);
                    q = newq;
                }
            }
            if(carry == 1){
                ListNode* newnode = new ListNode(1);
                now->next = newnode;
            }
            return result;
        }
        
        
    }
};