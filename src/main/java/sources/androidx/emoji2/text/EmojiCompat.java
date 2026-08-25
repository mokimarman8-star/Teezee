package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.b;
import androidx.core.util.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class EmojiCompat {
    private static final Object o = new Object();
    private static final Object p = new Object();
    private static volatile EmojiCompat q;
    private final Set b;
    private final b e;
    final g f;
    private final i g;
    final boolean h;
    final boolean i;
    final int[] j;
    private final boolean k;
    private final int l;
    private final int m;
    private final e n;
    private final ReadWriteLock a = new ReentrantReadWriteLock();
    private volatile int c = 3;
    private final Handler d = new Handler(Looper.getMainLooper());

    private static class ListenerDispatcher implements Runnable {
        private final List<f> mInitCallbacks;
        private final int mLoadState;
        private final Throwable mThrowable;

        ListenerDispatcher(@NonNull f fVar, int i) {
            this(Arrays.asList((f) i.h(fVar, "initCallback cannot be null")), i, null);
        }

        ListenerDispatcher(@NonNull Collection<f> collection, int i) {
            this(collection, i, null);
        }

        ListenerDispatcher(@NonNull Collection<f> collection, int i, @Nullable Throwable th) {
            i.h(collection, "initCallbacks cannot be null");
            this.mInitCallbacks = new ArrayList(collection);
            this.mLoadState = i;
            this.mThrowable = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.mInitCallbacks.size();
            int i = 0;
            if (this.mLoadState != 1) {
                while (i < size) {
                    this.mInitCallbacks.get(i).a(this.mThrowable);
                    i++;
                }
            } else {
                while (i < size) {
                    this.mInitCallbacks.get(i).b();
                    i++;
                }
            }
        }
    }

    private EmojiCompat(c cVar) {
        this.h = cVar.c;
        this.i = cVar.d;
        this.j = cVar.e;
        this.k = cVar.g;
        this.l = cVar.h;
        this.f = cVar.a;
        this.m = cVar.i;
        this.n = cVar.j;
        b bVar = new b();
        this.b = bVar;
        d dVar = cVar.b;
        this.g = dVar == null ? new d() : dVar;
        Set set = cVar.f;
        if (set != null && !set.isEmpty()) {
            bVar.addAll(cVar.f);
        }
        this.e = new a(this);
        m();
    }

    public static EmojiCompat c() {
        EmojiCompat emojiCompat;
        synchronized (o) {
            emojiCompat = q;
            i.i(emojiCompat != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return emojiCompat;
    }

    public static boolean f(InputConnection inputConnection, Editable editable, int i, int i2, boolean z) {
        return h.b(inputConnection, editable, i, i2, z);
    }

    public static boolean g(Editable editable, int i, KeyEvent keyEvent) {
        return h.c(editable, i, keyEvent);
    }

    public static EmojiCompat h(c cVar) {
        EmojiCompat emojiCompat = q;
        if (emojiCompat == null) {
            synchronized (o) {
                try {
                    emojiCompat = q;
                    if (emojiCompat == null) {
                        emojiCompat = new EmojiCompat(cVar);
                        q = emojiCompat;
                    }
                } finally {
                }
            }
        }
        return emojiCompat;
    }

    public static boolean i() {
        return q != null;
    }

    private boolean k() {
        return e() == 1;
    }

    private void m() {
        this.a.writeLock().lock();
        try {
            if (this.m == 0) {
                this.c = 0;
            }
            this.a.writeLock().unlock();
            if (e() == 0) {
                this.e.a();
            }
        } catch (Throwable th) {
            this.a.writeLock().unlock();
            throw th;
        }
    }

    public int d() {
        return this.l;
    }

    public int e() {
        this.a.readLock().lock();
        try {
            return this.c;
        } finally {
            this.a.readLock().unlock();
        }
    }

    public boolean j() {
        return this.k;
    }

    public void l() {
        i.i(this.m == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (k()) {
            return;
        }
        this.a.writeLock().lock();
        try {
            if (this.c == 0) {
                return;
            }
            this.c = 0;
            this.a.writeLock().unlock();
            this.e.a();
        } finally {
            this.a.writeLock().unlock();
        }
    }

    void n(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.a.writeLock().lock();
        try {
            this.c = 2;
            arrayList.addAll(this.b);
            this.b.clear();
            this.a.writeLock().unlock();
            this.d.post(new ListenerDispatcher(arrayList, this.c, th));
        } catch (Throwable th2) {
            this.a.writeLock().unlock();
            throw th2;
        }
    }

    void o() {
        ArrayList arrayList = new ArrayList();
        this.a.writeLock().lock();
        try {
            this.c = 1;
            arrayList.addAll(this.b);
            this.b.clear();
            this.a.writeLock().unlock();
            this.d.post(new ListenerDispatcher(arrayList, this.c));
        } catch (Throwable th) {
            this.a.writeLock().unlock();
            throw th;
        }
    }

    public CharSequence p(CharSequence charSequence) {
        return q(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence q(CharSequence charSequence, int i, int i2) {
        return r(charSequence, i, i2, Integer.MAX_VALUE);
    }

    public CharSequence r(CharSequence charSequence, int i, int i2, int i3) {
        return s(charSequence, i, i2, i3, 0);
    }

    public CharSequence s(CharSequence charSequence, int i, int i2, int i3, int i4) {
        boolean z;
        i.i(k(), "Not initialized yet");
        i.e(i, "start cannot be negative");
        i.e(i2, "end cannot be negative");
        i.e(i3, "maxEmojiCount cannot be negative");
        i.b(i <= i2, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        i.b(i <= charSequence.length(), "start should be < than charSequence length");
        i.b(i2 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i == i2) {
            return charSequence;
        }
        if (i4 != 1) {
            z = i4 != 2 ? this.h : false;
        } else {
            z = true;
        }
        return this.e.b(charSequence, i, i2, i3, z);
    }

    public void t(f fVar) {
        i.h(fVar, "initCallback cannot be null");
        this.a.writeLock().lock();
        try {
            if (this.c != 1 && this.c != 2) {
                this.b.add(fVar);
                this.a.writeLock().unlock();
            }
            this.d.post(new ListenerDispatcher(fVar, this.c));
            this.a.writeLock().unlock();
        } catch (Throwable th) {
            this.a.writeLock().unlock();
            throw th;
        }
    }

    public void u(f fVar) {
        i.h(fVar, "initCallback cannot be null");
        this.a.writeLock().lock();
        try {
            this.b.remove(fVar);
        } finally {
            this.a.writeLock().unlock();
        }
    }

    public void v(EditorInfo editorInfo) {
        if (!k() || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        this.e.c(editorInfo);
    }
}
