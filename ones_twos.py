#!/usr/bin/python
import math

class OneTwo:

  def __init__(self, x):
    self.one = x[0]
    self.two = x[1]
    self.no_one = True if self.one == 0 else False

  def powers_two(self, n):
    n = math.floor(math.log(n)/math.log(2))
    n = int(n)
    if n <= self.two:
      return n
    else:
      return 0

  def end_point(self):
    s_one = self.one * 1
    m_two = 2**self.two
    m_two = 0 if m_two == 1 else m_two
    return s_one + m_two

  def two_multiply(self, n, available_two):
    two_multiply = int(n/2)
    if two_multiply <= available_two:
      return two_multiply
    else:
      return available_two

  def one_multiply(self, n):
    if n <= self.one:
      return n
    else:
      return self.one

  def start_point(self):
    if self.one > self.two*2:
      return self.one+1
    else:
      return self.two*2+1

  def result_jump(self):
    if self.no_one:
      return (self.two*2/2)
    elif self.one > self.two*2:
      return self.one
    else:
      return self.two*2

  def evaluation_result_count(self):
    end_point = self.end_point()
    result = 0
    start_point = 1
    result = self.result_jump()
    start_point = self.start_point()
    n = start_point
    while (n <= end_point):
      powers_two = self.powers_two(n)
      powers_two_result = 2**powers_two if powers_two != 0 else 0
      remaining = n - powers_two_result
      available_two = self.two - powers_two
      if remaining > 0:
        remaining -= 2*self.two_multiply(remaining, available_two)
        remaining -= self.one_multiply(remaining)
      
      if remaining == 0:
        result += 1
      n += 1
    return result

if __name__ == "__main__":
  t = int(raw_input())
  a_b = [[int(i) for i in raw_input().strip().split(' ')] for x in range(t)]
  for x in a_b:
    oneTwo = OneTwo(x)
    print oneTwo.evaluation_result_count()
