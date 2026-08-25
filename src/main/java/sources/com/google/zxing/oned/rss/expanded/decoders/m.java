package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class m extends p {
    private final char b;

    m(int i, char c) {
        super(i);
        this.b = c;
    }

    char b() {
        return this.b;
    }

    boolean c() {
        return this.b == '$';
    }
}
