package com.example.mainsquestion.adapter





import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mainsquestion.Address
import com.example.mainsquestion.databinding.ReviseoceptlayoutBinding


class reviseConceptAdapter (private val context: Context, private var musicList:List<Address>) : RecyclerView.Adapter<reviseConceptAdapter.MyHolder>() {


    class MyHolder(
        binding: ReviseoceptlayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun getlikebuttonstatus(audioid: Int, userid: String) {


        }


        val title = binding.revtxt
        val root=binding.root




    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // inflates the card_view_design view
        // that is used to hold list item


        return MyHolder(ReviseoceptlayoutBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        holder.title.text = musicList[position].name


    }




    // return the number of the items in the list
    override fun getItemCount(): Int {

        return musicList.size
    }

}
