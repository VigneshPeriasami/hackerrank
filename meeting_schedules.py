#!/usr/bin/python

class Meeting:

  def __init__(self):
    self.occupied = []

  def read_busy_schedules(self, t):
    [s_h, s_m, e_h, e_m] = map(int, raw_input().strip().split(" "))
    start = (s_h*60) + s_m
    if e_h > s_h or (e_h == s_h and e_m > s_m):
      end = ((e_h)*60) + e_m
    else:
      end = ((e_h or 24)*60) + e_m
    for x in range(start, end):
      self.occupied.append(x)

  def get_formatted_time(self, time):
    frmt = "%02d %02d" % (time/60, time%60)
    return frmt

  def print_freetime(self):
    start = -1
    min_count = 0
    for x in range(1441):
      if x not in self.occupied and start == -1:
        start = x
      elif x in self.occupied and min_count >= self.k:
        end = x
        print "{0} {1}".format(self.get_formatted_time(start),
                               self.get_formatted_time(end))
      if x in self.occupied:
        min_count = 0
        start = -1
      else:
        min_count += 1
    if min_count >= self.k and -1 < start < 1440:
      print "{0} {1}".format(self.get_formatted_time(start),
                             self.get_formatted_time(00))
      
if __name__ == "__main__":
  meet = Meeting()
  [t,meet.k] = map(int, raw_input().strip().split(" "))
  map(meet.read_busy_schedules, range(t))
  meet.print_freetime()
