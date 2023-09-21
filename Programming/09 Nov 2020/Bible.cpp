#include <iostream>
#include <fstream>
using namespace std;

int main() {
    int choice;
    string verse = "but those who hope in the LORD \nwill renew their strength.\nThey will soar on wings like eagles; \nthey will run and not grow weary, \nthey will walk and not be faint.\n";
    cout << verse;
    cout << "Please select a number from 1, 2 or 3 " << endl; 
    cout << "Enter Choice : ";
    cin >> choice; 
    ofstream myfile;
    char enterVerse = 'y';
    switch (choice) {
        case 1:
            myfile.open ("session_10_Kofi_Larbi_bible1.txt");
            myfile << "1\n";
            myfile << verse;
            myfile.close();
            break;
        case 2:
            myfile.open ("session_10_Kofi_Larbi_bible2.txt");
            myfile << "2\n";
            myfile << verse +"\n";
            while (enterVerse == 'y'){
                cout << "Enter bible verses from the Old Testament: "; 
                string verse2;
                cin.ignore();
                getline(cin, verse2);
                myfile << "2\n";
                myfile << verse2 +"\n";
                cout << "Do you want to enter more verses? (y=Yes and n=No)\n";
                cin >> enterVerse;
            }
            myfile.close();
            break;
        case 3:
            myfile.open ("session_10_Kofi_Larbi_bible3.txt");
            myfile << "3\n";
            myfile << verse +"\n";
            while (enterVerse == 'y'){
                cout << "Enter bible verses from the New Testament: "; 
                string verse3;
                cin.ignore();
                getline(cin, verse3);
                myfile << "3\n";
                myfile << verse3 +"\n";
                cout << "Do you want to enter more verses? (y=Yes and n=No)\n";
                cin >> enterVerse;
            }
            myfile.close();
            break;
        default : 
            cout << "Invalid choice" << endl;
    }
}