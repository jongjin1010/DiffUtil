package com.jjoh.diffutil

import androidx.recyclerview.widget.DiffUtil

class MyDiffCallback : DiffUtil.ItemCallback<Human>() {
    override fun areItemsTheSame(oldItem: Human, newItem: Human): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: Human, newItem: Human): Boolean {
        return oldItem == newItem
    }
}