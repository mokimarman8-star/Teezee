package com.transsion.subtitle.helper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import com.blankj.utilcode.util.KeyboardUtils;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class h implements View.OnTouchListener {
    public static final a o = new a(null);
    private final ViewGroup a;
    private ht.a b;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private EditText f;
    private float h;
    private Function2 i;
    private Function0 j;
    private long k;
    private float l;
    private Handler g = new Handler(Looper.getMainLooper());
    private final Runnable m = new Runnable() { // from class: com.transsion.subtitle.helper.g
        @Override // java.lang.Runnable
        public final void run() {
            h.s(h.this);
        }
    };
    private final c n = new c(Looper.getMainLooper());

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            Editable text;
            Intrinsics.h(s, "s");
            h.this.g.removeCallbacks(h.this.m);
            EditText editText = h.this.f;
            if (editText == null || (text = editText.getText()) == null) {
                return;
            }
            h hVar = h.this;
            float m = h.m(hVar, text, 0.0f, 2, null);
            if (hVar.h != m) {
                hVar.h = m;
            }
            if (hVar.l == m) {
                return;
            }
            if (!StringsKt.G(text.toString(), "s", false, 2, null)) {
                EditText editText2 = hVar.f;
                if (editText2 != null) {
                    editText2.setText(((Object) text) + "s");
                }
                EditText editText3 = hVar.f;
                if (editText3 != null) {
                    editText3.setSelection(text.length());
                }
            }
            hVar.l = m;
            hVar.u((long) (m * 1000));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int i, int i2, int i3) {
            Intrinsics.h(s, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int i, int i2, int i3) {
            Intrinsics.h(s, "s");
        }
    }

    public static final class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Intrinsics.h(msg, "msg");
            super.handleMessage(msg);
            int i = msg.what;
            int i2 = msg.arg1;
            if (i == 1) {
                h.this.t(i2 == R$id.iv_sync_adjust_plus);
                sendMessageDelayed(obtainMessage(i, msg.arg1, msg.arg2), 100L);
            }
        }
    }

    public h(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    private final float l(CharSequence charSequence, float f) {
        if (charSequence.length() == 0) {
            return f;
        }
        String obj = charSequence.toString();
        if (StringsKt.G(obj, "s", false, 2, null)) {
            obj = obj.substring(0, obj.length() - 1);
            Intrinsics.g(obj, "substring(...)");
        }
        if (StringsKt.c0(obj, "s", false, 2, null)) {
            StringsKt.Q(obj, "s", HttpUrl.FRAGMENT_ENCODE_SET, false, 4, null);
        }
        try {
            return Float.parseFloat(obj);
        } catch (Throwable unused) {
            return f;
        }
    }

    static /* synthetic */ float m(h hVar, CharSequence charSequence, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = Float.NaN;
        }
        return hVar.l(charSequence, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(h hVar, View view) {
        Function0 function0 = hVar.j;
        if (function0 != null) {
            function0.invoke();
        }
        hVar.g.removeCallbacks(hVar.m);
        hVar.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(h hVar) {
        hVar.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(boolean z) {
        float f = (z ? (this.h * 1000.0f) + 100 : (this.h * 1000.0f) - 100) / 1000.0f;
        this.h = f;
        EditText editText = this.f;
        if (editText != null) {
            editText.setText(f + "s");
        }
        this.g.removeCallbacks(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(long j) {
        SubtitleDownloadTable b2;
        ht.a aVar = this.b;
        if (aVar != null && (b2 = aVar.b()) != null) {
            b2.setDelay(Long.valueOf(j));
        }
        Function2 function2 = this.i;
        if (function2 != null) {
            function2.invoke(this.b, Long.valueOf(j));
        }
    }

    public final void n() {
        ViewGroup viewGroup = this.a;
        if (viewGroup != null) {
            uf.c.g(viewGroup);
            KeyboardUtils.e(viewGroup);
        }
    }

    public final void o(Function2 function2) {
        this.i = function2;
        ViewGroup viewGroup = this.a;
        this.c = viewGroup != null ? (ImageView) viewGroup.findViewById(R$id.iv_close) : null;
        ViewGroup viewGroup2 = this.a;
        this.d = viewGroup2 != null ? (ImageView) viewGroup2.findViewById(R$id.iv_sync_adjust_plus) : null;
        ViewGroup viewGroup3 = this.a;
        this.e = viewGroup3 != null ? (ImageView) viewGroup3.findViewById(R$id.iv_sync_adjust_minus) : null;
        ViewGroup viewGroup4 = this.a;
        this.f = viewGroup4 != null ? (EditText) viewGroup4.findViewById(R$id.et_sync_adjust) : null;
        ImageView imageView = this.c;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.subtitle.helper.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h.p(h.this, view);
                }
            });
        }
        ImageView imageView2 = this.d;
        if (imageView2 != null) {
            imageView2.setOnTouchListener(this);
        }
        ImageView imageView3 = this.e;
        if (imageView3 != null) {
            imageView3.setOnTouchListener(this);
        }
        ImageView imageView4 = this.d;
        if (imageView4 != null) {
            imageView4.setFocusable(true);
        }
        ImageView imageView5 = this.e;
        if (imageView5 != null) {
            imageView5.setFocusable(true);
        }
        ImageView imageView6 = this.d;
        if (imageView6 != null) {
            imageView6.setClickable(true);
        }
        ImageView imageView7 = this.e;
        if (imageView7 != null) {
            imageView7.setClickable(true);
        }
        EditText editText = this.f;
        if (editText != null) {
            editText.addTextChangedListener(new b());
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.k = System.currentTimeMillis();
            c cVar = this.n;
            cVar.sendMessageDelayed(cVar.obtainMessage(1, view != null ? view.getId() : 0, 0), 1200L);
            if (view != null) {
                view.setPressed(true);
            }
        } else if (valueOf != null && valueOf.intValue() == 1) {
            this.n.removeCallbacksAndMessages(null);
            if (System.currentTimeMillis() - this.k <= 400) {
                t((view != null ? view.getId() : 0) == R$id.iv_sync_adjust_plus);
            }
            if (view != null) {
                view.setPressed(false);
            }
        }
        return true;
    }

    public final void q(Function2 callback) {
        Intrinsics.h(callback, "callback");
        this.i = callback;
    }

    public final void r(ht.a aVar) {
        SubtitleDownloadTable b2;
        Long delay;
        this.b = aVar;
        float longValue = ((aVar == null || (b2 = aVar.b()) == null || (delay = b2.getDelay()) == null) ? 0L : delay.longValue()) / 1000.0f;
        this.h = longValue;
        this.l = longValue;
        EditText editText = this.f;
        if (editText != null) {
            editText.setText(longValue + "s");
        }
        com.transsion.subtitle.a.a.a(h.class.getSimpleName() + " --> setCurDefVideoSubtitleBean() --> cur duration = " + this.h);
    }
}
