package encryptdecrypt;

import java.util.Arrays;

class Main {

    public static void main(String[] args) {

        // local variables
         String mode = "";
         int key = 0;
         String data = "" ;
         String fileOut = "";
         String finalData;
         String algo = "";

         // loop to process command line arguments
        for(int i = 0; i < args.length; i++){
            switch(args[i]){
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    data = args[i + 1];
                    break;
                case "-in":
                    String fileIn = args[i + 1];
                    data = FileOperations.readInput(fileIn);
                    break;
                case "-out":
                    fileOut = args[i + 1];
                    break;
                case "-alg":
                    algo = args[i + 1];
                    break;
            }
        }

        //If no input is provided, show message to user and exit

        if(Arrays.stream(args).noneMatch("-data"::equals) && Arrays.stream(args).noneMatch("-in"::equals)){
            System.out.println(">>> Error: No input data/file provided!");
            System.out.println(">>> Please supply -data or -in argument!");
            System.exit(0);
        }
        else if(Arrays.asList(args).contains("-data") && Arrays.asList(args).contains("-in")){
            System.out.println(">>> Not allowed to supply -data and -in argument together!");
            System.out.println(">>> -data and -in cannot be used at the same time");
            System.exit(0);
        }

        //select operation to perform based on value of -alg command line argument supplied
        assert mode != null;
        switch(mode){
            case "dec":
                finalData = decrypt(algo, data, key);
                break;
            case "enc":
            default:
                finalData = encrypt(algo, data, key);
                break;
        }

        //if output file is NOT Specified print output to standard output : Terminal

        if(Arrays.stream(args).noneMatch("-out"::equals)){
            System.out.println("Operation Successful!");
            System.out.println("OUTPUT : ");
            System.out.println(finalData);

        }
        // if output file is specified write output to file
        else{
            System.out.println("Operation Successful!");
            FileOperations.writeOutput(fileOut, finalData);
        }

    }//end of main

    private static String encrypt(String algo, String data, int key){
        String encData;

        assert data != null;
        if("unicode".equals(algo)){
            encData = Encrypt.unicode(data,key);
        }
        else if("shift".equals(algo)){
            encData = Encrypt.shift(data,key);
        }
        else{
            encData = Encrypt.unicode(data,key);
        }
        return encData;
    }

    private static String decrypt(String algo, String data, int key){
        String decData;

        assert data != null;
        if("unicode".equals(algo)){
            decData = Decrypt.unicode(data,key);
        }
        else if("shift".equals(algo)){
            decData = Decrypt.shift(data,key);
        }
        else{
            decData = Decrypt.unicode(data,key);
        }
        return decData;
    }

}//end of class Main
