package com.dicoding.bestcharacter

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvCharacter: RecyclerView
    private lateinit var character: Character

    private val list = ArrayList<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvCharacter = findViewById(R.id.listCharacter)
        rvCharacter.setHasFixedSize(true)
        list.addAll(getListCharacter())
        showRecyclerList()


    }
    private fun getListCharacter(): ArrayList<Character> {
        val dataName = resources.getStringArray(R.array.data_name)

        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val fullDescription = resources.getStringArray(R.array.data_fullDeskripsi)
        val listCharacter = ArrayList<Character>()
        for (i in dataName.indices) {
            character = Character(dataName[i], fullDescription[i], dataPhoto.getResourceId(i, -1))

            listCharacter.add(character)
        }
        return listCharacter
    }
    private fun showRecyclerList() {
        rvCharacter.layoutManager = LinearLayoutManager(this)
        val listCharacterAdapter = CharacterAdapter(list)
        rvCharacter.adapter = listCharacterAdapter
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.klikProfile -> {

                val moveIntentProfile = Intent(this@MainActivity, profile::class.java)
                startActivity(moveIntentProfile)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}