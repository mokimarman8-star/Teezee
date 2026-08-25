package com.tn.lib.widget.toast.core;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tn.lib.widget.toast.core.a;
import java.lang.ref.WeakReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class g extends Handler implements gh.b {
    public static final a e = new a(null);
    private Application a;
    private com.tn.lib.widget.toast.core.a b;
    private WeakReference c;
    private gh.c d;

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

    @Override // gh.b
    public void a(CharSequence charSequence) {
        removeMessages(1);
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = charSequence;
        sendMessageDelayed(obtain, 200L);
    }

    @Override // gh.b
    public void b(gh.c cVar) {
        this.d = cVar;
    }

    public gh.a c(Application application) {
        com.tn.lib.widget.toast.core.a aVar = this.b;
        Intrinsics.e(aVar);
        Activity a2 = aVar.a();
        gh.a bVar = a2 != null ? new b(a2) : Build.VERSION.SDK_INT == 25 ? new d(application) : new e(application);
        gh.c cVar = this.d;
        Intrinsics.e(cVar);
        bVar.b(cVar.createView(application));
        gh.c cVar2 = this.d;
        Intrinsics.e(cVar2);
        int gravity = cVar2.getGravity();
        gh.c cVar3 = this.d;
        Intrinsics.e(cVar3);
        int xOffset = cVar3.getXOffset();
        gh.c cVar4 = this.d;
        Intrinsics.e(cVar4);
        bVar.setGravity(gravity, xOffset, cVar4.getYOffset());
        gh.c cVar5 = this.d;
        Intrinsics.e(cVar5);
        float horizontalMargin = cVar5.getHorizontalMargin();
        gh.c cVar6 = this.d;
        Intrinsics.e(cVar6);
        bVar.setMargin(horizontalMargin, cVar6.getVerticalMargin());
        return bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Object obj;
        Intrinsics.h(message, "msg");
        WeakReference weakReference = this.c;
        if (weakReference != null) {
            Intrinsics.e(weakReference);
            obj = weakReference.get();
        } else {
            obj = null;
        }
        int i = message.what;
        if (i != 1) {
            if (i == 2 && obj != null) {
                ((gh.a) obj).cancel();
                return;
            }
            return;
        }
        Object obj2 = message.obj;
        if (obj2 instanceof CharSequence) {
            Intrinsics.f(obj2, "null cannot be cast to non-null type kotlin.CharSequence");
            CharSequence charSequence = (CharSequence) obj2;
            gh.a aVar = (gh.a) obj;
            if (aVar != null) {
                aVar.cancel();
            }
            gh.a c = c(this.a);
            this.c = new WeakReference(c);
            Intrinsics.e(c);
            c.setDuration(d(charSequence));
            c.setText(charSequence);
            try {
                Result.Companion companion = Result.Companion;
                c.show();
                Result.constructor-impl(Unit.a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th));
            }
            b(new hh.a());
        }
    }

    @Override // gh.b
    public void registerStrategy(Application application) {
        this.a = application;
        a.C0037a c0037a = com.tn.lib.widget.toast.core.a.b;
        Intrinsics.e(application);
        this.b = c0037a.a(application);
    }
}
