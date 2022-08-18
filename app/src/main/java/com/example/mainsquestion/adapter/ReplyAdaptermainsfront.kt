package com.example.mainsquestion.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mainsquestion.databinding.ReplylayoutBinding

import com.example.mainsquestion.Models.replymainsFrontModel

class replyAdapter (private val context: Context, private var List:List<replymainsFrontModel>) : RecyclerView.Adapter<replyAdapter.MyHolder>() {
    companion object{
        var size:Int=0
    }

    class MyHolder(
        binding: ReplylayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        var comm=binding.urcommtxt


        val root=binding.root



    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // inflates the card_view_design view
        // that is used to hold list item


        return MyHolder(ReplylayoutBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.comm.text=List[position].reply






        var i=0
    }




    // return the number of the items in the list
    override fun getItemCount(): Int {
        size =List.size

        return List.size
    }
    /* private fun setintetnonclickitem(ref:String,pos:Int)
     {
         val intent= Intent(context, commentActivity::class.java)
         intent.putExtra("index",pos)
         intent.putExtra("class",ref)
         ContextCompat.startActivity(context,intent,null)
     }*/
}