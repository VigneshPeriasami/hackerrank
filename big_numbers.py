#!/usr/bin/python

def seive(n):
  t = { str(x):0 for x in xrange(2, n+1) }
  keys = t.keys()
  for i in keys:
    i = int(i)
    p = 2
    while i*p < n+1:
      if str(i*p) in t:
        del t[str(i*p)]
      p += 1
  return t.keys()


if __name__ == "__main__":
  a = 10**18 + 10**18
  print seive(a)
