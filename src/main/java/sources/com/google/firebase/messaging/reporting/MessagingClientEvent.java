package com.google.firebase.messaging.reporting;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class MessagingClientEvent {
    private static final MessagingClientEvent p = new a().a();
    private final long a;
    private final String b;
    private final String c;
    private final MessageType d;
    private final SDKPlatform e;
    private final String f;
    private final String g;
    private final int h;
    private final int i;
    private final String j;
    private final long k;
    private final Event l;
    private final String m;
    private final long n;
    private final String o;

    public enum Event implements gc.a {
        UNKNOWN_EVENT(0),
        MESSAGE_DELIVERED(1),
        MESSAGE_OPEN(2);

        private final int number_;

        Event(int i) {
            this.number_ = i;
        }

        @Override // gc.a
        public int getNumber() {
            return this.number_;
        }
    }

    public enum MessageType implements gc.a {
        UNKNOWN(0),
        DATA_MESSAGE(1),
        TOPIC(2),
        DISPLAY_NOTIFICATION(3);

        private final int number_;

        MessageType(int i) {
            this.number_ = i;
        }

        @Override // gc.a
        public int getNumber() {
            return this.number_;
        }
    }

    public enum SDKPlatform implements gc.a {
        UNKNOWN_OS(0),
        ANDROID(1),
        IOS(2),
        WEB(3);

        private final int number_;

        SDKPlatform(int i) {
            this.number_ = i;
        }

        @Override // gc.a
        public int getNumber() {
            return this.number_;
        }
    }

    public static final class a {
        private long a = 0;
        private String b = TtmlNode.ANONYMOUS_REGION_ID;
        private String c = TtmlNode.ANONYMOUS_REGION_ID;
        private MessageType d = MessageType.UNKNOWN;
        private SDKPlatform e = SDKPlatform.UNKNOWN_OS;
        private String f = TtmlNode.ANONYMOUS_REGION_ID;
        private String g = TtmlNode.ANONYMOUS_REGION_ID;
        private int h = 0;
        private int i = 0;
        private String j = TtmlNode.ANONYMOUS_REGION_ID;
        private long k = 0;
        private Event l = Event.UNKNOWN_EVENT;
        private String m = TtmlNode.ANONYMOUS_REGION_ID;
        private long n = 0;
        private String o = TtmlNode.ANONYMOUS_REGION_ID;

        a() {
        }

        public MessagingClientEvent a() {
            return new MessagingClientEvent(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
        }

        public a b(String str) {
            this.m = str;
            return this;
        }

        public a c(String str) {
            this.g = str;
            return this;
        }

        public a d(String str) {
            this.o = str;
            return this;
        }

        public a e(Event event) {
            this.l = event;
            return this;
        }

        public a f(String str) {
            this.c = str;
            return this;
        }

        public a g(String str) {
            this.b = str;
            return this;
        }

        public a h(MessageType messageType) {
            this.d = messageType;
            return this;
        }

        public a i(String str) {
            this.f = str;
            return this;
        }

        public a j(int i) {
            this.h = i;
            return this;
        }

        public a k(long j) {
            this.a = j;
            return this;
        }

        public a l(SDKPlatform sDKPlatform) {
            this.e = sDKPlatform;
            return this;
        }

        public a m(String str) {
            this.j = str;
            return this;
        }

        public a n(int i) {
            this.i = i;
            return this;
        }
    }

    MessagingClientEvent(long j, String str, String str2, MessageType messageType, SDKPlatform sDKPlatform, String str3, String str4, int i, int i2, String str5, long j2, Event event, String str6, long j3, String str7) {
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = messageType;
        this.e = sDKPlatform;
        this.f = str3;
        this.g = str4;
        this.h = i;
        this.i = i2;
        this.j = str5;
        this.k = j2;
        this.l = event;
        this.m = str6;
        this.n = j3;
        this.o = str7;
    }

    public static a p() {
        return new a();
    }

    public String a() {
        return this.m;
    }

    public long b() {
        return this.k;
    }

    public long c() {
        return this.n;
    }

    public String d() {
        return this.g;
    }

    public String e() {
        return this.o;
    }

    public Event f() {
        return this.l;
    }

    public String g() {
        return this.c;
    }

    public String h() {
        return this.b;
    }

    public MessageType i() {
        return this.d;
    }

    public String j() {
        return this.f;
    }

    public int k() {
        return this.h;
    }

    public long l() {
        return this.a;
    }

    public SDKPlatform m() {
        return this.e;
    }

    public String n() {
        return this.j;
    }

    public int o() {
        return this.i;
    }
}
