package com.example.mainsquestion.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mainsquestion.Models.currentAffair
import com.example.mainsquestion.R
import com.example.mainsquestion.databinding.CurrentaffairactivityBinding
import com.example.mainsquestion.databinding.CurrentaffairshowmoreBinding
class currentAffairshowmore : AppCompatActivity() {

    var  position:Int=0
    lateinit var list:List<currentAffair>
    private lateinit var binding: CurrentaffairshowmoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CurrentaffairshowmoreBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initialiszelayout()
    }
    private fun  initialiszelayout() {
        position = intent.getIntExtra("index", 0)
        when (intent.getStringExtra("class")) {

            "uploadAdapter" -> {
                list = ArrayList()

                MainActivity.realmano?.executeTransaction {

                    list= it.where(currentAffair::class.java).findAll()

                }
               binding.titletxt.text= list[position].title
                binding.topictxt.text= list[position].topic
                binding.subtopictxt.text= list[position].subtopic
                binding.anstxt.text= list[position].ans
            }
        }
    }
}