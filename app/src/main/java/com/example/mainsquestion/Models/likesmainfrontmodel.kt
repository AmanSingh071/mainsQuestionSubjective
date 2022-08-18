package com.example.mainsquestion

import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmField
import java.util.*


open class likes :io.realm.RealmObject() {
    @PrimaryKey
    @RealmField("_id")
    var id: String? = UUID.randomUUID().toString()
    var postid:Int?=null
    var userid:String=""


}