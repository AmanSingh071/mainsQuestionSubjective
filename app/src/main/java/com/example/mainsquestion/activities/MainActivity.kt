package com.example.mainsquestion.activities


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mainsquestion.Adapters.currentAffairAdapter
import com.example.mainsquestion.Models.currentAffair
import com.example.mainsquestion.databinding.CurrentaffairactivityBinding

import io.realm.Realm
import io.realm.mongodb.*
import io.realm.mongodb.mongo.MongoCollection
import io.realm.mongodb.mongo.MongoDatabase
import io.realm.mongodb.sync.SyncConfiguration
import org.bson.Document


class MainActivity  : AppCompatActivity() {
    var appid:String="mainsquestion-gbrkk"





    companion object{
            lateinit var currentaffairList: List<currentAffair>

        lateinit var config2:SyncConfiguration
        var user: User? = null
        var user2: User? = null

        var realm: Realm? =null
        var realmano: Realm? =null
        lateinit var app2: App
        var  i:Int?=0

    }

    private lateinit var binding: CurrentaffairactivityBinding

    val realmName: String = "main"





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CurrentaffairactivityBinding.inflate(layoutInflater)

        setContentView(binding.root)


Realm.init(this)





        val app: App = App(AppConfiguration.Builder(appid).build())
        var credentials: Credentials = Credentials.emailPassword("admin@gmail.com","aman123")

        app.loginAsync(credentials ,App.Callback { it ->
            if (it.isSuccess)
            {
                Log.e("User","Logged success")
                user = app.currentUser()



                var question:String="Which one of the following sculptures was invariably used\n"
                var topic:String="Society"
                var subtopic:String="Salient features of Indian society"
                var gs:String="GS1"
                var ans="Indian society is a pluralistic society with a complex social order characterized by a multitude of ethnic, linguistic, religious, and caste divisions. It comprises people living in rural, urban, tribal setting and all sections which carry the ethos of Indianness.\n" +
                        "Amid the complexities and so much diversity among the nation, widely accepted cultural themes, the feeling of oneness, brotherhood, and values of constitution binds individuals and enhance social harmony and order.\n" +
                        "After independence, several demands of the reorganization of states based on cultural similarity, linguistic identity, and others emerged from different parts of India.\n" +
                        "Though the government restructured various states and also formed new states, cultural units have been intact in India to this day.\n" +
                        "Indian society is an exemplification of multicultural, multi-ethnic and multi-ideological constructs, which co-exist, at once striving to strike harmony and also to retain its individuality"
                var title:String="Denying individuals matrimonial and other rights that emanate from matrimony solely for their sexual orientation is unjust and unconstitutional. Comment."







                config2 = SyncConfiguration.Builder(it.get(),it.get().id).allowWritesOnUiThread(true).allowQueriesOnUiThread(true).build()

                realmano  = Realm.getInstance(config2)


                recylerviewcall()

            /*    realmano?.executeTransaction { transactionRealm ->
                    transactionRealm.insert(currentAffair().apply { this.title=title

                        this.topic=topic
                        this.subtopic=subtopic
                        this.ans=ans
                        this.gs=gs

                        i=  currentaffairList.size

                        this.uniqueid=i

                    })
                }*/




            }



        }

        )



      var appid:String="mainsquestion-gbrkk"

          app2 = App(AppConfiguration.Builder(appid).build())
        var credentials2: Credentials = Credentials.emailPassword("akshatamanakshat@gmail.com","aman123")
        app2.loginAsync(credentials2 , App.Callback {
            if (it.isSuccess)
            {
                Log.e("User","Logged success")
                 user2 = app2.currentUser()


           var config3 = SyncConfiguration.Builder(it.get(),it.get().id).allowWritesOnUiThread(true).allowQueriesOnUiThread(true).build()

                  realm = Realm.getInstance(config3)


            }
        })



    }

    private fun recylerviewcall() {
        var realmano= Realm.getInstance(config2)

        currentaffairList =   realmano.where(currentAffair::class.java)!!.findAll()


        //currentaffair recycler view

        var topiclinearlayout= LinearLayoutManager(this)
        val recyviewtopic=binding.recy
        val adaptertopic = currentAffairAdapter(this, currentaffairList)
        recyviewtopic.adapter = adaptertopic
        recyviewtopic.layoutManager=topiclinearlayout
    }

    fun send(user2: User?): User? {
          return user2
      }



}




