package com.example.companies.ui.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class VerticalListItemDecoration(
    private val vertical: Int = 0,
    private val horizontal: Int = 0,
    private val betweenItem: Int = 0,
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        outRect.left = horizontal
        outRect.right = horizontal
        when (parent.getChildLayoutPosition(view)) {
            0 -> {
                outRect.top = vertical
                outRect.bottom = betweenItem
            }

            parent.adapter!!.itemCount - 1 -> {
                outRect.bottom = vertical
            }

            else -> {
                outRect.bottom = betweenItem
            }
        }
    }
}