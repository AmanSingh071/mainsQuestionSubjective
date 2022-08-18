package com.example.mainsquestion

import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmField
import java.util.*

open class mainDailyModel :io.realm.RealmObject() {
    @PrimaryKey
    @RealmField("_id")
    var id: String? = UUID.randomUUID().toString()
    var uniqueid:Int?=null
    var question:String=""
    var topic:String=""
    var likes:Int?=null
    var userid:String?=""

}