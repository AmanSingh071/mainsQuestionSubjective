package com.example.mainsquestion.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mainsquestion.Models.replymainsFrontModel
import com.example.mainsquestion.adapter.replyAdapter
import com.example.mainsquestion.databinding.ReplyactivitymainfrontBinding

class replyActivity : AppCompatActivity() {
    var position:Int=0
    lateinit var replyList: List<replymainsFrontModel>
    private lateinit var binding: ReplyactivitymainfrontBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ReplyactivitymainfrontBinding.inflate(layoutInflater)
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
                        transactionRealm.insert(replymainsFrontModel().apply { this.reply= txt.toString()
                            this.postid=position
                            this.userid= MainActivity.user2

                        }
                        )
                    }

                }
                MainActivity.realm?.executeTransaction {

                    replyList = it.where(replymainsFrontModel::class.java).equalTo("postid", position).and()
                        .equalTo("userid", MainActivity.user2).findAll()
                }
                var linearlayoutreply= LinearLayoutManager(this)

                val recyrevise1=binding.replysecrecy
                val adapterreivse1 = replyAdapter(this, replyList)
                recyrevise1.adapter = adapterreivse1
                recyrevise1.layoutManager= linearlayoutreply

            }



        }
    }
}