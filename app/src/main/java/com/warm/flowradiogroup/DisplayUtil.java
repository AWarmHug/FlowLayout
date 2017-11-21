package com.warm.flowradiogroup;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * dp、sp 转换为 px 的工具类
 */
public class DisplayUtil {

    /**
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getApplicationContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     *
     * @param context
     * @param dipValue
     * @return
     */
    public static int dp2px(Context context, float dipValue) {
        final float scale = context.getApplicationContext().getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getApplicationContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     *
     * @param context
     * @param spValue
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getApplicationContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 获取压缩后的bitmap
     * @param path
     * @param need_width
     * @param need_height
     * @return
     */
    public static Bitmap simpleBitmap(String path, int need_width, int need_height){
        //压缩和显示图片
        BitmapFactory.Options options = new BitmapFactory.Options();
        //负责加载图片但是不保存到内存中,
        options.inJustDecodeBounds = true;
        //设置图片质量
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        BitmapFactory.decodeFile(path, options);
        options.inSampleSize = getSampleSize(options, need_width, need_height);
        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeFile(path, options);
        return bitmap;
    }

    /**
     * 获取压缩后的bitmap的path
     * @param path
     * @param need_width
     * @param need_height
     * @return
     */
    public static String simpleBitmapPath(String path, int need_width, int need_height){
        //压缩和显示图片
        BitmapFactory.Options options = new BitmapFactory.Options();
        //负责加载图片但是不保存到内存中,
        options.inJustDecodeBounds = true;
        //设置图片质量
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        BitmapFactory.decodeFile(path, options);
        options.inSampleSize = getSampleSize(options, need_width, need_height);
//        options.inJustDecodeBounds = false;
//        Bitmap bitmap = BitmapFactory.decodeFile(path, options);
        return path;
    }



    /**
     * 根据图片的宽高,和imageview的宽高,计算出来的压缩比例
     *
     * @param options
     * @return
     */
    private static int getSampleSize(BitmapFactory.Options options, int width, int height) {
        int realWidth = options.outWidth;
        int realHeight = options.outHeight;
        int reqWidth;
        int reqHeight;
        if (realWidth > realHeight) {
            reqWidth = height;
            reqHeight = width;
        } else {
            reqWidth = width;
            reqHeight = height;

        }
        if (realWidth > reqWidth || realHeight > reqHeight) {
            //需要进行压缩;
            int widthSize = Math.round(realWidth / reqWidth);
            int heightSize = Math.round(realHeight / reqHeight);
            return widthSize > heightSize ? widthSize : heightSize;
        }
        return 1;
    }


}