package com.google.firebase.sessions.settings;

import android.net.Uri;
import java.net.URL;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class RemoteSettingsFetcher implements com.google.firebase.sessions.settings.a {
    public static final a d = new a(null);
    private final com.google.firebase.sessions.b a;
    private final CoroutineContext b;
    private final String c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RemoteSettingsFetcher(com.google.firebase.sessions.b bVar, CoroutineContext coroutineContext, String str) {
        Intrinsics.h(bVar, "appInfo");
        Intrinsics.h(coroutineContext, "blockingDispatcher");
        Intrinsics.h(str, "baseUrl");
        this.a = bVar;
        this.b = coroutineContext;
        this.c = str;
    }

    public /* synthetic */ RemoteSettingsFetcher(com.google.firebase.sessions.b bVar, CoroutineContext coroutineContext, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, coroutineContext, (i & 4) != 0 ? "firebase-settings.crashlytics.com" : str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final URL c() {
        return new URL(new Uri.Builder().scheme("https").authority(this.c).appendPath("spi").appendPath("v2").appendPath("platforms").appendPath("android").appendPath("gmp").appendPath(this.a.b()).appendPath("settings").appendQueryParameter("build_version", this.a.a().a()).appendQueryParameter("display_version", this.a.a().f()).build().toString());
    }

    @Override // com.google.firebase.sessions.settings.a
    public Object a(Map map, Function2 function2, Function2 function22, Continuation continuation) {
        Object g = i.g(this.b, new RemoteSettingsFetcher$doConfigFetch$2(this, map, function2, function22, null), continuation);
        return g == IntrinsicsKt.f() ? g : Unit.a;
    }
}
