package com.example.mainsquestion.adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mainsquestion.Models.likesmainsubjectiveModel
import com.example.mainsquestion.Models.mainSubjectiveQuestionModel
import com.example.mainsquestion.R
import com.example.mainsquestion.activities.Commentsubjectivemains
import com.example.mainsquestion.activities.MainActivity
import com.example.mainsquestion.activities.mainsQuestiontype
import com.example.mainsquestion.databinding.MainsquestiontypelayoutBinding
import com.example.mainsquestion.likes
import io.realm.Realm


class mainqQuestiontypeAdapter (private val context: Context, private var List:List<mainSubjectiveQuestionModel>) : RecyclerView.Adapter<mainqQuestiontypeAdapter.MyHolder>() {
companion object{
    var size:Int=0
}

    class MyHolder(
        binding: MainsquestiontypelayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun getlikebuttonstatus(audioid: Int, userid: String) {


        }

        val question = binding.questionmainsubtxt
        val topic = binding.topictxt
        var submit=binding.submitans
        var ansTxt=binding.anstxt
        var urans=binding.urans
        var likes=binding.likes
        var liketxt=binding.likecount
        var comm=binding.comment


        var likeclick:Boolean=false

        val root=binding.root



    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // inflates the card_view_design view
        // that is used to hold list item


        return MyHolder(MainsquestiontypelayoutBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        holder.question.text = List[position].question
        holder.topic.text = List[position].topic
        holder.urans.text=List[position].ans
        var test:Boolean=true

        holder.submit.setOnClickListener {

            val realm: Realm = Realm.getInstance(MainActivity.config2)
            var i= List[position].uniqueid
            holder.urans.text=   holder.ansTxt.text.toString()

            realm.executeTransaction {
                    var txt=holder.ansTxt.text.toString()
                var j=3
                var us=it.where(mainSubjectiveQuestionModel::class.java).equalTo("uniqueid",position).findFirst()

                it.copyToRealmOrUpdate(us)?.apply { this.ans=txt }


            }
        }
        MainActivity.realmano?.executeTransaction {

            var us=it.where(likesmainsubjectiveModel::class.java).equalTo("postid",position).and().equalTo("userid",
                MainActivity.user2
            ).findFirstAsync()
            if (us.isValid()){

                holder.likes.setImageResource(R.drawable.ic_baseline_favorite_24)

            }

            else{     holder.likes.setImageResource(R.drawable.ic_baseline_favorite_border_24)

            }


            // items results now contains all matched objects (more than zero)


            var like = it.where(likesmainsubjectiveModel::class.java).equalTo("postid", position).count()
            holder.liketxt.text= like.toString()


        }



        holder.likes.setOnClickListener {
            if (test)
            {
                MainActivity.realmano?.executeTransaction {

                    var us = it.where(likesmainsubjectiveModel::class.java).equalTo("postid", position).and()
                        .equalTo("userid", MainActivity.user2).findFirst()
                    if (us!=null) {
                        var t=it.where(likesmainsubjectiveModel::class.java).equalTo("postid",position).and().equalTo("userid",
                            MainActivity.user2
                        ).findFirst()
                        if (t != null) {
                            t.deleteFromRealm()
                        }

                        holder.liketxt.text= (holder.liketxt.text.toString().toInt()-1).toString()
                        holder.likes.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                        test=false




                    } else {
                        it.insert(likesmainsubjectiveModel().apply {


                            this.userid = MainActivity.user2

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
                    it.insert(likesmainsubjectiveModel().apply {


                        this.userid = MainActivity.user2

                        this.postid = position
                    })

                    holder.liketxt.text=  (holder.liketxt.text.toString().toInt()+1).toString()
                    holder.likes.setImageResource(R.drawable.ic_baseline_favorite_24)
                    test=true
                }
            }





        }
        holder.comm.setOnClickListener {


            setintetnonclickcomm(ref = "uploadAdapter", pos = position)

        }

        var i=0
    }




    // return the number of the items in the list
    override fun getItemCount(): Int {
        size =List.size

        return List.size
    }

    private fun setintetnonclickcomm(ref:String,pos:Int)
    {
        val intent= Intent(context, Commentsubjectivemains::class.java)
        intent.putExtra("index",pos)
        intent.putExtra("class",ref)
        ContextCompat.startActivity(context,intent,null)
    }
}
