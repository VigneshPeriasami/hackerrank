
def seive(n):
  t = { x:x for x in range(n+1) if x > 1 }
  keys = t.keys()
  for i in keys:
    p = 2
    while i*p < n+1:
      if i*p in t:
        del t[i*p]
      p += 1
  return t.keys()

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
  n_i = recursive_relation(42)
  n = [ int(raw_input()) for x in range(t)]
  primes = seive(n_i[41])
  for i in n:
    m = n_i[i]
    count = 0
    for prime in primes:
      if prime > m:
        break
      else:
        count+=1
    print count
