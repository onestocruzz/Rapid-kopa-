package com.rapidkopainc.rapidkopa;

import android.util.Log;

public class Credentials {

    //User Credentials
    static String name = "testuser";
    static String email = "testuser@boostpesa.com";
    static String password = "testpass";
    //Methods

   static boolean loginCredentialsCheck(String userEmail,String userPassword)
    {
        Log.i("CredentialClass","\n\nC_EMAIL\t"+email+"\nC_PASSWORD\t"+password);
        //Used in login page
        if( email.equals(userEmail) &&userPassword.equals(password))
        {
            return true;
        }
        else
        {
            return  false;
        }

    }



    static boolean registrationCredentialsCheck(String userName,String userEmail,String userPassword)
    {
        //Used in registration page
        if(name.equals(userName)&& email.equals(userEmail)&& password.equals(userPassword))
        {
            return true;
        }
        else
        {
            return  false;
        }
    }
}
