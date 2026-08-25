package com.transsion.publish;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.api.bean.RequestPostEntity;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u0003J\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0016\u001a\u00020\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0003R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010 R\u0016\u0010\"\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001d¨\u0006$"}, d2 = {"Lcom/transsion/publish/PublishService;", "Landroid/app/Service;", "<init>", "()V", "Landroid/content/Intent;", "intent", BuildConfig.FLAVOR, "c", "(Landroid/content/Intent;)V", "d", "Ljava/lang/Runnable;", "runnable", "b", "(Ljava/lang/Runnable;)V", "onCreate", "p0", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", BuildConfig.FLAVOR, "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "onDestroy", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "I", "NOTIFICATION_ID", "Lcom/transsion/publish/api/bean/RequestPostEntity;", "Lcom/transsion/publish/api/bean/RequestPostEntity;", "entity", "sourceType", "e", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PublishService extends Service {
    private static boolean f;

    /* renamed from: a, reason: from kotlin metadata */
    private Context context;

    /* renamed from: b, reason: from kotlin metadata */
    private int NOTIFICATION_ID = 100012;

    /* renamed from: c, reason: from kotlin metadata */
    private RequestPostEntity entity;

    /* renamed from: d, reason: from kotlin metadata */
    private int sourceType;

    /* renamed from: e, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static String g = "PublishService";

    /* renamed from: com.transsion.publish.PublishService$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, RequestPostEntity requestPostEntity, int i) {
            Intrinsics.h(context, "context");
            Intrinsics.h(requestPostEntity, "entity");
            Intent intent = new Intent(context, (Class<?>) PublishService.class);
            intent.putExtra("entity", requestPostEntity);
            intent.putExtra("sourceType", i);
            context.startService(intent);
        }
    }

    private final void b(Runnable runnable) {
        p.b.a().d(runnable);
    }

    private final void c(Intent intent) {
        f = true;
        Intrinsics.e(intent);
        Serializable serializableExtra = intent.getSerializableExtra("entity");
        this.sourceType = intent.getIntExtra("sourceType", 0);
        if (serializableExtra != null && (serializableExtra instanceof RequestPostEntity)) {
            this.entity = (RequestPostEntity) serializableExtra;
        }
        d();
    }

    private final void d() {
        if (this.entity == null) {
            return;
        }
        a.a aVar = wf.a.a;
        a.a.f(aVar, g, "disposePost", false, 4, (Object) null);
        a.a.f(aVar, g, String.valueOf(this.entity), false, 4, (Object) null);
        PublishManager a = PublishManager.Companion.a();
        RequestPostEntity requestPostEntity = this.entity;
        Intrinsics.e(requestPostEntity);
        a.publish(requestPostEntity, this.sourceType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(PublishService publishService, Intent intent) {
        publishService.c(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent p0) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.context = getApplicationContext();
    }

    @Override // android.app.Service
    public void onDestroy() {
        a.a.f(wf.a.a, g, "onDestroy", false, 4, (Object) null);
        f = false;
        stopForeground(true);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int flags, int startId) {
        a.a.f(wf.a.a, g, "onStartCommand", false, 4, (Object) null);
        b(new Runnable() { // from class: com.transsion.publish.l
            @Override // java.lang.Runnable
            public final void run() {
                PublishService.e(PublishService.this, intent);
            }
        });
        return super.onStartCommand(intent, flags, startId);
    }
}
