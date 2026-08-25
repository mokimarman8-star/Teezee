package q9;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;
import i9.x;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
abstract class h {
    static final String[] a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    private static CommentFrame a(int i, d0 d0Var) {
        int n = d0Var.n();
        if (d0Var.n() == 1684108385) {
            d0Var.Q(8);
            String y = d0Var.y(n - 16);
            return new CommentFrame("und", y, y);
        }
        s.i("MetadataUtil", "Failed to parse comment attribute: " + a.a(i));
        return null;
    }

    private static ApicFrame b(d0 d0Var) {
        int n = d0Var.n();
        if (d0Var.n() != 1684108385) {
            s.i("MetadataUtil", "Failed to parse cover art attribute");
            return null;
        }
        int b = a.b(d0Var.n());
        String str = b == 13 ? "image/jpeg" : b == 14 ? "image/png" : null;
        if (str == null) {
            s.i("MetadataUtil", "Unrecognized cover art flags: " + b);
            return null;
        }
        d0Var.Q(4);
        int i = n - 16;
        byte[] bArr = new byte[i];
        d0Var.j(bArr, 0, i);
        return new ApicFrame(str, (String) null, 3, bArr);
    }

    public static Metadata.Entry c(d0 d0Var) {
        int e = d0Var.e() + d0Var.n();
        int n = d0Var.n();
        int i = (n >> 24) & 255;
        try {
            if (i == 169 || i == 253) {
                int i2 = 16777215 & n;
                if (i2 == 6516084) {
                    return a(n, d0Var);
                }
                if (i2 == 7233901 || i2 == 7631467) {
                    return h(n, "TIT2", d0Var);
                }
                if (i2 == 6516589 || i2 == 7828084) {
                    return h(n, "TCOM", d0Var);
                }
                if (i2 == 6578553) {
                    return h(n, "TDRC", d0Var);
                }
                if (i2 == 4280916) {
                    return h(n, "TPE1", d0Var);
                }
                if (i2 == 7630703) {
                    return h(n, "TSSE", d0Var);
                }
                if (i2 == 6384738) {
                    return h(n, "TALB", d0Var);
                }
                if (i2 == 7108978) {
                    return h(n, "USLT", d0Var);
                }
                if (i2 == 6776174) {
                    return h(n, "TCON", d0Var);
                }
                if (i2 == 6779504) {
                    return h(n, "TIT1", d0Var);
                }
            } else {
                if (n == 1735291493) {
                    return g(d0Var);
                }
                if (n == 1684632427) {
                    return d(n, "TPOS", d0Var);
                }
                if (n == 1953655662) {
                    return d(n, "TRCK", d0Var);
                }
                if (n == 1953329263) {
                    return i(n, "TBPM", d0Var, true, false);
                }
                if (n == 1668311404) {
                    return i(n, "TCMP", d0Var, true, true);
                }
                if (n == 1668249202) {
                    return b(d0Var);
                }
                if (n == 1631670868) {
                    return h(n, "TPE2", d0Var);
                }
                if (n == 1936682605) {
                    return h(n, "TSOT", d0Var);
                }
                if (n == 1936679276) {
                    return h(n, "TSO2", d0Var);
                }
                if (n == 1936679282) {
                    return h(n, "TSOA", d0Var);
                }
                if (n == 1936679265) {
                    return h(n, "TSOP", d0Var);
                }
                if (n == 1936679791) {
                    return h(n, "TSOC", d0Var);
                }
                if (n == 1920233063) {
                    return i(n, "ITUNESADVISORY", d0Var, false, false);
                }
                if (n == 1885823344) {
                    return i(n, "ITUNESGAPLESS", d0Var, false, true);
                }
                if (n == 1936683886) {
                    return h(n, "TVSHOWSORT", d0Var);
                }
                if (n == 1953919848) {
                    return h(n, "TVSHOW", d0Var);
                }
                if (n == 757935405) {
                    return e(d0Var, e);
                }
            }
            s.b("MetadataUtil", "Skipped unknown metadata entry: " + a.a(n));
            d0Var.P(e);
            return null;
        } finally {
            d0Var.P(e);
        }
    }

    private static TextInformationFrame d(int i, String str, d0 d0Var) {
        int n = d0Var.n();
        if (d0Var.n() == 1684108385 && n >= 22) {
            d0Var.Q(10);
            int J = d0Var.J();
            if (J > 0) {
                String str2 = "" + J;
                int J2 = d0Var.J();
                if (J2 > 0) {
                    str2 = str2 + "/" + J2;
                }
                return new TextInformationFrame(str, (String) null, str2);
            }
        }
        s.i("MetadataUtil", "Failed to parse index/count attribute: " + a.a(i));
        return null;
    }

