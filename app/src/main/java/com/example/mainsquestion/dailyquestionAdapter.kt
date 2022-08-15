package com.example.mainsquestion







import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mainsquestion.Address
import com.example.mainsquestion.MainActivity.Companion.config2
import com.example.mainsquestion.MainActivity.Companion.user2

import com.example.mainsquestion.databinding.DailyquestionlayoutBinding
import com.example.mainsquestion.databinding.ActivityMainBinding
import com.example.mainsquestion.questionActivity
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.mongodb.App
import io.realm.mongodb.AppConfiguration
import io.realm.mongodb.Credentials
import io.realm.mongodb.User
import io.realm.mongodb.sync.SyncConfiguration
import java.util.*
import javax.security.auth.callback.Callback


import kotlin.collections.ArrayList


class dailyquestionAdapter (private val context: Context, private var List:List<mainDailyModel>) : RecyclerView.Adapter<dailyquestionAdapter.MyHolder>() {


    class MyHolder(
        binding: DailyquestionlayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun getlikebuttonstatus(audioid: Int, userid: String) {


        }


        val question = binding.questiontxt
        val topic = binding.topictxt
        var likes=binding.likes
        var liketxt=binding.likecount
        var likeclick:Boolean=false

        val root=binding.root




    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // inflates the card_view_design view
        // that is used to hold list item


        return MyHolder(DailyquestionlayoutBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        holder.question.text = List[position].question
        holder.topic.text = List[position].topic
        holder.liketxt.text= List[position].likes.toString()
        var i=0

        lateinit var config3:SyncConfiguration
        holder.likes.setOnClickListener {

        }



    }




    // return the number of the items in the list
    override fun getItemCount(): Int {

        return List.size
    }

}

