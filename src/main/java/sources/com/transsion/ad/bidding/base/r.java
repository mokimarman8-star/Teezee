package com.transsion.ad.bidding.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.mediation.ad.ViewBinder;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class r {
    private final Context a;

    public r(Context context) {
        Intrinsics.h(context, "context");
        this.a = context;
    }

    private final void B(ViewBinder viewBinder) {
        ci.b bVar = ci.b.a;
        View view = viewBinder.layout;
        Intrinsics.g(view, TtmlNode.TAG_LAYOUT);
        bVar.e(view, viewBinder.callToActionId);
    }

    private final View f(Context context) {
        if (context == null) {
            context = Utils.a();
        }
        View inflate = LayoutInflater.from(context).inflate(t(), (ViewGroup) null);
        Intrinsics.g(inflate, "inflate(...)");
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(AppCompatTextView appCompatTextView) {
        try {
            Result.Companion companion = Result.Companion;
            String lowerCase = appCompatTextView.getText().toString().toLowerCase(Locale.ROOT);
            Intrinsics.g(lowerCase, "toLowerCase(...)");
            if (ci.b.a.b(lowerCase)) {
                appCompatTextView.setText(StringsKt.z(lowerCase));
            }
            Result.constructor-impl(Unit.a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th));
        }
    }

    public boolean A() {
        return true;
    }

    public Integer b() {
        return null;
    }

    public abstract Integer c();

    public Integer d() {
        return null;
    }

    public Integer e() {
        return null;
    }

    public final w g() {
        int t = t();
        View f = f(this.a);
        Integer v = v();
        Integer z = z();
        Integer s = s();
        Integer l = l();
        Integer m = m();
        Integer c = c();
        Integer h = h();
        Integer d = d();
        return new w(Integer.valueOf(t), f, z, s, l, v, m, x(), w(), y(), u(), o(), e(), b(), c, d, h, n(), p(), j(), k(), i());
    }

    public abstract Integer h();

    public abstract Integer i();

    public Integer j() {
        return null;
    }

    public Integer k() {
        return null;
    }

    public abstract Integer l();

    public abstract Integer m();

    public Integer n() {
        return null;
    }

    public Integer o() {
        return null;
    }

    public Integer p() {
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e8, code lost:
    
        if (r5 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f7, code lost:
    
        if (r4 == null) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ViewBinder q(w wVar, TAdNativeInfo tAdNativeInfo) {
        String appInfo;
        TAdNativeInfo.Image icon;
        List<TAdNativeInfo.Image> imageList;
        TAdNativeInfo.Image image;
        Intrinsics.h(wVar, "adLayoutProvider");
        ViewBinder.Builder builder = new ViewBinder.Builder(wVar.i());
        builder.contextMode(1);
        Integer l = wVar.l();
        if (l != null) {
            builder.titleId(l.intValue());
        }
        Integer g = wVar.g();
        if (g != null) {
            builder.descriptionId(g.intValue());
        }
        Integer j = wVar.j();
        if (j != null) {
            builder.mediaId(j.intValue());
        }
        Integer h = wVar.h();
        if (h != null) {
            builder.iconId(h.intValue());
        }
        Integer f = wVar.f();
        if (f != null) {
            int intValue = f.intValue();
            builder.callToActionId(intValue);
            final AppCompatTextView findViewById = wVar.i().findViewById(intValue);
            if (findViewById != null) {
                findViewById.post(new Runnable() { // from class: com.transsion.ad.bidding.base.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        r.r(findViewById);
                    }
                });
            }
        }
        Integer a = wVar.a();
        if (a != null) {
            builder.adChoicesView(a.intValue());
        }
        Integer b = wVar.b();
        if (b != null) {
            builder.storeMarkView(b.intValue());
        }
        Integer c = wVar.c();
        if (c != null) {
            wVar.i().findViewById(c.intValue()).setVisibility(8);
        }
        Integer e = wVar.e();
        Unit unit = null;
        if (e != null) {
            ImageView imageView = (ImageView) wVar.i().findViewById(e.intValue());
            if (imageView != null) {
                String url = (tAdNativeInfo == null || (imageList = tAdNativeInfo.getImageList()) == null || (image = (TAdNativeInfo.Image) CollectionsKt.k0(imageList)) == null) ? null : image.getUrl();
                String url2 = (tAdNativeInfo == null || (icon = tAdNativeInfo.getIcon()) == null) ? null : icon.getUrl();
                if (tAdNativeInfo == null || tAdNativeInfo.getAdType() != 6) {
                    if (url != null) {
                        if (url.length() <= 0) {
                            url = null;
                        }
                    }
                    url = url2;
                    Glide.with(imageView.getContext()).load(url).transform(new ei.a(55, 2, true)).into(imageView);
                } else {
                    if (url2 != null) {
                        if (url2.length() <= 0) {
                            url2 = null;
                        }
                    }
                    Glide.with(imageView.getContext()).load(url).transform(new ei.a(55, 2, true)).into(imageView);
                }
            }
        }
        try {
            Result.Companion companion = Result.Companion;
            if (tAdNativeInfo != null && (appInfo = tAdNativeInfo.getAppInfo()) != null) {
                JSONObject jSONObject = new JSONObject(appInfo);
                String string = jSONObject.getString("star");
                Integer k = wVar.k();
                if (k != null) {
                    ((TextView) wVar.i().findViewById(k.intValue())).setText(string);
                }
                long j2 = jSONObject.getLong("size");
                Integer d = wVar.d();
                if (d != null) {
                    ((TextView) wVar.i().findViewById(d.intValue())).setText(com.blankj.utilcode.util.i.b(j2, 1));
                    unit = Unit.a;
                }
            }
            Result.constructor-impl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th));
        }
        ViewBinder build = builder.build();
        Intrinsics.g(build, "build(...)");
        B(build);
        return build;
    }

    public abstract Integer s();

    public abstract int t();

    public Integer u() {
        return null;
    }

    public abstract Integer v();

    public Integer w() {
        return null;
    }

    public Integer x() {
        return null;
    }

    public Integer y() {
        return null;
    }

    public abstract Integer z();
}
