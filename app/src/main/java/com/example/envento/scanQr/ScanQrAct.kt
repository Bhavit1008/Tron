package com.example.envento.scanQr

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.envento.MainActivity
import com.example.envento.R
import com.google.zxing.integration.android.IntentIntegrator


class ScanQrAct : AppCompatActivity() {

    var backButtonCount:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_qr)
        letsScan()
        findViewById<Button>(R.id.btn).setOnClickListener { letsScan() }

    }

    private fun letsScan() {
        val integrator = IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
        integrator.setPrompt("scan")
        integrator.setCameraId(0)
        integrator.setBeepEnabled(false)
        integrator.setBarcodeImageEnabled(false)
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        scanResult.let {
            findViewById<TextView>(R.id.value).text = scanResult.contents
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        var i = Intent(this,MainActivity::class.java)
        startActivity(i)
    }
}
