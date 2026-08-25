package androidx.compose.ui.viewinterop;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class AndroidView_androidKt {

    /* renamed from: a, reason: collision with root package name */
    private static final Function1 f5509a = new Function1<View, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$NoOpUpdate$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.a;
        }

        public final void invoke(View view) {
        }
    };

    public static final Function1 a() {
        return f5509a;
    }
}
