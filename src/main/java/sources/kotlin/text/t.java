package kotlin.text;

import kotlin.jvm.functions.Function2;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class t implements Function2 {
    public final /* synthetic */ char[] a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ t(char[] cArr, boolean z) {
        this.a = cArr;
        this.b = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return StringsKt__StringsKt.Y(this.a, this.b, (CharSequence) obj, ((Integer) obj2).intValue());
    }
}
