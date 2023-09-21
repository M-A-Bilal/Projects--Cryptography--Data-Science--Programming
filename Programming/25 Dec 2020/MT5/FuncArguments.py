
# You should change the header and body of func1 
# Implement header + body in 4 lines of code or shorter
def func1():
    pass


# You should change the header and body of func2
def func2():
    pass


# You should change the header and body of func3
def func3():
    pass    


def main():
    """
    The code given here is for you test your functions. You can modify
    it to perform more tests. When submitting, make sure the code you
    leave under main() does not cause a syntax error.
    """
    res1, res2 = func1(10,2,5)
    print(res1)
    print(res2)
    res3 = func1(7, 2, -1)
    print(res3)
    res = func2("John")
    print(res)
    res = func2("Joe", "Goodbye")
    print(res)
    res = func2("Alice", "How are you")
    print(res)
    lst = [0, 10, 20, 30, 40]
    th = 15
    res = func3(inp_list = lst, threshold = th)
    print(res)
    lst = [100, 0, 55, 70, 30]
    th = 60
    res = func3(threshold = th, inp_list = lst)
    print(res)
    
    
    
    
################################################################ 
"""
DO NOT EDIT BELOW THIS LINE
"""
if __name__ == '__main__':
    main()