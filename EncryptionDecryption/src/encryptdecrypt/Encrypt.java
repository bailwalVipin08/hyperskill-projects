package encryptdecrypt;

class Encrypt {

  // Algorithm 1 : Encryption Algorithm based on unicode value of characters
    static String unicode(String s, int k){
        char[] result = new char[s.length()];

        char ch;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            ch = (char)((int)c + k);
            result[i] += ch;
        }

        return String.valueOf(result);
    }// end of unicode encrypt

    // Algorithm 2 : Encryption Algorithm based on shifting and rotating the value of characters
    static String shift(String s, int k){

        char[] result = new char[s.length()];

        char ch;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= 65 && c <= 90){

                if((int)c + k > 90){
                    ch = (char)((int)c + k - 26);
                }
                else{
                    ch = (char)((int)c + k);
                }
            }
            else if(c >= 97 && c <= 122){

                if((int)c + k > 122){
                    ch = (char)((int)c + k - 26);
                }
                else{
                    ch = (char)((int)c + k);
                }
            }
            else{
                ch = c;
            }

            result[i] += ch;
        }

        return String.valueOf(result);
    }//end of shift encrypt
}


