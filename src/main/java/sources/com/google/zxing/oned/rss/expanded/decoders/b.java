package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class b extends f {
    b(kd.a aVar) {
        super(aVar);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.i
    protected void h(StringBuilder sb2, int i) {
        if (i < 10000) {
            sb2.append("(3202)");
        } else {
            sb2.append("(3203)");
        }
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.i
    protected int i(int i) {
        return i < 10000 ? i : i - 10000;
    }
}
