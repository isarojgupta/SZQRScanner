package io.android.szqrscanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

  val btnScanBarcode: Button by lazy{
      findViewById(R.id.btnScanBarcode)
  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnScanBarcode.setOnClickListener{
            startActivity(Intent(this,ScannedBarcodeActivity::class.java))
        }
    }
}