package com.dicoding.bestcharacter

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var share:Button
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var character = intent.getParcelableExtra<Character>(DetailActivity.EXTRA_NAME)

        val name = findViewById<TextView>(R.id.tv_item_name)
        val photo = findViewById<ImageView>(R.id.img_item_photo)
        val desk= findViewById<TextView>(R.id.tv_item_description)

        name.text = character?.name
        desk.text = character?.description
        character?.photo?.let { photo.setImageResource(it) }

        val noAction= supportActionBar
        noAction?.title=character?.name
        noAction?.setDisplayHomeAsUpEnabled(true)
        share=findViewById(R.id.action_share)
        share.setOnClickListener{
            val intent= Intent(Intent.ACTION_SEND)
            intent.type="type/plain"
            val intentBody="Terima kasih"
            val intentSub="bro"
            intent.putExtra(Intent.EXTRA_SUBJECT, intentBody)
            intent.putExtra(Intent.EXTRA_TEXT,intentSub)
            startActivity(Intent.createChooser(intent,"Share now!!"))
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                val moveIntent = Intent(this@DetailActivity, MainActivity::class.java)
                startActivity(moveIntent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.backPage -> {
                val moveIntent = Intent(this@DetailActivity, MainActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }


    companion object {
        const val EXTRA_NAME = "extra_name"
    }
}