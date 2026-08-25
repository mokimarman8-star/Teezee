package ul;

import com.transsion.lib_web.download_render.c;
import com.transsion.lib_web.download_render.data.FileData;
import com.transsion.lib_web.download_render.task.compare.CompareRequest;
import com.transsion.lib_web.download_render.task.compare.CompareResponse;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface b {

    public interface a {
        CompareResponse a(CompareRequest compareRequest);
    }

    /* renamed from: ul.b$b, reason: collision with other inner class name */
    public static final class C0096b {
        public static FileData a(b bVar, FileData fileData) {
            Intrinsics.h(fileData, "remoteFileData");
            return c.a.e(fileData);
        }
    }

    CompareResponse a(CompareRequest compareRequest, a aVar);
}
