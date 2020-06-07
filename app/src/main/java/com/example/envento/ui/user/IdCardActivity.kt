package com.example.envento.ui.user

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import com.example.envento.R
import com.example.envento.api.RetrofitClient
import com.example.envento.model.EventResponse
import kotlinx.android.synthetic.main.activity_id_card.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IdCardActivity : AppCompatActivity() {
    val REQUEST_IMAGE_CAPTURE = 1

    var id:String = ""
    var name :String = ""
    var number :String = ""
    var email : String = ""
    var regType :String = ""
    var noTicket :String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_id_card)
        id = intent.getStringExtra("id")
        name = intent.getStringExtra("name")
        number = intent.getStringExtra("number")
        email = intent.getStringExtra("email")
        regType = intent.getStringExtra("regType")
        noTicket = intent.getStringExtra("noTicket")
        dispatchTakePictureIntent()
    }

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }

        btn_take_pic.setOnClickListener {
            dispatchTakePictureIntent()
        }



        btn_id_reg.setOnClickListener {
            if(email !=null && number !=null){
                RetrofitClient.instance.createUser(
                    id,
                    name,
                    email,
                    regType,
                    number,
                    noTicket
                ).enqueue(object : Callback<EventResponse> {
                    override fun onFailure(call: Call<EventResponse>, t: Throwable) {
                        val i = Intent(applicationContext,SuccessScreen::class.java)
                        i.putExtra("id",id)
                        startActivity(i)
                    }

                    override fun onResponse(call: Call<EventResponse>, response: Response<EventResponse>) {
                        Log.d("response",response.body().toString())
                    }

                })
            }
            else{
                Toast.makeText(this,"NOT ENTERED", Toast.LENGTH_SHORT).show()
            }

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)
        }
    }
}
