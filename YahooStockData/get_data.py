"""
Inputs:
  urllib2
  YahooKeyStatistics
Outputs:
  A gui displaying data

This code grabs data from online and displays it to the user.
The object created in this code is a YahooKeyStatistics object from key_statistics.py
"""

import urllib2
# from Tkinter import *
from key_statistics import YahooKeyStatistics


ticker = "AAPL"
parser = YahooKeyStatistics()
yahoo = urllib2.urlopen('http://finance.yahoo.com/q/ks?s='+ticker+'+Key+Statistics')
data = parser.feed(yahoo.read().decode('utf-8'))
parser.print_key_size()
key_stats = parser.build_stat_data()

"""

no return statement, key_stats gets changed but isn't used or passed to anything,
other variables are changed but never touched afterwards 1


Is this block supposed to be commented out?  2
vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
"""

# if __name__ == '__main__':
#
#     # app = QApplication(sys.argv)
#     # ex = Example()
    # sys.exit(app.exec_())

# root = Tk()
# root.title("Stock Info")
# label = Label(root, text='Shares Short: ')
# label2 = Label(root, text=key_stats['Shares Short'])
# label.pack(side='left')
# label2.pack(side='right')
# print('*' + str(key_stats.keys()) + '*')
# counter_label(label)
# button = Button(root, text='Stop', width=25, command=root.destroy)
# button.pack()
#
# root.mainloop()
