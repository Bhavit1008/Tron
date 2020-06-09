package com.example.envento.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.envento.R
import com.example.envento.api.RetrofitClient
import com.example.envento.model.RegistrationResponse
import com.example.envento.scanQr.ScanQrAct
import kotlinx.android.synthetic.main.activity_admin_registration.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdminRegistration : AppCompatActivity() {

    var name:String = ""
    var number :String = ""
    var email :String = ""
    var password :String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_registration)
        btn_register_admin_reg.setOnClickListener {

            name = edt_name_admin_reg.text.toString()
            number = edt_number_admin_reg.text.toString()
            email = edt_email_admin_reg.text.toString()
            password = edt_password_admin_reg.text.toString()
            if (email != null && password != null && name != null && number != null) {
                RetrofitClient.instance.createUser(
                    name,
                    number,
                    email,
                    password
                ).enqueue(object : Callback<RegistrationResponse> {
                    override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message.toString(), Toast.LENGTH_SHORT)
                            .show()
                    }

                    override fun onResponse(
                        call: Call<RegistrationResponse>,
                        response: Response<RegistrationResponse>
                    ) {
                        Toast.makeText(
                            applicationContext,
                            response.message().toString(),
                            Toast.LENGTH_SHORT
                        ).show()


                        val i = Intent(applicationContext,ScanQrAct::class.java)
                        startActivity(i)
                    }

                })
            }

        }
    }
}
