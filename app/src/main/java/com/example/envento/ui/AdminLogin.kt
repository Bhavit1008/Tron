package com.example.envento.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.envento.R
import com.example.envento.api.RetrofitClient
import com.example.envento.model.LoginResponse
import com.example.envento.scanQr.ScanQrAct
import kotlinx.android.synthetic.main.activity_admin_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdminLogin : AppCompatActivity() {

    var email :String = ""
    var password :String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)

        btn_login.setOnClickListener {
            email = edt_email_admin.text.toString()
            password = edt_password_admin.text.toString()

            if(email !=null && password !=null){
                RetrofitClient.instance.loginUser(
                    email,
                    password
                ).enqueue(object : Callback<LoginResponse> {
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(applicationContext,"Error", Toast.LENGTH_SHORT).show()
                        Log.d("error",t.toString())
                    }

                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        val i = Intent(applicationContext,ScanQrAct::class.java)
                        startActivity(i)
                    }

                })
            }
            else{
                Toast.makeText(this,"NOT ENTERED", Toast.LENGTH_SHORT).show()
            }

        }

        registration_activity_bypass.setOnClickListener {
            val i = Intent(this,AdminRegistration::class.java)
            startActivity(i)
        }
    }
}
