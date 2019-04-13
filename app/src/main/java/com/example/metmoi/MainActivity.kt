package com.example.metmoi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View.OnClickListener
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {


    lateinit var mtext : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ima = findViewById<ImageView>(R.id.Logo)
        ima.setImageResource(R.drawable.image)
        btnbackground.setOnClickListener(gotoBackground)
        btntitle.setOnClickListener(gotoTitleActivity)

        mtext = findViewById(R.id.tview)
       val data = intent.extras
        val tex = data.getString("key","DTV")
        tview.text = tex


    }

    private val gotoTitleActivity = OnClickListener {
        val haha = Intent(this,TitleActivity::class.java)
        haha.putExtra("text",tview.text)
        haha.putExtra("color",tview.currentTextColor)
        startActivity(haha)
    }

    companion object {
        const val REQUEST_CODE = 1099
        //const val REQUEST = 1097
    }

    private val gotoBackground = OnClickListener {
        val intent = Intent(this, BackgroundActivity::class.java)
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {

            val ima = findViewById<ImageView>(R.id.Logo)
            val img = data?.getIntExtra("haha", 0)
            img?.let {ima.setImageResource(img)}
        }
    }




}