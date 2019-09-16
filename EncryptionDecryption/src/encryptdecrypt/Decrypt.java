package encryptdecrypt;

class Decrypt {

    static String unicode(String s, int k){

        char[] result = new char[s.length()];

        char ch;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            ch = (char)((int)c - k);

            result[i] += ch;
        }
        return String.valueOf(result);
    }//end of unicode decrypt

    static String shift(String s, int k){

        char[] result = new char[s.length()];

        char ch;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            //for capital letters
            if(c >= 65 && c <= 90){

                if((int)c - k < 65){
                    ch = (char)((int)c - k + 26);
                }
                else{
                    ch = (char)((int)c - k);
                }
            }
            //for small letters
            else if(c >= 97 && c <= 122){

                if((int)c - k < 97){
                    ch = (char)((int)c - k + 26);
                }
                else{
                    ch = (char)((int)c - k);
                }
            }
            //for any other character
            else{
                ch = c;
            }

            result[i] += ch;
        }

        return String.valueOf(result);
    }//end of shift decrypt
}
