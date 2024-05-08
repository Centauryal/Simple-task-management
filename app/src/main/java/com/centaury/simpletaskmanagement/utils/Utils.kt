package com.centaury.simpletaskmanagement.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

object Utils {
    fun toggleEmptyState(
        size: Int,
        emptyState: View,
        recyclerView: RecyclerView,
    ) {
        if (size > 0) {
            emptyState.gone()
            recyclerView.visible()
        } else {
            recyclerView.gone()
            emptyState.visible()
        }
    }

    class TopItemDecoration(private val spacing: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State,
        ) {
            val position = parent.getChildAdapterPosition(view) // item position
            if (position == 0) {
                outRect.top = spacing
            }
        }
    }
}