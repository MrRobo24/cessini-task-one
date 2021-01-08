package com.arpit.cessini_task_one.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arpit.cessini_task_one.R
import com.arpit.cessini_task_one.model.ChildItem

class ChildAdapter (val itemList: ArrayList<ChildItem>): RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {

    class ChildViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imgProfilePic: ImageView = view.findViewById(R.id.imgProfilePic)
        val txtProfileName: TextView = view.findViewById(R.id.txtProfileName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_child_single_row, parent, false)

        return ChildViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        val currItem: ChildItem = itemList[position]
        holder.txtProfileName.text = currItem.profileName
    }
}