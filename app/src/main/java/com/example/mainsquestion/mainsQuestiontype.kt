package com.example.mainsquestion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mainsquestion.MainActivity.Companion.maindailyqList
import com.example.mainsquestion.databinding.ActivityMainsQuestiontypeBinding
import com.example.mainsquestion.databinding.SubtopicactivityBinding
import mainqQuestiontypeAdapter

class mainsQuestiontype : AppCompatActivity() {
    private lateinit var binding:  ActivityMainsQuestiontypeBinding
    var  position:Int=0
    lateinit var list:ArrayList<mainDailyModel>
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
                list.addAll(maindailyqList)
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