package com.transsion.shorttv.base.activity;

import android.view.MotionEvent;
import com.transsion.gslb.BuildConfig;
import f4.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import ur.j;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u000b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/transsion/shorttv/base/activity/BaseMusicFloatActivity;", "Lf4/a;", "T", "Lcom/transsion/shorttv/base/activity/BaseCommonActivity;", "<init>", "()V", "Landroid/view/MotionEvent;", "ev", BuildConfig.FLAVOR, "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "Lur/j;", "c", "Lkotlin/Lazy;", "P", "()Lur/j;", "shortMusicAudioProvider", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class BaseMusicFloatActivity<T extends f4.a> extends BaseCommonActivity<T> {

    /* renamed from: c, reason: from kotlin metadata */
    private final Lazy shortMusicAudioProvider = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.base.activity.c
        public final Object invoke() {
            j Q;
            Q = BaseMusicFloatActivity.Q();
            return Q;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final j Q() {
        vr.a c = pq.c.a.c();
        if (c != null) {
            return c.g();
        }
        return null;
    }

    protected final j P() {
        return (j) this.shortMusicAudioProvider.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean dispatchTouchEvent(MotionEvent ev) {
        j P;
        Integer valueOf = ev != null ? Integer.valueOf(ev.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0 && (P = P()) != null) {
            P.c(this, ev);
        }
        return super/*android.app.Activity*/.dispatchTouchEvent(ev);
    }
}