    private static Id3Frame e(d0 d0Var, int i) {
        String str = null;
        String str2 = null;
        int i2 = -1;
        int i3 = -1;
        while (d0Var.e() < i) {
            int e = d0Var.e();
            int n = d0Var.n();
            int n2 = d0Var.n();
            d0Var.Q(4);
            if (n2 == 1835360622) {
                str = d0Var.y(n - 12);
            } else if (n2 == 1851878757) {
                str2 = d0Var.y(n - 12);
            } else {
                if (n2 == 1684108385) {
                    i2 = e;
                    i3 = n;
                }
                d0Var.Q(n - 12);
            }
        }
        if (str == null || str2 == null || i2 == -1) {
            return null;
        }
        d0Var.P(i2);
        d0Var.Q(16);
        return new InternalFrame(str, str2, d0Var.y(i3 - 16));
    }

    public static MdtaMetadataEntry f(d0 d0Var, int i, String str) {
        while (true) {
            int e = d0Var.e();
            if (e >= i) {
                return null;
            }
            int n = d0Var.n();
            if (d0Var.n() == 1684108385) {
                int n2 = d0Var.n();
                int n3 = d0Var.n();
                int i2 = n - 16;
                byte[] bArr = new byte[i2];
                d0Var.j(bArr, 0, i2);
                return new MdtaMetadataEntry(str, bArr, n3, n2);
            }
            d0Var.P(e + n);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static TextInformationFrame g(d0 d0Var) {
        String str;
        int j = j(d0Var);
        if (j > 0) {
            String[] strArr = a;
            if (j <= strArr.length) {
                str = strArr[j - 1];
                if (str == null) {
                    return new TextInformationFrame("TCON", (String) null, str);
                }
                s.i("MetadataUtil", "Failed to parse standard genre code");
                return null;
            }
        }
        str = null;
        if (str == null) {
        }
    }

    private static TextInformationFrame h(int i, String str, d0 d0Var) {
        int n = d0Var.n();
        if (d0Var.n() == 1684108385) {
            d0Var.Q(8);
            return new TextInformationFrame(str, (String) null, d0Var.y(n - 16));
        }
        s.i("MetadataUtil", "Failed to parse text attribute: " + a.a(i));
        return null;
    }

    private static Id3Frame i(int i, String str, d0 d0Var, boolean z, boolean z2) {
        int j = j(d0Var);
        if (z2) {
            j = Math.min(1, j);
        }
        if (j >= 0) {
            return z ? new TextInformationFrame(str, (String) null, Integer.toString(j)) : new CommentFrame("und", str, Integer.toString(j));
        }
        s.i("MetadataUtil", "Failed to parse uint8 attribute: " + a.a(i));
        return null;
    }

    private static int j(d0 d0Var) {
        d0Var.Q(4);
        if (d0Var.n() == 1684108385) {
            d0Var.Q(8);
            return d0Var.D();
        }
        s.i("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    public static void k(int i, x xVar, p1.b bVar) {
        if (i == 1 && xVar.a()) {
            bVar.N(xVar.a).O(xVar.b);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000b, code lost:
    
        if (r6 != null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void l(int i, Metadata metadata, Metadata metadata2, p1.b bVar, Metadata... metadataArr) {
        Metadata metadata3 = new Metadata(new Metadata.Entry[0]);
        if (i != 1) {
            if (i == 2 && metadata2 != null) {
                for (int i2 = 0; i2 < metadata2.length(); i2++) {
                    Metadata.Entry entry = metadata2.get(i2);
                    if (entry instanceof MdtaMetadataEntry) {
                        Metadata.Entry entry2 = (MdtaMetadataEntry) entry;
                        if ("com.android.capture.fps".equals(((MdtaMetadataEntry) entry2).key)) {
                            metadata = new Metadata(new Metadata.Entry[]{entry2});
                            break;
                        }
                    }
                }
            }
            metadata = metadata3;
        }
        for (Metadata metadata4 : metadataArr) {
            metadata = metadata.copyWithAppendedEntriesFrom(metadata4);
        }
        if (metadata.length() > 0) {
            bVar.X(metadata);
        }
    }
}
