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
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.view.expand.SubjectExpandView;
import com.tn.lib.widget.R;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class SubjectExpandView extends AppCompatTextView {
    public static final int STATE_EXPAND = 1;
    public static final int STATE_SHRINK = 0;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private float r;
    private bh.a s;
    private bh.a t;
    private Layout u;
    private CharSequence v;
    private ClickableSpan w;
    private boolean x;
    private boolean y;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            SubjectExpandView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            SubjectExpandView subjectExpandView = SubjectExpandView.this;
            subjectExpandView.k(subjectExpandView.v);
            SubjectExpandView.this.j = true;
        }
    }

    public interface b {
    }

    public SubjectExpandView(Context context) {
        this(context, null);
    }

    public SubjectExpandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = "  ";
        this.e = "  ";
        this.f = false;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = false;
        this.k = 1;
        this.l = -1711276033;
        this.m = -1711276033;
        this.n = 872415231;
        this.o = 872415231;
        this.p = -1;
        this.q = 0;
        this.x = false;
        this.y = false;
        i(context, attributeSet);
    }

    public SubjectExpandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = "  ";
        this.e = "  ";
        this.f = false;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = false;
        this.k = 1;
        this.l = -1711276033;
        this.m = -1711276033;
        this.n = 872415231;
        this.o = 872415231;
        this.p = -1;
        this.q = 0;
        this.x = false;
        this.y = false;
        i(context, attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private CharSequence f(int i) {
        String str;
        int i2;
        TextPaint paint = getPaint();
        if (this.v != null) {
            str = "" + ((Object) this.v);
        } else {
            str = "";
        }
        if (this.u == null) {
            this.u = new StaticLayout(str, paint, i, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        }
        int lineCount = this.u.getLineCount();
        int i3 = this.k;
        if (lineCount <= i3) {
            CharSequence charSequence = this.v;
            if (charSequence == null) {
                charSequence = " ";
            }
            return l(new SpannableStringBuilder(charSequence));
        }
        int i4 = this.q;
        if (i4 != 0) {
            if (i4 != 1 || !this.i) {
                return l(new SpannableStringBuilder(this.v));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.v);
            spannableStringBuilder.append((CharSequence) this.e).append((CharSequence) this.c);
            int length = (spannableStringBuilder.length() - this.e.length()) - this.c.length();
            int length2 = spannableStringBuilder.length();
            i2 = length >= 0 ? length : 0;
            spannableStringBuilder.setSpan(this.w, i2, length2, 33);
            spannableStringBuilder.setSpan(this.s, i2, length2, 33);
            return l(spannableStringBuilder);
        }
        int g = g(str, paint, this.u.getLineStart(this.k - 1), this.u.getLineEnd(i3 - 1), i);
        CharSequence charSequence2 = this.v;
        if (charSequence2 != null && charSequence2.length() <= g) {
            g = this.v.length() - 1;
        }
        CharSequence charSequence3 = this.v;
        if (charSequence3 == null || g <= 0) {
            return charSequence3;
        }
        SpannableStringBuilder append = new SpannableStringBuilder(charSequence3.length() > 180 ? this.v.subSequence(0, 180) : this.v).append((CharSequence) this.a);
        if (this.h) {
            append.append((CharSequence) this.d);
            append.append((CharSequence) this.b);
            int length3 = (append.length() - this.d.length()) - this.b.length();
            int length4 = append.length();
            i2 = length3 >= 0 ? length3 : 0;
            append.setSpan(this.w, i2, length4, 33);
            append.setSpan(this.t, i2, length4, 33);
        }
        return l(append);
    }

    private int g(String str, TextPaint textPaint, int i, int i2, int i3) {
        String str2;
        bh.a aVar = this.t;
        String str3 = this.a;
        if (this.h) {
            str2 = this.b + this.d;
        } else {
            str2 = "";
        }
        return textPaint.breakText(str, i, i2, true, i3 - aVar.e(textPaint, str3, str2), null) + i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int getLayoutWidth() {
        Layout layout = getLayout();
        int width = layout != null ? layout.getWidth() : 0;
        return (width > 0 || getWidth() == 0) ? width : (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void h() {
        if (this.r == 0.0f) {
            this.r = getTextSize();
        }
        boolean z = getLayoutDirection() == 1;
        this.t = new bh.a(getContext(), R.mipmap.info_player_ic_expand, this.l, this.n, this.r, 5, z);
        this.s = new bh.a(getContext(), R.mipmap.info_player_ic_collapse, this.m, this.o, this.r, 5, z);
        setMovementMethod(new LinkMovementMethod());
        if (TextUtils.isEmpty(this.a)) {
            this.a = "...";
        }
        if (TextUtils.isEmpty(this.b)) {
            this.b = getResources().getString(R.string.player_more);
        }
        if (TextUtils.isEmpty(this.c)) {
            this.c = getResources().getString(R.string.player_hide);
        }
        if (this.d == null) {
            this.d = "  ";
        }
        if (this.e == null) {
            this.e = "  ";
        }
        setOnClickListener(new View.OnClickListener() { // from class: bh.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubjectExpandView.this.j(view);
            }
        });
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    private void i(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            h();
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.ExpandView_pop_hint_text_size) {
                this.r = obtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == R.styleable.ExpandView_pop_reverse_Lines) {
                this.k = obtainStyledAttributes.getInteger(index, 1);
            } else if (index == R.styleable.ExpandView_pop_ellipsis) {
                this.a = obtainStyledAttributes.getString(index);
            } else if (index == R.styleable.ExpandView_pop_expand_hint) {
                this.b = obtainStyledAttributes.getString(index);
            } else if (index == R.styleable.ExpandView_pop_shrink_hint) {
                this.c = obtainStyledAttributes.getString(index);
            } else if (index == R.styleable.ExpandView_pop_toggle_enabled) {
                this.f = obtainStyledAttributes.getBoolean(index, this.f);
            } else if (index == R.styleable.ExpandView_pop_show_expand_hint) {
                this.h = obtainStyledAttributes.getBoolean(index, this.h);
            } else if (index == R.styleable.ExpandView_pop_show_shrink_hint) {
                this.i = obtainStyledAttributes.getBoolean(index, this.i);
            } else if (index == R.styleable.ExpandView_pop_expand_hint_color) {
                this.l = obtainStyledAttributes.getInteger(index, -1711276033);
            } else if (index == R.styleable.ExpandView_pop_shrink_hint_color) {
                this.m = obtainStyledAttributes.getInteger(index, -1711276033);
            } else if (index == R.styleable.ExpandView_pop_expand_bg_Color) {
                this.n = obtainStyledAttributes.getInteger(index, 872415231);
            } else if (index == R.styleable.ExpandView_pop_shrink_bg_color) {
                this.o = obtainStyledAttributes.getInteger(index, 872415231);
            } else if (index == R.styleable.ExpandView_pop_Init_state) {
                this.q = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.ExpandView_pop_expand_gap) {
                this.d = obtainStyledAttributes.getString(index);
            } else if (index == R.styleable.ExpandView_pop_collapse_gap) {
                this.e = obtainStyledAttributes.getString(index);
            } else if (index == R.styleable.ExpandView_pop_hash_tag_color) {
                this.p = obtainStyledAttributes.getInteger(index, this.p);
            }
        }
        obtainStyledAttributes.recycle();
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        m();
    }

    private CharSequence l(SpannableStringBuilder spannableStringBuilder) {
        return spannableStringBuilder;
    }

    private void m() {
        if (getText().toString().contains(this.b) || getText().toString().contains(this.c) || this.y) {
            int i = this.q;
            if (i == 0) {
                this.q = 1;
            } else if (i == 1) {
                this.q = 0;
            }
            k(this.v);
        }
    }

    public int getExpandState() {
        return this.q;
    }

    public boolean isOutLines() {
        Layout layout = this.u;
        return layout != null && layout.getLineCount() > this.k;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void reset() {
        this.q = 0;
        k(this.v);
    }

    public void setCollapseEnable(boolean z) {
        this.g = z;
    }

    public void setExpandListener(b bVar) {
    }

    public void setHasStarring(boolean z) {
        this.x = z;
    }

    public void setShrink(boolean z) {
        this.y = z;
        if (z) {
            this.q = 1;
            m();
            this.y = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: setTitle, reason: merged with bridge method [inline-methods] */
    public void k(final CharSequence charSequence) {
        if (!this.g) {
            super/*android.widget.TextView*/.setText(charSequence);
            return;
        }
        if (!TextUtils.equals(charSequence, this.v)) {
            this.u = null;
        }
        this.v = charSequence;
        int layoutWidth = getLayoutWidth();
        if (this.x) {
            if (this.q == 1) {
                super/*android.widget.TextView*/.setText(charSequence);
                return;
            }
            if (this.v != null) {
                charSequence = f(layoutWidth);
            }
            super/*android.widget.TextView*/.setText(charSequence);
            return;
        }
        if (layoutWidth > 0) {
            if (this.v != null) {
                charSequence = f(layoutWidth);
            }
            super/*android.widget.TextView*/.setText(charSequence);
        } else if (this.j) {
            postDelayed(new Runnable() { // from class: bh.f
                @Override // java.lang.Runnable
                public final void run() {
                    SubjectExpandView.this.k(charSequence);
                }
            }, 100L);
        }
    }
}
