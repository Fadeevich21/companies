package com.example.companies.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import com.example.companies.R
import com.example.companies.databinding.CustomNavigationButtonBinding

class CustomNavigationButton(
    context: Context,
    attributeSet: AttributeSet
) : CardView(context, attributeSet) {

    private val binding =
        CustomNavigationButtonBinding.inflate(LayoutInflater.from(context), this, false)

    init {
        addView(binding.root)
        val typedArray = context.theme.obtainStyledAttributes(
            attributeSet,
            R.styleable.CustomNavigationButton,
            0,
            0
        )

        val title = typedArray.getString(R.styleable.CustomNavigationButton_android_title)
        setTitle(title = title)

        val subtitle = typedArray.getString(R.styleable.CustomNavigationButton_android_subtitle)
        setSubtitle(subtitle = subtitle)
    }

    fun setTitle(title: String?) {
        binding.title.text = title
    }

    fun setSubtitle(subtitle: String?) {
        binding.subtitle.text = subtitle
    }
}