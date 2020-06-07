package com.example.envento.ui.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.envento.R
import kotlinx.android.synthetic.main.activity_success_screen.*

class SuccessScreen : AppCompatActivity() {
    var id:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_screen)

        id = intent.getStringExtra("id")
        txt_reg_id_success.text = id
    }
}
