package com.example.mainsquestion


import android.app.DownloadManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mainsquestion.databinding.ActivityMainBinding
import com.example.mainsquestion.databinding.ActivityMainsQuestiontypeBinding
import com.example.socialapp.uploadAdapter
import com.mongodb.BasicDBObject
import com.mongodb.client.model.Filters.eq
import com.mongodb.client.model.Updates
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.internal.interop.OBJECT_ID_BYTES_SIZE
import io.realm.mongodb.*
import io.realm.mongodb.mongo.MongoClient
import io.realm.mongodb.mongo.MongoCollection
import io.realm.mongodb.mongo.MongoDatabase
import io.realm.mongodb.mongo.iterable.MongoCursor
import io.realm.mongodb.sync.SyncConfiguration
import io.realm.mongodb.sync.SyncSession
import mainqQuestiontypeAdapter.Companion.size
import org.bson.Document
import org.bson.conversions.Bson
import org.bson.types.ObjectId
import org.litote.kmongo.MongoOperator
import java.util.*


class MainActivity  : AppCompatActivity() {
    var appid:String="mainsquestion-gbrkk"

    private lateinit var adapter:uploadAdapter
    private lateinit var binding2: ActivityMainsQuestiontypeBinding


    companion object{
            lateinit var datamo: List<Address>
        lateinit var maindailyqList: List<mainDailyModel>
        lateinit var mainSubjectQuesListt: List<mainSubjectiveQuestionModel>
        lateinit var modelsdata: List<models>
        lateinit var config2:SyncConfiguration
        lateinit var config3:SyncConfiguration
        var  i:Int?=0
        var user2: User? = null

    }
    var user: User? = null
    var mongoclient  =null
     var mongoDatabase:MongoDatabase?=null
    lateinit var mongoCollection:MongoCollection<Document>

    private lateinit var binding: ActivityMainBinding

    val realmName: String = "main"

    var list= arrayListOf<Address>()

    lateinit var realm:Realm


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding2 =  ActivityMainsQuestiontypeBinding.inflate(layoutInflater)
        setContentView(binding.root)


Realm.init(this)





        val app: App = App(AppConfiguration.Builder(appid).build())

        app.loginAsync(Credentials.anonymous() ,App.Callback { it ->
            if (it.isSuccess)
            {
                Log.e("User","Logged success")
                user =app.currentUser()



                var no:String="ffffwaf"
                var no2:Int=0
                var no22:String="aman"
                var no2222:Int=23333
                var question:String="Which one of the following sculptures was invariably used\n"
                var topic:String="History"






                  config2 = SyncConfiguration.Builder(it.get(),it.get().id).allowWritesOnUiThread(true).build()

                val realm: Realm = Realm.getInstance(config2)

               realm.executeTransactionAsync {
                   it.insert(Address().apply { this.name = no22 })

               }



                realm.executeTransaction { transactionRealm ->
                    transactionRealm.insert(models().apply { this.name=no22
                    this.pos=no2222})
                }




              datamo  = realm.where(Address::class.java).findAll()

                modelsdata = realm.where(models::class.java).findAll()
               maindailyqList = realm.where(mainDailyModel::class.java).findAll()
                 mainSubjectQuesListt = realm.where(mainSubjectiveQuestionModel::class.java).findAll()

                //topic recycler view

               var topiclinearlayout= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

                val recyviewtopic=binding.recy
                val adaptertopic = uploadAdapter(this,datamo)
                recyviewtopic.adapter = adaptertopic
                recyviewtopic.layoutManager=topiclinearlayout

                //revise recycler view
                var linearlayoutrevise= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

                val recyrevise=binding.reviserecy
                val adapterreivse = reviseConceptAdapter(this, datamo)
                recyrevise.adapter = adapterreivse
                recyrevise.layoutManager= linearlayoutrevise
                //daily recyler View


                var linearlayoutrevise2= LinearLayoutManager(this)

                val recyrevise1=binding.dailyquesrecy
                val adapterreivse1 = dailyquestionAdapter(this, maindailyqList)
                recyrevise1.adapter = adapterreivse1
                recyrevise1.layoutManager= linearlayoutrevise2



                   realm.executeTransaction { transactionRealm ->
                    transactionRealm.insert(mainDailyModel().apply { this.question=question
                        i= binding.dailyquesrecy.adapter?.itemCount!!

                        this.uniqueid=i

                        this.topic=topic
                        this.likes=no2
                    })
                }
                realm.executeTransaction { transactionRealm ->
                    transactionRealm.insert(mainSubjectiveQuestionModel().apply { this.question=question
                        i=  mainSubjectQuesListt.size

                        this.uniqueid=i

                        this.topic=topic

                    })
                }





            }



        }

        )
        user?.logOut()

