package kotlin.text;

import kotlin.jvm.functions.Function0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class g implements Function0 {
    public final /* synthetic */ Regex a;
    public final /* synthetic */ CharSequence b;
    public final /* synthetic */ int c;

    public /* synthetic */ g(Regex regex, CharSequence charSequence, int i) {
        this.a = regex;
        this.b = charSequence;
        this.c = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return Regex.a(this.a, this.b, this.c);
    }
}
