package com.ls.entertainmentbox.app.widget

import android.annotation.TargetApi
import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.TextUtils
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.annotation.StyleRes
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.ls.entertainmentbox.R


/**
 * 自定义toolbar
 */
class CustomToolBar : FrameLayout {

    private lateinit var toolBar: Toolbar
    private lateinit var toolBarTitle: AppCompatTextView

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet) {
        val view = LayoutInflater.from(context).inflate(R.layout.toolbar_layout_custom, this)
        toolBar = view.findViewById(R.id.toolBar)
        toolBar.title = ""
        toolBarTitle = view.findViewById(R.id.toolbarTitle)
    }

    fun setCenterTitle(titleStr: String) {
        toolBarTitle.text = titleStr
    }

    fun setCenterTitle(titleResId: Int) {
        toolBarTitle.text = context.getString(titleResId)
    }

    fun setCenterTitleColor(colorResId: Int) {
        toolBarTitle.setTextColor(colorResId)
    }

    fun setToolbarBackGround(colorResId: Int) {
        toolBar.setBackgroundColor(colorResId)
    }

    fun getBaseToolBar(): Toolbar {
        return toolBar
    }
}