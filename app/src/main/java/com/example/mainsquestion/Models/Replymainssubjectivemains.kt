package com.example.mainsquestion.Models

import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmField
import java.util.*

open class Replymainssubjectivemains :io.realm.RealmObject() {
    @PrimaryKey
    @RealmField("_id")
    var id: String? = UUID.randomUUID().toString()
    var reply:String?=""
    var userid:String?=""
    var postid:Int?=null


}