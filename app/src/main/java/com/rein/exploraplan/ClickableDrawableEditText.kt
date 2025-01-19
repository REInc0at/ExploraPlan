package com.rein.exploraplan

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatEditText

class ClickableDrawableEditText : AppCompatEditText {

    private var drawableEndClickListener: DrawableEndClickListener? = null
    private var drawableEnd: Drawable? = null

    interface DrawableEndClickListener {
        fun onDrawableEndClick()
    }

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        // Get the drawableEnd and set its click listener
        drawableEnd = compoundDrawablesRelative[2] // Index 2 for drawableEnd
        setDrawableEndClickListener(object : DrawableEndClickListener {
            override fun onDrawableEndClick() {
                // Handle the drawableEnd click event here
                drawableEndClickListener?.onDrawableEndClick()
            }
        })
    }

    fun setDrawableEndClickListener(listener: DrawableEndClickListener?) {
        drawableEndClickListener = listener
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_UP && drawableEnd != null) {
            val x = event.x.toInt()
            val y = event.y.toInt()
            if (x >= width - paddingRight - drawableEnd!!.bounds.width()
                && x <= width - paddingRight
                && y >= (height - drawableEnd!!.bounds.height()) / 2
                && y <= (height + drawableEnd!!.bounds.height()) / 2
            ) {
                drawableEndClickListener?.onDrawableEndClick()
                return true
            }
        }
        return super.onTouchEvent(event)
    }

    // Override onSizeChanged to ensure correct drawableEnd position
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        updateDrawableEndPosition()
    }

    private fun updateDrawableEndPosition() {
        if (drawableEnd != null) {
            val top = (height - drawableEnd!!.bounds.height()) / 2
            val bottom = top + drawableEnd!!.bounds.height()
            val left = width - paddingRight - drawableEnd!!.bounds.width()
            val right = width - paddingRight

            drawableEnd!!.setBounds(left, top, right, bottom)
        }
    }

    override fun onTextChanged(text: CharSequence?, start: Int, lengthBefore: Int, lengthAfter: Int) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
        // Update drawableEnd position when text changes
        updateDrawableEndPosition()
    }

    override fun drawableStateChanged() {
        super.drawableStateChanged()
        // Update drawableEnd position when state changes
        updateDrawableEndPosition()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // Draw the drawableEnd on the canvas
        drawableEnd?.draw(canvas)
    }
}