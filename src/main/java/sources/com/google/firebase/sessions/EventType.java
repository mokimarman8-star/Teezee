package com.google.firebase.sessions;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/google/firebase/sessions/EventType;", TtmlNode.ANONYMOUS_REGION_ID, "Lfc/f;", TtmlNode.ANONYMOUS_REGION_ID, "number", "<init>", "(Ljava/lang/String;II)V", "I", "getNumber", "()I", "EVENT_TYPE_UNKNOWN", "SESSION_START", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public enum EventType implements fc.f {
    EVENT_TYPE_UNKNOWN(0),
    SESSION_START(1);

    private final int number;

    EventType(int i) {
        this.number = i;
    }

    @Override // fc.f
    public int getNumber() {
        return this.number;
    }
}
