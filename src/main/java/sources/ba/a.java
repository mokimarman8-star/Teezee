package ba;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a {
    public j a(com.google.android.exoplayer2.source.rtsp.j jVar) {
        String str = (String) com.google.android.exoplayer2.util.a.e(jVar.c.l);
        str.hashCode();
        switch (str) {
            case "video/3gpp":
                return new e(jVar);
            case "video/hevc":
                return new g(jVar);
            case "audio/amr-wb":
            case "audio/3gpp":
                return new d(jVar);
            case "audio/mp4a-latm":
                return new b(jVar);
            case "audio/ac3":
                return new c(jVar);
            case "audio/raw":
            case "audio/g711-alaw":
            case "audio/g711-mlaw":
                return new k(jVar);
            case "video/mp4v-es":
                return new h(jVar);
            case "video/avc":
                return new f(jVar);
            case "audio/opus":
                return new i(jVar);
            case "video/x-vnd.on2.vp8":
                return new l(jVar);
            case "video/x-vnd.on2.vp9":
                return new m(jVar);
            default:
                return null;
        }
    }
}
