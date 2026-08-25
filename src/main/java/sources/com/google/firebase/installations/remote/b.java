package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.TokenResult;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class b extends TokenResult {
    private final String a;
    private final long b;
    private final TokenResult.ResponseCode c;

    /* renamed from: com.google.firebase.installations.remote.b$b, reason: collision with other inner class name */
    static final class C0040b extends TokenResult$a {
        private String a;
        private Long b;
        private TokenResult.ResponseCode c;

        C0040b() {
        }

        @Override // com.google.firebase.installations.remote.TokenResult$a
        public TokenResult a() {
            Long l = this.b;
            String str = TtmlNode.ANONYMOUS_REGION_ID;
            if (l == null) {
                str = TtmlNode.ANONYMOUS_REGION_ID + " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new b(this.a, this.b.longValue(), this.c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.installations.remote.TokenResult$a
        public TokenResult$a b(TokenResult.ResponseCode responseCode) {
            this.c = responseCode;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult$a
        public TokenResult$a c(String str) {
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult$a
        public TokenResult$a d(long j) {
            this.b = Long.valueOf(j);
            return this;
        }
    }

    private b(String str, long j, TokenResult.ResponseCode responseCode) {
        this.a = str;
        this.b = j;
        this.c = responseCode;
    }

    public TokenResult.ResponseCode b() {
        return this.c;
    }

    public String c() {
        return this.a;
    }

    public long d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenResult)) {
            return false;
        }
        TokenResult tokenResult = (TokenResult) obj;
        String str = this.a;
        if (str != null ? str.equals(tokenResult.c()) : tokenResult.c() == null) {
            if (this.b == tokenResult.d()) {
                TokenResult.ResponseCode responseCode = this.c;
                if (responseCode == null) {
                    if (tokenResult.b() == null) {
                        return true;
                    }
                } else if (responseCode.equals(tokenResult.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.b;
        int i = (((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        TokenResult.ResponseCode responseCode = this.c;
        return i ^ (responseCode != null ? responseCode.hashCode() : 0);
    }

    public String toString() {
        return "TokenResult{token=" + this.a + ", tokenExpirationTimestamp=" + this.b + ", responseCode=" + this.c + "}";
    }
}
