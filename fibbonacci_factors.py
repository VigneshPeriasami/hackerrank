#!/usr/bin/python

class FibboFactor:

  def __init__(self):
    self.fibbo = [0, 1, 1]
    self.d = 0

  def fibbo_series(self, k):
    if(self.fibbo[-1] < k):
      f = self.fibbo[-2] + self.fibbo[-1]
      self.fibbo.append(f)
      for i in xrange(2, k+1):
        if(f%i == 0 and k%i == 0):
          self.d = i
          return
      self.fibbo_series(k)

  def go_beyond_k(self, k):
    f = self.fibbo[-2] + self.fibbo[-1]
    self.fibbo.append(f)
    while(f%k != 0):
      f = self.fibbo[-2] + self.fibbo[-1]
      self.fibbo.append(f)
    return f

  def common_fibbo_factor(self, k):
    self.d = 0
    self.fibbo = [0,1,1]
    self.fibbo_series(k)
    return self.d
        
if __name__ == "__main__":
  t = int(raw_input())
  fibbo_factor = FibboFactor()
  t_k = [ int(raw_input()) for i in range(t) ]
  for k in t_k:
    d = fibbo_factor.common_fibbo_factor(k)
    if d != 0:
      print fibbo_factor.fibbo[-1], d
    else:
      fibbo_factor.go_beyond_k(k)
      print fibbo_factor.fibbo[-1], k
