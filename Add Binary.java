 
 Add Binary  Apr 2 '123380 / 9921
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 
 
 
==========================================================
 
 public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(a == null || b == null) return null;
        if(a.length() < b.length()){
            String s = a;
            a = b;
            b = s;
        }
        
        int la= a.length() -1;
        int lb = b.length() -1;
        
        StringBuilder sb = new StringBuilder("");
        int carry = 0;
        for(int i = 0; i <= la; i++ ){
            int sum = 0;
            if(i <= lb){
                sum = (a.charAt(la-i) - '0') + (b.charAt(lb-i) - '0') + carry;
             }else{
                sum = (a.charAt(la-i) - '0') + carry;
             }
            carry = sum/2;
            if (sum%2 == 0){
                sb.insert(0, "0");// new Interger(i).toString()
                //user insert(index, str) not append()
            }else{
                sb.insert(0, "1");// new Interger(i).toString()/Integer.toString(sum%2)
            }
            
            
        }
        
        if(carry == 1) 
            sb.insert(0,"1");
        
        return sb.toString();
    }
