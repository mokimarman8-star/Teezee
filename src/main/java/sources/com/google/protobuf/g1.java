package com.google.protobuf;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class g1 implements q0 {
    private static final int IS_EDITION_BIT = 4;
    private static final int IS_PROTO2_BIT = 1;
    private final s0 defaultInstance;
    private final int flags;
    private final String info;
    private final Object[] objects;

    g1(s0 s0Var, String str, Object[] objArr) {
        this.defaultInstance = s0Var;
        this.info = str;
        this.objects = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 < 55296) {
                this.flags = i | (charAt2 << i2);
                return;
            } else {
                i |= (charAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    @Override // com.google.protobuf.q0
    public s0 getDefaultInstance() {
        return this.defaultInstance;
    }

    Object[] getObjects() {
        return this.objects;
    }

    String getStringInfo() {
        return this.info;
    }

    @Override // com.google.protobuf.q0
    public ProtoSyntax getSyntax() {
        int i = this.flags;
        return (i & 1) != 0 ? ProtoSyntax.PROTO2 : (i & 4) == 4 ? ProtoSyntax.EDITIONS : ProtoSyntax.PROTO3;
    }

    @Override // com.google.protobuf.q0
    public boolean isMessageSetWireFormat() {
        return (this.flags & 2) == 2;
    }
}
