package com.example.mainsquestion

import io.realm.RealmList
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import io.realm.annotations.RealmField
import io.realm.annotations.Required


import io.realm.kotlin.types.RealmObject
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.util.*


open class Address :io.realm.RealmObject() {
    @PrimaryKey
    @RealmField("_id")
    var id: String? = UUID.randomUUID().toString()
    var name:String=""


}


