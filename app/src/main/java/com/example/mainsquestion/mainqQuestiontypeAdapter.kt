


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mainsquestion.*
import com.example.mainsquestion.databinding.SublayoutBinding
import com.example.mainsquestion.databinding.ActivityMainBinding
import com.example.mainsquestion.databinding.MainsquestiontypelayoutBinding
import io.realm.Realm
import io.realm.kotlin.where


import kotlin.collections.ArrayList


class mainqQuestiontypeAdapter (private val context: Context, private var List:List<mainDailyModel>) : RecyclerView.Adapter<mainqQuestiontypeAdapter.MyHolder>() {
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
        holder.submit.setOnClickListener {

            val realm: Realm = Realm.getInstance(MainActivity.config2)
            var i= List[position].uniqueid

            realm.executeTransaction {
                    var txt=holder.ansTxt.text.toString()
                var j=3
                var us=it.where(mainSubjectiveQuestionModel::class.java).equalTo("uniqueid",position).findFirst()

                it.copyToRealmOrUpdate(us)?.apply { this.ans=txt }


            }
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
        val intent= Intent(context, mainsQuestiontype::class.java)
        intent.putExtra("index",pos)
        intent.putExtra("class",ref)
        ContextCompat.startActivity(context,intent,null)
    }
}
