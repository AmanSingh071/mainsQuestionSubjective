package com.example.mainsquestion

import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmField
import java.util.*

open class models :io.realm.RealmObject() {
    @PrimaryKey
    @RealmField("_id")
    var id: String? = UUID.randomUUID().toString()
    var name:String=""
    var pos:Int?=null

}