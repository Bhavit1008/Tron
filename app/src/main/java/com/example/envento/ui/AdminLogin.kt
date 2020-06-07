package com.example.envento.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.envento.R
import com.example.envento.scanQr.ScanQrAct
import kotlinx.android.synthetic.main.activity_admin_login.*

class AdminLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)

        btn_login.setOnClickListener {
            val i = Intent(this,ScanQrAct::class.java)
            startActivity(i)
        }

        registration_activity_bypass.setOnClickListener {
            val i = Intent(this,AdminRegistration::class.java)
            startActivity(i)
        }
    }
}
