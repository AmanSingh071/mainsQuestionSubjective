package com.example.mainsquestion.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mainsquestion.Models.commetnmodel
import com.example.mainsquestion.Models.mainssubjectiveCommentModel
import com.example.mainsquestion.R
import com.example.mainsquestion.adapter.commentAdapter
import com.example.mainsquestion.adapter.commentAdaptersubjective
import com.example.mainsquestion.databinding.ActivityCommentactivityBinding
import com.example.mainsquestion.databinding.ActivityCommentsubjectivemainsBinding

class Commentsubjectivemains : AppCompatActivity() {
    var position:Int=0
    private lateinit var binding: ActivityCommentsubjectivemainsBinding
    lateinit var messageList: List<mainssubjectiveCommentModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityCommentsubjectivemainsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialiszelayout()
    }
    private fun  initialiszelayout() {
        position = intent.getIntExtra("index", 0)
        when (intent.getStringExtra("class")) {

            "uploadAdapter" -> {
                binding.sendcomm.setOnClickListener {
                    var txt= binding.entcommtxt.text.toString()
                    MainActivity.realmano?.executeTransaction { transactionRealm ->
                        transactionRealm.insert(mainssubjectiveCommentModel().apply { this.comment= txt.toString()
                            this.postid=position
                            this.userid= MainActivity.user2

                        }
                        )
                    }


                }
                MainActivity.realmano?.executeTransaction {

                    messageList = it.where(mainssubjectiveCommentModel::class.java).equalTo("postid", position).findAll()
                }
                var linearlayoutcomment= LinearLayoutManager(this)

                val recyrevise1=binding.commentsecrecy
                val adapterreivse1 = commentAdaptersubjective(this, messageList)
                recyrevise1.adapter = adapterreivse1
                recyrevise1.layoutManager= linearlayoutcomment


            }

        }

    }
}