package com.jaychang.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.annotation.ColorInt;
import android.support.annotation.Px;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jaychang.utils.AppUtils;

import static android.graphics.Color.WHITE;

public final class SimpleToolbar extends RelativeLayout {

  private ViewStub leftIconViewStub;
  private ViewStub leftTextViewStub;
  private ViewStub titleTextViewStub;
  private ViewStub rightTextViewStub;
  private ViewStub rightIconViewStub;
  private ViewStub rightIcon2ViewStub;
  private ViewStub rightIcon3ViewStub;
  private ViewStub rightIcon4ViewStub;
  private ViewStub rightIcon5ViewStub;
  private ImageButton leftIconView;
  private TextView leftTextView;
  private TextView titleTextView;
  private TextView rightTextView;
  private ImageButton rightIconView;
  private ImageButton rightIcon2View;
  private ImageButton rightIcon3View;
  private ImageButton rightIcon4View;
  private ImageButton rightIcon5View;
  private View rootView;

  private int leftIcon;
  private String leftText;
  private int leftTextSize;
  private int leftTextStyle;
  private int leftTextIcon;
  private int leftTextIconPosition;
  private ColorStateList leftTextColor;

  private String title;
  private int titleTextSize;
  private int titleTextStyle;
  private int titleTextIcon;
  private int titleTextIconPosition;
  private int titleTextGravity;
  private ColorStateList titleTextColor;

  private int rightIcon;
  private int rightIcon2;
  private int rightIcon3;
  private int rightIcon4;
  private int rightIcon5;
  private String rightText;
  private int rightTextSize;
  private int rightTextIcon;
  private int rightTextIconPosition;
  private int rightTextStyle;
  private ColorStateList rightTextColor;

  private ColorStateList simpleToolbarTitleTextColor;
  private int simpleToolbarTitleTextSize;
  private int simpleToolbarTitleTextStyle;
  private int simpleToolbarTitleTextGravity;
  private ColorStateList simpleToolbarTextColor;
  private int simpleToolbarTextSize;
  private int simpleToolbarTextStyle;
  private int simpleToolbarBackgroundColor;
  private int simpleToolbarHeight;

  public SimpleToolbar(Context context) {
    this(context, null);
  }

  public SimpleToolbar(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public SimpleToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    inflateViews(context);
    initAttrs(context, attrs, defStyleAttr);
    initViews();
  }

  private void inflateViews(Context context) {
    View view = LayoutInflater.from(context).inflate(R.layout.view_simpletoolbar, this);
    leftIconViewStub = (ViewStub) view.findViewById(R.id.leftIconStub);
    leftTextViewStub = (ViewStub) view.findViewById(R.id.leftTextStub);
    titleTextViewStub = (ViewStub) view.findViewById(R.id.titleStub);
    rightIconViewStub = (ViewStub) view.findViewById(R.id.rightIconStub);
    rightIcon2ViewStub = (ViewStub) view.findViewById(R.id.rightIcon2Stub);
    rightIcon3ViewStub = (ViewStub) view.findViewById(R.id.rightIcon3Stub);
    rightIcon4ViewStub = (ViewStub) view.findViewById(R.id.rightIcon4Stub);
    rightIcon5ViewStub = (ViewStub) view.findViewById(R.id.rightIcon5Stub);
    rightTextViewStub = (ViewStub) view.findViewById(R.id.rightTextStub);
    rootView = view.findViewById(R.id.rootView);
  }

