package com.dicoding.bestcharacter

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class profile : AppCompatActivity(),View.OnClickListener {
    private lateinit var klikBack : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        klikBack=findViewById(R.id.backPage)
        klikBack.setOnClickListener(this)
        val noAction= supportActionBar
        noAction!!.title= "My profile"
        noAction.setDisplayHomeAsUpEnabled(true)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                val moveIntent = Intent(this@profile, MainActivity::class.java)
                startActivity(moveIntent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.backPage -> {
                val moveIntent = Intent(this@profile, MainActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}