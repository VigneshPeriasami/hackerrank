#!/usr/bin/python
import re

class Read:
  
  def __init__(self):
    self.source_str = []
    self.source_index = {}
    self.patt_str = []
    self.pattern_index = {}
    self.no_segment = False

  def remove_special(self, x):
    pattern= re.compile("[^a-z|^A-Z]")
    wrd = pattern.sub('', x)
    self.source_str.append(wrd)
    self.add_index(wrd, len(self.source_str)-1)
    return wrd

  def add_index(self, wrd, position):
    if wrd.lower() not in self.source_index:
      index_arr = []
    else:
      index_arr = self.source_index[wrd.lower()]
    index_arr.append(position)
    self.source_index[wrd.lower()] = index_arr 

  def construct_position(self, wrd_i):
    pattern_str = raw_input().strip().lower()
    if pattern_str not in self.source_index:
      self.no_segment = True
      return False
    self.patt_str.append(pattern_str)
    for x in self.source_index[pattern_str]:
      self.pattern_index[x] = pattern_str
    return pattern_str

  def reload_pattern(self):
    return self.patt_str[:]

  def check_pattern(self):
    safe_copy = self.reload_pattern()
    keylist = self.pattern_index.keys()
    segment_pos = {}
    keylist.sort()
    w = 20**18
    result = []
    for k in keylist:
      segment_pos[self.pattern_index[k]] = k
      if all(safe in segment_pos for safe in safe_copy):
        values = [ x for i, x in segment_pos.iteritems() ]
        values.sort()
        if values[-1] - values[0] < w:
          w = values[-1] - values[0]
          result = values
    print ' '.join(self.source_str[result[0]:result[-1]+1])
      
if __name__ == "__main__":
  r = Read()
  a = map(r.remove_special, raw_input().strip().split(" "))
  no = int(raw_input())
  patt_str = map(r.construct_position, range(no))
  if r.no_segment:
    print "NO SUBSEGMENT FOUND"
  else:
    r.check_pattern()
