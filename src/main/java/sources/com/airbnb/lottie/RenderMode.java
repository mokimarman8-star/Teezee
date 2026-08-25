package com.airbnb.lottie;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public enum RenderMode {
    AUTOMATIC,
    HARDWARE,
    SOFTWARE;

    public boolean useSoftwareRendering(int i, boolean z, int i2) {
        int i3 = a.a[ordinal()];
        if (i3 == 1) {
            return false;
        }
        if (i3 != 2) {
            return (z && i < 28) || i2 > 4 || i <= 25;
        }
        return true;
    }
}
