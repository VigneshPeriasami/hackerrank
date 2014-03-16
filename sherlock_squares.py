#!/usr/bin/python
import math

def read_input(i):
  a_b = map(int, raw_input().strip().split(' '))
  return a_b

def find_end_points(x):
  start = 0
  for i in xrange(x[0], x[1]+1):
    if math.sqrt(i)%1 == 0:
      start = int(math.sqrt(i))
      break
  return start

def calculate_squares(x):
  squares_count = 0
  start = find_end_points(x)
  if start == 0:
    print start
    return start
  for i in xrange(start, x[1]+1):
    if i**2 <= x[1]:
      squares_count += 1
    else:
      break
  print squares_count
  return squares_count

if __name__ == "__main__":
  t = int(raw_input())
  ranges = map(read_input, range(t))  
  results = map(calculate_squares, ranges)
