package ya;

import android.os.Build;
import android.view.View;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.r;
import androidx.appcompat.app.t;
import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class c {
    private final d a;
    private final ya.b b;
    private final View c;

    private static class b implements d {
        private OnBackInvokedCallback a;

        private b() {
        }

        @Override // ya.c.d
        public void a(@NonNull View view) {
            OnBackInvokedDispatcher findOnBackInvokedDispatcher;
            findOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
            if (findOnBackInvokedDispatcher == null) {
                return;
            }
            r.a(findOnBackInvokedDispatcher, this.a);
            this.a = null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0005, code lost:
        
            r3 = r3.findOnBackInvokedDispatcher();
         */
        @Override // ya.c.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(@NonNull ya.b bVar, @NonNull View view, boolean z) {
            OnBackInvokedDispatcher findOnBackInvokedDispatcher;
            if (this.a == null && findOnBackInvokedDispatcher != null) {
                OnBackInvokedCallback c = c(bVar);
                this.a = c;
                t.a(findOnBackInvokedDispatcher, z ? 1000000 : 0, c);
            }
        }

        OnBackInvokedCallback c(final ya.b bVar) {
            Objects.requireNonNull(bVar);
            return new OnBackInvokedCallback() { // from class: ya.e
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    b.this.handleBackInvoked();
                }
            };
        }

        boolean d() {
            return this.a != null;
        }
    }

    /* renamed from: ya.c$c, reason: collision with other inner class name */
    private static class C0203c extends b {

        /* renamed from: ya.c$c$a */
        class a implements OnBackAnimationCallback {
            final /* synthetic */ ya.b a;

            a(ya.b bVar) {
                this.a = bVar;
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackCancelled() {
                if (C0203c.this.d()) {
                    this.a.cancelBackProgress();
                }
            }

            @Override // android.window.OnBackInvokedCallback
            public void onBackInvoked() {
                this.a.handleBackInvoked();
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackProgressed(BackEvent backEvent) {
                if (C0203c.this.d()) {
                    this.a.updateBackProgress(new androidx.activity.b(backEvent));
                }
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackStarted(BackEvent backEvent) {
                if (C0203c.this.d()) {
                    this.a.startBackProgress(new androidx.activity.b(backEvent));
                }
            }
        }

        private C0203c() {
            super();
        }

        @Override // ya.c.b
        OnBackInvokedCallback c(ya.b bVar) {
            return new a(bVar);
        }
    }

    private interface d {
        void a(View view);

        void b(ya.b bVar, View view, boolean z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(View view) {
        this((ya.b) view, view);
    }

    public c(ya.b bVar, View view) {
        this.a = a();
        this.b = bVar;
        this.c = view;
    }

    private static d a() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            return new C0203c();
        }
        if (i >= 33) {
            return new b();
        }
        return null;
    }

    private void d(boolean z) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.b(this.b, this.c, z);
        }
    }

    public boolean b() {
        return this.a != null;
    }

    public void c() {
        d(false);
    }

    public void e() {
        d(true);
    }

    public void f() {
        d dVar = this.a;
        if (dVar != null) {
            dVar.a(this.c);
        }
    }
}
