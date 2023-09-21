/*
* Programmer: TUAZON, Gian Michael D.S
* Date Created: 11/29/2019
* Terminal No: 30
* Program: IT
* Course / Section: CS127-8L/BM3
* Purpose: This program will calculate the speed from distance over time
*/

/*
   Linear equation using elimination method

*/

#include<iostream>
#include<iomanip>
#include<cmath>
using namespace std;
const int row=2;
const int col=3;
//function declaration
void equation1(int list[][col], int rsize);//to display the value in 2D array plus linear equation


void Elimination(int list1[][col], int rsize);//input the 2 values to elimate in eqn1 and eqn2
//then display the new equations that is already multiplied to the 2values

void final1(int list1[][col], int rsize,int Y);
//diplay the value of computed Y and the equation need to substitute the value of Y
//process and computes the value of X
//and finally, display the solution set of (x,y)

void final2(int list1[][col], int rsize,int X);
//diplay the value of computed X and the equation need to substitute the value of X
//process and computes the value of Y
//and finally, display the solution set of (x,y)

int deterY(int list2[3]);//computes the value of Y and returns the value of Y

int deterX(int list2[3]);//computes the value of X and returns the value of X

char choice();//display the menu and returns the value of choice


int main()
{
    char opt;
    
    opt=choice();
    
    switch(opt)
    {
       
       
       
       case '1'://two dimensional
          char ans;do{    system("cls");
              cout<<"SYSTEMS OF LINEAR EQUATIONS:\n"
                  <<"Solving by addition or elimination\n";
             
		   //ADD CODE HERE
		   		//Declaration
					int xlist[row][col]; 	//to input the values in 2D array
    				int xlist2[col]; 		//Array for the answer after elimination & addition of eqn1 and eqn2
		   			int rowSize;			//actual parameter of rsize
		   			int iR,iC;				//variables for count of row & column used in for loops
		   			int value;				//to store the value of X or the value of Y
		  
		   cout<<"This program uses Addition or Elimination Method."
			   <<endl
			   <<"We begin by setting up and evaluating the three variables x, y and the constant."
			   <<"\nFor example,\n 5x + y = -14 \nshould be entered as 5 1 -14";
		   cout<<"\n\nPress any key to continue....";
                       cin.ignore();
		   cin.get();

		   system("cls");
		   
		   cout<<"Again, 5x + y = -14 should be entered as 5 1 -14";
		   //ADD CODE HERE
		   		//Input Values
		   			for(iR=0;iR<row;iR++)
    				{
    					for(iC=0;iC<col;iC++)
    					{
    						if(iR==0&&iC==0)
    						{
    							cout<<endl<<"Enter Equation 1: ";
    						}
    						if(iR==1&&iC==0)
    						{
    							cout<<endl<<"Enter Equation 2: ";
    						}
    			
    						cin>>xlist[iR][iC];
    			
						}
					}
	
					system("pause");
					system("cls");
					
			//	Call function equation1 here 
				equation1(xlist,rowSize);        
            //Call function Elimination here
                Elimination(xlist,rowSize);
               
        	//ADD CODE HERE
        		//Computation for storing the answer in 1D-array: xlist2[col]
        				for(iC=0;iC<col;iC++)
        				{
        					if(iC==0)
        						xlist2[iC]=xlist[0][iC]+xlist[1][iC];
        					if(iC==1)
        						xlist2[iC]=xlist[0][iC]+xlist[1][iC];
        					if(iC==2)
        						xlist2[iC]=xlist[0][iC]+xlist[1][iC];
						}
						
				//Determining X or Y
        			if(xlist2[0]==0) //Determining Y since X-terms are cancelled
        				{	
        					value=deterY(xlist2);
        					cout<<"y="<<value<<endl;
        				
        					final1(xlist,rowSize,value);
        				}
        			if(xlist2[1]==0) //Determining X since Y-terms are cancelled
        				{
        					value=deterX(xlist2);
        					cout<<"x="<<value<<endl;
        				
        					final2(xlist,rowSize,value);
        				}
        			
        				system("pause");
        				system("cls");
        			
        		//Prompt the user to try again
        			do{
        				cout<<"Do you want to try another equation?[y/n]: ";
        				cin>>ans;
        			
        				ans=toupper(ans);
        				system("cls");
        				
        				if(ans=='N')
        					break;
        			
					}while((ans!='Y')&&(ans!='N'));
					  
            	}while(ans=='Y'); //Trying another equation   
       break;
       
       case '2': 
            //ADD CODE HERE
            	break;
    }//end switch
     
    system("pause");
    return 0;
    
}//end main

