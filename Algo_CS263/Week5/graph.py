import matplotlib.pyplot as plt
ele = ['2K','4K','6K','8K','10K']
y1 = [11.8,12.2,13.8,14.5,15.9]
y2 = [4.1,2.6,2.8,3.2,3.8]
y3 = [1193.6, 1220.3,1975.6,2732.3, 3000]
plt.plot(ele,y1,label="Insertion")
plt.plot(ele,y2,label="Deletion")
plt.plot(ele,y3,label="Heap Sort")
plt.xlabel('Number of Elements')
plt.ylabel('Time Taken')
plt.title('Time Analysis')
plt.legend()
plt.show()

# import matplotlib.pyplot as plt
# ele = ['2K','4K','6K','8K','10K']
# y1 = [0.4, 0.8, 1.0, 1.6,2.0]
# y2 = [1.4, 1.7, 1.8, 1.9,2.1]
# y3 = [1086.5, 1235.9, 2587.9, 2934.2, 3243.5]
# plt.plot(ele,y1,label="Insertion")
# plt.plot(ele,y2,label="Deletion")
# plt.plot(ele,y3,label="Heap Sort")
# plt.xlabel('Number of Elements')
# plt.ylabel('Time Taken')
# plt.title('Time Analysis')
# plt.legend()
# plt.show()

# import matplotlib.pyplot as plt
# ele = ['2K','4K','6K','8K','10K']
# y1 = [1.2, 1.9, 2.3, 2.9, 3.3]
# y2 = [1.1, 1.5, 1.7, 1.9, 2.4]
# y3 = [1201.9, 1397.0, 3034.6, 3144.8, 3221.2]
# plt.plot(ele,y1,label="Insertion")
# plt.plot(ele,y2,label="Deletion")
# plt.plot(ele,y3,label="Heap Sort")
# plt.xlabel('Number of Elements')
# plt.ylabel('Time Taken')
# plt.title('Time Analysis')
# plt.legend()
# plt.show()