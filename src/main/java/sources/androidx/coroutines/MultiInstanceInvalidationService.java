package androidx.coroutines;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.coroutines.j;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00120\u00118\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\n\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001d¨\u0006\u001f"}, d2 = {"Landroidx/room/MultiInstanceInvalidationService;", "Landroid/app/Service;", "<init>", "()V", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "", "a", "I", "c", "()I", "d", "(I)V", "maxClientId", "", "", "b", "Ljava/util/Map;", "()Ljava/util/Map;", "clientNames", "Landroid/os/RemoteCallbackList;", "Landroidx/room/i;", "Landroid/os/RemoteCallbackList;", "()Landroid/os/RemoteCallbackList;", "callbackList", "Landroidx/room/j$a;", "Landroidx/room/j$a;", "binder", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class MultiInstanceInvalidationService extends Service {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int maxClientId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Map clientNames = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final RemoteCallbackList callbackList = new b();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final j.a binder = new a();

    public static final class a extends j.a {
        a() {
        }

        @Override // androidx.coroutines.j
        public void V0(i iVar, int i5) {
            Intrinsics.h(iVar, "callback");
            RemoteCallbackList callbackList = MultiInstanceInvalidationService.this.getCallbackList();
            MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
            synchronized (callbackList) {
                multiInstanceInvalidationService.getCallbackList().unregister(iVar);
            }
        }

        @Override // androidx.coroutines.j
        public void Z(int i5, String[] strArr) {
            Intrinsics.h(strArr, "tables");
            RemoteCallbackList callbackList = MultiInstanceInvalidationService.this.getCallbackList();
            MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
            synchronized (callbackList) {
                String str = (String) multiInstanceInvalidationService.getClientNames().get(Integer.valueOf(i5));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int beginBroadcast = multiInstanceInvalidationService.getCallbackList().beginBroadcast();
                for (int i6 = 0; i6 < beginBroadcast; i6++) {
                    try {
                        Object broadcastCookie = multiInstanceInvalidationService.getCallbackList().getBroadcastCookie(i6);
                        Intrinsics.f(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                        Integer num = (Integer) broadcastCookie;
                        int intValue = num.intValue();
                        String str2 = (String) multiInstanceInvalidationService.getClientNames().get(num);
                        if (i5 != intValue && Intrinsics.c(str, str2)) {
                            try {
                                ((i) multiInstanceInvalidationService.getCallbackList().getBroadcastItem(i6)).o(strArr);
                                Unit unit = Unit.a;
                            } catch (RemoteException e5) {
                                Log.w("ROOM", "Error invoking a remote callback", e5);
                            }
                        }
                    } catch (Throwable th) {
                        multiInstanceInvalidationService.getCallbackList().finishBroadcast();
                        throw th;
                    }
                }
                multiInstanceInvalidationService.getCallbackList().finishBroadcast();
                Unit unit2 = Unit.a;
            }
        }

        @Override // androidx.coroutines.j
        public int r0(i iVar, String str) {
            Intrinsics.h(iVar, "callback");
            int i5 = 0;
            if (str == null) {
                return 0;
            }
            RemoteCallbackList callbackList = MultiInstanceInvalidationService.this.getCallbackList();
            MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
            synchronized (callbackList) {
                try {
                    multiInstanceInvalidationService.d(multiInstanceInvalidationService.getMaxClientId() + 1);
                    int maxClientId = multiInstanceInvalidationService.getMaxClientId();
                    if (multiInstanceInvalidationService.getCallbackList().register(iVar, Integer.valueOf(maxClientId))) {
                        multiInstanceInvalidationService.getClientNames().put(Integer.valueOf(maxClientId), str);
                        i5 = maxClientId;
                    } else {
                        multiInstanceInvalidationService.d(multiInstanceInvalidationService.getMaxClientId() - 1);
                        multiInstanceInvalidationService.getMaxClientId();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return i5;
        }
    }

    public static final class b extends RemoteCallbackList {
        b() {
        }

        @Override // android.os.RemoteCallbackList
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCallbackDied(i iVar, Object obj) {
            Intrinsics.h(iVar, "callback");
            Intrinsics.h(obj, "cookie");
            MultiInstanceInvalidationService.this.getClientNames().remove((Integer) obj);
        }
    }

    /* renamed from: a, reason: from getter */
    public final RemoteCallbackList getCallbackList() {
        return this.callbackList;
    }

    /* renamed from: b, reason: from getter */
    public final Map getClientNames() {
        return this.clientNames;
    }

    /* renamed from: c, reason: from getter */
    public final int getMaxClientId() {
        return this.maxClientId;
    }

    public final void d(int i5) {
        this.maxClientId = i5;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.h(intent, "intent");
        return this.binder;
    }
}
