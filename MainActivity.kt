package com.example.demo_basic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    /*AppCompatActivity-> Base class for activities that wish to use some of newer platform features
      on older android devices. Here used as we require the use of action bar

      onCreate-> called when activity is first created

      setContentView-> used to fill the window with UI provided from layout file(input param)
      based on this input, views will be inflated and rendered and then added to window*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this,"On Create Main",Toast.LENGTH_SHORT).show()

        // show password rules in text view
        password_hint.text = "Password minimum length 8"
        password_hint.append(", 1 uppercase")
        password_hint.append("\n1 number")
        password_hint.append(", 1 special character")


        // add text changed listener for edit text
        /*regpass.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?,
                                           start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?,
                                       start: Int, before: Int, count: Int) {
                s?.apply {
                    // check user input a valid formatted password
                    if (isValidPassword() && toString().length>=8) {
                        regpass.error == null
                    }else{
                        // show error on input invalid password
                        regpass.error = "invalid password."
                    }
                }
            }
            override fun afterTextChanged(s: Editable?) {

            }
        })*/


        /*supportactionbar to call getSupportActionBar method which allows us to
          use the Action Bar utility methods
        val actionBar = supportActionBar
        if (actionBar!=null){
            actionBar.title= "Registration Page"
        }*/

        /*val->constant variable; var->general variable and can be assigned multiple times

          Toast used to display a short notification without affecting UI. Toast class displays
          msg quickly and then disappears. LENGTH_SHORT depicts msg appears for short duration

          Intent-> intention to do action; Android intent is msg that is passed btw components
          which carries info that Android system uses to determine which component to start
          below is e.g. of explicit intent where intent provides external class to be invoked

          For example an Activity can send an Intents to the Android system which starts another
          Activity . putExtra() adds extended data to the intent.*/

        btnsignup.setOnClickListener {
            val user_name = reguname.text.toString()
            val password = regpass.text.toString()
            val repassword = regrepass.text.toString()
            var alertPopup = ""
            if (user_name.equals("") || password.equals("") || repassword.equals("")) {
                alertPopup = "Please enter all the details"
                Toast.makeText(this, alertPopup, Toast.LENGTH_SHORT).show()
            }
            else{
                if(user_name.length<5)
                {
                    alertPopup="User Name Length should be greater than 4"
                    Toast.makeText(this, alertPopup, Toast.LENGTH_SHORT).show()
                }
                else
                {
                    if (!isValidPassword(password))
                    {
                        alertPopup="Password format incorrect"
                        Toast.makeText(this, alertPopup, Toast.LENGTH_SHORT).show()
                        // show error on input invalid password
                        //regpass.error = "invalid password."
                    }
                    else{
                        //regpass.error == null
                        if (password.equals(repassword)) {
                            alertPopup = "Registered Successfully"
                            Toast.makeText(this, alertPopup, Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, SigninActivity::class.java)
                            intent.putExtra("usern",user_name)
                            intent.putExtra("passw",password)
                            startActivity(intent)
                            /*If u call finish() after intent u can't go back to previous activity
                              with 'back' button*/
                            finish()
                        } else {
                            alertPopup = "Password and Re-Entered Passowrd don't match"
                            Toast.makeText(this, alertPopup, Toast.LENGTH_SHORT).show()
                        }

                    }
                }

            }
        }
        //When calling finish() on an activity, the method onDestroy() is executed.
        btnregsignin.setOnClickListener {
            val intentSignin = Intent(this,SigninActivity::class.java)
            startActivity(intentSignin)
            finish()
        }


    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"On Start Main",Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"On Resume Main",Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"On Pause Main",Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"On Stop Main",Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this,"On Restart Main",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"On Destroy Main",Toast.LENGTH_SHORT).show()
    }
}

// extension function to validate password rules/patterns
/*A regular expression, specified as a string, must first be compiled into an instance of Pattern class.
The resulting pattern can then be used to create a Matcher object that can match arbitrary character
sequences against the regular expression. All of the state involved in performing a match resides in
the matcher, so many matchers can share the same pattern.*/

fun isValidPassword(str: String): Boolean {
    val passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$"
    val pattern = Pattern.compile(passwordPattern)
    val matcher = pattern.matcher(str)
    return matcher.matches()
}




/*

^                 // start-of-string
(?=.*[0-9])       // a digit must occur at least once
(?=.*[A-Z])       // an upper case letter must occur at least once
(?=.*[@#$%^&+=])  // a special character must occur at least once
(?=\\S+$)         // no whitespace allowed in the entire string
.{8,}             // anything, at least eight places
$                 // end-of-string

*/