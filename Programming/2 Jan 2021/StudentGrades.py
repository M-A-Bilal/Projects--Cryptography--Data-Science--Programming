#!/usr/bin/env python
# coding: utf-8

# In[62]:


import numpy as np
import matplotlib.pyplot as plt


def read_data(filename):
    i=0
    array =[]
    with open(filename) as textFile:
        lines = [line.split(',') for line in textFile]
        array.append(lines)
            #print(lines)
        #i=i+1
        
            
    return array


def calc_variance(data, col_name):
    for i in range(len(data[0][1])):
        if data[0][1][i] == col_name:
            index=i
    print(index)
    
    data1 = []
    i=2
    for i in range(len(data[0])-2):
        data1.append(float(data[0][i-100][index]))
        #print(float(data[0][i-100][index]))
        
    
    # Number of observations
    n = len(data1)
    # Mean of the data
    mean = sum(data1) / n
    # Square deviations
    deviations = [(x - mean) ** 2 for x in data1]
    # Variance
    variance = sum(deviations) / n
    return variance
    #return -1.0


def course_grade_average(data):
    array =[]
    for i in range(len(data[0])-2):
        mid = (float(data[0][i-100][0])*0.15 + float(data[0][i-100][2])*0.15 + float(data[0][i-100][4])*0.15)
        hw = (float(data[0][i-100][1])*0.05 + float(data[0][i-100][3])*0.05 + float(data[0][i-100][5])*0.05) 
        final = float(data[0][i-100][6]) * 0.30
        lab = float(data[0][i-100][0]) * 0.10
        #print(mid, hw, final, lab)
        array.append(mid+hw+final+lab)
                 
               
    return array


def plot_stats_and_fit(data, item):
    pass
    

def main():
    """
    The code given here is for you test your functions. You can modify
    it to perform more tests. When submitting, make sure the code you
    leave under main() does not cause a syntax error.
    """
    data = read_data("student_grades.txt")
    columns = data[0][1]
    
    #data = data[0][2:]
    
    print(columns)
    print(data)
    #print(len(columns))
    
    print(calc_variance(data, "hw2"))
    print(course_grade_average(data))
    #plot_stats_and_fit(data, 1)
    
    
    
################################################################ 
"""
DO NOT EDIT BELOW THIS LINE
"""
if __name__ == '__main__':
    main()


# In[ ]:




