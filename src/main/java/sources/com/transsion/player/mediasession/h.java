package com.transsion.player.mediasession;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.app.z;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.session.MediaButtonReceiver;
import androidx.media3.common.util.f0;
import androidx.media3.common.util.g0;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.a0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.R$mipmap;
import com.transsion.player.R$string;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h {
    private static boolean b;
    private static MediaSessionCompat c;
    private static MediaService d;
    private static MediaItem e;
    private static Integer f;
    private static Bitmap g;
    public static final h a = new h();
    private static String h = BuildConfig.FLAVOR;
    private static final a i = new a();

    public static final class a extends CustomTarget {
        a() {
        }

        public void onLoadCleared(Drawable drawable) {
            i.a.a(h.a.i() + " --> loadAlbum --> onLoadCleared() ---> 加载失败");
        }

        public void onLoadFailed(Drawable drawable) {
            super.onLoadFailed(drawable);
            i iVar = i.a;
            h hVar = h.a;
            iVar.a(hVar.i() + " --> loadAlbum --> onLoadFailed() ---> 加载失败");
            h.g = BitmapFactory.decodeResource(Utils.a().getResources(), R$mipmap.player_ic_notification_icon);
            hVar.o(h.d, h.e, h.f, h.c);
        }

        public void onResourceReady(Bitmap bitmap, Transition transition) {
            Intrinsics.h(bitmap, "resource");
            String str = h.h;
            MediaItem mediaItem = h.e;
            if (TextUtils.equals(str, mediaItem != null ? mediaItem.getCoverUrl() : null)) {
                h.g = bitmap;
                h.a.o(h.d, h.e, h.f, h.c);
            }
        }
    }

    private h() {
    }

    private final Bitmap h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return q(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String i() {
        String simpleName = h.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final String k(String str) {
        String b2;
        b2 = sn.h.a.b(str, a0.a(48.0f), (r18 & 4) != 0 ? true : true, (r18 & 8) != 0, (r18 & 16) != 0 ? 0 : 0, (r18 & 32) != 0 ? false : false, (r18 & 64) != 0 ? false : false);
        return b2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m(MediaService mediaService, MediaItem mediaItem, Integer num, MediaSessionCompat mediaSessionCompat) {
        String str;
        String subTitle;
        d = mediaService;
        e = mediaItem;
        f = num;
        c = mediaSessionCompat;
        n();
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        NotificationCompat.m mVar = new NotificationCompat.m(a2, "MUSIC_NOTIFICATION_ID");
        String str2 = "VideoPlayer";
        if (mediaItem == null || (str = mediaItem.getTitle()) == null) {
            str = "VideoPlayer";
        }
        NotificationCompat.m r = mVar.r(str);
        if (mediaItem != null && (subTitle = mediaItem.getSubTitle()) != null) {
            str2 = subTitle;
        }
        NotificationCompat.m q = r.q(str2);
        Intrinsics.g(q, "setContentText(...)");
        Bitmap bitmap = g;
        if (bitmap == null) {
            q.A(BitmapFactory.decodeResource(Utils.a().getResources(), R$mipmap.player_ic_push_small_logo));
        } else {
            q.A(bitmap);
        }
        q.v(MusicNotificationBroadcastReceiver.INSTANCE.a());
        Object obj = null;
        if ((mediaItem != null ? mediaItem.getPendingIntent() : null) != null) {
            q.p(mediaItem.getPendingIntent());
        }
        q.O(1);
        if (num != null && num.intValue() == 3) {
            q.b(new NotificationCompat.b.a(R$mipmap.player_pause, MediaItem.MUSIC_FLOAT_STATE_PAUSE, MediaButtonReceiver.a(a2, 2L)).a());
        } else {
            q.b(new NotificationCompat.b.a(R$mipmap.player_play, MediaItem.MUSIC_FLOAT_STATE_PLAY, MediaButtonReceiver.a(a2, 4L)).a());
        }
        androidx.media.app.c cVar = new androidx.media.app.c();
        MediaSessionCompat mediaSessionCompat2 = c;
        q.L(cVar.q(mediaSessionCompat2 != null ? mediaSessionCompat2.b() : null).r(new int[]{0}));
        q.J(R$mipmap.player_ic_push_small_logo);
        try {
            Notification c2 = q.c();
            Intrinsics.e(c2);
            c2.flags = 224;
            if (b) {
                if (mediaService != 0) {
                    try {
                        obj = mediaService.getSystemService("notification");
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        return;
                    }
                }
                Intrinsics.f(obj, "null cannot be cast to non-null type android.app.NotificationManager");
                ((NotificationManager) obj).notify(89757, c2);
                return;
            }
            if (!com.blankj.utilcode.util.c.j()) {
                i.a.b("Service is restricted, cannot start foreground.");
                return;
            }
            if (mediaService != 0) {
                try {
                    mediaService.startForeground(89757, c2);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    try {
                        Object systemService = mediaService.getSystemService("notification");
                        Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                        ((NotificationManager) systemService).notify(89757, c2);
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
            }
            b = true;
        } catch (Throwable unused) {
        }
    }

    private final void n() {
        Object obj;
        String str;
        MediaItem mediaItem = e;
        String coverUrl = mediaItem != null ? mediaItem.getCoverUrl() : null;
        if (TextUtils.isEmpty(coverUrl) || TextUtils.equals(h, coverUrl)) {
            return;
        }
        h = coverUrl;
        if (coverUrl != null && StringsKt.c0(coverUrl, "http", false, 2, (Object) null)) {
            g = null;
            RequestBuilder diskCacheStrategy = Glide.with(Utils.a()).asBitmap().centerInside().diskCacheStrategy(DiskCacheStrategy.DATA);
            MediaItem mediaItem2 = e;
            if (mediaItem2 == null || (str = mediaItem2.getCoverUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            Intrinsics.e(diskCacheStrategy.load(k(str)).into(i));
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            g = a.h(h);
            obj = Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            g = BitmapFactory.decodeResource(Utils.a().getResources(), R$mipmap.player_ic_push_small_logo);
        }
        m(d, e, f, c);
    }

    private final Bitmap q(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int a2 = a0.a(48.0f);
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i2 = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i3 = options.outWidth;
            int i4 = options.outHeight;
            if (i3 <= a2 && i4 <= a2) {
                options.inJustDecodeBounds = false;
                return BitmapFactory.decodeFile(str, options);
            }
            if (i4 > a2 || i3 > a2) {
                float f2 = a2;
                i2 = Math.round(RangesKt.d(i4 / f2, i3 / f2));
            }
            options.inSampleSize = i2;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public final int j() {
        return Build.VERSION.SDK_INT >= 31 ? 67108864 : 134217728;
    }

    public final void l() {
        i.a.a(i() + " --> initNotificationChannel() --> 初始化 通知的 渠道");
        Object systemService = Utils.a().getSystemService("notification");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (Build.VERSION.SDK_INT >= 26) {
            g0.a();
            NotificationChannel a2 = m.f.a("MUSIC_NOTIFICATION_ID", Utils.a().getString(R$string.player_notification_name), 3);
            a2.setSound(null, null);
            f0.a(a2, "playing media");
            m.c.a(notificationManager, a2);
        }
        MusicNotificationBroadcastReceiver.INSTANCE.b();
    }

    public final void o(MediaService mediaService, MediaItem mediaItem, Integer num, MediaSessionCompat mediaSessionCompat) {
        if (mediaItem != null) {
            m(mediaService, mediaItem, num, mediaSessionCompat);
            return;
        }
        i.a.b(i() + " --> notifyNotification() --> mediaItem == null --> return");
        p();
    }

    public final void p() {
        MediaBrowserServiceCompat mediaBrowserServiceCompat = d;
        if (mediaBrowserServiceCompat != null) {
            z.a(mediaBrowserServiceCompat, 1);
        }
        Object systemService = Utils.a().getSystemService("notification");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancel(89757);
        b = false;
    }

    public final void r(boolean z) {
        b = z;
    }
}
