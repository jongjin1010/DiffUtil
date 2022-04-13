package com.jjoh.diffutil

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jjoh.diffutil.databinding.LayoutViewholderBinding
import java.util.*

class MyRecyclerViewAdapter : ListAdapter<Human, RecyclerView.ViewHolder>(MyDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder = MyViewHolder(
            LayoutViewholderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // 해당되는 데이터와 ViewHolder 묶어주기

        if (holder is MyViewHolder) {
            val human = getItem(position) as Human
            holder.bind(human)
        }
    }

    fun moveItem(fromPosition: Int, toPosition: Int) {
        val newList = currentList.toMutableList() // 변경 가능한 형태로 변경
        Collections.swap(newList, fromPosition, toPosition)
        submitList(newList)
    }

    fun removeItem(position: Int) {
        val newList = currentList.toMutableList()
        newList.removeAt(position)
        submitList(newList)
    }


}