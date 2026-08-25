package tt;

import com.transsion.transfer.androidasync.a0;
import com.transsion.transfer.androidasync.s;
import java.io.InputStream;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class e extends d {
    public e(String str, long j, List list) {
        super(str, j, list);
    }

    @Override // tt.d
    public void d(s sVar, st.a aVar) {
        try {
            a0.f(e(), sVar, aVar);
        } catch (Exception e) {
            aVar.g(e);
        }
    }

    protected abstract InputStream e();
}
