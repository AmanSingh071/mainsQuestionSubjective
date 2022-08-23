package com.example.mainsquestion.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mainsquestion.Models.currentAffair
import com.example.mainsquestion.databinding.CurrentaffairlayoutBinding

class currentAffairAdapter (private val context: Context, private var List:List<currentAffair>) : RecyclerView.Adapter<currentAffairAdapter.MyHolder>() {


    class MyHolder(
        binding: CurrentaffairlayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        val title = binding.titletxt
        val topic = binding.topictxt
        val subtopic = binding.subtopictxt
        val ans = binding.anstxt


    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        return MyHolder(CurrentaffairlayoutBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        holder.title.text = List[position].title
        holder.topic.text = List[position].topic
        holder.subtopic.text = List[position].subtopic
        holder.ans.text = List[position].ans

      /*  holder.root.setOnClickListener {
            setintetnonclickitem(ref = "uploadAdapter", pos = position)
        }*/
    }




    // return the number of the items in the list
    override fun getItemCount(): Int {

        return List.size
    }
  /*  private fun setintetnonclickitem(ref:String,pos:Int)
    {
        val intent= Intent(context, questionActivity::class.java)
        intent.putExtra("index",pos)
        intent.putExtra("class",ref)
        ContextCompat.startActivity(context,intent,null)
    }*/
}