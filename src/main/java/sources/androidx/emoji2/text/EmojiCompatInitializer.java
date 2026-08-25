package androidx.emoji2.text;

import android.content.Context;
import androidx.core.os.s;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.lifecycle.e;
import androidx.lifecycle.f;
import androidx.lifecycle.u;
import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class EmojiCompatInitializer implements d4.a {

    static class LoadEmojiCompatRunnable implements Runnable {
        LoadEmojiCompatRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                s.a("EmojiCompat.EmojiCompatInitializer.run");
                if (EmojiCompat.i()) {
                    EmojiCompat.c().l();
                }
            } finally {
                s.b();
            }
        }
    }

    class a implements f {
        final /* synthetic */ Lifecycle a;

        a(Lifecycle lifecycle) {
            this.a = lifecycle;
        }

        public /* synthetic */ void onCreate(u uVar) {
            e.a(this, uVar);
        }

        public /* synthetic */ void onDestroy(u uVar) {
            e.b(this, uVar);
        }

        public /* synthetic */ void onPause(u uVar) {
            e.c(this, uVar);
        }

        public void onResume(u uVar) {
            EmojiCompatInitializer.this.e();
            this.a.d(this);
        }

        public /* synthetic */ void onStart(u uVar) {
            e.e(this, uVar);
        }

        public /* synthetic */ void onStop(u uVar) {
            e.f(this, uVar);
        }
    }

    public List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean b(Context context) {
        EmojiCompat.h(new b(context));
        d(context);
        return Boolean.TRUE;
    }

    void d(Context context) {
        Lifecycle lifecycle = ((u) androidx.startup.a.e(context).f(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.a(new a(lifecycle));
    }

    void e() {
        c.d().postDelayed(new LoadEmojiCompatRunnable(), 500L);
    }
}
