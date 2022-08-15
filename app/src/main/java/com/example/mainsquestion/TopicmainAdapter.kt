package com.example.socialapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mainsquestion.Address
import com.example.mainsquestion.databinding.SublayoutBinding
import com.example.mainsquestion.databinding.ActivityMainBinding
import com.example.mainsquestion.questionActivity


import kotlin.collections.ArrayList


class uploadAdapter (private val context: Context, private var musicList:List<Address>) : RecyclerView.Adapter<uploadAdapter.MyHolder>() {


    class MyHolder(
        binding: SublayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun getlikebuttonstatus(audioid: Int, userid: String) {


        }


        val title = binding.subtxtdis
        val root=binding.root




    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // inflates the card_view_design view
        // that is used to hold list item


        return MyHolder(SublayoutBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        holder.title.text = musicList[position].name

        holder.root.setOnClickListener {
            setintetnonclickitem(ref = "uploadAdapter", pos = position)
        }
    }




    // return the number of the items in the list
    override fun getItemCount(): Int {

        return musicList.size
    }
    private fun setintetnonclickitem(ref:String,pos:Int)
    {
        val intent= Intent(context, questionActivity::class.java)
        intent.putExtra("index",pos)
        intent.putExtra("class",ref)
        ContextCompat.startActivity(context,intent,null)
    }
}