///////////////////////////////////////////////////////////
char choice()
{
    //ADD CODE HERE
     	//declaration
			char ch; //Input choice
	
		//executable
		do{
     		cout<<"<<<<<<<MENU>>>>>>>"			  <<endl
     			<<"[1] Systems of Linear Equation"<<endl
     			<<"[2} Quit"					  <<endl
     			<<"Enter your choice: ";
     		cin>>ch;
     	
     		system("cls");
     	
		}while(ch!='1'&&ch!='2');
	
		return ch; 
		
}//end choice
///////////////////////////////////////////////////////////////
void equation1(int list[][col], int rsize)
{
	//ADD CODE HERE
		//declaration
			int r,c; //variables for count of row & column used in for loops
	
	//executable	
		cout<<"You have entered (using 2-dimensional array)"<<endl;
			for(r=0;r<row;r++)
			{
				for(c=0;c<col;c++)
				{
					cout<<setw(5)<<list[r][c];
				}
				
				cout<<endl;
			}
		
		cout<<endl<<"SOLVING SIMPLE EQUATIONS"<<endl;
			for(r=0;r<row;r++)
			{
				for(c=0;c<col;c++)
				{
					if(r==0&&c==0||r==1&&c==0)
						cout<<setw(5)<<list[r][c]<<"x + ";
					else if(r==0&&c==1||r==1&&c==1)
						cout<<list[r][c]<<"y = ";
					else
						cout<<list[r][c];
				}
				
				cout<<endl;
			}
			
		cout<<"\n\n\n";
               
}//end equation1
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
void Elimination(int list1[][col], int rsize)
{
     //ADD CODE HERE
    	 //declaration
			int Eq1; //value for equation 1
			int Eq2; //value for equation 2
			int R,C;//variables that will be used to count of row & column  in for loops
	
		//executable
			cout<<"_____________________________________________"						<<endl
				<<"Please enter the value to eliminate the variable"					<<endl
				<<"for example. . . if you have:"										<<endl
				<<"2x+3y=10"															<<endl
				<<"4x+5y=15"															<<endl
				<<"if you want to eliminate x..you need to input -2"					<<endl
				<<"(for 2x to become -4x in eqn.1) and 1 (to remain the value in eqn.2)"<<endl
				<<"if you want to eliminate y..you need to input -/+5 in eqn.1"			<<endl
				<<"and +-3 in eqn.2"													<<endl<<endl
		
			//Input Values for both Equation 1 & 2
					<<"enter value for equation 1: ";
				cin>>Eq1;
				cout<<"enter value for equation 2: ";
				cin>>Eq2;
		
			cout<<"\n\nELIMINATING EQUATIONS"<<endl;
				for(R=0;R<row;R++)
				{
					for(C=0;C<col;C++)
					{	
						//  Equation 1
						if(R==0) 
						{
							if(C==0) 
							{
								list1[R][C]*=Eq1;
								cout<<setw(5)<<list1[R][C]<<"x + ";
							}
							else if(C==1)
							{
								list1[R][C]*=Eq1;
								cout<<list1[R][C]<<"y = ";
							}
							else
							{
								list1[R][C]*=Eq1;
								cout<<list1[R][C];
							}
						}
					
						//  Equation 2
						if(R==1)
						{
							if(C==0)
							{
								list1[R][C]*=Eq2;
								cout<<setw(5)<<list1[R][C]<<"x + ";
							}
							else if(C==1)
							{
								list1[R][C]*=Eq2;
								cout<<list1[R][C]<<"y = ";
							}
							else
							{
								list1[R][C]*=Eq2;
								cout<<list1[R][C];
							}
						
						}
					}
					cout<<endl;
				}
		
		cout<<"======================================================";
  		cout<<endl;         
     
     }
////////////////////////////////////////////////////
int deterY(int list2[3])
{
    //ADD CODE HERE
    	//declaration
			int Y; //The value of Y
	
		//executable
			Y=list2[2]/list2[1];
			return Y;
			
}
///////////////////////////////////////////////
int deterX(int list2[3])
{
    //ADD CODE HERE
    	//declaration
		int X; //The value of X
	
		//executable
		X=list2[2]/list2[0];
		return X;
    
}
///////////////////////////////////////////////////////
void final1(int list1[][col], int rsize,int Y)
{
    //ADD CODE HERE
    	//declaration
			int C;			//variable for count of column used in for loops
			int prod,prod2; //variables used for the computation of getting the value of X
			int final;		//value of X
	
		//executable
			cout<<"substitute the value of Y to equation 1:"<<endl;
	
			for(C=0;C<col;C++)
				{
					if(C==0)
						cout<<setw(5)<<list1[0][C	]<<"x + ";
					else if(C==1)
						cout<<list1[0][C]<<"y = ";
					else
						cout<<list1[0][C];
				}
	
			cout<<"\n\nthen becomes:"<<endl;
			for(C=0;C<col;C++)
				{
					if(C==0)
						cout<<setw(5)<<list1[0][C]<<"x + ";
					else if(C==1)
						cout<<list1[0][C]<<"("<<Y<<") = ";
					else
						cout<<list1[0][C];
				}
		
		//process and computes the value of X
			prod=list1[0][1]*Y;			//Substitution & Computation of Y-term
			prod2=(-1*prod)+list1[0][2]; //includes transposing
			final=prod2/list1[0][0];	//getting the final value of X
		
		cout<<"\nThen the solution set (x,y)=("<<final<<","<<Y<<")"<<endl;
}
////////////////////////////////////////////////////////////////////////////
void final2(int list1[][col], int rsize,int X)
{
    //ADD CODE HERE
    	//declaration
			int c;			//variable for count of column used in for loops
			int prod,prod2; //variables used for the computation of getting the value of Y
			int final;		//value of Y
	
		//executable
			cout<<"substitute the value of X to equation 1:"<<endl;
	
			for(c=0;c<col;c++)
				{
					if(c==0)
						cout<<setw(5)<<list1[0][c]<<"x + ";
					else if(c==1)
						cout<<list1[0][c]<<"y = ";
					else
						cout<<list1[0][c];
				}
	
			cout<<"\n\nthen becomes:"<<endl;
			for(c=0;c<col;c++)
				{
					if(c==0)
						cout<<setw(5)<<list1[0][c]<<"("<<X<<") + ";
					else if(c==1)
						cout<<list1[0][c]<<"y = ";
					else
						cout<<list1[0][c];
				}
		
		//process and computes the value of Y
			prod=list1[0][0]*X;			//Substitution & Computation of X-term
			prod2=(-1*prod)+list1[0][2]; //includes transposing
			final=prod2/list1[0][1];	//getting the final value of Y
		
		cout<<"\nThen the solution set (x,y)=("<<X<<","<<final<<")"<<endl;
    
}

