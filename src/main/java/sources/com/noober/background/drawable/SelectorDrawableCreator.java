package com.noober.background.drawable;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import com.noober.background.R;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class SelectorDrawableCreator implements ICreateDrawable {
    private TypedArray selectorTa;
    private TypedArray typedArray;

    public SelectorDrawableCreator(TypedArray typedArray, TypedArray typedArray2) {
        this.typedArray = typedArray;
        this.selectorTa = typedArray2;
    }

    private void setSelectorDrawable(TypedArray typedArray, TypedArray typedArray2, StateListDrawable stateListDrawable, int i, int i2) throws Exception {
        Drawable drawable;
        int i3 = 0;
        try {
            i3 = typedArray2.getColor(i, 0);
            drawable = i3 == 0 ? typedArray2.getDrawable(i) : null;
        } catch (Exception unused) {
            drawable = typedArray2.getDrawable(i);
        }
        if (drawable != null || i3 == 0) {
            stateListDrawable.addState(new int[]{i2}, drawable);
            return;
        }
        GradientDrawable drawable2 = DrawableFactory.getDrawable(typedArray);
        drawable2.setColor(i3);
        stateListDrawable.addState(new int[]{i2}, drawable2);
    }

    public Drawable create() throws Exception {
        StateListDrawable stateListDrawable = new StateListDrawable();
        for (int i = 0; i < this.selectorTa.getIndexCount(); i++) {
            int index = this.selectorTa.getIndex(i);
            if (index == R.styleable.background_selector_bl_checkable_drawable) {
                setSelectorDrawable(this.typedArray, this.selectorTa, stateListDrawable, index, android.R.attr.state_checkable);
            } else if (index == R.styleable.background_selector_bl_unCheckable_drawable) {
                setSelectorDrawable(this.typedArray, this.selectorTa, stateListDrawable, index, -16842911);
            } else if (index == R.styleable.background_selector_bl_checked_drawable) {
                setSelectorDrawable(this.typedArray, this.selectorTa, stateListDrawable, index, android.R.attr.state_checked);
            } else if (index == R.styleable.background_selector_bl_unChecked_drawable) {
                setSelectorDrawable(this.typedArray, this.selectorTa, stateListDrawable, index, -16842912);
            } else if (index == R.styleable.background_selector_bl_enabled_drawable) {
                setSelectorDrawable(this.typedArray, this.selectorTa, stateListDrawable, index, android.R.attr.state_enabled);
            } else if (index == R.styleable.background_selector_bl_unEnabled_drawable) {
                setSelectorDrawable(this.typedArray, this.selectorTa, stateListDrawable, index, -16842910);
            } else if (index == R.styleable.background_selector_bl_selected_drawable) {
                setSelectorDrawable(this.typedArray, this.selectorTa, stateListDrawable, index, android.R.attr.state_selected);
            } else if (index == R.styleable.background_selector_bl_unSelected_drawable) {
                setSelectorDrawable(this.typedArray, this.selectorTa, stateListDrawable, index, -16842913);
            } else if (index == R.styleable.background_selector_bl_pressed_drawable) {
                setSelectorDrawable(this.typedArray, this.selectorTa, stateListDrawable, index, android.R.attr.state_pressed);
            } else if (index == R.styleable.background_selector_bl_unPressed_drawable) {
                setSelectorDrawable(this.typedArray, this.selectorTa, stateListDrawable, index, -16842919);
            } else if (index == R.styleable.background_selector_bl_focused_drawable) {
                setSelectorDrawable(this.typedArray, this.selectorTa, stateListDrawable, index, android.R.attr.state_focused);
            } else if (index == R.styleable.background_selector_bl_unFocused_drawable) {
                setSelectorDrawable(this.typedArray, this.selectorTa, stateListDrawable, index, -16842908);
            } else if (index == R.styleable.background_selector_bl_focused_hovered) {
                setSelectorDrawable(this.typedArray, this.selectorTa, stateListDrawable, index, android.R.attr.state_hovered);
            } else if (index == R.styleable.background_selector_bl_unFocused_hovered) {
                setSelectorDrawable(this.typedArray, this.selectorTa, stateListDrawable, index, -16843623);
            } else if (index == R.styleable.background_selector_bl_focused_activated) {
                setSelectorDrawable(this.typedArray, this.selectorTa, stateListDrawable, index, android.R.attr.state_activated);
            } else if (index == R.styleable.background_selector_bl_unFocused_activated) {
                setSelectorDrawable(this.typedArray, this.selectorTa, stateListDrawable, index, -16843518);
            }
        }
        return stateListDrawable;
    }
}
