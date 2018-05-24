package com.example.fame.random_party.data

/**
 * Created by fame on 24/5/2561.
 */

class Profile(val name:String,var about_me:String,var nickname:String) {
    var score:Double = 10.0
    var history : ArrayList<Activity_Data> = ArrayList()
    public fun addActivity(act:Activity_Data){
        history.add(act)
    }

}