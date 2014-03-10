#!/usr/bin/python

def read(x):
  n = int(raw_input())
  p = map(int, raw_input().strip().split(" "))
  return p

def calculate_profit(x):
  m = x[-1]
  profit = 0
  for i in range(len(x)-2, -1, -1):
    if x[i] < m:
      profit += m - x[i]
    else:
      m = x[i]
  print profit
  return profit

if __name__ == "__main__":
  t = int(raw_input())
  s = map(read, range(t))
  profits = map(calculate_profit, s)
