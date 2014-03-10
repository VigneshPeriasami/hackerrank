#!/usr/bin/python

if __name__ == "__main__":
  s = int(raw_input())
  x = map(int, raw_input().strip().split(" "))
  v = x[-1]
  if v < x[-2]:
    x[-1] = x[-2]
    for i in range(s-2, -1, -1):
      if v < x[i]:
        x[i+1] = x[i]
      print " ".join(map(str, x))
      x[i] = v
      if i == 0 or x[i] >= x[i-1]:
        print " ".join(map(str, x))
        break
      
  else:
    print " ".join(map(str,x))
