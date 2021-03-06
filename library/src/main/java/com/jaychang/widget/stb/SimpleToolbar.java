package com.jaychang.widget.stb;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
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

public final class SimpleToolbar extends RelativeLayout {

  private final int WHITE = ContextCompat.getColor(getContext(), android.R.color.white);

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
  private CharSequence leftText;
  private int leftTextSize;
  private int leftTextStyle;
  private String leftTextFont;
  private int leftTextIcon;
  private int leftTextIconPosition;
  private ColorStateList leftTextColor;

  private CharSequence title;
  private int titleTextSize;
  private int titleTextStyle;
  private String titleTextFont;
  private int titleTextIcon;
  private int titleTextIconPosition;
  private int titleTextGravity;
  private ColorStateList titleTextColor;
  private boolean isTitleSingleLine;

  private int rightIcon;
  private int rightIcon2;
  private int rightIcon3;
  private int rightIcon4;
  private int rightIcon5;
  private CharSequence rightText;
  private int rightTextSize;
  private int rightTextIcon;
  private int rightTextIconPosition;
  private int rightTextStyle;
  private String rightTextFont;
  private ColorStateList rightTextColor;

  private ColorStateList simpleToolbarTitleTextColor;
  private int simpleToolbarTitleTextSize;
  private int simpleToolbarTitleTextStyle;
  private String simpleToolbarTitleTextFont;
  private int simpleToolbarTitleTextGravity;
  private ColorStateList simpleToolbarTextColor;
  private int simpleToolbarTextSize;
  private int simpleToolbarTextStyle;
  private String simpleToolbarTextFont;
  private int simpleToolbarBackgroundColor;
  private int simpleToolbarHeight;
  private boolean simpleToolbarTitleSingleLine;
  private boolean isTitleComponentInited = true;
  private boolean isLeftComponentTextInited = true;
  private boolean isRightComponentTextInited = true;

  private Drawable backgroundDrawable;

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
    leftTextFont = typedArray.getString(R.styleable.SimpleToolbar_stb_leftTextFont);

    title = typedArray.getString(R.styleable.SimpleToolbar_stb_title);
    titleTextSize = typedArray.getDimensionPixelSize(R.styleable.SimpleToolbar_stb_titleTextSize, PIXEL_SIZE_20);
    titleTextIcon = typedArray.getResourceId(R.styleable.SimpleToolbar_stb_titleTextIcon, 0);
    titleTextIconPosition = typedArray.getInt(R.styleable.SimpleToolbar_stb_titleTextIconPosition, 0);
    titleTextColor = typedArray.getColorStateList(R.styleable.SimpleToolbar_stb_titleTextColor);
    isTitleSingleLine = typedArray.getBoolean(R.styleable.SimpleToolbar_stb_titleSingleLine, true);
    titleTextGravity = typedArray.getInt(R.styleable.SimpleToolbar_stb_titleTextGravity, -1);
    titleTextStyle = typedArray.getInt(R.styleable.SimpleToolbar_stb_titleTextStyle, 0);
    titleTextFont = typedArray.getString(R.styleable.SimpleToolbar_stb_titleTextFont);

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
    rightTextFont = typedArray.getString(R.styleable.SimpleToolbar_stb_rightTextFont);

    typedArray.recycle();

    // background attr
    int[] backgroundAttr = new int[] {
      android.R.attr.background
    };
    TypedArray bgTypeArray = context.obtainStyledAttributes(attrs, backgroundAttr);
    backgroundDrawable = bgTypeArray.getDrawable(0);
    bgTypeArray.recycle();

    // global attr
    int[] globalStyleAttrs = new int[]{
      R.attr.simpleToolbarTitleTextColor,
      R.attr.simpleToolbarTitleTextSize,
      R.attr.simpleToolbarTitleTextStyle,
      R.attr.simpleToolbarTitleTextGravity,
      R.attr.simpleToolbarTextColor,
      R.attr.simpleToolbarTextSize,
      R.attr.simpleToolbarTextStyle,
      R.attr.simpleToolbarBackgroundColor,
      R.attr.simpleToolbarHeight,
      R.attr.simpleToolbarTitleSingleLine,
      R.attr.simpleToolbarTitleTextFont,
      R.attr.simpleToolbarTextFont
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
    simpleToolbarTitleSingleLine = ta.getBoolean(9, false);
    simpleToolbarTitleTextFont = ta.getString(10);
    simpleToolbarTextFont = ta.getString(11);
    ta.recycle();
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
    if (!TextUtils.isEmpty(leftText)) {
      setLeftText(leftText);
      initLeftTextComponent();
    } else {
      isLeftComponentTextInited = false;
    }
  }

