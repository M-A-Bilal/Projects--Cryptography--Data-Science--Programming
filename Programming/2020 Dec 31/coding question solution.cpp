/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <iostream>

using namespace std;

int main()
{
    int n;
    cout<<"Enter number of students "<<endl;
    cin>>n;
    
    int score[n];
    for(int i=0;i<n;i++){
        cout<<"Enter a number ";
        cin>>score[i];
    }
    
    int temp = score[0];
    for(int i=0; i<n; i++) {
      if(temp>score[i]) {
         temp=i;
      }
   }
   cout<<"smallest element index = "<<temp<<endl;
   
   int sum=0;
   for(int i=0;i<n;i++){
       sum+=score[i];
   }
   cout<<"Average = "<<sum/n<<endl;
   
   int reverse[n];
   int x=0;
   for(int i=n-1;i>=0;i--){
       reverse[x]=score[i];
       x++;
   }
   
   for(int i=0; i<n;i++){
       cout<<reverse[i]<<" ";
   }

    return 0;
}
