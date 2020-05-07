package com.company;

import java.security.MessageDigest;

public class JThread extends Thread {
String password, answer,hashanswer;
   char a,b,c,d,e;

    JThread(String str){
    password = str;
    }

    public void run(){



        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try{
            for (char k='a';k<='z';k++){
                a=k;
                for(char r='a';r<='z';r++){
                    b=r;
                    for (char v='a';v<='z';v++){
                        c=v;
                        for (char o='a';o<='z';o++){
                            d=o;
                            for(char i='a';i<='z';i++){
                                e=i;
                               answer= Character.toString(a) + Character.toString(b) + Character.toString(c) +
                                       Character.toString(d) + Character.toString(e);

                                hashanswer = sha256(answer);
                                       if(hashanswer.equals(password)){
                                System.out.println("Пароль к хэшу: "+ password + " ->" + answer);
                                       return;}
                            }
                        }
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Thread has been interrupted");
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
    public static String sha256(String base) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
