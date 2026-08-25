package com.airbnb.lottie.model.content;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public enum ShapeTrimPath$Type {
    SIMULTANEOUSLY,
    INDIVIDUALLY;

    public static ShapeTrimPath$Type forId(int i) {
        if (i == 1) {
            return SIMULTANEOUSLY;
        }
        if (i == 2) {
            return INDIVIDUALLY;
        }
        throw new IllegalArgumentException("Unknown trim path type " + i);
    }
}
