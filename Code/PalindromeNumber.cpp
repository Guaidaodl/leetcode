#include <iostream>
#include <cstdlib>

using namespace std;

bool isPalindrome(int x) {
    if (x < 0) return false;
    int a = 1;
    int b = 1;
    while(b < INT_MAX / 10 && b * 10 <= x) {
        b = b * 10;
    }

    while(a < b) {
        int start = x / a % 10;        
        int end = x / b % 10;

        if (start != end) return false;

        a = a * 10;
        b = b / 10;
    }

    return true;
}



int main() {
    cout << isPalindrome(INT_MIN) << endl;
    cout << isPalindrome(121) << endl;
    cout << isPalindrome(123) << endl;
    cout << isPalindrome(0) << endl;
    cout << isPalindrome(10) << endl;
}



