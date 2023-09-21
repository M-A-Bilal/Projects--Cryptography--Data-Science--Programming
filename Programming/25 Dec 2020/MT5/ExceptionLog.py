
def divide_elementwise(a, b):
    """
    This version of divide_elementwise does not handle exceptions.
    You should write it in a way that handles different exceptions.
    """
    n = len(a)
	m = len(b)
    c = []
    for i in range(n):
        row_of_zeros = []
        for j in range(n):
            row_of_zeros.append(0.0)
        c.append(row_of_zeros)
    for i in range(n):
        for j in range(n):
            elt1 = float(a[i][j])
            elt2 = float(b[i][j])
            result = elt1 / elt2
            c[i][j] = result
    
    

def main():
    """
    The code in the main() function will not be graded. You can modify 
    it to run more tests. When submitting, make sure the code you leave 
    here does not cause syntax errors. 
    
    DO NOT HANDLE ANY EXCEPTIONS HERE! ALL EXCEPTION HANDLING MUST 
    BE IN THE divide_elementwise() FUNCTION.
    """
    
    # No errors
    a = [[str(4.2), str(5.3), str(6.1)], 
         [str(2.0), str(5.9), str(1.4)],
         [str(9.8), str(7.6), str(5.4)]]
    b = [[str(1.0), str(2.0), str(3.0)], 
         [str(7.3), str(4.2), str(1.4)],
         [str(9.8), str(7.6), str(5.4)]]
    divide_elementwise(a,b)
    
    # String to int conversion error
    a = [[str(4.2), str(5.3)], 
         [str(2.0), str(5.9)]]
    b = [[str(1.0), str(3.1)], 
         [str("somerandomtext"), str(4.2)]]
    divide_elementwise(a,b)
    
    # Division by zero
    a = [[str(4.2), str(5.3)], 
         [str(2.0), str(5.9)]]
    b = [[str(1.0), str(0.0)], 
         [str(7.3), str(4.2)]]
    divide_elementwise(a,b)
    
    # Different matrix size
    a = [[str(4.2), str(5.3), str(6.1)], 
         [str(2.0), str(5.9), str(1.4)],
         [str(9.8), str(7.6), str(5.4)]]
    b = [[str(1.0), str(2.0)], 
         [str(7.3), str(4.2)]] 
    divide_elementwise(a,b)
    
    
    
    
    
################################################################ 
"""
DO NOT EDIT BELOW THIS LINE
"""
if __name__ == '__main__':
    main()