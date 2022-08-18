package com.example.mainsquestion.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mainsquestion.activities.MainActivity.Companion.realmano
import com.example.mainsquestion.activities.MainActivity.Companion.user2
import com.example.mainsquestion.Models.commetnmodel
import com.example.mainsquestion.adapter.commentAdapter
import com.example.mainsquestion.databinding.ActivityCommentactivityBinding

class activitycomment : AppCompatActivity() {
    private lateinit var binding: ActivityCommentactivityBinding

    var position:Int=0
    lateinit var messageList: List<commetnmodel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityCommentactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialiszelayout()
    }
    private fun  initialiszelayout() {
         position = intent.getIntExtra("index", 0)
        when (intent.getStringExtra("class")) {

            "uploadAdapter" -> {
                binding.sendcomm.setOnClickListener {
                    var txt= binding.entcommtxt.text.toString()
                    realmano?.executeTransaction { transactionRealm ->
                        transactionRealm.insert(commetnmodel().apply { this.comment= txt.toString()
                            this.postid=position
                            this.userid=user2

                        }
                        )
                    }


                }
                realmano ?.executeTransaction {

                    messageList = it.where(commetnmodel::class.java).equalTo("postid", position).findAll()
                }
                var linearlayoutcomment= LinearLayoutManager(this)

                val recyrevise1=binding.commentsecrecy
                val adapterreivse1 = commentAdapter(this, messageList)
                recyrevise1.adapter = adapterreivse1
                recyrevise1.layoutManager= linearlayoutcomment


            }

        }

    }
}