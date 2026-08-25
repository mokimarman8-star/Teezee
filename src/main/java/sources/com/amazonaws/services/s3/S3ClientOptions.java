package com.amazonaws.services.s3;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class S3ClientOptions {
    private boolean a;
    private boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;

    public static final class Builder {
        private boolean a;
        private boolean b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;

        private Builder() {
            this.a = false;
            this.b = false;
            this.c = false;
            this.d = false;
            this.e = false;
            this.f = false;
        }

        public S3ClientOptions a() {
            return new S3ClientOptions(this.a, this.b, this.c, this.d, this.e, this.f);
        }

        public Builder b(boolean z) {
            this.d = z;
            return this;
        }

        public Builder c(boolean z) {
            this.b = z;
            return this;
        }
    }

    @Deprecated
    public S3ClientOptions() {
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
    }

    public S3ClientOptions(S3ClientOptions s3ClientOptions) {
        this.a = s3ClientOptions.a;
        this.b = s3ClientOptions.b;
        this.c = s3ClientOptions.c;
        this.d = s3ClientOptions.d;
        this.e = s3ClientOptions.e;
        this.f = s3ClientOptions.f;
    }

    private S3ClientOptions(boolean z, boolean z2, boolean z3, boolean z4, boolean z7, boolean z8) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z7;
        this.f = z8;
    }

    public static Builder a() {
        return new Builder();
    }

    public boolean b() {
        return this.d;
    }

    public boolean c() {
        return this.a;
    }

    public boolean d() {
        return this.f;
    }

    public boolean e() {
        return this.b;
    }
}
