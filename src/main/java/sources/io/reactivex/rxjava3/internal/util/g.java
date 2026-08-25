package io.reactivex.rxjava3.internal.util;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class g {
    public static int a(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }
}
