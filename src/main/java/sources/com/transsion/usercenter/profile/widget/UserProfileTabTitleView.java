package com.transsion.usercenter.profile.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import cj.a;
import cj.c;
import com.blankj.utilcode.util.a0;
import com.noober.background.drawable.DrawableCreator;
import com.noober.background.view.BLTextView;
import com.tn.lib.widget.R;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import xy.b;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\rJ/\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001b\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\bH\u0016¢\u0006\u0004\b!\u0010 J\u0019\u0010$\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J\u0019\u0010&\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b&\u0010%J!\u0010)\u001a\u00020\u000b2\u0010\u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\"\u0018\u00010'H\u0016¢\u0006\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00062"}, d2 = {"Lcom/transsion/usercenter/profile/widget/UserProfileTabTitleView;", "Lcom/noober/background/view/BLTextView;", "Lxy/b;", "Lcj/a;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", HttpUrl.FRAGMENT_ENCODE_SET, "index", "totalCount", HttpUrl.FRAGMENT_ENCODE_SET, "onSelected", "(II)V", "onDeselected", HttpUrl.FRAGMENT_ENCODE_SET, "leavePercent", HttpUrl.FRAGMENT_ENCODE_SET, "leftToRight", "onLeave", "(IIFZ)V", "enterPercent", "onEnter", "getContentLeft", "()I", "getContentTop", "getContentRight", "getContentBottom", "changeLocal", "()V", "resId", "setTextById", "(I)V", "setHintById", HttpUrl.FRAGMENT_ENCODE_SET, "srt", "setHintWithString", "(Ljava/lang/CharSequence;)V", "setTextWithString", "Lkotlin/Function0;", "action", "setTextAction", "(Lkotlin/jvm/functions/Function0;)V", "a", "I", "selectedColor", "Lcj/c;", "b", "Lcj/c;", "textDelegate", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class UserProfileTabTitleView extends BLTextView implements b, a {

    /* renamed from: a, reason: from kotlin metadata */
    private final int selectedColor;

    /* renamed from: b, reason: from kotlin metadata */
    private final c textDelegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UserProfileTabTitleView(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        this.selectedColor = androidx.core.content.b.getColor(context, R.color.white_100);
        setTextSize(12.0f);
        setGravity(17);
        int a = a0.a(12.0f);
        int a2 = a0.a(6.0f);
        setPadding(a, a2, a, a2);
        this.textDelegate = new c(this);
    }

    public void changeLocal() {
        this.textDelegate.changeLocal();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xy.b
    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) + ((fontMetrics.bottom - fontMetrics.top) / 2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xy.b
    public int getContentLeft() {
        String obj;
        List l;
        Rect rect = new Rect();
        if (StringsKt.c0(getText().toString(), "\n", false, 2, null)) {
            List split = new Regex("\\n").split(getText().toString(), 0);
            if (!split.isEmpty()) {
                ListIterator listIterator = split.listIterator(split.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        l = CollectionsKt.K0(split, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            }
            l = CollectionsKt.l();
            String[] strArr = (String[]) l.toArray(new String[0]);
            obj = HttpUrl.FRAGMENT_ENCODE_SET;
            for (String str : strArr) {
                Intrinsics.e(str);
                if (str.length() > obj.length()) {
                    obj = str;
                }
            }
        } else {
            obj = getText().toString();
        }
        getPaint().getTextBounds(obj, 0, obj.length(), rect);
        return (getLeft() + (getWidth() / 2)) - (rect.width() / 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xy.b
    public int getContentRight() {
        String obj;
        List l;
        Rect rect = new Rect();
        if (StringsKt.c0(getText().toString(), "\n", false, 2, null)) {
            List split = new Regex("\\n").split(getText().toString(), 0);
            if (!split.isEmpty()) {
                ListIterator listIterator = split.listIterator(split.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        l = CollectionsKt.K0(split, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            }
            l = CollectionsKt.l();
            String[] strArr = (String[]) l.toArray(new String[0]);
            obj = HttpUrl.FRAGMENT_ENCODE_SET;
            for (String str : strArr) {
                Intrinsics.e(str);
                if (str.length() > obj.length()) {
                    obj = str;
                }
            }
        } else {
            obj = getText().toString();
        }
        getPaint().getTextBounds(obj, 0, obj.length(), rect);
        return getLeft() + (getWidth() / 2) + (rect.width() / 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xy.b
    public int getContentTop() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) - ((fontMetrics.bottom - fontMetrics.top) / 2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xy.d
    public void onDeselected(int index, int totalCount) {
        getPaint().setFakeBoldText(false);
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        setTypeface(uf.a.d(context));
        setBackground(new DrawableCreator.Builder().setCornersRadius(a0.a(8.0f)).setSolidColor(getContext().getResources().getColor(R.color.transparent)).build());
        setTextColor(androidx.core.content.b.getColor(getContext(), R.color.white_80));
    }

    @Override // xy.d
    public void onEnter(int index, int totalCount, float enterPercent, boolean leftToRight) {
    }

    @Override // xy.d
    public void onLeave(int index, int totalCount, float leavePercent, boolean leftToRight) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xy.d
    public void onSelected(int index, int totalCount) {
        getPaint().setFakeBoldText(true);
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        setTypeface(uf.a.a(context));
        setBackground(new DrawableCreator.Builder().setCornersRadius(a0.a(100.0f)).setSolidColor(getContext().getResources().getColor(R.color.white_10)).build());
        setTextColor(this.selectedColor);
    }

    public void setHintById(int resId) {
        this.textDelegate.b(resId);
    }

    public void setHintWithString(CharSequence srt) {
        this.textDelegate.c(srt);
    }

    public void setLocalChangeListener(Function0<Unit> function0) {
        a.a.a(this, function0);
    }

    public void setTextAction(Function0<? extends CharSequence> action) {
        this.textDelegate.e(action);
    }

    public void setTextById(int resId) {
        this.textDelegate.f(resId);
    }

    public void setTextWithString(CharSequence srt) {
        this.textDelegate.g(srt);
    }
}
