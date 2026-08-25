package qt;

import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import kotlin.coroutines.Continuation;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface a {

    /* renamed from: qt.a$a, reason: collision with other inner class name */
    public static final class C0096a {
        public static /* synthetic */ Object a(a aVar, int i, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDownloadFailureList");
            }
            if ((i2 & 1) != 0) {
                i = 6;
            }
            return aVar.d(i, continuation);
        }
    }

    Object a(String str, Continuation continuation);

    Object b(String str, Continuation continuation);

    SubtitleDownloadTable c(String str, int i);

    Object d(int i, Continuation continuation);

    Object e(SubtitleDownloadTable subtitleDownloadTable, Continuation continuation);

    void f(SubtitleDownloadTable subtitleDownloadTable);

    void g(SubtitleDownloadTable subtitleDownloadTable);
}
