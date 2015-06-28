#include <iostream>

using namespace std;

int findPalindrome(string s, int begin, int end) {
    while (begin >= 0 && end < s.size() && s[begin] == s[end]) {
        begin--;
        end++;
    }

    return (end - 1) - (begin + 1) + 1;
}

string longestPalindrome(string s) {
    auto maxBegin = 0;
    auto maxLength = 0;
    for (auto i = 0; i < s.size(); i++) {
        int oddLength = findPalindrome(s, i, i);
        int evenLength = findPalindrome(s, i - 1, i);
        int length = oddLength > evenLength ? oddLength : evenLength;

        if (length > maxLength) {
            maxBegin = i - length / 2;
            maxLength = length;
        }
    }

    return s.substr(maxBegin, maxLength);
}

int main(int argc, const char *argv[]) {
    cout << "test \"\" longest: " << longestPalindrome("") << " expected \"\"\n";
    cout << "test \"bb\" longest: " << longestPalindrome("bb") << " expected bb" << endl;
    cout << "test \"a\" longest: " << longestPalindrome("a") << " expected a" << endl;
    cout << "test \"asddsa\" longest :\"" << longestPalindrome("asddsa") << "\" expected: \"asddsa\"" << endl;
    cout << "test \"asdsb\" longest : " << longestPalindrome("asdsb") << " expected sds" << endl;
}


