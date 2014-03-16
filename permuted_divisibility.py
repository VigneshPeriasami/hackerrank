#!/usr/bin/python

def tables():
  tables = set()
  for x in range(13, 126):
    tables.add(x*8)
  return tables

class ExtNumber:

  def __init__(self, n):
    self.number = n
    self.number_frequency = { x:0 for x in range(0,10) }
    self.number_stack = set(map(self.read_int, str(n)))
  
  def read_int(self, n_i):
    n_i = int(n_i)
    self.number_frequency[n_i] += 1 
    return n_i
  
  def compare_two_digit(self, k):
    [o,t] = map(int, str(k))
    digi1 = o*10 + t
    digi2 = t*10 + o
    if (digi1 % 8 == 0 or digi2 % 8 == 0):
      return True
    else:
      return False

  def compare_with(self, k):

    if len(str(self.number)) == 1 and self.number % 8 == 0:
      return True
    elif len(str(self.number)) == 2:
      return self.compare_two_digit(self.number)

    stack_frequency = {}
    for d in str(k):
      d = int(d)
      if d in stack_frequency:
        stack_frequency[d] += 1
      else:
        stack_frequency[d] = 1
    if all(stack_frequency[key] <= self.number_frequency[key]
            for key in stack_frequency.keys()):
      return True
    else:
      return False
        
if __name__ == "__main__":
  t = int(raw_input())
  safe_stack =  tables()
  numbers = [ int(raw_input()) for i in range(t) ]
  for n in numbers:
    extNumber = ExtNumber(n)
    not_found = True
    for d in safe_stack:
      if extNumber.compare_with(d):
        print "YES"
        not_found = False
        break

    if not_found:
      print "NO"
