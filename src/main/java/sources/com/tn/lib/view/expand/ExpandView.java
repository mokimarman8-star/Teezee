package com.tn.lib.view.expand;

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
import com.tn.lib.view.expand.ExpandView;
import com.tn.lib.widget.R;
import com.tn.lib.widget.TnTextView;
import kotlin.jvm.functions.Function0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class ExpandView extends TnTextView {
    public static final int STATE_EXPAND = 1;
    public static final int STATE_SHRINK = 0;
    private String A;
    private String B;
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
    private bh.a v;
    private bh.a w;
    private Layout x;
    private CharSequence y;
    private c z;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ExpandView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ExpandView expandView = ExpandView.this;
            expandView.m(expandView.y);
            ExpandView.this.k = true;
        }
    }

    public interface b {
    }

    public interface c {
        void a(ExpandView expandView);

        void b(ExpandView expandView);
    }

    public ExpandView(Context context) {
        this(context, null);
    }

    public ExpandView(Context context, AttributeSet attributeSet) {
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
        this.o = 872415231;
        this.p = 872415231;
        this.q = -1;
        this.r = 0;
        this.t = true;
        k(context, attributeSet);
    }

    public ExpandView(Context context, AttributeSet attributeSet, int i) {
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
        this.o = 872415231;
        this.p = 872415231;
        this.q = -1;
        this.r = 0;
        this.t = true;
        k(context, attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int getLayoutWidth() {
        Layout layout = getLayout();
        int width = layout != null ? layout.getWidth() : 0;
        return (width > 0 || getWidth() == 0) ? width : (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private CharSequence h(int i) {
        String str;
        int i2;
        TextPaint paint = getPaint();
        if (this.y != null) {
            str = "" + ((Object) this.y);
        } else {
            str = "";
        }
        if (this.x == null) {
            this.x = new StaticLayout(str, paint, i, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        }
        int lineCount = this.x.getLineCount();
        int i3 = this.l;
        if (lineCount <= i3) {
            CharSequence charSequence = this.y;
            if (charSequence == null) {
                charSequence = " ";
            }
            return o(new SpannableStringBuilder(charSequence));
        }
        int i4 = this.r;
        if (i4 != 0) {
            if (i4 != 1 || !this.j) {
                return o(new SpannableStringBuilder(this.y));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.y);
            spannableStringBuilder.append((CharSequence) this.f).append((CharSequence) this.d);
            int length = (spannableStringBuilder.length() - this.f.length()) - this.d.length();
            int length2 = spannableStringBuilder.length();
            i2 = length >= 0 ? length : 0;
            spannableStringBuilder.setSpan(this.u, i2, length2, 33);
            spannableStringBuilder.setSpan(this.v, i2, length2, 33);
            return o(spannableStringBuilder);
        }
        int i5 = i(str, paint, this.x.getLineStart(this.l - 1), this.x.getLineEnd(i3 - 1), i);
        CharSequence charSequence2 = this.y;
        if (charSequence2 != null && charSequence2.length() <= i5) {
            i5 = this.y.length() - 1;
        }
        CharSequence charSequence3 = this.y;
        if (charSequence3 == null || i5 <= 0) {
            return charSequence3;
        }
        SpannableStringBuilder append = new SpannableStringBuilder(charSequence3.subSequence(0, i5)).append((CharSequence) this.b);
        if (this.i) {
            append.append((CharSequence) this.e);
            append.append((CharSequence) this.c);
            int length3 = (append.length() - this.e.length()) - this.c.length();
            int length4 = append.length();
            i2 = length3 >= 0 ? length3 : 0;
            append.setSpan(this.u, i2, length4, 33);
            append.setSpan(this.w, i2, length4, 33);
        }
        return o(append);
    }

    private int i(String str, TextPaint textPaint, int i, int i2, int i3) {
        String str2;
        bh.a aVar = this.w;
        String str3 = this.b;
        if (this.i) {
            str2 = this.c + this.e;
        } else {
            str2 = "";
        }
        return textPaint.breakText(str, i, i2, true, i3 - aVar.e(textPaint, str3, str2), null) + i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void j() {
        if (this.s == 0.0f) {
            this.s = getTextSize();
        }
        boolean z = getLayoutDirection() == 1;
        this.w = new bh.a(getContext(), this.t ? R.mipmap.info_player_ic_expand : -111, this.m, this.o, this.s, 5, z);
        this.v = new bh.a(getContext(), this.t ? R.mipmap.info_player_ic_collapse : -111, this.n, this.p, this.s, 5, z);
        setMovementMethod(new LinkMovementMethod());
        if (TextUtils.isEmpty(this.b)) {
            this.b = "...";
        }
        if (TextUtils.isEmpty(this.c)) {
            this.c = getResources().getString(R.string.player_more);
        }
        if (TextUtils.isEmpty(this.d)) {
            this.d = getResources().getString(R.string.player_hide);
        }
        if (this.e == null) {
            this.e = "  ";
        }
        if (this.f == null) {
            this.f = "  ";
        }
        setOnClickListener(new View.OnClickListener() { // from class: bh.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandView.this.l(view);
            }
        });
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    private void k(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            j();
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
                this.o = obtainStyledAttributes.getInteger(index, 872415231);
            } else if (index == R.styleable.ExpandView_pop_shrink_bg_color) {
                this.p = obtainStyledAttributes.getInteger(index, 872415231);
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
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(View view) {
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ CharSequence n(final CharSequence charSequence) {
        if (!this.h) {
            return charSequence;
        }
        if (!TextUtils.equals(charSequence, this.y)) {
            this.x = null;
        }
        this.y = charSequence;
        int layoutWidth = getLayoutWidth();
        if (layoutWidth > 0) {
            return this.y == null ? charSequence : h(layoutWidth);
        }
        if (this.k) {
            postDelayed(new Runnable() { // from class: bh.d
                @Override // java.lang.Runnable
                public final void run() {
                    ExpandView.this.m(charSequence);
                }
            }, 100L);
        }
        return null;
    }

    private CharSequence o(SpannableStringBuilder spannableStringBuilder) {
        return spannableStringBuilder;
    }

    private void p() {
        if (getText().toString().contains(this.c) || getText().toString().contains(this.d)) {
            int i = this.r;
            if (i == 0) {
                this.r = 1;
                c cVar = this.z;
                if (cVar != null) {
                    cVar.b(this);
                }
            } else if (i == 1) {
                this.r = 0;
                c cVar2 = this.z;
                if (cVar2 != null) {
                    cVar2.a(this);
                }
            }
            m(this.y);
        }
    }

    public void addLegacyHashTag(String str, String str2) {
        this.B = str;
        this.A = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void changeLocal() {
        this.c = getResources().getString(R.string.player_more);
        this.d = getResources().getString(R.string.player_hide);
        super.changeLocal();
    }

    public int getExpandState() {
        return this.r;
    }

    public boolean isOutLines() {
        Layout layout = this.x;
        return layout != null && layout.getLineCount() > this.l;
    }

    protected void onDetachedFromWindow() {
        super/*androidx.appcompat.widget.AppCompatTextView*/.onDetachedFromWindow();
    }

    public void reset() {
        this.r = 0;
        c cVar = this.z;
        if (cVar != null) {
            cVar.a(this);
        }
        m(this.y);
    }

    public void setCollapseEnable(boolean z) {
        this.h = z;
    }

    public void setExpandListener(c cVar) {
        this.z = cVar;
    }

    public void setOnClickHashTagListener(b bVar) {
    }

    /* renamed from: setTitle, reason: merged with bridge method [inline-methods] */
    public void m(final CharSequence charSequence) {
        setTextAction(new Function0() { // from class: bh.b
            public final Object invoke() {
                CharSequence n;
                n = ExpandView.this.n(charSequence);
                return n;
            }
        });
    }
}
