package i9;

import android.net.Uri;
import com.cloud.tmc.kernel.bridge.extension.BridgeResponse;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class i implements r {
    private static final int[] n = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14};
    private static final a o = new a(new a.InterfaceC0050a() { // from class: i9.g
        @Override // i9.i.a.InterfaceC0050a
        public final Constructor a() {
            Constructor e;
            e = i.e();
            return e;
        }
    });
    private static final a p = new a(new a.InterfaceC0050a() { // from class: i9.h
        @Override // i9.i.a.InterfaceC0050a
        public final Constructor a() {
            Constructor f;
            f = i.f();
            return f;
        }
    });
    private boolean b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int l;
    private int k = 1;
    private int m = 112800;

    /* JADX INFO: Access modifiers changed from: private */
    static final class a {
        private final InterfaceC0050a a;
        private final AtomicBoolean b = new AtomicBoolean(false);
        private Constructor c;

        /* renamed from: i9.i$a$a, reason: collision with other inner class name */
        public interface InterfaceC0050a {
            Constructor a();
        }

        public a(InterfaceC0050a interfaceC0050a) {
            this.a = interfaceC0050a;
        }

        private Constructor b() {
            synchronized (this.b) {
                if (this.b.get()) {
                    return this.c;
                }
                try {
                    return this.a.a();
                } catch (ClassNotFoundException unused) {
                    this.b.set(true);
                    return this.c;
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating extension", e);
                }
            }
        }

        public l a(Object... objArr) {
            Constructor b = b();
            if (b == null) {
                return null;
            }
            try {
                return (l) b.newInstance(objArr);
            } catch (Exception e) {
                throw new IllegalStateException("Unexpected error creating extractor", e);
            }
        }
    }

    private void d(int i, List list) {
        switch (i) {
            case 0:
                list.add(new s9.b());
                break;
            case 1:
                list.add(new s9.e());
                break;
            case 2:
                list.add(new s9.h((this.c ? 2 : 0) | this.d | (this.b ? 1 : 0)));
                break;
            case 3:
                list.add(new j9.b((this.c ? 2 : 0) | this.e | (this.b ? 1 : 0)));
                break;
            case 4:
                l a2 = o.a(Integer.valueOf(this.f));
                if (a2 == null) {
                    list.add(new l9.d(this.f));
                    break;
                } else {
                    list.add(a2);
                    break;
                }
            case 5:
                list.add(new com.google.android.exoplayer2.extractor.flv.b());
                break;
            case 6:
                list.add(new o9.e(this.g));
                break;
            case 7:
                list.add(new p9.f((this.c ? 2 : 0) | this.j | (this.b ? 1 : 0)));
                break;
            case 8:
                list.add(new q9.g(this.i));
                list.add(new q9.k(this.h));
                break;
            case 9:
                list.add(new r9.d());
                break;
            case BridgeResponse.ERROR_CODE_UNAUTHORIZED_USERINFO /* 10 */:
                list.add(new s9.a0());
                break;
            case 11:
                list.add(new s9.h0(this.k, this.l, this.m));
                break;
            case 12:
                list.add(new t9.b());
                break;
            case 14:
                list.add(new n9.a());
                break;
            case 15:
                l a3 = p.a(new Object[0]);
                if (a3 != null) {
                    list.add(a3);
                    break;
                }
                break;
            case 16:
                list.add(new k9.b());
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Constructor e() {
        if (Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", null).invoke(null, null))) {
            return Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(l.class).getConstructor(Integer.TYPE);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Constructor f() {
        return Class.forName("com.google.android.exoplayer2.decoder.midi.MidiExtractor").asSubclass(l.class).getConstructor(null);
    }

    @Override // i9.r
    public synchronized l[] c(Uri uri, Map map) {
        ArrayList arrayList;
        try {
            int[] iArr = n;
            arrayList = new ArrayList(iArr.length);
            int b = com.google.android.exoplayer2.util.l.b(map);
            if (b != -1) {
                d(b, arrayList);
            }
            int c = com.google.android.exoplayer2.util.l.c(uri);
            if (c != -1 && c != b) {
                d(c, arrayList);
            }
            for (int i : iArr) {
                if (i != b && i != c) {
                    d(i, arrayList);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return (l[]) arrayList.toArray(new l[arrayList.size()]);
    }

    @Override // i9.r
    public synchronized l[] createExtractors() {
        return c(Uri.EMPTY, new HashMap());
    }
}
