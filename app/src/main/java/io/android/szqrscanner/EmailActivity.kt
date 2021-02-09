package io.android.szqrscanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.view.View
import javax.security.auth.Subject

class EmailActivity : AppCompatActivity() {
    private lateinit var inSubject: EditText
    private lateinit var inBody:EditText
    private lateinit var txtEmailAddress:TextView
    private lateinit var btnSendEmail:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)
    }
    fun initViews() {
        inSubject = findViewById(R.id.inSubject)
        inBody = findViewById(R.id.inBody)
        txtEmailAddress = findViewById(R.id.txtEmailAddress)
        btnSendEmail = findViewById(R.id.btnSendEmail)

        if (intent.getStringExtra("email_address")!=null){
            txtEmailAddress.text = "Recipient: "+ intent.getStringExtra("email_address")

        }
        btnSendEmail.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL,  arrayOf(txtEmailAddress.text.toString()));
            intent.putExtra(Intent.EXTRA_SUBJECT,inSubject.text.toString())
            intent.putExtra(Intent.EXTRA_TEXT,inBody.text.toString())
            startActivity(Intent.createChooser(intent,"Send Email"))
        }
        fun onClick(view:View){
            when(view.id){
                R.id.btnScanBarcode->
                    startActivity(Intent(this,ScannedBarcodeActivity::class.java))

            }

        }

    }
}