#!/usr/bin/env python
# encoding: utf-8

class Solution(object):
    def largestRectangleArea(self, height):
        height.append(0)
        size = len(height)
        no_decrease_stack = [0]
        max_size = height[0]

        i = 0
        while i < size:
            cur_num = height[i]
            if (not no_decrease_stack or
                    cur_num > height[no_decrease_stack[-1]]):
                no_decrease_stack.append(i)
                i += 1
            else:
                index = no_decrease_stack.pop()
                if no_decrease_stack:
                    width = i - no_decrease_stack[-1] - 1
                else:
                    width = i
                max_size = max(max_size, width * height[index])
        return max_size

