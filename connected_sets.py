#!/usr/bin/python    

class ConnectedSets:

  def __init__(self):
    self.k_arr_index = []

  def read_elements(self, k, m, n):
    k = int(k)
    if(k == 1):
      self.k_arr_index.append((m, n))
    return k

  def read_row(self, t_i):
    m = [self.read_elements(x, t_i, i) 
         for i, x in enumerate(raw_input().strip().split(' ')) ] 
    return m

  def get_neighbors(self, m, n):
    [m_plus, m_minus, n_plus, n_minus] = [m+1, m-1, n+1, n-1]
    neighbors = [(m_minus, n_minus), (m_minus, n), (m_minus, n_plus),
                 (m, n_minus), (m, n_plus),
                 (m_plus, n_minus), (m_plus, n), (m_plus, n_plus)]
    return neighbors

  def check_available_neighbors(self, cell, safe_copy, stack_neighbor):
    neighbors = [ x for x in self.get_neighbors(cell[0], cell[1])
                  if (x[0] >= 0 and x[1] >= 0) ]
    for n in neighbors:
      neighbor = (n[0], n[1])
      if neighbor in safe_copy:
        safe_copy.remove(neighbor)
        stack_neighbor.add(neighbor)

  def process_connected_sets(self):
    safe_copy = set(self.k_arr_index)
    connected_count = 0
    while len(safe_copy) != 0:
      take = safe_copy.pop()
      stack_neighbor = set()

      self.check_available_neighbors(take, safe_copy, stack_neighbor)
      while(len(stack_neighbor) != 0):
        take = stack_neighbor.pop()
        self.check_available_neighbors(take, safe_copy, stack_neighbor)
      connected_count += 1
    return connected_count
      
if __name__ == "__main__":
  t = int(raw_input())
  connectedSets = []
  for i in range(t):
    n = int(raw_input())
    connectedSet = ConnectedSets()
    mat = map(connectedSet.read_row, range(n))
    # print connectedSets.process_connected_sets()
    connectedSets.append(connectedSet)
  for connectedSet in connectedSets:
    print connectedSet.process_connected_sets()


