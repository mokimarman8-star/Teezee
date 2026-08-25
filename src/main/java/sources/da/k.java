package da;

import com.google.android.exoplayer2.p1;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface k {
    public static final k a = new a();

    class a implements k {
        a() {
        }

        @Override // da.k
        public boolean a(p1 p1Var) {
            String str = p1Var.l;
            return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str) || "text/x-exoplayer-cues".equals(str);
        }

        @Override // da.k
        public j b(p1 p1Var) {
            String str = p1Var.l;
            if (str != null) {
                switch (str) {
                    case "application/dvbsubs":
                        return new fa.a(p1Var.n);
                    case "application/pgs":
                        return new ga.a();
                    case "application/x-mp4-vtt":
                        return new ma.a();
                    case "text/vtt":
                        return new ma.h();
                    case "application/x-quicktime-tx3g":
                        return new la.a(p1Var.n);
                    case "text/x-ssa":
                        return new ia.a(p1Var.n);
                    case "application/x-mp4-cea-608":
                    case "application/cea-608":
                        return new ea.a(str, p1Var.D, 16000L);
                    case "text/x-exoplayer-cues":
                        return new g();
                    case "application/cea-708":
                        return new ea.c(p1Var.D, p1Var.n);
                    case "application/x-subrip":
                        return new ja.a();
                    case "application/ttml+xml":
                        return new ka.c();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    }

    boolean a(p1 p1Var);

    j b(p1 p1Var);
}
