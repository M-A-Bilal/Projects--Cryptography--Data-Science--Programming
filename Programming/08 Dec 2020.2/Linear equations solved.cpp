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
          char ans;
		  do{    
			  system("cls");
              cout<<"SYSTEMS OF LINEAR EQUATIONS:\n"
                  <<"Solving by addition or elimination\n";
            
			  //ADD CODE HERE
			  int Array2D_1[row][col]; 	
			  int Array2D_2[col]; 		
			  int row_dim = 0;			
			  int Rc,Cc;				
			  int val;					
			  
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
			  for(Rc=0;Rc<row;Rc++){
				  for(Cc=0;Cc<col;Cc++){
					  if(Rc==0&&Cc==0)
						  cout<<endl<<"Enter Equation 1: ";
					  if(Rc==1&&Cc==0)
						  cout<<endl<<"Enter Equation 2: ";
					  cin>>Array2D_1[Rc][Cc];
				  }
			  }
			  system("pause");
			  system("cls");
			  //	Call function equation1 here 
			  equation1(Array2D_1,row_dim);        
			  //Call function Elimination here
			  Elimination(Array2D_1,row_dim);
			  //ADD CODE HERE
			  for(Cc=0;Cc<col;Cc++){
				  if(Cc==0)
					  Array2D_2[Cc]=Array2D_1[0][Cc]+Array2D_1[1][Cc];
				  if(Cc==1)
					  Array2D_2[Cc]=Array2D_1[0][Cc]+Array2D_1[1][Cc];
				  if(Cc==2)
					  Array2D_2[Cc]=Array2D_1[0][Cc]+Array2D_1[1][Cc];
			  }
			  if(Array2D_2[0]==0){	
				  val=deterY(Array2D_2);
				  cout<<"y="<<val<<endl;
				  final1(Array2D_1,row_dim,val);
			  }
			  if(Array2D_2[1]==0){
				  val=deterX(Array2D_2);
				  cout<<"x="<<val<<endl;
				  final2(Array2D_1,row_dim,val);
			  }
			  system("pause");
			  system("cls");
			  do{
				  cout<<"Do you want to try another equation?[y/n]: ";
				  cin>>ans;
				  ans=toupper(ans);
				  system("cls");
				  if(ans=='N')
					  break;
			  }while((ans!='Y')&&(ans!='N'));
		  }while(ans=='Y');
		  break;
	   
	   case '2': 
		   //ADD CODE HERE
		   break;
	}//end switch
	system("pause");
    return 0;
    
}//end main

