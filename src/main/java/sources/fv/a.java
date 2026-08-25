package fv;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a {
    public static final C0057a a = new C0057a(null);

    /* renamed from: fv.a$a, reason: collision with other inner class name */
    public static final class C0057a {
        private C0057a() {
        }

        public /* synthetic */ C0057a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SpannableStringBuilder a(String prefix, String desc, int i) {
            Intrinsics.h(prefix, "prefix");
            Intrinsics.h(desc, "desc");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(desc);
            int n0 = StringsKt.n0(desc, ':', 0, false, 6, null);
            if (n0 == -1) {
                return spannableStringBuilder;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i), 0, n0, 33);
            return spannableStringBuilder;
        }
    }
}
