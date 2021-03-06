package com.example.chirag.musica.CustomLayout;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;

public class NonFocusingScrollView extends NestedScrollView {

  public NonFocusingScrollView(Context context) {
    super(context);
  }

  public NonFocusingScrollView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public NonFocusingScrollView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @Override
  protected boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
    return true;
  }

}