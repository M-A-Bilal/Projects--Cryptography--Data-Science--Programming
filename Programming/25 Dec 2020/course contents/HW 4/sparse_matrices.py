import random
import math

def sparse_mat_add(sp_matrix1, sp_matrix2):
    """ 
    This function adds two sparse matrices together.
    You do not need to do do anything to this function, it is given to you
    as an example.
    """
    if (sp_matrix1[-1][0] != sp_matrix2[-1][0]) or (sp_matrix1[-1][1] != sp_matrix2[-1][1]):
        raise Exception ("Error! Matrix dimensions must agree.")

    
    sp_matrix_res = {}
    sp_matrix_res[-1] = sp_matrix1[-1]

    # Copying the first matrix into the result matrix
    # You can directly use a built-in dictionary method for this!
    # sp_matrix_res = sp_matrix1.copy()
    
    for key in sp_matrix1.keys():
        sp_matrix_res[key] = sp_matrix1[key]
        
    # Now, just add them update
    # Remember the get method of dictionaries!
    for key in sp_matrix2.keys()::
        sp_matrix_res[key] = sp_matrix_res.get(key,0)+sp_matrix2[key]
        
    return sp_matrix_res
    
def generate_random_sparse_matrix(nrow, ncol, sparsity=0.6):
    """
    This function generates a random matrix as a list of lists with a given sparsity.
    """
    
    row = [0.]*ncol
    res=[]
    for i in range(nrow):
        res.append(row[:])

    nr = int((1.-sparsity)*nrow*ncol)
    pos = random.sample(range(nrow*ncol), nr)
    for ind in pos:
        n_ind = math.floor(ind/ncol)
        m_ind = ind-n_ind*ncol
        res[n_ind][m_ind]=random.random()
    return res

def is_equal(matrix, sparse_matrix, epsilon=1e-9):
    """ 
    This function compares a matrix with list of lists representation to a sparse matrix
    """

    nrows=len(matrix)
    ncols=len(matrix[0])
    if nrows!=sparse_matrix[-1][0] or ncols!=sparse_matrix[-1][1]:
        return False
        
    for r in range(nrows):
        for c in range(ncols):
            if abs(matrix[r][c] - sparse_matrix.get((r,c),0)) > epsilon:
                return False

    return True                

def show_sparse(sp_matrix):
    """
    This function displays the input sparse matrix as a formatted string
    """
    
    nrow,ncol=sp_matrix[-1]
    out=""
    for i in range(nrow):
        for j in range(ncol-1):
            out+=f"{sp_matrix.get((i,j),0.):8.3f},"
        out+=f"{sp_matrix.get((i,j+1),0.):8.3f}"+"\n"
    return out

def get_shape(item):
    rows, cols = 1,1
    if type(item) == list:  
        rows = len(item)
        if type(item[0]) == list:
            cols = len(item[0])
    return rows, cols

def mat_mult(matrix1, matrix2):
    """ 
    This function multiplies two sparse matrices to get a third sparse matrix and returns the result.
    sp_matrix_res = sp_matrix1*sp_matrix2
    TODO: Implement this function
    """
    
    r1,c1 = get_shape(matrix1)
    r2,c2 = get_shape(matrix2)
    
    if c1 != r2:
        raise ValueError("Inner matrix dimensions do not match")
    
    output_item = [0]*r1
    for i in range(r1):
        output_item[i] = [0]*c2
        for j in range(c2):
            for k in range(c1):
                output_item[i][j] += matrix1[i][k]*matrix2[k][j]
    return output_item

# The functions you need to modify are given below, you do not need to modify anything above this line. 
# Feel free to add more functions

def dense_to_sparse(matrix):
    """ 
    This function converts a given list of lists representation of a matrix to a sparse representation.
    This function must return the sparse representation of matrix as a dictionary. 
    return sp_matrix
    TODO: Implement this function
    """
    
    sp_matrix = {}
    
    # YOUR CODE GOES HERE. MAKE SURE sp_matrix IS THE SPARSE REPRESENTATION OF matrix
    
    return  sp_matrix
    
def sparse_transpose(sp_matrix):
    """ 
    This function returns the transpose of the input sparse matrix (sp_matrix) as another
    sparse matrix (sp_matrix_transpose).
    Hint: Look at the mat_mult function given above
    TODO: Implement this function
    """
    
    sp_matrix_transpose = {}
    
    # YOUR CODE GOES HERE. MAKE SURE sp_matrix_transpose IS SPARSE 
    
    return sp_matrix_transpose
    
def sparse_mat_mult(sp_matrix1, sp_matrix2):
    """ 
    This function multiplies two sparse matrices to get a third sparse matrix and returns the result.
    sp_matrix_res = sp_matrix1*sp_matrix2
    TODO: Implement this function
    """
    
    sp_matrix_res = {}
    
    # YOUR CODE GOES HERE. MAKE SURE sp_matrix_res IS SPARSE 

    
    return sp_matrix_res

if __name__=="__main__":
    #WARNING: Not all the conditions are checked!!!
    
    iters = 100
    
    for iter in range(iters):
        r1 = random.randint(1,100)
        c1 = random.randint(1,100)
        c2 = random.randint(1,100)
        no_match = False
        if random.random() < 0.9:
            r2 = c1  
        else: 
            r2 = random.randint(1,100)
            if r2 != c1:
                no_match = True
        ll_sp_m1 = generate_random_sparse_matrix(3,4)
        ll_sp_m2 = generate_random_sparse_matrix(4,2)
        
        sp_m1 = dense_to_sparse(ll_sp_m1)
        sp_m2 = dense_to_sparse(ll_sp_m2)
        
        if(not is_equal(ll_sp_m1,sp_m1) or not is_equal(ll_sp_m2,sp_m2)):
            raise Exception("Wrong conversion from dense to sparse")
            
        sp_m1T = sparse_transpose(sp_m1)
        sp_m1TT = sparse_transpose(sp_m1T)
        if(not is_equal(ll_sp_m1,sp_m1TT)):
            raise Exception("Wrong sparse transpose operation")    
        
        try:
            ll_mult = mat_mult(ll_sp_m1, ll_sp_m2)    
            sp_mult = sparse_mat_mult(sp_m1, sp_m2)
        except ValueError as e:
            print(e)
            if(not no_match):
                raise
                
        if(not is_equal(ll_mult,sp_mult)):
            raise Exception("Wrong sparse matrix multiplication operation")    
