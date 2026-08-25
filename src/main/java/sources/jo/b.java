package jo;

import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.flow.bean.LayoutStyle;
import com.transsion.flow.bean.PlayUrl;
import com.transsion.flow.bean.SubjectGameInfo;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.GifBean;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.SubjectDl;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsion.publish.api.AudioEntity;
import com.transsion.publish.api.GroupBean;
import com.transsion.publish.api.LinkEntity;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.api.VsMediaInfo;
import com.transsion.room.api.bean.LocationPlace;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import sm.e;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    private Integer a = 0;
    private Integer b = 0;
    private List c;
    private AudioEntity d;
    private VsMediaInfo e;
    private LinkEntity f;
    private PhotoEntity g;
    private Subject h;
    private GroupBean i;
    private LocationPlace j;

    public final AudioEntity a() {
        return this.d;
    }

    public final PhotoEntity b() {
        return this.g;
    }

    public final GroupBean c() {
        return this.i;
    }

    public final Integer d() {
        return this.b;
    }

    public final Integer e() {
        return this.a;
    }

    public final LinkEntity f() {
        return this.f;
    }

    public final LocationPlace g() {
        return this.j;
    }

    public final List h() {
        return this.c;
    }

    public final Subject i() {
        return this.h;
    }

    public final VsMediaInfo j() {
        return this.e;
    }

    public final void k(AudioEntity audioEntity) {
        this.d = audioEntity;
    }

    public final void l(PhotoEntity photoEntity) {
        this.g = photoEntity;
    }

    public final void m(GroupBean groupBean) {
        this.i = groupBean;
    }

    public final void n(Integer num) {
        this.b = num;
    }

    public final void o(Integer num) {
        this.a = num;
    }

    public final void p(LinkEntity linkEntity) {
        this.f = linkEntity;
    }

    public final void q(LocationPlace locationPlace) {
        this.j = locationPlace;
    }

    public final void r(List list) {
        this.c = list;
    }

    public final void s(Subject subject) {
        this.h = subject;
    }

    public final b t(String str, Integer num, String str2, String str3, String str4) {
        this.h = new Subject(str, num, str2, (String) null, new Cover((Integer) null, (Integer) null, (Integer) null, str3, (String) null, str4, (GifBean) null, (String) null, (String) null, 471, (DefaultConstructorMarker) null), (String) null, (String) null, (String) null, (Integer) null, e.a.g(num), (List) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (List) null, (Long) null, (Boolean) null, (String) null, (SubjectDl) null, (List) null, (Cover) null, (Trailer) null, false, false, (BiddingNativeManager) null, (String) null, (Long) null, (String) null, (String) null, false, false, (ShortTVItem) null, (ShortTVFavInfo) null, 0, false, false, 0L, (String) null, (List) null, 0L, (List) null, 0, false, (Integer) null, 0, (SubjectGameInfo) null, (String) null, (List) null, (String) null, (String) null, 0, (Long) null, (Integer) null, (LayoutStyle) null, (PlayUrl) null, (Boolean) null, -536, 67108863, (DefaultConstructorMarker) null);
        return this;
    }

    public final void u(VsMediaInfo vsMediaInfo) {
        this.e = vsMediaInfo;
    }
}
