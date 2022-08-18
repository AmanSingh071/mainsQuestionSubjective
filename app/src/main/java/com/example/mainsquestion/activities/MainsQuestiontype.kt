package com.example.mainsquestion.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mainsquestion.activities.MainActivity.Companion.mainSubjectQuesListt
import com.example.mainsquestion.Models.mainSubjectiveQuestionModel
import com.example.mainsquestion.databinding.ActivityMainsQuestiontypeBinding
import com.example.mainsquestion.adapter.mainqQuestiontypeAdapter

class mainsQuestiontype : AppCompatActivity() {
    private lateinit var binding:  ActivityMainsQuestiontypeBinding
    var  position:Int=0
    lateinit var list:ArrayList<mainSubjectiveQuestionModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainsQuestiontypeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialiszelayout()
    }
    private fun  initialiszelayout() {
        position = intent.getIntExtra("index", 0)
        when (intent.getStringExtra("class")) {

            "uploadAdapter" -> {
                list = ArrayList()
                list.addAll(mainSubjectQuesListt)
                 list[position]

                if ( MainActivity.modelsdata[position].name.equals("aman") ) {

                    val linearLayoutManager = LinearLayoutManager(this)

                    val recyview = binding.mainssubrecy
                    val adapter = mainqQuestiontypeAdapter(this,  list)
                    recyview.adapter = adapter
                    recyview.layoutManager = linearLayoutManager
                }

                else if (MainActivity.datamo[questionActivity.position].name.equals("akshat") )
                {
                    val linearLayoutManager = LinearLayoutManager(this)

                    val recyview= binding.mainssubrecy
                    val adapter = mainqQuestiontypeAdapter(this,  list)
                    recyview.adapter = adapter
                    recyview.layoutManager=linearLayoutManager
                }






                //this will display name and song image


            }



        }
    }
}