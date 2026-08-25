package com.gyf.immersionbar;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.gyf.immersionbar.g;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class j extends ContentObserver {
    private ArrayList a;
    private Application b;
    private boolean c;

    private static class b {
        private static final j a = new j();
    }

    private j() {
        super(new Handler(Looper.getMainLooper()));
        this.c = false;
    }

    static j b() {
        return b.a;
    }

    void a(n nVar) {
        if (nVar == null) {
            return;
        }
        if (this.a == null) {
            this.a = new ArrayList();
        }
        if (this.a.contains(nVar)) {
            return;
        }
        this.a.add(nVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void c(Application application) {
        Uri uriFor;
        Uri uri;
        this.b = application;
        if (application == null || application.getContentResolver() == null || this.c) {
            return;
        }
        Uri uri2 = null;
        if (!OSUtils.isHuaWei() && !OSUtils.isEMUI()) {
            if (OSUtils.isXiaoMi() || OSUtils.isMIUI()) {
                uriFor = Settings.Global.getUriFor("force_fsg_nav_bar");
                uri = null;
                uri2 = Settings.Global.getUriFor("hide_gesture_line");
            } else if (OSUtils.isVivo() || OSUtils.isFuntouchOrOriginOs()) {
                uriFor = Settings.Secure.getUriFor("navigation_gesture_on");
            } else if (OSUtils.isOppo() || OSUtils.isColorOs()) {
                uriFor = Settings.Secure.getUriFor("hide_navigationbar_enable");
            } else if (!OSUtils.isSamsung()) {
                uriFor = Settings.Secure.getUriFor("navigation_mode");
            } else if (Settings.Global.getInt(this.b.getContentResolver(), "navigationbar_hide_bar_enabled", -1) == -1) {
                uriFor = Settings.Global.getUriFor("navigation_bar_gesture_while_hidden");
                uri2 = Settings.Global.getUriFor("navigation_bar_gesture_detail_type");
                uri = Settings.Global.getUriFor("navigation_bar_gesture_hint");
            } else {
                uriFor = Settings.Global.getUriFor("navigationbar_hide_bar_enabled");
            }
            if (uriFor != null) {
                this.b.getContentResolver().registerContentObserver(uriFor, true, this);
                this.c = true;
            }
            if (uri2 != null) {
                this.b.getContentResolver().registerContentObserver(uri2, true, this);
            }
            if (uri == null) {
                this.b.getContentResolver().registerContentObserver(uri, true, this);
                return;
            }
            return;
        }
        uriFor = !OSUtils.isEMUI3_x() ? Settings.Global.getUriFor("navigationbar_is_min") : Settings.System.getUriFor("navigationbar_is_min");
        uri = null;
        if (uriFor != null) {
        }
        if (uri2 != null) {
        }
        if (uri == null) {
        }
    }

    void d(n nVar) {
        ArrayList arrayList;
        if (nVar == null || (arrayList = this.a) == null) {
            return;
        }
        arrayList.remove(nVar);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        super.onChange(z);
        ArrayList arrayList = this.a;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        g.a a2 = g.a(this.b);
        boolean z2 = true;
        if (a2.a && (!a2.b || com.gyf.immersionbar.a.f(this.b) <= 0)) {
            z2 = false;
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((n) it.next()).onNavigationBarChange(z2, a2.c);
        }
    }
}
