package com.example.mainsquestion.adapter




import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mainsquestion.Models.commetnmodel
import com.example.mainsquestion.activities.replyActivity
import com.example.mainsquestion.databinding.CommentlayoutBinding


class commentAdapter (private val context: Context, private var List:List<commetnmodel>) : RecyclerView.Adapter<commentAdapter.MyHolder>() {
    companion object{
        var size:Int=0
    }

    class MyHolder(
        binding: CommentlayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun getlikebuttonstatus(audioid: Int, userid: String) {


        }
        var comm=binding.urcommtxt
        var reply=binding.replybtn


        val root=binding.root



    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // inflates the card_view_design view
        // that is used to hold list item


        return MyHolder(CommentlayoutBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.comm.text=List[position].comment

        holder.reply.setOnClickListener {

            setintetnonclickitem(ref = "uploadAdapter", pos = position)
        }






        var i=0
    }




    // return the number of the items in the list
    override fun getItemCount(): Int {
        size=List.size

        return List.size
    }
    private fun setintetnonclickitem(ref:String,pos:Int)
    {
        val intent= Intent(context, replyActivity::class.java)
        intent.putExtra("index",pos)
        intent.putExtra("class",ref)
        ContextCompat.startActivity(context,intent,null)
    }
}
