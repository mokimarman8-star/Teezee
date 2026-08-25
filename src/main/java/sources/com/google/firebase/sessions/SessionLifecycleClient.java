package com.google.firebase.sessions;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class SessionLifecycleClient {
    public static final a f = new a(null);
    private final CoroutineContext a;
    private Messenger b;
    private boolean c;
    private final LinkedBlockingDeque d;
    private final b e;

    public static final class ClientUpdateHandler extends Handler {
        private final CoroutineContext a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClientUpdateHandler(CoroutineContext coroutineContext) {
            super(Looper.getMainLooper());
            Intrinsics.h(coroutineContext, "backgroundDispatcher");
            this.a = coroutineContext;
        }

        private final void a(String str) {
            kotlinx.coroutines.i.d(o0.a(this.a), (CoroutineContext) null, (CoroutineStart) null, new SessionLifecycleClient$ClientUpdateHandler$handleSessionUpdate$1(str, null), 3, (Object) null);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            Intrinsics.h(message, "msg");
            if (message.what == 3) {
                Bundle data = message.getData();
                if (data == null || (str = data.getString("SessionUpdateExtra")) == null) {
                    str = TtmlNode.ANONYMOUS_REGION_ID;
                }
                a(str);
                return;
            }
            Log.w("SessionLifecycleClient", "Received unexpected event from the SessionLifecycleService: " + message);
            super.handleMessage(message);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Connected to SessionLifecycleService. Queue size ");
            sb2.append(SessionLifecycleClient.this.d.size());
            SessionLifecycleClient.this.b = new Messenger(iBinder);
            SessionLifecycleClient.this.c = true;
            SessionLifecycleClient sessionLifecycleClient = SessionLifecycleClient.this;
            sessionLifecycleClient.o(sessionLifecycleClient.j());
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            SessionLifecycleClient.this.b = null;
            SessionLifecycleClient.this.c = false;
        }
    }

    public SessionLifecycleClient(CoroutineContext coroutineContext) {
        Intrinsics.h(coroutineContext, "backgroundDispatcher");
        this.a = coroutineContext;
        this.d = new LinkedBlockingDeque(20);
        this.e = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List j() {
        ArrayList arrayList = new ArrayList();
        this.d.drainTo(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Message l(List list, int i) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (((Message) obj2).what == i) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                long when = ((Message) next).getWhen();
                do {
                    Object next2 = it.next();
                    long when2 = ((Message) next2).getWhen();
                    if (when < when2) {
                        next = next2;
                        when = when2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (Message) obj;
    }

    private final void m(Message message) {
        if (!this.d.offer(message)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to enqueue message ");
            sb2.append(message.what);
            sb2.append(". Dropping.");
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Queued message ");
        sb3.append(message.what);
        sb3.append(". Queue size ");
        sb3.append(this.d.size());
    }

    private final void n(int i) {
        List j = j();
        Message obtain = Message.obtain(null, i, 0, 0);
        Intrinsics.g(obtain, "obtain(null, messageCode, 0, 0)");
        j.add(obtain);
        o(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final t1 o(List list) {
        return kotlinx.coroutines.i.d(o0.a(this.a), (CoroutineContext) null, (CoroutineStart) null, new SessionLifecycleClient$sendLifecycleEvents$1(this, list, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(Message message) {
        if (this.b == null) {
            m(message);
            return;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Sending lifecycle ");
            sb2.append(message.what);
            sb2.append(" to service");
            Messenger messenger = this.b;
            if (messenger != null) {
                messenger.send(message);
            }
        } catch (RemoteException e) {
            Log.w("SessionLifecycleClient", "Unable to deliver message: " + message.what, e);
            m(message);
        }
    }

    public final void h() {
        n(2);
    }

    public final void i(y yVar) {
        Intrinsics.h(yVar, "sessionLifecycleServiceBinder");
        yVar.a(new Messenger(new ClientUpdateHandler(this.a)), this.e);
    }

    public final void k() {
        n(1);
    }
}
