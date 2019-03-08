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
    ListNode* reverseList(ListNode* head) {
        if(head == NULL || head->next == NULL) 
            return head;
        ListNode*temp = head->next;
        ListNode*pretemp = head;
        while(temp != NULL){
            pretemp->next = pretemp->next->next;
            ListNode* oldhead = head;
            head = temp;
            head->next = oldhead;
            temp = pretemp->next;
        }
        return head;
    }
};