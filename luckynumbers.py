#!/usr/bin/python

class Read:
  def __init__(self):
    self.big = -1

  def read_input(self, x):
    ab = map(int, raw_input().strip().split(" "))
    if ab[1] > self.big:
      self.big = ab[1]
    return ab

  def seive(self, n):
    t = { x:x for x in xrange(2, n) }
    keys = t.keys()
    for i in keys:
      p = 2
      while i*p < n+1:
        if i*p in t:
          del t[i*p]
        p += 1
    self.primes = t

  def sum_digits(self, n):
    sumd = 0
    while n:
      sumd += n % 10
      n /= 10
    return sumd

  def sum_square_digit(self, n):
    sum_squares = 0
    while n:
      sum_squares += (n % 10) ** 2
      n /= 10
    return sum_squares

  def is_lucky(self, x):
    sum_digi = self.sum_digits(x)
    sum_square = self.sum_square_digit(x)
    if sum_digi in self.primes and sum_square in self.primes:
      return True
    else:
      return False

if __name__ == '__main__':
  t = int(raw_input())
  r = Read()
  ab = map(r.read_input, range(t))
  r.seive(r.big)
  for x in ab:
    count = 0
    for i in range(x[0], x[1]):
      if r.is_lucky(i):
        count += 1
    print count
