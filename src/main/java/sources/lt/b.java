package lt;

import android.view.ViewGroup;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.subtitle.helper.d;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface b {
    SimpleSubtitleView a();

    void b(boolean z);

    void c(String str);

    SimpleSubtitleView d();

    void e(ht.a aVar, ht.a aVar2, boolean z);

    void f(boolean z);

    boolean g();

    ViewGroup getSubtitleViewGroup();

    void h(DubsInfo dubsInfo);

    d i();

    List j();

    boolean k();

    void l(ht.a aVar, long j);
}
