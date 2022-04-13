package com.jjoh.diffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.jjoh.diffutil.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val dataSet = arrayListOf<Human>().apply {
        add(Human("신태윤", 17, "남자", Job.Student))
        add(Human("오종진", 17, "남자", Job.Developer))
        add(Human("진시윤", 17, "남자", Job.Developer))
        add(Human("노 혁", 17, "남자", Job.Developer))
        add(Human("선생님", 24, "여자", Job.Teacher))
    }

    private val myRecyclerViewAdapter: MyRecyclerViewAdapter by lazy {
        MyRecyclerViewAdapter()
    }

    override fun init() {
        binding.activity = this
        setRecyclerView()
        setTouch()
    }

    private fun setRecyclerView() {
        binding.rvList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = myRecyclerViewAdapter
        }
        myRecyclerViewAdapter.submitList(dataSet)
    }

    private fun setTouch() {
        val itemTouchHelperCallback = ItemTouchHelper(MyItemTouchHelperCallback(binding.rvList))
        itemTouchHelperCallback.attachToRecyclerView(binding.rvList)
    }

    fun shuffle(view: View) {
        myRecyclerViewAdapter.submitList(dataSet.shuffled())
    }
}