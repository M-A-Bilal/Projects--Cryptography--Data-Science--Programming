#include<iostream>
#include<iomanip>
using namespace std;

char getMenu();
void getBinDisplay(int* ptr, int* xsize);
int getLoc(int* ptr, int size, int* xtarget);
int getSize();
void getInput(double* ptr, int xsize);
double getElim(double* ptr, int xsize);
void getTry();


int main() {
    char ans, sagot;
    char* ptr;

    double* ptr_array;
    double average;
    int arraySize = 12, loc, size;
    int array[12] = { 4,7,8,10,14,21,22,36,62,77,81,91 };

  
    ptr = &sagot;
    do {
        ans = getMenu();
        try {
            if (ans != '1' && ans != '2' && ans != '3') {
                throw (ans);
            }
            else break;
        }
        catch (char e) {
            cout << e << " is an invalid choice please try again\n";
        }
            
    } while (ans != '1' && ans != '2' && ans != '3');

    switch (ans) {
    case '1':
        getBinDisplay(&array[0], &arraySize);

        int target;
        cout << "Enter your target key: ";
        cin >> target;
        loc = getLoc(&array[0], arraySize, &target);
        if (loc == -1) {
            cout << target << " is not in the list" << endl;
        }
        else cout << "target is at position [" << loc+1 << "]" << endl;
        break;
    case '2':
        size = getSize();
            
        ptr_array = new double[size];
        getInput(ptr_array, size);
        average = getElim(ptr_array, size);
        cout << "Average is "<<average << endl;
        break;
    case '3':
        exit(1);
        break;
    default:
        break;
    }
    getTry();
    cout << endl;
    return 0;
}



////////////////////////////////////////////
char getMenu() {
    cout << "---------CHOICES---------" << endl
        << "[1] - Binary searching" << endl
        << "[2] - Grade elimination" << endl
        << "[3] - Exit" << endl
        << "Enter your choice: ";
    char choice;
    cin >> choice;
    return choice;
}


void getBinDisplay(int* ptr, int* xsize) {
    cout << "Displaying elements in array" << endl;
    for (int i = 0; i < *xsize; i++) {
        cout << *(ptr + i) << "   ";
    }
}

int getLoc(int* ptr, int size, int* xtarget) {
    int index = 0;
    while (index <= size) {
        int m = index + (size - index) / 2;
        if (*(ptr+m) == *xtarget)
            return m;
        if (*(ptr + m) < *xtarget)
            index = m + 1;
        else
            size = m - 1;
    }
    return -1;
}

int getSize() {
    int size;
    do {
        cout << "Option2 : Grade elimination\n";
        //system("cls");
        cout << "Enter your desired number of grades [5 to 10 only] ";
        cin >> size;
        try {
            if (size < 5 || size>10) throw (size);
            else break;
        }
        catch (int s) {
            cout << s << " is invalid......please re-enter";
            system("cls");
        }
    } while (size < 5 || size>10);
    


    
    return size;
    
}

void getInput(double* ptr, int xsize) {
    cout << "Enter " << xsize << " grades" << endl;
    for (int srt = 0; srt < xsize; srt++) {
        cout << "index[" << srt << "]: ";
        cin >> *(ptr + srt);
    }
}

double getElim(double* ptr, int size) {
    double elim_no;
    int index = 0, m = -1, found = 0;
    while (found == 0) {
        cout << "Enter the number to be eliminated: ";
        cin >> elim_no;
        for (int i = 0; i < size; i++) {
            if (*(ptr + i) == elim_no) {
                found = i;
                break;
            }
        }
        if (found != 0) {
            break;
        }
        else {
            cout << "Number not found" << endl;
            system("cls");
        }

    }
    
    for (int i = found; i < size-1; i++) {
        *(ptr + i) = *(ptr + i + 1);
    }
    cout << elim_no << " is eliminated" << endl;

    double average=0;

    for (int i = 0; i < size - 1; i++) {
        average += *(ptr + i);
    }
    average /= (size - 1);
    return average;

    
}

void getTry() {
    char ans;
    do {
        cout << "Try Again?[y/n]:";
        cin >> ans;
        ans = tolower(ans);
    } while (ans != 'y' && ans != 'n');
    system("cls");

    try {
        if (ans == 'y') main();
        else if (ans == 'n') return;
        else throw(ans);
    }
    catch (char ex) {
        cout << ex << " is invalid";
        getTry();
        system("cls");
    }
}