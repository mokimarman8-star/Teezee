package com.iab.omid.library.mmadbridge.adsession.media;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public enum Position {
    PREROLL("preroll"),
    MIDROLL("midroll"),
    POSTROLL("postroll"),
    STANDALONE("standalone");

    private final String position;

    Position(String str) {
        this.position = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.position;
    }
}
