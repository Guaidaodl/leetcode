#include <iostream>

using namespace std;


int myAtoi(string str) {
    int sign = 1;

    int start = 0;
    while(str[start] == ' ') {
        start++;
    }
    if (str[start] == '-') {
        sign = -1;
        start++;
    } else if (str[start] == '+') {
        start++;
    }

    auto result = 0;
    for (int i = start; i < str.length(); i++) {
        if (str[i] < '0' || str[i] > '9') return sign * result;
        int num = str[i] - '0';
        if (sign == 1 && result > (INT32_MAX - num) / 10) {
            return INT32_MAX;
        } else if (sign == -1 && -result < (INT32_MIN + num) / 10) {
            return INT32_MIN;
        }
        result = result * 10 + num;
    }


    return sign * result;
}



int main(int argc, const char *argv[]) {
    cout << "0: "<< myAtoi("0") << endl;
    cout << "-123: "<< myAtoi("-123") << endl;
    cout << "10: " << myAtoi(("012")) << endl;
    cout << "0: " <<myAtoi("+-2") << endl;
    cout << "23: " << myAtoi("     +23") << endl;
    cout << "12: " << myAtoi("  +12ad") << endl;
    cout << "-2147483648: " << myAtoi("-2147483648") << endl;
    cout << "2147483647: " << myAtoi("2147483648") << endl;
    cout << "2147483647: " << myAtoi(" 10522545459")<<endl;
}
