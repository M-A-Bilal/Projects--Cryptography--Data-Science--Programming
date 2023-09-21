
def read_temperatures(filename):
    """
    IMPLEMENT THIS FUNCTION.
    """
    return -1


def delete_year(data, year):
    """
    IMPLEMENT THIS FUNCTION.
    """
    return -1


def monthly_averages(data, year):
    """
    IMPLEMENT THIS FUNCTION.
    """
    return -1
    

def yearly_average(data):
    """
    IMPLEMENT THIS FUNCTION.
    """
    pass



def main():
    """
    The code given here is for you test your functions. You can modify
    it to perform more tests. When submitting, make sure the code you
    leave under main() does not cause a syntax error.
    """
    # Testing Part A
    istanbul_data = read_temperatures("ISTANBUL.txt")
    ankara_data = read_temperatures("ANKARA.txt")
    #print(istanbul_data)
    #print(ankara_data)
    
    # Testing Part B
    #istanbul_data = delete_year(istanbul_data, 2020)
    #ankara_data = delete_year(ankara_data, 2020)
    #print(istanbul_data)
    #print(ankara_data)
    
    # Testing Part C 
    #print(monthly_averages(istanbul_data, 2017))
    #print(monthly_averages(ankara_data, 2017))
    
    # Testing Part D
    #yearly_average(ankara_data)
    
    
    
################################################################ 
"""
DO NOT EDIT BELOW THIS LINE
"""
if __name__ == '__main__':
    main()