package com.transsion.ugcvideodetail.widget.expand;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import com.transsion.shorttv.R;
import com.transsion.shorttv_pugc.base.widget.TnTextView;
import com.transsion.ugcvideodetail.widget.expand.UGCImmExpandView;
import kotlin.jvm.functions.Function0;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class UGCImmExpandView extends TnTextView {
    public static final int STATE_EXPAND = 1;
    public static final int STATE_SHRINK = 0;
    private String A;
    private boolean B;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private float s;
    private boolean t;
    private ClickableSpan u;
    private mu.a v;
    private mu.a w;
    private Layout x;
    private CharSequence y;
    private String z;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            UGCImmExpandView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            UGCImmExpandView uGCImmExpandView = UGCImmExpandView.this;
            uGCImmExpandView.l(uGCImmExpandView.y);
            UGCImmExpandView.this.k = true;
        }
    }

    public interface b {
    }

    public interface c {
    }

    public UGCImmExpandView(Context context) {
        this(context, null);
    }

    public UGCImmExpandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = "  ";
        this.f = "  ";
        this.g = false;
        this.h = true;
        this.i = true;
        this.j = true;
        this.k = false;
        this.l = 1;
        this.m = -1711276033;
        this.n = -1711276033;
        this.o = 0;
        this.p = 0;
        this.q = -1;
        this.r = 0;
        this.t = true;
        this.B = false;
        j(context, attributeSet);
    }

    public UGCImmExpandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = "  ";
        this.f = "  ";
        this.g = false;
        this.h = true;
        this.i = true;
        this.j = true;
        this.k = false;
        this.l = 1;
        this.m = -1711276033;
        this.n = -1711276033;
        this.o = 0;
        this.p = 0;
        this.q = -1;
        this.r = 0;
        this.t = true;
        this.B = false;
        j(context, attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int getLayoutWidth() {
        Layout layout = getLayout();
        int width = layout != null ? layout.getWidth() : 0;
        return (width > 0 || getWidth() == 0) ? width : (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private CharSequence h(int i) {
        int i2;
        TextPaint paint = getPaint();
        CharSequence charSequence = this.y;
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        if (charSequence != null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET + ((Object) this.y);
        }
        if (this.x == null) {
            this.x = new StaticLayout(str, paint, i, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        }
        int lineCount = this.x.getLineCount();
        int i3 = this.l;
        if (lineCount <= i3) {
            CharSequence charSequence2 = this.y;
            if (charSequence2 == null) {
                charSequence2 = " ";
            }
            return n(new SpannableStringBuilder(charSequence2));
        }
        int i4 = this.r;
        if (i4 != 0) {
            if (i4 != 1 || !this.j) {
                return n(new SpannableStringBuilder(this.y));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.y);
            spannableStringBuilder.append((CharSequence) this.f).append((CharSequence) this.d);
            int length = (spannableStringBuilder.length() - this.f.length()) - this.d.length();
            int length2 = spannableStringBuilder.length();
            i2 = length >= 0 ? length : 0;
            spannableStringBuilder.setSpan(this.u, i2, length2, 33);
            spannableStringBuilder.setSpan(this.v, i2, length2, 33);
            return n(spannableStringBuilder);
        }
        int lineEnd = this.x.getLineEnd(i3 - 1);
        this.x.getLineStart(this.l - 1);
        CharSequence charSequence3 = this.y;
        if (charSequence3 != null && charSequence3.length() <= lineEnd) {
            lineEnd = this.y.length() - 1;
        }
        CharSequence charSequence4 = this.y;
        if (charSequence4 == null || lineEnd <= 0) {
            return charSequence4;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder((charSequence4.subSequence(0, Math.max(0, lineEnd - 3)).toString() + this.b).replace("\n\n", "\n"));
        if (this.i) {
            spannableStringBuilder2.append((CharSequence) this.e);
            spannableStringBuilder2.append((CharSequence) this.c);
            int length3 = (spannableStringBuilder2.length() - this.e.length()) - this.c.length();
            int length4 = spannableStringBuilder2.length();
            i2 = length3 >= 0 ? length3 : 0;
            spannableStringBuilder2.setSpan(this.u, i2, length4, 33);
            spannableStringBuilder2.setSpan(this.w, i2, length4, 33);
        }
        return n(spannableStringBuilder2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void i() {
        if (this.s == 0.0f) {
            this.s = getTextSize();
        }
        boolean z = getLayoutDirection() == 1;
        this.w = new mu.a(getContext(), this.t ? R.mipmap.short_tv_ic_down_more : -111, this.m, this.o, this.s, 0, z);
        this.v = new mu.a(getContext(), this.t ? R.mipmap.short_tv_ic_up_hide : -111, this.n, this.p, this.s, 0, z);
        setMovementMethod(new LinkMovementMethod());
        if (TextUtils.isEmpty(this.b)) {
            this.b = "...";
        }
        if (TextUtils.isEmpty(this.c)) {
            this.c = getResources().getString(R.string.short_tv_str_more);
        }
        if (TextUtils.isEmpty(this.d)) {
            this.d = "\n" + getResources().getString(R.string.short_tv_str_hide);
        }
        if (this.e == null) {
            this.e = "  ";
        }
        if (this.f == null) {
            this.f = "  ";
        }
        setOnClickListener(new View.OnClickListener() { // from class: mu.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UGCImmExpandView.this.k(view);
            }
        });
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    private void j(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            i();
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.ExpandView_pop_hint_text_size) {
                this.s = obtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == R.styleable.ExpandView_pop_reverse_Lines) {
                this.l = obtainStyledAttributes.getInteger(index, 1);
            } else if (index == R.styleable.ExpandView_pop_ellipsis) {
                this.b = obtainStyledAttributes.getString(index);
            } else if (index == R.styleable.ExpandView_pop_expand_hint) {
                this.c = obtainStyledAttributes.getString(index);
            } else if (index == R.styleable.ExpandView_pop_shrink_hint) {
                this.d = obtainStyledAttributes.getString(index);
            } else if (index == R.styleable.ExpandView_pop_toggle_enabled) {
                this.g = obtainStyledAttributes.getBoolean(index, this.g);
            } else if (index == R.styleable.ExpandView_pop_show_expand_hint) {
                this.i = obtainStyledAttributes.getBoolean(index, this.i);
            } else if (index == R.styleable.ExpandView_pop_show_shrink_hint) {
                this.j = obtainStyledAttributes.getBoolean(index, this.j);
            } else if (index == R.styleable.ExpandView_pop_expand_hint_color) {
                this.m = obtainStyledAttributes.getInteger(index, -1711276033);
            } else if (index == R.styleable.ExpandView_pop_shrink_hint_color) {
                this.n = obtainStyledAttributes.getInteger(index, -1711276033);
            } else if (index == R.styleable.ExpandView_pop_expand_bg_Color) {
                this.o = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.ExpandView_pop_shrink_bg_color) {
                this.p = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.ExpandView_pop_Init_state) {
                this.r = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.ExpandView_pop_expand_gap) {
                this.e = obtainStyledAttributes.getString(index);
            } else if (index == R.styleable.ExpandView_pop_collapse_gap) {
                this.f = obtainStyledAttributes.getString(index);
            } else if (index == R.styleable.ExpandView_pop_hash_tag_color) {
                this.q = obtainStyledAttributes.getInteger(index, this.q);
            } else if (index == R.styleable.ExpandView_pop_show_hint_icon) {
                this.t = obtainStyledAttributes.getBoolean(index, true);
            }
        }
        obtainStyledAttributes.recycle();
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(View view) {
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ CharSequence m(final CharSequence charSequence) {
        if (!this.h) {
            return charSequence;
        }
        if (!TextUtils.equals(charSequence, this.y)) {
            this.x = null;
        }
        this.y = charSequence;
        int layoutWidth = getLayoutWidth();
        if (layoutWidth > 0) {
            this.B = true;
            return this.y == null ? charSequence : h(layoutWidth);
        }
        if (this.k) {
            postDelayed(new Runnable() { // from class: mu.d
                @Override // java.lang.Runnable
                public final void run() {
                    UGCImmExpandView.this.l(charSequence);
                }
            }, 100L);
        }
        return null;
    }

    private CharSequence n(SpannableStringBuilder spannableStringBuilder) {
        return spannableStringBuilder;
    }

    private void o() {
        if (getText().toString().contains(this.c) || getText().toString().contains(this.d)) {
            int i = this.r;
            if (i == 0) {
                this.r = 1;
            } else if (i == 1) {
                this.r = 0;
            }
            l(this.y);
        }
    }

    public void addLegacyHashTag(String str, String str2) {
        this.A = str;
        this.z = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.shorttv_pugc.base.widget.TnTextView, js.a
    public void changeLocal() {
        this.c = getResources().getString(R.string.short_tv_str_more);
        this.d = getResources().getString(R.string.short_tv_str_hide);
        super.changeLocal();
    }

    public int getExpandState() {
        return this.r;
    }

    public boolean isOutLines() {
        Layout layout = this.x;
        return layout != null && layout.getLineCount() > this.l;
    }

    public boolean isSetTitleSuccess() {
        return this.B;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void reset() {
        this.r = 0;
        l(this.y);
    }

    public void setCollapseEnable(boolean z) {
        this.h = z;
    }

    public void setExpandListener(c cVar) {
    }

    public void setOnClickHashTagListener(b bVar) {
    }

    /* renamed from: setTitle, reason: merged with bridge method [inline-methods] */
    public void l(final CharSequence charSequence) {
        setTextAction(new Function0() { // from class: mu.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                CharSequence m;
                m = UGCImmExpandView.this.m(charSequence);
                return m;
            }
        });
    }
}
