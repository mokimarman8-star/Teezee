package ad;

import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class j {
    private final long a;
    private final long b;

    public static class b {
        private long a = 60;
        private long b = ConfigFetchHandler.j;

        public j c() {
            return new j(this);
        }

        public b d(long j) {
            if (j < 0) {
                throw new IllegalArgumentException(String.format("Fetch connection timeout has to be a non-negative number. %d is an invalid argument", Long.valueOf(j)));
            }
            this.a = j;
            return this;
        }

        public b e(long j) {
            if (j >= 0) {
                this.b = j;
                return this;
            }
            throw new IllegalArgumentException("Minimum interval between fetches has to be a non-negative number. " + j + " is an invalid argument");
        }
    }

    private j(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
    }

    public long a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }
}
