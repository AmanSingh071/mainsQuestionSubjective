package com.example.mainsquestion.Models

import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmField
import java.util.*

open class currentAffair :io.realm.RealmObject() {
    @PrimaryKey
    @RealmField("_id")
    var id: String? = UUID.randomUUID().toString()
    var title:String=""
    var uniqueid:Int?=null
    var topic:String=""
    var subtopic:String=""
    var gs:String=""
    var ans:String=""

}