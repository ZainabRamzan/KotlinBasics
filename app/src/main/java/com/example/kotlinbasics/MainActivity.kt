package com.example.kotlinbasics
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnShow_Toast.setOnClickListener {
            Toast.makeText(this,"button clicked",Toast.LENGTH_LONG).show()
        }

        btnSendMessage_to_SecondActivity.setOnClickListener {
            val message :String=etUser_Message.text.toString()
            Toast.makeText(this,message, Toast.LENGTH_LONG ).show()
            //Explicit Intent
            val intent =Intent(this,SecondActivity::class.java)
            intent.putExtra("my_Msg",message)
            startActivity(intent)
        }

        //implicit intent
        btnSendData_to_DifferApps.setOnClickListener {
            val message=etUser_Message.text.toString()
            val intent=Intent()
            intent.action=Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,message)
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent," Share to: "))
        }
            //RecyclerView
        btnRecyclerView.setOnClickListener {
            val intent=Intent(this,HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}