
"""
Inputs:
  datetime
Outputs:
  ticker_ and bar_ data

There are several major errors in this code that should be fixed immediately. I'm fairly certain this won't even compile.
"""



__author__ = 'byron'

import datetime

class TickerData():
    def __init__(self, ticker, time_frame, exchange):
        self.ticker = ticker
        self.time_frame = time_frame
        self.exchange = exchange
        self.candlesticks = []
        self.file_contents = self.get_ticker_data()


    def get_ticker_data(self):
        __folder = '/home/byron/Stock-Data/{0}'.format(self.exchange)
        __file_name = '{0}/{1}-{2}.data'.format(__folder, self.ticker, self.time_frame)

        with open(__file_name, mode='r') as data_file:
            for line in data_file:
                # print(line)
                self.candlesticks.append(BarData(line.split(','))) #is this block
            # b = BarData(line.split(','))                         #supposed be
            #     						   #commented out?
            # BarData(line.split(',')).print_bar_data()            #
            return data_file.read()

	 #1 FILE NEVER CLOSED

class BarData():
    def __init__(self, ohlc):
        self.bar_datetime = ohlc[0]
        self.open = ohlc[1]
        self.high = ohlc[2]
        self.low = ohlc[3]
        self.close = ohlc[4]
        self.volume = ohlc[5]
        self.candlestick = [self.bar_datetime, self.open, self.high, self.low, self.close, self.volume]

    def print_bar_data(self):
        print('Time: {0} | Open: {1} | High: {2} | Low: {3} | Close: {4} | Volume: {5}'.format(
            self.bar_datetime, self.open, self.close, self.high, self.low, self.close, self.volume)) #1 self.close is referenced twice, should only be once. It also will break the format.

    def __iter__(self):
        return iter(self.candlestick)
