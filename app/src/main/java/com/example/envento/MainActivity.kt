package com.example.envento

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.envento.scanQr.ScanQrAct
import com.example.envento.ui.AdminLogin
import com.example.envento.ui.AdminRegistration
import com.example.envento.ui.UserEventList
import kotlinx.android.synthetic.main.activity_main.*
import javax.security.auth.login.LoginException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        card_admin.setOnClickListener {
            val i = Intent(this,AdminLogin::class.java)
            startActivity(i)
        }

        card_user.setOnClickListener {
            val i = Intent(this,UserEventList::class.java)
            startActivity(i)
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        moveTaskToBack(false)
    }


}
