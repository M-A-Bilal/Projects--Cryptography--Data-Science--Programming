def protein_parser(pdbfile):

    return atoms

def center_of_mass(atoms):
    """Calculate the center of mass."""
    mass={'C':12.01, 'O':16.00, 'H':1.008, 'N': 14.01, 'S':32.06}
    
    return cm

def shift(atoms,vec):
    """shift the protein defined in atoms by the vector vec"""
    """atoms should not be modified, function should return atomsnew
    list with the updated coordinates"""

    return atomsnew


atoms=protein_parser('1ubq.pdb')

com=center_of_mass(atoms[:])
print(f"Center of mass of the protein is {com[0]:6.3f}, {com[1]:6.3f}, {com[2]:6.3f}")

#If we shift the protein by vector -com, 
#it's center of mass will be at the origin
for i in range(3):
    com[i] *= -1
atomsnew=shift(atoms,com)

com=center_of_mass(atomsnew[:])
print(f"New center of mass of the protein is {com[0]:6.3f}, {com[1]:6.3f}, {com[2]:6.3f}")

"""
Expected output is:
Center of mass of the protein is 30.317, 28.775, 15.353
New center of mass of the protein is  0.000,  0.000,  0.000
"""