  private void initAttrs(Context context, AttributeSet attrs, int defStyleAttr) {
    final int PIXEL_SIZE_17 = AppUtils.sp2px(getContext(), 17);
    final int PIXEL_SIZE_20 = AppUtils.sp2px(getContext(), 20);

    TypedArray typedArray = context.getTheme()
      .obtainStyledAttributes(attrs, R.styleable.SimpleToolbar, defStyleAttr, 0);

    leftIcon = typedArray.getResourceId(R.styleable.SimpleToolbar_stb_leftIcon, 0);
    leftText = typedArray.getString(R.styleable.SimpleToolbar_stb_leftText);
    leftTextSize = typedArray.getDimensionPixelSize(R.styleable.SimpleToolbar_stb_leftTextSize, PIXEL_SIZE_17);
    leftTextIcon = typedArray.getResourceId(R.styleable.SimpleToolbar_stb_leftTextIcon, 0);
    leftTextIconPosition = typedArray.getInt(R.styleable.SimpleToolbar_stb_leftTextIconPosition, 0);
    leftTextColor = typedArray.getColorStateList(R.styleable.SimpleToolbar_stb_leftTextColor);
    leftTextStyle = typedArray.getInt(R.styleable.SimpleToolbar_stb_leftTextStyle, 0);

    title = typedArray.getString(R.styleable.SimpleToolbar_stb_title);
    titleTextSize = typedArray.getDimensionPixelSize(R.styleable.SimpleToolbar_stb_titleTextSize, PIXEL_SIZE_20);
    titleTextIcon = typedArray.getResourceId(R.styleable.SimpleToolbar_stb_titleTextIcon, 0);
    titleTextIconPosition = typedArray.getInt(R.styleable.SimpleToolbar_stb_titleTextIconPosition, 0);
    titleTextColor = typedArray.getColorStateList(R.styleable.SimpleToolbar_stb_titleTextColor);
    titleTextStyle = typedArray.getInt(R.styleable.SimpleToolbar_stb_titleTextStyle, 0);
    titleTextGravity = typedArray.getInt(R.styleable.SimpleToolbar_stb_titleTextGravity, -1);

    rightIcon = typedArray.getResourceId(R.styleable.SimpleToolbar_stb_rightIcon, 0);
    rightIcon2 = typedArray.getResourceId(R.styleable.SimpleToolbar_stb_rightIcon2, 0);
    rightIcon3 = typedArray.getResourceId(R.styleable.SimpleToolbar_stb_rightIcon3, 0);
    rightIcon4 = typedArray.getResourceId(R.styleable.SimpleToolbar_stb_rightIcon4, 0);
    rightIcon5 = typedArray.getResourceId(R.styleable.SimpleToolbar_stb_rightIcon5, 0);
    rightText = typedArray.getString(R.styleable.SimpleToolbar_stb_rightText);
    rightTextSize = typedArray.getDimensionPixelSize(R.styleable.SimpleToolbar_stb_rightTextSize, PIXEL_SIZE_17);
    rightTextIcon = typedArray.getResourceId(R.styleable.SimpleToolbar_stb_rightTextIcon, 0);
    rightTextIconPosition = typedArray.getInt(R.styleable.SimpleToolbar_stb_rightTextIconPosition, 0);
    rightTextColor = typedArray.getColorStateList(R.styleable.SimpleToolbar_stb_rightTextColor);
    rightTextStyle = typedArray.getInt(R.styleable.SimpleToolbar_stb_rightTextStyle, 0);

    int[] globalStyleAttrs = new int[]{
      R.attr.simpleToolbarTitleTextColor,
      R.attr.simpleToolbarTitleTextSize,
      R.attr.simpleToolbarTitleTextStyle,
      R.attr.simpleToolbarTitleTextGravity,
      R.attr.simpleToolbarTextColor,
      R.attr.simpleToolbarTextSize,
      R.attr.simpleToolbarTextStyle,
      R.attr.simpleToolbarBackgroundColor,
      R.attr.simpleToolbarHeight
    };
    TypedArray ta = context.obtainStyledAttributes(globalStyleAttrs);
    simpleToolbarTitleTextColor = ta.getColorStateList(0);
    simpleToolbarTitleTextSize = ta.getDimensionPixelSize(1, PIXEL_SIZE_20);
    simpleToolbarTitleTextStyle = ta.getInt(2, 0);
    simpleToolbarTitleTextGravity = ta.getInt(3, -1);
    simpleToolbarTextColor = ta.getColorStateList(4);
    simpleToolbarTextSize = ta.getDimensionPixelSize(5, PIXEL_SIZE_17);
    simpleToolbarTextStyle = ta.getInt(6, 0);
    simpleToolbarBackgroundColor = ta.getResourceId(7, 0);
    simpleToolbarHeight = ta.getDimensionPixelSize(8, 0);
    ta.recycle();

    typedArray.recycle();
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    if (simpleToolbarHeight != 0) {
      rootView.getLayoutParams().height = simpleToolbarHeight;
    }
  }

  private void initViews() {
    initLeftIcon();
    initLeftText();
    initTitle();
    initRightIcon();
    initRightText();
    initBackground();
  }

  private void initLeftIcon() {
    if (leftIcon != 0) {
      setLeftIcon(leftIcon);
    }
  }

  private void initLeftText() {
    final int WHITE = ContextCompat.getColor(getContext(), android.R.color.white);

    if (!TextUtils.isEmpty(leftText)) {
      setLeftText(leftText);
    } else {
      return;
    }

    if (leftTextIcon != 0) {
      setLeftTextIcon(leftTextIcon);
    }

    if (leftTextColor != null) {
      setLeftTextColor(leftTextColor);
    } else if (simpleToolbarTextColor != null) {
      setLeftTextColor(simpleToolbarTextColor);
    } else {
      setLeftTextColor(WHITE);
    }

    if (leftTextStyle != 0) {
      setLeftTextStyle(leftTextStyle);
    } else if (simpleToolbarTextStyle != 0) {
      setLeftTextStyle(simpleToolbarTextStyle);
    }

    setLeftTextSize(leftTextSize);
    if (simpleToolbarTextSize != 0) {
      setLeftTextSize(simpleToolbarTextSize);
    }
  }

