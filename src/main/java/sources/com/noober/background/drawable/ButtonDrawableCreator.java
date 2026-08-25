package com.noober.background.drawable;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import com.noober.background.R;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class ButtonDrawableCreator implements ICreateDrawable {
    private TypedArray buttonTa;
    private TypedArray typedArray;

    public ButtonDrawableCreator(TypedArray typedArray, TypedArray typedArray2) {
        this.typedArray = typedArray;
        this.buttonTa = typedArray2;
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
        for (int i = 0; i < this.buttonTa.getIndexCount(); i++) {
            int index = this.buttonTa.getIndex(i);
            if (index == R.styleable.background_button_drawable_bl_checked_button_drawable) {
                setSelectorDrawable(this.typedArray, this.buttonTa, stateListDrawable, index, android.R.attr.state_checked);
            } else if (index == R.styleable.background_button_drawable_bl_unChecked_button_drawable) {
                setSelectorDrawable(this.typedArray, this.buttonTa, stateListDrawable, index, -16842912);
            }
        }
        return stateListDrawable;
    }
}
