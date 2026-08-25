package com.transsion.usercenter;

import android.text.InputFilter;
import android.text.Spanned;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class t implements InputFilter {
    private final int a;
    private a b;

    public interface a {
        void a();
    }

    public t(int i) {
        this.a = i;
    }

    public final void a(a aVar) {
        this.b = aVar;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence source, int i, int i2, Spanned dest, int i3, int i4) {
        Intrinsics.h(source, "source");
        Intrinsics.h(dest, "dest");
        int length = this.a - (dest.length() - (i4 - i3));
        if (length > 0) {
            if (length >= i2 - i) {
                return null;
            }
            int i5 = length + i;
            return (Character.isHighSurrogate(source.charAt(i5 + (-1))) && (i5 = i5 + (-1)) == i) ? HttpUrl.FRAGMENT_ENCODE_SET : source.subSequence(i, i5);
        }
        a aVar = this.b;
        if (aVar == null) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        aVar.a();
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }
}
