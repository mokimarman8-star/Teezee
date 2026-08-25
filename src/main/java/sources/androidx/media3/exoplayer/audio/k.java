package androidx.media3.exoplayer.audio;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class k {

    /* renamed from: d, reason: collision with root package name */
    public static final k f9873d = new b().d();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f9874a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f9875b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f9876c;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private boolean f9877a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f9878b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f9879c;

        public k d() {
            if (this.f9877a || !(this.f9878b || this.f9879c)) {
                return new k(this);
            }
            throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
        }

        public b e(boolean z5) {
            this.f9877a = z5;
            return this;
        }

        public b f(boolean z5) {
            this.f9878b = z5;
            return this;
        }

        public b g(boolean z5) {
            this.f9879c = z5;
            return this;
        }
    }

    private k(b bVar) {
        this.f9874a = bVar.f9877a;
        this.f9875b = bVar.f9878b;
        this.f9876c = bVar.f9879c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.f9874a == kVar.f9874a && this.f9875b == kVar.f9875b && this.f9876c == kVar.f9876c;
    }

    public int hashCode() {
        return ((this.f9874a ? 1 : 0) << 2) + ((this.f9875b ? 1 : 0) << 1) + (this.f9876c ? 1 : 0);
    }
}
