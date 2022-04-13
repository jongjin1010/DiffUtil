package com.jjoh.diffutil

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class MyItemTouchHelperCallback(private val recyclerview: RecyclerView) :
    ItemTouchHelper.SimpleCallback(
        ItemTouchHelper.UP or ItemTouchHelper.DOWN,
        ItemTouchHelper.LEFT
    ) {

        override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
        ): Boolean {
                (recyclerView.adapter as MyRecyclerViewAdapter).moveItem(
                        viewHolder.adapterPosition, // 위, 아래로 옮기면서 위치가 수시로 변경되기에 adapterPosition 사용
                        target.adapterPosition
                )
                return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                (recyclerview.adapter as MyRecyclerViewAdapter).removeItem(viewHolder.layoutPosition)
        }

        // 움직일시 투명도
        override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
                super.onSelectedChanged(viewHolder, actionState)
                when(actionState) {
                        ItemTouchHelper.ACTION_STATE_DRAG, ItemTouchHelper.ACTION_STATE_SWIPE -> {
                                (viewHolder as MyViewHolder).setAlpha(0.5f)
                        }
                }
        }

        override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
                super.clearView(recyclerView, viewHolder)
                (viewHolder as MyViewHolder).setAlpha(1.0f)
        }

}