package com.transsion.player.mediasession;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import on.e0;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/transsion/player/mediasession/MusicIntentReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", BuildConfig.FLAVOR, "a", "()Ljava/lang/String;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", BuildConfig.FLAVOR, "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "LibPlayer_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MusicIntentReceiver extends BroadcastReceiver {
    private final String a() {
        String simpleName = MusicIntentReceiver.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        Object obj;
        Throwable th2;
        String action;
        Unit unit;
        Intrinsics.h(context, "context");
        Intrinsics.h(intent, "intent");
        try {
            Result.Companion companion = Result.Companion;
            action = intent.getAction();
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th3));
        }
        if (action != null && action.hashCode() == 1997055314 && action.equals("android.intent.action.MEDIA_BUTTON")) {
            Bundle extras = intent.getExtras();
            unit = null;
            Object obj2 = extras != null ? extras.get("android.intent.extra.KEY_EVENT") : null;
            KeyEvent keyEvent = obj2 instanceof KeyEvent ? (KeyEvent) obj2 : null;
            if (keyEvent != null) {
                i.a.a(a() + " --> onReceive --> 接收到通知点击事件, = " + keyEvent + ", " + keyEvent.getKeyCode());
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 126) {
                    com.transsion.player.orplayer.f e = e0.a.e();
                    if (e != null) {
                        e.play();
                        unit = Unit.a;
                    }
                } else if (keyCode != 127) {
                    switch (keyCode) {
                        case 86:
                            com.transsion.player.orplayer.f e2 = e0.a.e();
                            if (e2 != null) {
                                e2.stop();
                                unit = Unit.a;
                                break;
                            }
                            break;
                        case 87:
                            MediaBrowserCompatHelper.h.a().x();
                            unit = Unit.a;
                            break;
                        case 88:
                            MediaBrowserCompatHelper.h.a().z();
                            unit = Unit.a;
                            break;
                        default:
                            unit = Unit.a;
                            break;
                    }
                } else {
                    com.transsion.player.orplayer.f e3 = e0.a.e();
                    if (e3 != null) {
                        e3.pause();
                        unit = Unit.a;
                    }
                }
            }
            obj = Result.constructor-impl(unit);
            th2 = Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                return;
            }
            i.a.a(a() + " --> onReceive --> 接收到通知点击事件 --- it = " + th2);
            return;
        }
        unit = Unit.a;
        obj = Result.constructor-impl(unit);
        th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
        }
    }
}
