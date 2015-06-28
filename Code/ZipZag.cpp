#include <iostream>
#include <cstdio>

using namespace std;

string convert(string s, int numRows) {
    if (numRows == 1 || s.size() <= numRows) {
        return s;
    }
    string zipzag(s.size(), ' ');
    auto curIndex = 0;
    auto firstOffset = 2 * numRows - 2;
    auto secondOffset = 0;
    
    for (int row = 0; row < numRows; row++) {
        auto index = row;
        auto length = s.size();
        
        zipzag[curIndex++] = s[index];
        while(index < length) {
            index += firstOffset;
            if (firstOffset != 0 && index < length) {
                zipzag[curIndex++] = s[index];
            }
            index += secondOffset;
            if (secondOffset != 0 && index < length) {
                zipzag[curIndex++] = s[index];
            }
        }
        
        firstOffset -= 2;
        secondOffset += 2;
    }
    
    return zipzag;
}

int main(int argc, const char *argv[]) {
    cout << convert("aaba", 1) << endl;
    cout << convert("PAYPALISHIRING", 2) << endl;
}
