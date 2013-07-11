public int numDecodings(String s) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (s.length() == 0) return 0;
    char[] str = s.toCharArray();
    if (str[0] == '0') return 0;
    if (s.length() == 1) return 1;

    int first = 1, second = 1, next;
    for (int i = 1; i < s.length(); i++) {
        if (isValid(str[i-1], str[i])) {
            if (str[i] != '0') next = first + second;
            else next = first;
        } else {
            if (str[i] != '0') next = second;
            else return 0;
        }
        first = second;
        second = next;
    }
    return second;
}

public boolean isValid(char c1, char c2) {
    if (c1 == '1') return true;
    if (c1 == '2' && c2 - '0' < 7) return true;
    return false;
}
