package com.example.mainsquestion.Models

import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmField
import java.util.*

open class mainSubjectiveQuestionModel :io.realm.RealmObject() {
    @PrimaryKey
    @RealmField("_id")
    var id: String? = UUID.randomUUID().toString()
    var uniqueid:Int?=null
    var question:String=""
    var topic:String=""
    var ans:String=""




}