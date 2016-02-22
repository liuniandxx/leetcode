#!/usr/bin/env python
# encoding: utf-8

import math

class PowerOfThree(object):
    def isPowerOfThree(self, n):
        if n <= 0:
            return False

        return False if n <= 0 else n == round(3 ** round(math.log(n, 3)))

