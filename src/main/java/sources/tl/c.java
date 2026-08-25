package tl;

import com.transsion.baselib.db.download.DownloadException;
import com.transsion.gslb.BuildConfig;
import com.transsion.lib_web.download_render.data.FileData;
import com.transsion.lib_web.download_render.data.PageData;
import com.transsion.lib_web.download_render.data.PageListData;
import com.transsion.lib_web.download_render.task.compare.CompareRequest;
import com.transsion.lib_web.download_render.task.compare.CompareResponse;
import com.transsion.lib_web.download_render.utils.ReportUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import pl.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c implements d {
    private final long a;
    private final PageData b;
    private final String c;
    private final ul.a d;
    private final List e;

    public c(long j, PageData pageData) {
        Intrinsics.h(pageData, "pageData");
        this.a = j;
        this.b = pageData;
        this.c = "DR_FileDownloadTask";
        this.d = new ul.a(CollectionsKt.o(new ul.b[]{new vl.b(), new vl.a()}), 0, 2, null);
        this.e = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b(Ref.BooleanRef booleanRef, Ref.IntRef intRef, Ref.LongRef longRef, boolean z, String str, int i, long j) {
        Intrinsics.h(str, "loadingUrl");
        com.transsion.lib_web.download_render.utils.a.a.m(str);
        booleanRef.element = z;
        intRef.element = i;
        longRef.element = j;
        return Unit.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004c, code lost:
    
        if (r2 == null) goto L15;
     */
    @Override // tl.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void start() {
        boolean z;
        List<PageData> h5Pages;
        h.a.a(this.c, "<FileDownloadTask> start id:" + this.a);
        PageListData l = com.transsion.lib_web.download_render.c.a.l();
        if (l != null && (h5Pages = l.getH5Pages()) != null) {
            for (PageData pageData : h5Pages) {
                if (Intrinsics.c(pageData.getUrl(), this.b.getUrl())) {
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        pageData = new PageData(null, null, null, null, null, null, null, null, null, DownloadException.EXCEPTION_IO_SSL_KEY, null);
        List<FileData> files = pageData.getFiles();
        if (files == null || files.isEmpty()) {
            h.a.f(this.c, "<FileDownloadTask> end id:" + this.a + ", pageData.files.isNullOrEmpty");
            return;
        }
        String url = pageData.getUrl();
        if (url == null) {
            h.a.f(this.c, "<FileDownloadTask> end id:" + this.a + ", pageData.url.isNull");
            return;
        }
        String versionCode = pageData.getVersionCode();
        if (versionCode == null) {
            h.a.f(this.c, "<FileDownloadTask> end id:" + this.a + ", pageData.versionCode.isNull");
            return;
        }
        com.transsion.lib_web.download_render.c cVar = com.transsion.lib_web.download_render.c.a;
        PageData g = cVar.g(url);
        if (g == null) {
            g = new PageData(null, null, null, null, null, null, null, null, null, DownloadException.EXCEPTION_IO_SSL_KEY, null);
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        long currentTimeMillis = System.currentTimeMillis();
        final Ref.IntRef intRef = new Ref.IntRef();
        final Ref.LongRef longRef = new Ref.LongRef();
        CompareResponse a = this.d.a(new CompareRequest(g, pageData));
        cVar.u(url);
        cVar.w(url, versionCode);
        if (a.getRemoveFileList().isEmpty() && a.getCopyFileList().isEmpty() && a.getDownloadFileList().isEmpty()) {
            z = false;
        } else {
            cVar.t(url);
            cVar.s(url, false);
            z = true;
        }
        this.e.add(new wl.b(url, versionCode, a.getRemoveFileList()));
        this.e.add(new wl.a(url, versionCode, a.getCopyFileList()));
        this.e.add(new wl.c(url, versionCode, a.getDownloadFileList(), new Function4() { // from class: tl.b
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit b;
                b = c.b(booleanRef, intRef, longRef, ((Boolean) obj).booleanValue(), (String) obj2, ((Integer) obj3).intValue(), ((Long) obj4).longValue());
                return b;
            }
        }));
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((wl.d) it.next()).invoke();
        }
        if (intRef.element == a.getDownloadFileList().size()) {
            com.transsion.lib_web.download_render.c.a.s(url, true);
        }
        if (z) {
            ReportUtil reportUtil = ReportUtil.a;
            String versionCode2 = pageData.getVersionCode();
            if (versionCode2 == null) {
                versionCode2 = BuildConfig.FLAVOR;
            }
            int size = a.getRemoveFileList().size();
            int size2 = a.getCopyFileList().size();
            int size3 = a.getDownloadFileList().size();
            List<FileData> files2 = pageData.getFiles();
            reportUtil.b(url, versionCode2, size, size2, size3, files2 != null ? files2.size() : 0, intRef.element, System.currentTimeMillis() - currentTimeMillis, booleanRef.element, a.getTotalFileSize(), longRef.element);
        }
        h.a.a(this.c, "<FileDownloadTask> end id:" + this.a);
    }
}
