package tt;

import com.transsion.transfer.androidasync.http.Headers;
import com.transsion.transfer.androidasync.http.Multimap;
import com.transsion.transfer.androidasync.http.w;
import com.transsion.transfer.androidasync.s;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class d {
    Headers a;
    Multimap b;
    private long c;

    public d(Headers headers) {
        this.c = -1L;
        this.a = headers;
        this.b = Multimap.parseSemicolonDelimited(headers.c("Content-Disposition"));
    }

    public d(String str, long j, List list) {
        this.c = j;
        this.a = new Headers();
        StringBuilder sb = new StringBuilder(String.format(Locale.ENGLISH, "form-data; name=\"%s\"", str));
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                w wVar = (w) it.next();
                sb.append(String.format(Locale.ENGLISH, "; %s=\"%s\"", wVar.getName(), wVar.getValue()));
            }
        }
        this.a.f("Content-Disposition", sb.toString());
        this.b = Multimap.parseSemicolonDelimited(this.a.c("Content-Disposition"));
    }

    public String a() {
        return this.b.getString("name");
    }

    public Headers b() {
        return this.a;
    }

    public long c() {
        return this.c;
    }

    public void d(s sVar, st.a aVar) {
    }
}
