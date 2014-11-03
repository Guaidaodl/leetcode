#!/usr/bin/env python
#coding:utf8
# Definition for a  binary tree node
import collections
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.next = None
    def getVal(self):
        return self.val

class Solution:
    # @param root, a tree node
    # @return nothing
    def connect(self, root):
        queue = collections.deque()
        if root is not None:
            queue.append(root)

            firstNum = 1
            num = 1
            preNode = None
            while queue:
                curNode = queue.popleft()
                if num != firstNum :
                    preNode.next = curNode
                    preNode = curNode
                else:
                    firstNum = firstNum * 2
                    preNode = curNode;

                if curNode.left is not None:
                    queue.append(curNode.left)

                if curNode.right is not None:
                    queue.append(curNode.right)
                num++

def main():
    s = Solution()
    tree = TreeNode(1)
    tree.left = TreeNode(2)
    tree.right = TreeNode(3)
    s.connect(tree)


if __name__ == '__main__':
    main()