///////////////////////////////////////////////////////////
char choice(){
	//ADD CODE HERE
	char input;
	do{
		cout<<"<<<<<<<MENU>>>>>>>"<<endl
			<<"[1] Systems of Linear Equation"<<endl
			<<"[2] Quit"<<endl
			<<"Enter your choice:";
		cin>>input;
		system("cls");
	}while(input!='1'&&input!='2');
	
		return input; 
		
}//end choice
///////////////////////////////////////////////////////////////
void equation1(int list[][col], int rsize){
	//ADD CODE HERE
	int Row,Column;
	cout<<"you have entered (using 2-dimensional array)"<<endl;
	for(Row=0;Row<row;Row++){
		for(Column=0;Column<col;Column++)
			cout<<setw(5)<<list[Row][Column];
		cout<<endl;
	}
	cout<<endl<<"SOLVING SIMPLE EQUATIONS"<<endl;
	for(Row=0;Row<row;Row++){
		for(Column=0;Column<col;Column++){
			if(Row==0&&Column==0||Row==1&&Column==0)
				cout<<setw(5)<<list[Row][Column]<<"x + ";
			else if(Row==0&&Column==1||Row==1&&Column==1)
				cout<<list[Row][Column]<<"y = ";
			else
				cout<<list[Row][Column];
		}
		cout<<endl;
	}
	cout<<"\n\n\n";
               
}//end equation1
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
void Elimination(int list1[][col], int rsize){
	//ADD CODE HERE
	int eq1_val;
	int eq2_val;
	int Row,Column;
	cout<<"_____________________________________________"<<endl
		<<"Please enter the value to eliminate the variable"<<endl
		<<"for example. . . if you have:"<<endl
		<<"2x+3y=10"<<endl
		<<"4x+5y=15"<<endl
		<<"if you want to eliminate x..you need to input -2"<<endl
		<<"(for 2x to become -4x in eqn.1) and 1 (to remain the value in eqn.2)"<<endl
		<<"if you want to eliminate y..you need to input -/+5 in eqn.1"<<endl
		<<"and +-3 in eqn.2"<<endl
		<<"enter value for equation 1:";
	cin>>eq1_val;
	cout<<"enter value for equation 2:";
	cin>>eq2_val;
	cout<<"\n\nELIMINATING EQUATIONS"<<endl;
	for(Row=0;Row<row;Row++){
		for(Column=0;Column<col;Column++){	
			if(Row==0){
				if(Column==0){
					list1[Row][Column]*=eq1_val;
					cout<<setw(5)<<list1[Row][Column]<<"x + ";
				}else if(Column==1){
					list1[Row][Column]*=eq1_val;
					cout<<list1[Row][Column]<<"y = ";
				}else{
					list1[Row][Column]*=eq1_val;
					cout<<list1[Row][Column];
				}
			}
			if(Row==1){
				if(Column==0){
					list1[Row][Column]*=eq2_val;
					cout<<setw(5)<<list1[Row][Column]<<"x + ";
				}else if(Column==1){
					list1[Row][Column]*=eq2_val;
					cout<<list1[Row][Column]<<"y = ";
				}else{
					list1[Row][Column]*=eq2_val;
					cout<<list1[Row][Column];
				}
			}
		}
		cout<<endl;
	}
	cout<<"======================================================";
	cout<<endl;
}
////////////////////////////////////////////////////
int deterY(int list2[3]){
	//ADD CODE HERE
	return list2[2] / list2[1];
}
///////////////////////////////////////////////
int deterX(int list2[3]){
	//ADD CODE HERE
	return list2[2] / list2[0];
}
///////////////////////////////////////////////////////
void final1(int list1[][col], int rsize,int Y){
    //ADD CODE HERE
	int Column;
	int X_1,X_2; 
	int X;
	cout<<"substitute the value of Y to equation 1:"<<endl;
	for(Column=0;Column<col;Column++){
		if(Column==0)
			cout<<setw(5)<<list1[0][Column]<<"x + ";
		else if(Column==1)
			cout<<list1[0][Column]<<"y = ";
		else
			cout<<list1[0][Column];
	}
	cout<<"\n\nthen becomes:"<<endl;
	for(Column=0;Column<col;Column++){
		if(Column==0)
			cout<<setw(5)<<list1[0][Column]<<"x + ";
		else if(Column==1)
			cout<<list1[0][Column]<<"("<<Y<<") = ";
		else
			cout<<list1[0][Column];
	}
	X_1 = list1[0][1] * Y;
	X_2=(-1*X_1)+list1[0][2];
	X=X_2/list1[0][0];
	cout<<"\nThen the solution set (x,y)=("<<X<<","<<Y<<")"<<endl;
}
////////////////////////////////////////////////////////////////////////////
void final2(int list1[][col], int rsize, int X) {
	//ADD CODE HERE
	int Column;
	int Y_1, Y_2;
	int Y;
	cout << "substitute the value of X to equation 1:" << endl;
	for (Column = 0; Column < col; Column++) {
		if (Column == 0)
			cout << setw(5) << list1[0][Column] << "x + ";
		else if (Column == 1)
			cout << list1[0][Column] << "y = ";
		else
			cout << list1[0][Column];
	}
	cout << "\n\nthen becomes:" << endl;
	for (Column = 0; Column < col; Column++) {
		if (Column == 0)
			cout << setw(5) << list1[0][Column] << "(" << X << ") + ";
		else if (Column == 1)
			cout << list1[0][Column] << "y = ";
		else
			cout << list1[0][Column];
	}
	Y_1 = list1[0][0] * X;
	Y_2 = (-1 * Y_1) + list1[0][2];
	Y = Y_2 / list1[0][1];
	cout << "\nThen the solution set (x,y)=(" << X << "," << Y << ")" << endl;
}