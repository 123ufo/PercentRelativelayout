package com.example.customviewgroup2.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.customviewgroup2.R;

/**
 * Created by Administrator on 2015/6/7.
 */
public class PercentRelativeLayout extends RelativeLayout {


    public PercentRelativeLayout(Context context) {
        super(context);
    }

    public PercentRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PercentRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //1获取当前控件的大小
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        //获取所有子控件，拿到它的layoutparams对象，这样就可以拿到他的自定义属性
        //如 percentWidth,percentHeight，通过这个浮点数的百分比与当前的ViewGroup的
        //宽高相乘就可以计算出子View的宽高大小
        int childCount = this.getChildCount();

        for (int i = 0; i < childCount; i++) {
            View child = this.getChildAt(i);
            ViewGroup.LayoutParams lp = child.getLayoutParams();

            float percentWidth = 0;
            float percentHeight = 0;
            if (lp instanceof PercentRelativeLayout.LayoutParams) {
                percentWidth = ((PercentRelativeLayout.LayoutParams) lp).getPercentWidth();
                percentHeight = ((PercentRelativeLayout.LayoutParams) lp).getPercentHeight();
            }

            if (percentWidth != 0) {
                lp.width = (int) (width * percentWidth);
            }
            if (percentHeight != 0) {
                lp.height = (int) (height * percentHeight);
            }
//            child.setLayoutParams(lp);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    /**
     * 在这里把我们自定义的layoutparams对象返回去。此方法会在onMeasure之前调用
     * @param attrs
     * @return
     */
    @Override
    public RelativeLayout.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new PercentRelativeLayout.LayoutParams(getContext(),attrs);
    }

    /**
     * 自定义LayoutParams
     */
    class LayoutParams extends RelativeLayout.LayoutParams {

        private float mPercentWidth;
        private float mPercentHeight;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray typedArray = c.obtainStyledAttributes(attrs, R.styleable.PercentRelativeLayout);
            mPercentWidth = typedArray.getFloat(R.styleable.PercentRelativeLayout_percentWidth, 0);
            mPercentHeight = typedArray.getFloat(R.styleable.PercentRelativeLayout_percentHeight, 0);
            typedArray.recycle();
        }

        public LayoutParams(int w, int h) {
            super(w, h);
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }

        public LayoutParams(MarginLayoutParams source) {
            super(source);
        }

        public LayoutParams(RelativeLayout.LayoutParams source) {
            super(source);
        }

        public float getPercentWidth() {
            return mPercentWidth;
        }

        public void setPercentWidth(float percentWidth) {
            mPercentWidth = percentWidth;
        }

        public float getPercentHeight() {
            return mPercentHeight;
        }

        public void setPercentHeight(float percentHeight) {
            mPercentHeight = percentHeight;
        }
    }
}
