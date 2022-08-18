package com.example.mainsquestion.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mainsquestion.Models.Replymainssubjectivemains
import com.example.mainsquestion.Models.replymainsFrontModel

import com.example.mainsquestion.R
import com.example.mainsquestion.adapter.replyAdapter
import com.example.mainsquestion.adapter.replyAdaptermainssubjective
import com.example.mainsquestion.databinding.ActivityReplymainssubjectiveBinding

class replymainssubjective : AppCompatActivity() {
    var position:Int=0
    lateinit var replyList: List<Replymainssubjectivemains>
    private lateinit var binding: ActivityReplymainssubjectiveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityReplymainssubjectiveBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialiszelayout()
    }
    private fun  initialiszelayout() {
        position = intent.getIntExtra("index", 0)
        when (intent.getStringExtra("class")) {

            "uploadAdapter" -> {
                binding.sendreply.setOnClickListener {
                    var txt= binding.entreplytxt.text.toString()
                    MainActivity.realm?.executeTransaction { transactionRealm ->
                        transactionRealm.insert(Replymainssubjectivemains().apply { this.reply= txt.toString()
                            this.postid=position
                            this.userid= MainActivity.user2

                        }
                        )
                    }

                }
                MainActivity.realm?.executeTransaction {

                    replyList = it.where(Replymainssubjectivemains::class.java).equalTo("postid", position).and()
                        .equalTo("userid", MainActivity.user2).findAll()
                }
                var linearlayoutreply= LinearLayoutManager(this)

                val recyrevise1=binding.replysecrecy
                val adapterreivse1 = replyAdaptermainssubjective(this, replyList)
                recyrevise1.adapter = adapterreivse1
                recyrevise1.layoutManager= linearlayoutreply

            }



        }
    }
}