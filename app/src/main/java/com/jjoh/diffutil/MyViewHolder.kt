package com.jjoh.diffutil

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.jjoh.diffutil.databinding.LayoutViewholderBinding

class MyViewHolder(private val binding: LayoutViewholderBinding) : RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(data: Human) {
        with(binding) {
            tvName.text = data.name
            tvJob.text = "Job : ${data.job}"
            tvAge.text = "Age : ${data.age}"
            tvSex.text = data.sex

            layoutViewholder.setOnClickListener {
                Snackbar.make(it, "item $layoutPosition touched", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    fun setAlpha(alpha: Float) {
        with(binding) {

            tvName.alpha = alpha
            tvJob.alpha = alpha
            tvAge.alpha = alpha
            tvSex.alpha = alpha
        }
    }
}