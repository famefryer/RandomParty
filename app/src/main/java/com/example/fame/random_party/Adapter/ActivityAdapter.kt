package com.example.fame.random_party.Adapter

import android.support.v7.widget.RecyclerView
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by fame on 24/5/2561.
 */
abstract class ActivityAdapter(val items : ArrayList<String>,val context:Context) :  RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return RecyclerView.ViewHolder(LayoutInflater.from(context).inflate())
    }
}