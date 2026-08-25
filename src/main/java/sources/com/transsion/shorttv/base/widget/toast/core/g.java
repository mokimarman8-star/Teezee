package com.transsion.shorttv.base.widget.toast.core;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.transsion.shorttv.base.widget.toast.core.a;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class g extends Handler implements kr.b {
    public static final a e = new a(null);
    private Application a;
    private com.transsion.shorttv.base.widget.toast.core.a b;
    private WeakReference c;
    private kr.c d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public g() {
        super(Looper.getMainLooper());
    }

    private final int d(CharSequence charSequence) {
        return charSequence.length() > 20 ? 1 : 0;
    }

    @Override // kr.b
    public void a(CharSequence charSequence) {
        removeMessages(1);
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = charSequence;
        sendMessageDelayed(obtain, 200L);
    }

    @Override // kr.b
    public void b(kr.c cVar) {
        this.d = cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0035, code lost:
    
        if (r4.getApplicationInfo().targetSdkVersion < 30) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public kr.a c(Application application) {
        com.transsion.shorttv.base.widget.toast.core.a aVar = this.b;
        Intrinsics.e(aVar);
        Activity a2 = aVar.a();
        kr.a bVar = a2 != null ? new b(a2) : Build.VERSION.SDK_INT == 25 ? new d(application) : new e(application);
        if (!(bVar instanceof b) && Build.VERSION.SDK_INT >= 30) {
            Intrinsics.e(application);
        }
        kr.c cVar = this.d;
        Intrinsics.e(cVar);
        bVar.setView(cVar.createView(application));
        kr.c cVar2 = this.d;
        Intrinsics.e(cVar2);
        int gravity = cVar2.getGravity();
        kr.c cVar3 = this.d;
        Intrinsics.e(cVar3);
        int xOffset = cVar3.getXOffset();
        kr.c cVar4 = this.d;
        Intrinsics.e(cVar4);
        bVar.setGravity(gravity, xOffset, cVar4.getYOffset());
        kr.c cVar5 = this.d;
        Intrinsics.e(cVar5);
        float horizontalMargin = cVar5.getHorizontalMargin();
        kr.c cVar6 = this.d;
        Intrinsics.e(cVar6);
        bVar.setMargin(horizontalMargin, cVar6.getVerticalMargin());
        return bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        kr.a aVar;
        Intrinsics.h(message, "msg");
        WeakReference weakReference = this.c;
        if (weakReference != null) {
            Intrinsics.e(weakReference);
            aVar = (kr.a) weakReference.get();
        } else {
            aVar = null;
        }
        int i = message.what;
        if (i != 1) {
            if (i == 2 && aVar != null) {
                aVar.cancel();
                return;
            }
            return;
        }
        Object obj = message.obj;
        if (obj instanceof CharSequence) {
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.CharSequence");
            CharSequence charSequence = (CharSequence) obj;
            if (aVar != null) {
                aVar.cancel();
            }
            kr.a c = c(this.a);
            this.c = new WeakReference(c);
            Intrinsics.e(c);
            c.setDuration(d(charSequence));
            c.setText(charSequence);
            c.show();
            b(new lr.a());
        }
    }

    @Override // kr.b
    public void registerStrategy(Application application) {
        this.a = application;
        a.C0061a c0061a = com.transsion.shorttv.base.widget.toast.core.a.b;
        Intrinsics.e(application);
        this.b = c0061a.a(application);
    }
}
