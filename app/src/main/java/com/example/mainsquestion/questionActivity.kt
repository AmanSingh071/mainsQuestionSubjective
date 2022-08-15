package com.example.mainsquestion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mainsquestion.MainActivity.Companion.config2
import com.example.mainsquestion.MainActivity.Companion.datamo
import com.example.mainsquestion.MainActivity.Companion.modelsdata

import com.example.mainsquestion.databinding.ActivityMainBinding
import com.example.mainsquestion.databinding.SubtopicactivityBinding
import com.example.socialapp.uploadAdapter
import io.realm.Realm
import io.realm.mongodb.App
import io.realm.mongodb.AppConfiguration
import io.realm.mongodb.Credentials
import io.realm.mongodb.sync.SyncConfiguration

class questionActivity : AppCompatActivity() {
    companion object{
        var  position:Int=0
        lateinit var list:ArrayList<models>
    }
    var appid:String="mainsquestion-gbrkk"
    private lateinit var binding: SubtopicactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SubtopicactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)



        initialiszelayout()

    }
   private fun  initialiszelayout() {
         position = intent.getIntExtra("index", 0)
        when (intent.getStringExtra("class")) {

            "uploadAdapter" -> {
                list = ArrayList()
                list.addAll(modelsdata)
                list[position]

                if (datamo[position].name.equals("aman") )
                {

                    val linearLayoutManager = LinearLayoutManager(this)

                    val recyview= binding.subrecy
                    val adapter = subtopismainadapter(this, list)
                    recyview.adapter = adapter
                      recyview.layoutManager=linearLayoutManager
                }
                else if (datamo[position].name.equals("akshat") )
                {
                    val linearLayoutManager = LinearLayoutManager(this)

                    val recyview= binding.subrecy
                    val adapter = subtopismainadapter(this, list)
                    recyview.adapter = adapter
                    recyview.layoutManager=linearLayoutManager
                }






                //this will display name and song image


            }



        }
    }
}