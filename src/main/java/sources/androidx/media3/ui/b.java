package androidx.media3.ui;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b {

    /* renamed from: g, reason: collision with root package name */
    public static final b f12306g = new b(-1, -16777216, 0, 0, -1, null);

    /* renamed from: a, reason: collision with root package name */
    public final int f12307a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12308b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12309c;

    /* renamed from: d, reason: collision with root package name */
    public final int f12310d;

    /* renamed from: e, reason: collision with root package name */
    public final int f12311e;

    /* renamed from: f, reason: collision with root package name */
    public final Typeface f12312f;

    public b(int i5, int i6, int i7, int i8, int i9, Typeface typeface) {
        this.f12307a = i5;
        this.f12308b = i6;
        this.f12309c = i7;
        this.f12310d = i8;
        this.f12311e = i9;
        this.f12312f = typeface;
    }

    public static b a(CaptioningManager.CaptionStyle captionStyle) {
        return new b(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f12306g.f12307a, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f12306g.f12308b, captionStyle.hasWindowColor() ? captionStyle.windowColor : f12306g.f12309c, captionStyle.hasEdgeType() ? captionStyle.edgeType : f12306g.f12310d, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f12306g.f12311e, captionStyle.getTypeface());
    }
}
