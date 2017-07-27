package com.jaychang.widget.stb;

import android.content.Context;
import android.content.res.TypedArray;

class Utils {

  static int getAttrResourceId(Context context, int name) {
    int[] textSizeAttr = new int[]{name};
    TypedArray a = context.obtainStyledAttributes(textSizeAttr);
    int value = a.getResourceId(0, 0);
    a.recycle();
    return value;
  }

  static int getAttrDimensionPixelSize(Context context, int name) {
    int[] textSizeAttr = new int[]{name};
    TypedArray a = context.obtainStyledAttributes(textSizeAttr);
    int value = a.getDimensionPixelSize(0, 0);
    a.recycle();
    return value;
  }
}
