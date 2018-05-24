package com.example.fame.random_party.data

import java.sql.Time

/**
 * Created by fame on 24/5/2561.
 */
class Activity_Data(var activity_name:String,var activity_location:String,var activity_time:String,var activity_detail:String,var activity_date:String) {
    var activity_img_name:String?=null;
    var participations : ArrayList<Profile> = ArrayList()

    public fun addParticipation(p:Profile){
        participations.add(p)
    }
    public fun getParticipationNumber() : Int{
        return participations.size
    }
    public fun setImgName(imgName:String){
        activity_img_name = imgName
    }
}
