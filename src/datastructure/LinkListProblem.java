package datastructure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import common.ListNode;
//import leetcode.editor.cn.*;

public class LinkListProblem {

    public static void main(String[] args) {
        // 输入：lists = [[1,4,5],[1,3,4],[2,6]]
        //输出：[1,1,2,3,4,4,5,6]
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));
        Solution solution = new Solution();
        ListNode[] input = new ListNode[]{list1, list2, list3};
        ListNode out = solution.mergeKLists(new ListNode[]{});
        while (out != null) {
            System.out.println(out.val);
            out = out.next;
        }
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((o1, o2) -> (o1.val - o2.val));
        queue.addAll(Arrays.asList(lists));
        ListNode result = new ListNode();
        ListNode currentNode = result;
        while (!queue.isEmpty()) {
            currentNode.next = queue.poll();
            if (currentNode.next.next != null) {
                queue.offer(currentNode.next.next);
            }
            currentNode = currentNode.next;
        }
        return result.next;
    }
}