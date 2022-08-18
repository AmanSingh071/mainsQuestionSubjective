package com.example.mainsquestion.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mainsquestion.activities.MainActivity.Companion.datamo
import com.example.mainsquestion.activities.MainActivity.Companion.modelsdata
import com.example.mainsquestion.Models.models
import com.example.mainsquestion.adapter.subtopismainadapter

import com.example.mainsquestion.databinding.SubtopicactivityBinding

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