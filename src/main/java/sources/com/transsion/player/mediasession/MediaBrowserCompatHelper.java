package com.transsion.player.mediasession;

import android.app.Application;
import android.content.ComponentName;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MediaBrowserCompatHelper {
    public static final a h = new a(null);
    private static final Lazy i = LazyKt.b(new Function0() { // from class: com.transsion.player.mediasession.a
        public final Object invoke() {
            MediaBrowserCompatHelper q;
            q = MediaBrowserCompatHelper.q();
            return q;
        }
    });
    private MediaBrowserCompat d;
    private MediaControllerCompat e;
    private boolean g;
    private final MediaBrowserCompat.n a = new d();
    private final MediaControllerCompat.a b = new c();
    private final MediaBrowserCompat.c c = new b();
    private List f = new ArrayList();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MediaBrowserCompatHelper a() {
            return (MediaBrowserCompatHelper) MediaBrowserCompatHelper.i.getValue();
        }
    }

    public static final class b extends MediaBrowserCompat.c {
        b() {
        }

        public void a() {
            String c;
            super.a();
            try {
                try {
                    MediaBrowserCompat mediaBrowserCompat = MediaBrowserCompatHelper.this.d;
                    if (mediaBrowserCompat != null && (c = mediaBrowserCompat.c()) != null) {
                        MediaBrowserCompatHelper mediaBrowserCompatHelper = MediaBrowserCompatHelper.this;
                        MediaBrowserCompat mediaBrowserCompat2 = mediaBrowserCompatHelper.d;
                        if (mediaBrowserCompat2 != null) {
                            mediaBrowserCompat2.g(c);
                        }
                        MediaBrowserCompat mediaBrowserCompat3 = mediaBrowserCompatHelper.d;
                        if (mediaBrowserCompat3 != null) {
                            mediaBrowserCompat3.f(c, mediaBrowserCompatHelper.a);
                        }
                    }
                    MediaBrowserCompatHelper mediaBrowserCompatHelper2 = MediaBrowserCompatHelper.this;
                    Application a = Utils.a();
                    MediaBrowserCompat mediaBrowserCompat4 = MediaBrowserCompatHelper.this.d;
                    Intrinsics.e(mediaBrowserCompat4);
                    mediaBrowserCompatHelper2.e = new MediaControllerCompat(a, mediaBrowserCompat4.d());
                    MediaControllerCompat mediaControllerCompat = MediaBrowserCompatHelper.this.e;
                    if (mediaControllerCompat != null) {
                        mediaControllerCompat.c(MediaBrowserCompatHelper.this.b);
                    }
                    List<Function1> list = MediaBrowserCompatHelper.this.f;
                    MediaBrowserCompatHelper mediaBrowserCompatHelper3 = MediaBrowserCompatHelper.this;
                    for (Function1 function1 : list) {
                        MediaControllerCompat mediaControllerCompat2 = mediaBrowserCompatHelper3.e;
                        function1.invoke(mediaControllerCompat2 != null ? mediaControllerCompat2.b() : null);
                    }
                    MediaBrowserCompatHelper.this.f.clear();
                } catch (Exception e) {
                    e.printStackTrace();
                    i.a.a("mediaSource --> connectionCallback --> e = " + Log.getStackTraceString(e));
                }
                MediaBrowserCompatHelper.this.g = false;
            } catch (Throwable th2) {
                MediaBrowserCompatHelper.this.g = false;
                throw th2;
            }
        }

        public void b() {
            super.b();
            MediaBrowserCompatHelper.this.g = false;
        }

        public void c() {
            super.c();
        }
    }

    public static final class c extends MediaControllerCompat.a {
        c() {
        }

        public void d(MediaMetadataCompat mediaMetadataCompat) {
            Intrinsics.h(mediaMetadataCompat, "metadata");
            super.d(mediaMetadataCompat);
        }

        public void e(PlaybackStateCompat playbackStateCompat) {
            super.e(playbackStateCompat);
        }
    }

    public static final class d extends MediaBrowserCompat.n {
        d() {
        }

        public void a(String str, List list) {
            Intrinsics.h(str, "parentId");
            Intrinsics.h(list, "children");
            super.a(str, list);
            i.a.a("mediaSource --> subscriptionCallback --> onChildrenLoaded() --> parentId = " + str + " -- children = " + list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(MediaControllerCompat.e eVar) {
        if (eVar != null) {
            eVar.c();
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MediaBrowserCompatHelper q() {
        return new MediaBrowserCompatHelper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(MediaItem mediaItem, MediaControllerCompat.e eVar) {
        if (eVar != null) {
            eVar.a("transsion_pause", androidx.core.os.d.b(new Pair[]{new Pair("MediaItem", mediaItem)}));
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(MediaItem mediaItem, MediaControllerCompat.e eVar) {
        if (eVar != null) {
            eVar.a("transsion_play", androidx.core.os.d.b(new Pair[]{new Pair("MediaItem", mediaItem)}));
        }
        return Unit.a;
    }

    private final void w(Function1 function1) {
        p(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(MediaControllerCompat.e eVar) {
        if (eVar != null) {
            eVar.b();
        }
        return Unit.a;
    }

    public final void p(Function1 function1) {
        MediaControllerCompat.e d2;
        try {
            Result.Companion companion = Result.Companion;
            MediaBrowserCompat mediaBrowserCompat = this.d;
            if (mediaBrowserCompat != null && mediaBrowserCompat.e()) {
                if (function1 != null) {
                    MediaControllerCompat mediaControllerCompat = this.e;
                    function1.invoke(mediaControllerCompat != null ? mediaControllerCompat.b() : null);
                    return;
                }
                return;
            }
            if (this.g) {
                if (function1 != null) {
                    this.f.add(function1);
                    return;
                }
                return;
            }
            this.g = true;
            Application a2 = Utils.a();
            if (a2 != null) {
                if (ThreadUtils.i()) {
                    if (function1 != null) {
                        this.f.add(function1);
                    }
                    MediaBrowserCompat mediaBrowserCompat2 = new MediaBrowserCompat(a2, new ComponentName(a2, (Class<?>) MediaService.class), this.c, (Bundle) null);
                    this.d = mediaBrowserCompat2;
                    mediaBrowserCompat2.a();
                    d2 = Unit.a;
                } else {
                    d2 = kotlinx.coroutines.i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new MediaBrowserCompatHelper$init$1$2$2(function1, this, a2, null), 3, (Object) null);
                }
                r2 = d2;
            }
            Result.constructor-impl(r2);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    public final void r(final MediaItem mediaItem) {
        w(new Function1() { // from class: com.transsion.player.mediasession.d
            public final Object invoke(Object obj) {
                Unit s;
                s = MediaBrowserCompatHelper.s(MediaItem.this, (MediaControllerCompat.e) obj);
                return s;
            }
        });
    }

    public final void t(final MediaItem mediaItem) {
        w(new Function1() { // from class: com.transsion.player.mediasession.b
            public final Object invoke(Object obj) {
                Unit u;
                u = MediaBrowserCompatHelper.u(MediaItem.this, (MediaControllerCompat.e) obj);
                return u;
            }
        });
    }

    public final void v(String str) {
        Intrinsics.h(str, "mediaId");
    }

    public final void x() {
        w(new Function1() { // from class: com.transsion.player.mediasession.c
            public final Object invoke(Object obj) {
                Unit y;
                y = MediaBrowserCompatHelper.y((MediaControllerCompat.e) obj);
                return y;
            }
        });
    }

    public final void z() {
        w(new Function1() { // from class: com.transsion.player.mediasession.e
            public final Object invoke(Object obj) {
                Unit A;
                A = MediaBrowserCompatHelper.A((MediaControllerCompat.e) obj);
                return A;
            }
        });
    }
}
