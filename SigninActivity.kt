package com.example.demo_basic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_signin.*

class SigninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        /*Prepopulating Newly registered User data here*/
        val usname= intent.getStringExtra("usern")
        val pwd= intent.getStringExtra("passw")

        /*Toast.makeText(this,usname,Toast.LENGTH_SHORT).show()
            Toast.makeText(this,pwd,Toast.LENGTH_SHORT).show()*/
        btnsignin.setOnClickListener {

            val user_name= uname.text.toString()
            val password = pass.text.toString()
            var reg=""
            if(user_name.equals("")||password.equals(""))
            {
                reg="Please enter all the details"
                Toast.makeText(this,reg, Toast.LENGTH_SHORT).show()
            }


            /*if((user_name.equals("Piyush") && password.equals("pwdpiyush"))
                ||(user_name.equals(usname) && password.equals(pwd)))
            {
                reg="New User Login"
                Toast.makeText(this,reg,Toast.LENGTH_SHORT).show()
            }*/

            else{
                if((user_name.equals("Piyush") && password.equals("pwdpiyush"))
                    ||(user_name.equals(usname) && password.equals(pwd)))
                {
                    reg="Logged in Successfully"
                    Toast.makeText(this,reg, Toast.LENGTH_SHORT).show()
                    val intent2 = Intent(this,SecondActivity::class.java)
                    startActivity(intent2)
                    finish()
                }
                else{
                    reg="Invalid Credentials"
                    Toast.makeText(this,reg, Toast.LENGTH_SHORT).show()
                }
            }
        }


        
    }
}