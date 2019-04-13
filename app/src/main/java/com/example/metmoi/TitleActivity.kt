@file:Suppress("DEPRECATION")

package com.example.metmoi

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

@Suppress("DEPRECATION")
class TitleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_title)

        // var titlechange : String = R.id.title
        val doititle = findViewById<EditText>(R.id.title)
        val data1 = intent.extras
        val te : String = data1.getString("key","KHTN")



   //       val colorview = findViewById<ImageView>(R.id.iviewchange)
//        val data = intent
//        val edit = data.getStringExtra("text")
//        val colortext = data.getIntExtra("color",0)
//        colorview.setBackgroundColor(colortext)
//        doititle.setText(edit)
//        doititle.setTextColor(colortext)


        val blue = findViewById<ImageView>(R.id.imageblue)
        blue?.setOnClickListener{
           // colorview.setBackgroundColor(Color.parseColor("e53935"))
            doititle.setTextColor(Color.parseColor("e53935"))

            
        }

        val intentTitle = Intent(this, MainActivity::class.java)
        val btn_save = findViewById<Button>(R.id.titlesave)
        btn_save?.setOnClickListener{
            intentTitle.putExtra("key",doititle.text)
            startActivity(intentTitle)
        }
    }


}