  private void initTitle() {
    if (!TextUtils.isEmpty(title)) {
      setTitle(title);
    } else {
      return;
    }

    if (titleTextIcon != 0) {
      setTitleTextIcon(titleTextIcon);
    }

    if (titleTextColor != null) {
      setTitleTextColor(titleTextColor);
    } else if (simpleToolbarTitleTextColor != null) {
      setTitleTextColor(simpleToolbarTitleTextColor);
    } else if (simpleToolbarTextColor != null) {
      setTitleTextColor(simpleToolbarTextColor);
    } else {
      setTitleTextColor(WHITE);
    }

    setTitleTextSize(titleTextSize);
    if (simpleToolbarTitleTextSize != 0) {
      setTitleTextSize(simpleToolbarTitleTextSize);
    }

    if (titleTextStyle != 0) {
      setTitleTextTypeface(titleTextStyle);
    } else if (simpleToolbarTitleTextStyle != 0) {
      setTitleTextTypeface(simpleToolbarTitleTextStyle);
    } else if (simpleToolbarTextStyle != 0) {
      setTitleTextTypeface(simpleToolbarTextStyle);
    }
  }

  private void initRightIcon() {
    if (rightIcon != 0) {
      setRightIcon(rightIcon);
    }
    if (rightIcon2 != 0) {
      setRightIcon2(rightIcon2);
    }
    if (rightIcon3 != 0) {
      setRightIcon3(rightIcon3);
    }
    if (rightIcon4 != 0) {
      setRightIcon4(rightIcon4);
    }
    if (rightIcon5 != 0) {
      setRightIcon5(rightIcon5);
    }
  }

  private void initRightText() {
    if (!TextUtils.isEmpty(rightText)) {
      setRightText(rightText);
    } else {
      return;
    }

    if (rightTextIcon != 0) {
      setRightTextIcon(rightTextIcon);
    }

    if (rightTextColor != null) {
      setRightTextColor(rightTextColor);
    } else if (simpleToolbarTextColor != null) {
      setRightTextColor(simpleToolbarTextColor);
    } else if (simpleToolbarTitleTextColor != null) {
      setRightTextColor(simpleToolbarTitleTextColor);
    } else {
      setRightTextColor(WHITE);
    }

    if (rightTextStyle != 0) {
      setRightTextStyle(rightTextStyle);
    } else if (simpleToolbarTextStyle != 0) {
      setRightTextStyle(simpleToolbarTextStyle);
    }

    setRightTextSize(rightTextSize);
    if (simpleToolbarTextSize != 0) {
      setRightTextSize(simpleToolbarTextSize);
    }
  }

  private void initBackground() {
    if (simpleToolbarBackgroundColor != 0) {
      setBackgroundResource(simpleToolbarBackgroundColor);
    } else {
      int colorPrimary = Utils.getAttrResourceId(getContext(), R.attr.colorPrimary);
      if (colorPrimary != 0) {
        setBackgroundResource(colorPrimary);
      }
    }
  }

  /**
   * title
   */
  public void setTitle(@StringRes int title) {
    setTitle(getResources().getString(title));
  }

  public void setTitle(CharSequence title) {
    titleTextView = (TextView) titleTextViewStub.inflate();
    titleTextView.setClickable(false);
    titleTextView.setText(title);

    if (simpleToolbarTitleTextGravity == 0){
      LayoutParams params = ((LayoutParams) titleTextView.getLayoutParams());
      params.leftMargin = AppUtils.dp2px(getContext(), 72 - 16);
    } else if (simpleToolbarTitleTextGravity == 1) {
      LayoutParams params = ((LayoutParams) titleTextView.getLayoutParams());
      params.addRule(RelativeLayout.CENTER_IN_PARENT);
      titleTextView.setLayoutParams(params);
    }

    if (titleTextGravity == 0) {
      alightTitleLeft();
    } else if (titleTextGravity == 1) {
      alightTitleCenter();
    } else if (simpleToolbarTitleTextGravity == 0){
      alightTitleLeft();
    } else if (simpleToolbarTitleTextGravity == 1) {
      alightTitleCenter();
    } else {
      alightTitleLeft();
    }
  }

  private void alightTitleLeft() {
    LayoutParams params = ((LayoutParams) titleTextView.getLayoutParams());
    params.leftMargin = AppUtils.dp2px(getContext(), 72 - 16);
  }

