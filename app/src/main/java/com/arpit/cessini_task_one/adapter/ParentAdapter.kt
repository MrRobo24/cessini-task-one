package com.arpit.cessini_task_one.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arpit.cessini_task_one.R
import com.arpit.cessini_task_one.model.ParentItem

class ParentAdapter(private val itemList: ArrayList<ParentItem>) :
    RecyclerView.Adapter<ParentAdapter.ParentViewHolder>() {

    var viewPool: RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool()

    class ParentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtParentTitle: TextView = view.findViewById(R.id.txtParentTitle)
        val rvChildItem: RecyclerView = view.findViewById(R.id.rvChildItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_parent_single_row, parent, false)

        return ParentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val currItem = itemList[position]
        holder.txtParentTitle.text = currItem.dptTitle

        val layoutManager = LinearLayoutManager(
            holder.rvChildItem.context,
            LinearLayoutManager.VERTICAL,
            false
        )

        layoutManager.initialPrefetchItemCount = currItem.childList.size

        val childAdapter = ChildAdapter(currItem.childList)
        holder.rvChildItem.layoutManager = layoutManager
        holder.rvChildItem.adapter = childAdapter
        holder.rvChildItem.setRecycledViewPool(viewPool)

        holder.txtParentTitle.setOnClickListener{
            if (holder.rvChildItem.isVisible) {
                holder.rvChildItem.visibility = View.GONE
            } else {
                holder.rvChildItem.visibility = View.VISIBLE
            }
        }
    }
}