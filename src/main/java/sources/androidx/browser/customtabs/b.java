package androidx.browser.customtabs;

import android.os.Bundle;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f1164a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f1165b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f1166c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f1167d;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private Integer f1168a;

        /* renamed from: b, reason: collision with root package name */
        private Integer f1169b;

        /* renamed from: c, reason: collision with root package name */
        private Integer f1170c;

        /* renamed from: d, reason: collision with root package name */
        private Integer f1171d;

        public b a() {
            return new b(this.f1168a, this.f1169b, this.f1170c, this.f1171d);
        }
    }

    b(Integer num, Integer num2, Integer num3, Integer num4) {
        this.f1164a = num;
        this.f1165b = num2;
        this.f1166c = num3;
        this.f1167d = num4;
    }

    Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f1164a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f1165b;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f1166c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        Integer num4 = this.f1167d;
        if (num4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num4.intValue());
        }
        return bundle;
    }
}