  private void alightTitleCenter() {
    LayoutParams params = ((LayoutParams) titleTextView.getLayoutParams());
    params.addRule(RelativeLayout.CENTER_IN_PARENT);
    titleTextView.setLayoutParams(params);
  }

  public void setTitleTextIcon(int titleTextIcon) {
    if (titleTextIconPosition == 0) {
      titleTextView.setCompoundDrawablesWithIntrinsicBounds(titleTextIcon, 0, 0, 0);
    } else {
      titleTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, titleTextIcon, 0);
    }
  }

  public void setTitleTextColor(@ColorInt int color) {
    titleTextView.setTextColor(color);
  }

  public void setTitleTextColor(ColorStateList colorStateList) {
    titleTextView.setTextColor(colorStateList);
  }

  public void setTitleTextTypeface(int typeface) {
    titleTextView.setTypeface(null, typeface);
  }

  public void setTitleTextSize(@Px int textSize) {
    titleTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
  }


  /**
   * left
   */
  public void setLeftText(int stringRes) {
    setLeftText(getResources().getString(stringRes));
  }

  public void setLeftText(CharSequence text) {
    leftTextView = (TextView) leftTextViewStub.inflate();
    leftTextView.setText(text);
  }

  public void setLeftTextIcon(int leftTextIcon) {
    if (leftTextIconPosition == 0) {
      leftTextView.setCompoundDrawablesWithIntrinsicBounds(leftTextIcon, 0, 0, 0);
    } else {
      leftTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, leftTextIcon, 0);
    }
  }

  public void setLeftTextColor(@ColorInt int color) {
    leftTextView.setTextColor(color);
  }

  public void setLeftTextColor(ColorStateList colorStateList) {
    leftTextView.setTextColor(colorStateList);
  }

  public void setLeftTextStyle(int style) {
    leftTextView.setTypeface(null, style);
  }

  public void setLeftIcon(int drawableRes) {
    leftIconView = (ImageButton) leftIconViewStub.inflate();
    leftIconView.setImageResource(drawableRes);
  }

  public void setLeftTextSize(@Px int textSize) {
    leftTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
  }

  public void setLeftTextIcon(int leftTextIcon, boolean isLeft) {
    this.leftTextIconPosition = isLeft ? 0 : 1;
    setLeftTextIcon(leftTextIcon);
  }


  /**
   * right
   */
  public void setRightText(int stringRes) {
    setRightText(getResources().getString(stringRes));
  }

  public void setRightText(CharSequence text) {
    rightTextView = (TextView) rightTextViewStub.inflate();
    rightTextView.setText(text);
  }

  public void setRightTextIcon(int rightTextIcon) {
    if (rightTextIconPosition == 0) {
      rightTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, rightTextIcon, 0);
    } else {
      rightTextView.setCompoundDrawablesWithIntrinsicBounds(rightTextIcon, 0, 0, 0);
    }
  }

  public void setRightTextIcon(int rightTextIcon, boolean isRight) {
    this.rightTextIconPosition = isRight ? 0 : 1;
    setRightTextIcon(rightTextIcon);
  }

  public void setRightTextColor(@ColorInt int color) {
    rightTextView.setTextColor(color);
  }

  public void setRightTextColor(ColorStateList colorStateList) {
    rightTextView.setTextColor(colorStateList);
  }

  public void setRightTextStyle(int style) {
    rightTextView.setTypeface(null, style);
  }

  public void setRightIcon(int drawableRes) {
    rightIconView = (ImageButton) rightIconViewStub.inflate();
    rightIconView.setImageResource(drawableRes);
  }

  public void setRightIcon2(int drawableRes) {
    rightIcon2View = (ImageButton) rightIcon2ViewStub.inflate();
    rightIcon2View.setImageResource(drawableRes);
  }

  public void setRightIcon3(int drawableRes) {
    rightIcon3View = (ImageButton) rightIcon3ViewStub.inflate();
    rightIcon3View.setImageResource(drawableRes);
  }

  public void setRightIcon4(int drawableRes) {
    rightIcon4View = (ImageButton) rightIcon4ViewStub.inflate();
    rightIcon4View.setImageResource(drawableRes);
  }

  public void setRightIcon5(int drawableRes) {
    rightIcon5View = (ImageButton) rightIcon5ViewStub.inflate();
    rightIcon5View.setImageResource(drawableRes);
  }

  public void setRightTextSize(@Px int textSize) {
    rightTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
  }


  /**
   * getters
   */
  public ImageView getLeftIconView() {
    return leftIconView;
  }

  public TextView getLeftTextView() {
    return leftTextView;
  }

  public TextView getTitleTextView() {
    return titleTextView;
  }

  public ImageView getRightIconView() {
    return rightIconView;
  }

  public TextView getRightTextView() {
    return rightTextView;
  }

}
