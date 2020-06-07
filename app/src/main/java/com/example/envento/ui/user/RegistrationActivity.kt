package com.example.envento.ui.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.envento.R
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {

    var id:String = ""
    var name :String = ""
    var number :String = ""
    var email : String = ""
    var regType :String = ""
    var noTicket :String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        val languages = resources.getStringArray(R.array.Registration_type)
        id = intent.getStringExtra("eventId")
        // access the spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, languages
            )
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(
                        applicationContext,
                        "selected item" + " " +
                                "" + languages[position], Toast.LENGTH_SHORT
                    ).show()
                    regType = languages[position].toString()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    Toast.makeText(applicationContext,"Please select from list", Toast.LENGTH_SHORT).show()
                }

            }
        }

        btn_reg_next.setOnClickListener {
            name = edt_name.text.toString()
            number = edt_number.text.toString()
            email = edt_email.text.toString()
            noTicket = edt_tickets.text.toString()
            if(name.isEmpty() || number.isEmpty() || email.isEmpty() || noTicket.isEmpty() || regType.isEmpty())
            {
                Toast.makeText(applicationContext,"Please Enter the above fields",Toast.LENGTH_SHORT).show()
            }
            else {
                intent = Intent(applicationContext,IdCardActivity::class.java)
                intent.putExtra("name",name)
                intent.putExtra("email",email)
                intent.putExtra("number",number)
                intent.putExtra("noTicket",noTicket)
                intent.putExtra("regType",regType)
                intent.putExtra("id",id)
                startActivity(intent)
            }
        }

    }
}