  private void initLeftTextComponent() {
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


    setLeftTextStyle(simpleToolbarTextFont, simpleToolbarTextStyle);
    if (!TextUtils.isEmpty(leftTextFont) && leftTextStyle == 0) {
      setLeftTextStyle(leftTextFont, simpleToolbarTextStyle != 0? simpleToolbarTextStyle: Typeface.NORMAL);
    } else if (!TextUtils.isEmpty(leftTextFont) && leftTextStyle != 0) {
      setLeftTextStyle(leftTextFont, leftTextStyle);
    } else if (TextUtils.isEmpty(leftTextFont) && leftTextStyle != 0) {
      if (!TextUtils.isEmpty(simpleToolbarTextFont)) {
        setLeftTextStyle(simpleToolbarTextFont, leftTextStyle);
      } else {
        setLeftTextStyle(leftTextStyle);
      }
    }

    setLeftTextSize(leftTextSize);
    if (simpleToolbarTextSize != 0) {
      setLeftTextSize(simpleToolbarTextSize);
    }

    isLeftComponentTextInited = true;
  }

  private void initTitle() {
    if (!TextUtils.isEmpty(title)) {
      setTitle(title);
      initTitleComponent();
    } else {
      isTitleComponentInited = false;
    }
  }

  private void initTitleComponent() {
    titleTextView.setClickable(false);

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

    setTitleTextTypeface(simpleToolbarTitleTextFont, simpleToolbarTitleTextStyle);
    if (!TextUtils.isEmpty(titleTextFont) && titleTextStyle == 0) {
      setTitleTextTypeface(titleTextFont, simpleToolbarTitleTextStyle != 0? simpleToolbarTitleTextStyle: Typeface.NORMAL);
    } else if (!TextUtils.isEmpty(titleTextFont) && titleTextStyle != 0) {
      setTitleTextTypeface(titleTextFont, titleTextStyle);
    } else if (TextUtils.isEmpty(titleTextFont) && titleTextStyle != 0) {
      if (!TextUtils.isEmpty(simpleToolbarTitleTextFont)) {
        setTitleTextTypeface(simpleToolbarTitleTextFont, titleTextStyle);
      } else {
        setTitleTextTypeface(titleTextStyle);
      }
    }

    if (simpleToolbarTitleTextGravity == 0){
      setLeftMargin();
    } else if (simpleToolbarTitleTextGravity == 1) {
      setLeftMargin();
      alightTitleCenter();
    }

    if (titleTextGravity == 0) {
      setLeftMargin();
    } else if (titleTextGravity == 1) {
      alightTitleCenter();
    } else if (simpleToolbarTitleTextGravity == 0){
      setLeftMargin();
    } else if (simpleToolbarTitleTextGravity == 1) {
      alightTitleCenter();
    } else {
      setLeftMargin();
    }

    if (simpleToolbarTitleSingleLine) {
      setTitleSingleLine(true);
    } else {
      setTitleSingleLine(isTitleSingleLine);
    }

    isTitleComponentInited = true;
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
      initRightTextComponent();
    } else {
      isRightComponentTextInited = false;
    }
  }

  private void initRightTextComponent() {
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

    setRightTextStyle(simpleToolbarTextFont, simpleToolbarTextStyle);
    if (!TextUtils.isEmpty(rightTextFont) && rightTextStyle == 0) {
      setRightTextStyle(rightTextFont, simpleToolbarTextStyle != 0? simpleToolbarTextStyle: Typeface.NORMAL);
    } else if (!TextUtils.isEmpty(rightTextFont) && rightTextStyle != 0) {
      setRightTextStyle(rightTextFont, rightTextStyle);
    } else if (TextUtils.isEmpty(rightTextFont) && rightTextStyle != 0) {
      if (!TextUtils.isEmpty(simpleToolbarTextFont)) {
        setRightTextStyle(simpleToolbarTextFont, rightTextStyle);
      } else {
        setRightTextStyle(rightTextStyle);
      }
    }

    setRightTextSize(rightTextSize);
    if (simpleToolbarTextSize != 0) {
      setRightTextSize(simpleToolbarTextSize);
    }

    isRightComponentTextInited = true;
  }

  private void initBackground() {
    if (backgroundDrawable != null) {
      setBackgroundDrawable(backgroundDrawable);
    } else if (simpleToolbarBackgroundColor != 0) {
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
    inflateTitleViewIfNeed();
    if (!isTitleComponentInited) {
      initTitleComponent();
    }
    titleTextView.setText(title);
  }

  public void setLeftMargin() {
    inflateTitleViewIfNeed();
    LayoutParams params = ((LayoutParams) titleTextView.getLayoutParams());
    params.leftMargin = AppUtils.dp2px(getContext(), 72 - 16);
    titleTextView.setLayoutParams(params);
  }

  public void alightTitleCenter() {
    inflateTitleViewIfNeed();
    LayoutParams params = ((LayoutParams) titleTextView.getLayoutParams());
    params.addRule(RelativeLayout.CENTER_IN_PARENT);
    titleTextView.setLayoutParams(params);
  }

  public void setTitleTextIcon(int titleTextIcon) {
    inflateTitleViewIfNeed();
    if (titleTextIconPosition == 0) {
      titleTextView.setCompoundDrawablesWithIntrinsicBounds(titleTextIcon, 0, 0, 0);
    } else {
      titleTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, titleTextIcon, 0);
    }
  }

  public void setTitleTextColor(@ColorInt int color) {
    inflateTitleViewIfNeed();
    titleTextView.setTextColor(color);
  }

  public void setTitleTextColor(ColorStateList colorStateList) {
    inflateTitleViewIfNeed();
    titleTextView.setTextColor(colorStateList);
  }

  public void setTitleTextTypeface(@Nullable String font, int typeface) {
    inflateTitleViewIfNeed();
    if (font != null) {
      titleTextView.setTypeface(Typeface.create(font, typeface));
    } else {
      titleTextView.setTypeface(null, typeface);
    }
  }

  public void setTitleTextTypeface(int typeface) {
    setTitleTextTypeface(null, typeface);
  }

  public void setTitleTextSize(@Px int textSize) {
    inflateTitleViewIfNeed();
    titleTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
  }

  public void setTitleOnClickListener(View.OnClickListener listener) {
    inflateTitleViewIfNeed();
    titleTextView.setOnClickListener(listener);
  }

  public void setTitleSingleLine(boolean isSingleLine) {
    titleTextView.setSingleLine(isSingleLine);
    if (isSingleLine) {
      titleTextView.setEllipsize(TextUtils.TruncateAt.END);
    }
  }

  /**
   * left
   */
  public void setLeftText(int stringRes) {
    setLeftText(getResources().getString(stringRes));
  }

  public void setLeftText(CharSequence text) {
    inflateLeftTextViewIfNeed();
    if (!isLeftComponentTextInited) {
      initLeftTextComponent();
    }
    leftTextView.setText(text);
  }

  public void setLeftTextIcon(int leftTextIcon) {
    inflateLeftTextViewIfNeed();
    if (leftTextIconPosition == 0) {
      leftTextView.setCompoundDrawablesWithIntrinsicBounds(leftTextIcon, 0, 0, 0);
    } else {
      leftTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, leftTextIcon, 0);
    }
  }

  public void setLeftTextColor(@ColorInt int color) {
    inflateLeftTextViewIfNeed();
    leftTextView.setTextColor(color);
  }

  public void setLeftTextColor(ColorStateList colorStateList) {
    inflateLeftTextViewIfNeed();
    leftTextView.setTextColor(colorStateList);
  }

  public void setLeftTextStyle(@Nullable String font, int style) {
    inflateLeftTextViewIfNeed();
    if (font != null) {
      leftTextView.setTypeface(Typeface.create(font, style));
    } else {
      leftTextView.setTypeface(null, style);
    }
  }

  public void setLeftTextStyle(int style) {
    setLeftTextStyle(null, style);
  }

  public void setLeftTextSize(@Px int textSize) {
    inflateLeftTextViewIfNeed();
    leftTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
  }

  public void setLeftTextIcon(int leftTextIcon, boolean isLeft) {
    this.leftTextIconPosition = isLeft ? 0 : 1;
    setLeftTextIcon(leftTextIcon);
  }

  public void setLeftTextOnClickListener(View.OnClickListener listener) {
    inflateLeftTextViewIfNeed();
    leftTextView.setOnClickListener(listener);
  }

  public void setLeftIcon(int drawableRes) {
    inflateLeftIconViewIfNeed();
    leftIconView.setImageResource(drawableRes);
  }

  public void setLeftIconOnClickListener(View.OnClickListener listener) {
    inflateLeftIconViewIfNeed();
    leftIconView.setOnClickListener(listener);
  }

  /**
   * right
   */
  public void setRightText(int stringRes) {
    setRightText(getResources().getString(stringRes));
  }

  public void setRightText(CharSequence text) {
    inflateRightTextViewIfNeed();
    if (!isRightComponentTextInited) {
      initRightTextComponent();
    }
    rightTextView.setText(text);
  }

  public void setRightTextIcon(int rightTextIcon) {
    inflateRightTextViewIfNeed();
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
    inflateRightTextViewIfNeed();
    rightTextView.setTextColor(color);
  }

  public void setRightTextColor(ColorStateList colorStateList) {
    inflateRightTextViewIfNeed();
    rightTextView.setTextColor(colorStateList);
  }

  public void setRightTextStyle(@Nullable String font, int typeface) {
    inflateRightTextViewIfNeed();
    if (font != null) {
      rightTextView.setTypeface(Typeface.create(font, typeface));
    } else {
      rightTextView.setTypeface(null, typeface);
    }
  }

  public void setRightTextStyle(int typeface) {
    setRightTextStyle(null, typeface);
  }

  public void setRightIcon(int drawableRes) {
    inflateRightIconViewIfNeed();
    rightIconView.setImageResource(drawableRes);
  }

  public void setRightIcon2(int drawableRes) {
    inflateRightIcon2ViewIfNeed();
    rightIcon2View.setImageResource(drawableRes);
  }

  public void setRightIcon3(int drawableRes) {
    inflateRightIcon3ViewIfNeed();
    rightIcon3View.setImageResource(drawableRes);
  }

  public void setRightIcon4(int drawableRes) {
    inflateRightIcon4ViewIfNeed();
    rightIcon4View.setImageResource(drawableRes);
  }

  public void setRightIcon5(int drawableRes) {
    inflateRightIcon5ViewIfNeed();
    rightIcon5View.setImageResource(drawableRes);
  }

  public void setRightTextSize(@Px int textSize) {
    inflateRightTextViewIfNeed();
    rightTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
  }

  public void setRightTextOnClickListener(View.OnClickListener listener) {
    inflateRightTextViewIfNeed();
    rightTextView.setOnClickListener(listener);
  }

  public void setRightIconOnClickListener(View.OnClickListener listener) {
    inflateRightIconViewIfNeed();
    rightIconView.setOnClickListener(listener);
  }

  public void setRightIcon2OnClickListener(View.OnClickListener listener) {
    inflateRightIcon2ViewIfNeed();
    rightIcon2View.setOnClickListener(listener);
  }

  public void setRightIcon3OnClickListener(View.OnClickListener listener) {
    inflateRightIcon3ViewIfNeed();
    rightIcon3View.setOnClickListener(listener);
  }

  public void setRightIcon4OnClickListener(View.OnClickListener listener) {
    inflateRightIcon4ViewIfNeed();
    rightIcon4View.setOnClickListener(listener);
  }

  public void setRightIcon5OnClickListener(View.OnClickListener listener) {
    inflateRightIcon5ViewIfNeed();
    rightIcon5View.setOnClickListener(listener);
  }

  /**
   * helper
   * */
  private <V extends View> V inflateIfNeed(V view, ViewStub viewStub) {
    if (view == null) {
      view = (V) viewStub.inflate();
    }

    return view;
  }

  private void inflateRightTextViewIfNeed() {
    rightTextView = inflateIfNeed(rightTextView, rightTextViewStub);
  }

  private void inflateRightIconViewIfNeed() {
    rightIconView = inflateIfNeed(rightIconView, rightIconViewStub);
  }

  private void inflateRightIcon2ViewIfNeed() {
    rightIcon2View = inflateIfNeed(rightIcon2View, rightIcon2ViewStub);
  }

  private void inflateRightIcon3ViewIfNeed() {
    rightIcon3View = inflateIfNeed(rightIcon3View, rightIcon3ViewStub);
  }

  private void inflateRightIcon4ViewIfNeed() {
    rightIcon4View = inflateIfNeed(rightIcon4View, rightIcon4ViewStub);
  }

  private void inflateRightIcon5ViewIfNeed() {
    rightIcon5View = inflateIfNeed(rightIcon5View, rightIcon5ViewStub);
  }

  private void inflateLeftTextViewIfNeed() {
    leftTextView = inflateIfNeed(leftTextView, leftTextViewStub);
  }

  private void inflateLeftIconViewIfNeed() {
    leftIconView = inflateIfNeed(leftIconView, leftIconViewStub);
  }

  private void inflateTitleViewIfNeed() {
    titleTextView = inflateIfNeed(titleTextView, titleTextViewStub);
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
