package com.warm.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


public class FlowRadioGroup extends RadioGroup {

    /**
     * 横向间隙
     */
    private int spaceH;

    /**
     * 纵向间隙
     */
    private int spaceV;

    /**
     * 设置默认多少列
     */
    private int horizontalSize;

    public FlowRadioGroup(Context context) {
        this(context, null);
    }

    public FlowRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.FlowRadioGroup, 0, 0);
        for (int i=0;i<array.getIndexCount();i++){
            int item=array.getIndex(i);
            if (item==R.styleable.FlowRadioGroup_horizontalSize){
                horizontalSize=array.getInt(item,0);
            }else if (item==R.styleable.FlowRadioGroup_spaceH){
                spaceH=array.getDimensionPixelSize(item,0);
            }else {
                spaceV=array.getDimensionPixelSize(item,0);
            }
        }
        array.recycle();

    }

    public int getHorizontalSize() {
        return horizontalSize;
    }

    public void setHorizontalSize(int horizontalSize) {
        this.horizontalSize = horizontalSize;
    }

    public int getSpaceH() {
        return spaceH;
    }

    public void setSpaceH(int spaceH) {
        this.spaceH = spaceH;
    }

    public int getSpaceV() {
        return spaceV;
    }

    public void setSpaceV(int spaceV) {
        this.spaceV = spaceV;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //获取宽度
        int maxWidth = MeasureSpec.getSize(widthMeasureSpec);

        int childCount = getChildCount();
        int x = getPaddingLeft() + getPaddingRight();
        int y = getPaddingTop() + getPaddingBottom();
        int row = 1;
        int widthUsed = x, heightUsed = y;

        for (int i = 0; i < childCount; i++) {
            final View child = getChildAt(i);
            if (child.getVisibility() != View.GONE) {
                ViewGroup.LayoutParams lp = child.getLayoutParams();
                if (lp instanceof MarginLayoutParams) {
                    measureChildWithMargins(child, widthMeasureSpec, widthUsed, heightMeasureSpec, heightUsed);
                } else {
                    measureChild(child, widthMeasureSpec, heightMeasureSpec);
                }
                // 此处增加onlayout中的换行判断，用于计算所需的高度
                x += child.getMeasuredWidth();
                x += spaceH;
                //计算每添加一个子空间时的宽度，如果当前计算的宽度大于了父控件的宽度，这就需要换行
                y = row * child.getMeasuredHeight();
                y += spaceV * (row - 1);
                heightUsed = y;
                if (x > maxWidth) {
                    row++;
                    x = getPaddingLeft() + getPaddingRight();
                }
                widthUsed = x;

            }
        }
        // 设置容器所需的宽度和高度
        setMeasuredDimension(maxWidth, y);
    }

    @Override
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();

        int itemWidth;
        int childWidthMeasureSpec;
        int childHeightMeasureSpec;

        if (horizontalSize != 0) {
            itemWidth = (MeasureSpec.getSize(parentWidthMeasureSpec) - (getPaddingLeft() + getPaddingRight() + lp.leftMargin + lp.rightMargin) - 2 * spaceH) / horizontalSize;
        } else {
            itemWidth = lp.width;
        }
        childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                getPaddingLeft() + getPaddingRight() + lp.leftMargin + lp.rightMargin
                        + widthUsed, itemWidth);
        childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                getPaddingTop() + getPaddingBottom() + lp.topMargin + lp.bottomMargin
                        + heightUsed, lp.height);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    @Override
    protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        final ViewGroup.LayoutParams lp = child.getLayoutParams();

        int itemWidth;

        int childWidthMeasureSpec;
        int childHeightMeasureSpec;

        if (horizontalSize != 0) {
            itemWidth = (MeasureSpec.getSize(parentWidthMeasureSpec) - 2 * spaceH) / horizontalSize;
        } else {
            itemWidth = lp.width;
        }
        childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                getPaddingLeft() + getPaddingRight(), itemWidth);


        childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                getPaddingTop() + getPaddingBottom(), lp.height);

        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (changed) {
            int groupWidth = getMeasuredWidth();
            int left = getPaddingLeft();
            int top = getPaddingTop();
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View item = getChildAt(i);
                if (item.getVisibility() != GONE) {
                    //判断当前行最后一个left+item.getMeasuredWidth()，是否大于父控件的宽度，如果大于换行
                    if (left + item.getMeasuredWidth() <= groupWidth - getPaddingRight()) {
                        //每次摆放完成后，+横向间隙
                        item.layout(left, top, left + item.getMeasuredWidth(), top + item.getMeasuredHeight());
                        left += item.getMeasuredWidth();
                        left += spaceH;
                    } else {
                        //行数++,+纵向间隙，left恢复为原来值
                        top += item.getMeasuredHeight();
                        top += spaceV;
                        left = getPaddingLeft();
                        item.layout(left, top, left + item.getMeasuredWidth(), top + item.getMeasuredHeight());
                        left += item.getMeasuredWidth();
                        left += spaceH;
                    }
                }
            }
        }

    }
}