      var appid:String="mainsquestion-gbrkk"

        val app2: App = App(AppConfiguration.Builder(appid).build())
        var credentials2: Credentials = Credentials.emailPassword("akshatamanakshat@gmail.com","aman123")
        app2.loginAsync(credentials2 , App.Callback {
            if (it.isSuccess)
            {
                Log.e("User","Logged success")
                user2 =app2.currentUser()


                var no:String="ffffwaf"
                var no2:Int=0
                var no22:String="aman"
                var no2222:Int=23333
                var question:String="Which one of the following sculptures was invariably used\n"
                var topic:String="History"

                MainActivity.config3 = SyncConfiguration.Builder(it.get(),it.get().id).allowWritesOnUiThread(true).build()

                 val realm: Realm = Realm.getInstance(MainActivity.config3)



            /*    var mongoclient= user2?.getMongoClient("mongodb-atlas")
                mongoDatabase= mongoclient?.getDatabase("main")
                mongoCollection = mongoDatabase!!.getCollection("likes")
                var newuser:Document=Document().append("userid", user2.toString())
                mongoDatabase!!.getCollection("likes").updateOne(eq("postid",43),Updates.addToSet("userid",newuser))*/

            }
        })









     /*   app.emailPassword.registerUserAsync("aman180.com","vgvdfrgd",App.Callback {
            if (it.isSuccess)
            {
                Log.e("User","Added")
            }
            else{
                Log.e("User"," noy Added")

            }
        } )*/






      /*  if (user != null) {
            mongoclient= user!!.getMongoClient("mongodb-atlas")
        }
       mongoDatabase=mongoclient.getDatabase("main")*/
/*        mongoCollection = mongoDatabase.getCollection("questions")*/


/*
         var find:  RealmResultTask<MongoCursor<org.bson.Document>> = mongoCollection.find(queryfilter).iterator()
*/
        /*val client=KMongo.createClient()
        var databse=client.getDatabase("main")
        val col=databse.getCollection<datamodel>()
        col.insertMany(listOf(datamodel("aman",22), datamodel("arpit",44)))
        suspend  fun add(data:datamodel):datamodel{
            col.insertOne(data)
            return data
        }
        suspend fun getdata():List<datamodel> = col.find().toList()
        suspend fun getdatabyid(userid:String):List<datamodel>{
            return col.find(datamodel::userid eq userid).toList()
        }*/



      /*var listme:ArrayList<Address> = ArrayList()
        find.getAsync {
            if(it.isSuccess)
            {
               var result: MongoCursor<org.bson.Document> = it.get()
                while(result.hasNext())
                {
                    var re:org.bson.Document=result.next()
                    list.add(re)

                }


            }
            else
            {

            }

        }*/

      /*  val config2 = SyncConfiguration.Builder(user,"id").allowWritesOnUiThread(true)
            .build()
        val realm: Realm = Realm.getInstance(config2)*/
      /*  val datamo: List<Address> = realm.where(Address::class.java).findAll()

                for (i in datamo.indices){
                    binding.textdis.setText(datamo[i].id)
                }*/


/*
        val layoutManager =LinearLayoutManager(this@MainActivity)
        val recyview=findViewById<RecyclerView>(R.id.recy)
        val adapter = ExampleRecyclerViewAdapter(datamo)
        recyview.adapter = adapter
        recyview.layoutManager=layoutManager*/
      /*
        val layoutManager =LinearLayoutManager(this@MainActivity)
        adapter = uploadAdapter(this,list)
        recyview.adapter=adapter
        recyview.layoutManager=layoutManager*/
     /* mongoCollection.findOne(queryfilter).getAsync {
            if (it.isSuccess)

            {
                var res:org.bson.Document=it.get()
                txt.setText(res.getString("data"))
                Toast.makeText(this@MainActivity,"success", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this@MainActivity,"fail",Toast.LENGTH_SHORT).show()

            }
        }*/

       /* val recyclerView = RecyclerView(this)
        recyclerView.layoutManager =
            LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.addItemDecoration(
            DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL)
        )
// create an adapter with a RealmResults collection
// and attach it to the RecyclerView

        val adapter = ExampleRecyclerViewAdapter(realm.where(datamodel::class.java).findAll())
        recyclerView.adapter = adapter
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
       this.addContentView(recyclerView, layoutParams)*/





    }





}




