package com.arpit.cessini_task_one

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arpit.cessini_task_one.model.ChildItem
import com.arpit.cessini_task_one.adapter.ParentAdapter
import com.arpit.cessini_task_one.databinding.ActivityMainBinding
import com.arpit.cessini_task_one.model.ParentItem


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val layoutManager: LinearLayoutManager = LinearLayoutManager(this)
        val parentAdapter: ParentAdapter = ParentAdapter(buildParentList())

        binding.rvParentItem.adapter = parentAdapter
        binding.rvParentItem.layoutManager = layoutManager
    }

    private fun buildParentList(): ArrayList<ParentItem> {
        val parentList: ArrayList<ParentItem> = ArrayList()
        for (i in 1..8) {
            val parentItem: ParentItem = ParentItem("Department Name $i", buildChildList())
            parentList.add(parentItem)
        }
        return parentList
    }

    private fun buildChildList(): ArrayList<ChildItem> {
        val childList: ArrayList<ChildItem> = ArrayList()
        for (i in 1..3) {
            val childItem: ChildItem = ChildItem("Employee Name $i")
            childList.add(childItem)
        }

        return childList
    }
}