#include<iostream>
#include<iomanip>
using namespace std;

const int size = 10;// use in menu[1] miles per gallon
typedef double* pointers;
void MilesPerrGallon(double* ptr1, double* ptr2);//process and display milespergallon
void MperG();//input miles and gallons and call function MilePerGallon
void getSort();//use dynamic array and a sort techniques to sort n values 
void displaySort(int* ptr, int smax);//displaying the vsorted values in descending order
char displayMenu(char* pt);//display the option on screen and return values 1,2 or 3 
//using a pointer variable

int main(){
    char ans, sagot;
    char* ptr;

    do{
        ptr = &sagot;
        do{
            ans = displayMenu(ptr);
            cout << ans << " is invalid" << endl;
            cout << "Press any key to continue...." << endl;
            system("pause>0");
        } while (*ptr != '1' && *ptr != '2' && *ptr != '3');

        switch (sagot){
        case '1':
            MperG();
            break;
        case '2':
            getSort();
            break;
        case '3':           
            exit(1);
            break;
        default:
            break;
        }

        do{
            cout << "Try Again?[y/n]:";
            cin >> *ptr;
            *ptr = tolower(*ptr);
        } while (*ptr != 'y' && *ptr != 'n');
        system("cls");
    } while (*ptr == 'y');
    cout << endl;
    return 0;
}

void MperG(){
    int ctr;
    pointers milPtr, galPtr;
    int arraySize;
    system("cls");
    cout << "COMPUTING FOR MPG : miles per gallon...\n";
    cout << "MILES\n";
    milPtr = new double[10];
    galPtr = new double[10];
    cout << "Miles\n";
    for (ctr = 0; ctr < 10; ctr++){        
        while (1){
            cout << "miles[" << ctr << "]: ";
            cin >> *(milPtr + ctr);
            try{
                if (*(milPtr + ctr) > 250 || *(milPtr + ctr) < 100) throw* (milPtr + ctr);
                break;
            }
            catch (double e){
                cout << e << " is invalid!..100-250 only \nreenter a new value\n";
                system("pause>0");
                continue;
            }
        }
    }
    *(milPtr + ctr) = '\0';
    system("cls");
    cout << "GALLONS\n";
    for (ctr = 0; ctr < 10; ctr++){
        while (1){
            cout << "gallons[" << ctr << "]: ";
            cin >> *(galPtr + ctr);
            try{
                if ((*(galPtr + ctr) > 25) || (*(galPtr + ctr) < 5)) throw* (galPtr + ctr);
                break;
            }
            catch (double e){
                cout << e << " is invalid!..5-25 only \nreenter a new value\n";
                system("pause>0");
                continue;
            }
        }
    }
    *(galPtr + ctr) = '\0';
    MilesPerrGallon(milPtr, galPtr);
}
////////////////////////
void MilesPerrGallon(double* ptr1, double* ptr2){
    int len = 0;
    for (int i = 0; *(ptr2 + i) != '\0'; i++) len++;
    cout << len << endl;
    double mpg[10];
    pointers mpgPtr;
    int index;
    //add code here
    system("cls");
    mpgPtr = &mpg[0];
    for (index = 0; index < len; index++)
        *(mpgPtr + index) = *(ptr1 + index) / *(ptr2 + index);
    cout << "MILES     /        GALLON     =   MPG\n";
    cout << fixed << setprecision(2);
    for (index = 0; index < len; index++){
        cout << *(ptr1 + index)
            << setw(5) << "/"
            << setw(12) << *(ptr2 + index)
            << setw(16) << *(mpgPtr + index)
            << endl;
    }
}
///////////////////////////////////////
void getSort(){
    int srt;
    int* srtPtr;
    int ssize;
    cout << "Sorting\n";
    system("cls");
    cout << "How many numbers you would like to sort? ";
    cin >> ssize;
    srtPtr = new int[ssize];
    cout << "Enter "<< ssize<<" numbers"<<endl;
    for (srt = 0; srt < ssize; srt++){
        cout << "index[" << srt << "]: ";
        cin >> *(srtPtr + srt);
    }

    for (int i = 0; i < ssize - 1; i++){
        for (int j = 0; j < ssize - i - 1; j++){
            if (*(srtPtr + j) < *(srtPtr + j + 1)){
                int temp = *(srtPtr + j);
                *(srtPtr + j) = *(srtPtr + j + 1);
                *(srtPtr + j + 1) = temp;
            }
        }
    }
    displaySort(srtPtr, ssize);
}
/////////////////////////
void displaySort(int* ptr, int smax){
    int srt[10];
    int* srtPtr;
    int index;
    system("cls");
    srtPtr = &srt[0];
    cout << "Numbers in decending order" << endl;
    for (index = 0; index < smax; index++)
        *(srtPtr + index) = *(ptr + index);
    cout << fixed << setprecision(2);
    for (index = 0; index < smax; index++)
        cout << *(srtPtr + index) << " ";    
    cout << "\nNumbers in ascending order" << endl;    
    for (index = smax-1; index > -1; index--)
        cout << *(srtPtr + index) << " ";    
    cout << endl;
}
////////////////////////////////////////////
char displayMenu(char* pt){
    cout << "MAIN MENU" << endl
        << "[1] - MPG (Miles Per Gallon)" << endl
        << "[2] - Sorting of Numbers" << endl
        << "[3] - Exit Program" << endl
        << "Enter Option: ";
    cin >> *pt;
    return *pt;
}