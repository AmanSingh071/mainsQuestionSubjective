package com.example.mainsquestion.adapter







import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mainsquestion.*
import com.example.mainsquestion.activities.MainActivity
import com.example.mainsquestion.activities.MainActivity.Companion.user2
import com.example.mainsquestion.activities.activitycomment


import com.example.mainsquestion.databinding.DailyquestionlayoutBinding
import io.realm.mongodb.sync.SyncConfiguration


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
        var comm=binding.comment

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
        var test:Boolean=true

        var i=0
        var main: MainActivity?=null

        MainActivity.realmano?.executeTransaction {

            var us=it.where(likes::class.java).equalTo("postid",position).and().equalTo("userid", user2).findFirstAsync()
            if (us.isValid()){

                holder.likes.setImageResource(R.drawable.ic_baseline_favorite_24)

            }

            else{     holder.likes.setImageResource(R.drawable.ic_baseline_favorite_border_24)

            }


            // items results now contains all matched objects (more than zero)


            var like = it.where(likes::class.java).equalTo("postid", position).count()
            holder.liketxt.text= like.toString()


        }



        holder.likes.setOnClickListener {
            if (test)
            {
                MainActivity.realmano?.executeTransaction {

                    var us = it.where(likes::class.java).equalTo("postid", position).and()
                        .equalTo("userid", user2).findFirst()
                    if (us!=null) {
                         var t=it.where(likes::class.java).equalTo("postid",position).and().equalTo("userid", user2).findFirst()
                            if (t != null) {
                                t.deleteFromRealm()
                            }

                        holder.liketxt.text= (holder.liketxt.text.toString().toInt()-1).toString()
                        holder.likes.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                        test=false




                    } else {
                          it.insert(likes().apply {


                                this.userid =user2

                                this.postid = position
                            })

                        holder.liketxt.text=  (holder.liketxt.text.toString().toInt()+1).toString()
                        holder.likes.setImageResource(R.drawable.ic_baseline_favorite_24)
                        test=true



                    }
                }

            }
            else{
                MainActivity.realmano?.executeTransaction {
    it.insert(likes().apply {


        this.userid =user2

        this.postid = position
    })

    holder.liketxt.text=  (holder.liketxt.text.toString().toInt()+1).toString()
    holder.likes.setImageResource(R.drawable.ic_baseline_favorite_24)
    test=true
}
}





        }

        holder.comm.setOnClickListener {


                setintetnonclickitem(ref = "uploadAdapter", pos = position)

        }










        lateinit var config3:SyncConfiguration




    }




    // return the number of the items in the list
    override fun getItemCount(): Int {

        return List.size
    }
    private fun setintetnonclickitem(ref:String,pos:Int)
    {
        val intent= Intent(context, activitycomment::class.java)
        intent.putExtra("index",pos)
        intent.putExtra("class",ref)
        ContextCompat.startActivity(context,intent,null)
    }

}

