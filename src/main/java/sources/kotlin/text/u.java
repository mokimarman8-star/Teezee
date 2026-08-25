package kotlin.text;

import java.util.List;
import kotlin.jvm.functions.Function2;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class u implements Function2 {
    public final /* synthetic */ List a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ u(List list, boolean z) {
        this.a = list;
        this.b = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return StringsKt__StringsKt.X(this.a, this.b, (CharSequence) obj, ((Integer) obj2).intValue());
    }
}
