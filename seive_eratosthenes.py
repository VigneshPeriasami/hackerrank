
def seive(n):
  t = [ x for x in range(n+1) if x > 1]
  for i in t:
    p = 2
    while i*p < n:
      if i*p in t:
        t.remove(i*p)
      p += 1
  return t

def recursive_relation(limit):
  a = {}
  for i in range(limit):
    if i < 4:
      a[i] = 1
    else:
      a[i] = a[i-1] + a[i-4]
  return a



if __name__ == "__main__":
  t = int(raw_input())
  n_i = recursive_relation(41)
  n = [ int(raw_input()) for x in range(t)]
  for i in n:
    print len(seive(n_i[i]))
