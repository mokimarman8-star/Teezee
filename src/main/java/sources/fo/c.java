package fo;

import android.content.Context;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.widget.DownloadView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.DownloadRefreshEvent;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends BaseItemProvider {
    private final String e;
    private final rv.e f;

    public c(String str, rv.e eVar) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(eVar, "dotHelper");
        this.e = str;
        this.f = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void A(Subject subject, DownloadView downloadView, c cVar, Subject subject2, Integer num, View view) {
        String str;
        String resourceLink;
        String str2;
        String str3;
        if (!subject.isShortTV()) {
            if (ij.t.a.b()) {
                Intrinsics.e(view);
                cVar.B(view, subject2);
            } else {
                List resourceDetectors = subject2.getResourceDetectors();
                if (resourceDetectors != null) {
                    if (resourceDetectors.isEmpty() || (str2 = ((ResourceDetectors) resourceDetectors.get(0)).getResourceId()) == null) {
                        str2 = BuildConfig.FLAVOR;
                    }
                    str = str2;
                } else {
                    str = BuildConfig.FLAVOR;
                }
                DownloadManagerApi.a aVar = DownloadManagerApi.j;
                if (DownloadManagerApi.x0(aVar.a(), subject2.getSubjectId(), str, subject2.isSeries(), false, 8, (Object) null)) {
                    String subjectId = subject2.getSubjectId();
                    if (subjectId != null) {
                        DownloadManagerApi a = aVar.a();
                        Context context = downloadView.getContext();
                        Intrinsics.g(context, "getContext(...)");
                        DownloadManagerApi.z0(a, subjectId, context, cVar.e, (String) null, 8, (Object) null);
                    }
                } else {
                    DownloadManagerApi a2 = aVar.a();
                    FragmentActivity context2 = downloadView.getContext();
                    Intrinsics.f(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                    FragmentActivity fragmentActivity = context2;
                    String str4 = cVar.e;
                    String ops = subject.getOps();
                    ResourceDetectors resourceDetector = subject2.getResourceDetector();
                    DownloadManagerApi.M(a2, fragmentActivity, subject2, str4, BuildConfig.FLAVOR, ops, (resourceDetector == null || (resourceLink = resourceDetector.getResourceLink()) == null) ? BuildConfig.FLAVOR : resourceLink, (String) null, (String) null, (String) null, false, 960, (Object) null);
                    String subjectId2 = subject2.getSubjectId();
                    ResourceDetectors resourceDetector2 = subject2.getResourceDetector();
                    DownloadRefreshEvent downloadRefreshEvent = new DownloadRefreshEvent(subjectId2, resourceDetector2 != null ? resourceDetector2.getResourceId() : null, true, subject2.isSeries());
                    FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                    String name = DownloadRefreshEvent.class.getName();
                    Intrinsics.g(name, "getName(...)");
                    applicationScopeViewModel.postEvent(name, downloadRefreshEvent, 0L);
                }
            }
            str3 = "play_subject";
            rv.e eVar = cVar.f;
            String str5 = cVar.e;
            String subjectId3 = subject.getSubjectId();
            Boolean hasResource = subject.getHasResource();
            eVar.a(str5, str3, subjectId3, num, hasResource != null ? hasResource.booleanValue() : false);
        }
        DownloadManagerApi a3 = DownloadManagerApi.j.a();
        FragmentActivity context3 = downloadView.getContext();
        Intrinsics.f(context3, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        DownloadManagerApi.e0(a3, context3, cVar.e, BuildConfig.FLAVOR, (String) null, "download_subject", true, subject2, (String) null, (Boolean) null, 384, (Object) null);
        str3 = "download_subject";
        rv.e eVar2 = cVar.f;
        String str52 = cVar.e;
        String subjectId32 = subject.getSubjectId();
        Boolean hasResource2 = subject.getHasResource();
        eVar2.a(str52, str3, subjectId32, num, hasResource2 != null ? hasResource2.booleanValue() : false);
    }

    private final void B(View view, Subject subject) {
        if (subject == null) {
            return;
        }
        Navigator c = TheRouter.c("/playvideo/detail");
        Integer subjectType = subject.getSubjectType();
        Navigator.x(c.F("subject_type", subjectType != null ? subjectType.intValue() : SubjectType.MOVIE.getValue()).K("id", subject.getSubjectId()).F("season", subject.getSeason()).K("ops", subject.getOps()), view.getContext(), (mf.c) null, 2, (Object) null);
    }

    public int l() {
        return 1;
    }

    public int m() {
        return R$layout.item_foryou;
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, final Subject subject) {
        String str;
        String str2;
        boolean z = false;
        Intrinsics.h(baseViewHolder, "holder");
        Intrinsics.h(subject, "item");
        BaseProviderMultiAdapter g = g();
        final Integer valueOf = g != null ? Integer.valueOf(g.g0(subject)) : null;
        AppCompatTextView viewOrNull = baseViewHolder.getViewOrNull(R$id.tv_title);
        if (viewOrNull != null) {
            viewOrNull.setText(subject.getTitle());
        }
        ShapeableImageView viewOrNull2 = baseViewHolder.getViewOrNull(R$id.iv_cover);
        String str3 = BuildConfig.FLAVOR;
        if (viewOrNull2 != null) {
            f.a aVar = ni.f.a;
            Context context = viewOrNull2.getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m = aVar.m(context);
            Cover cover = subject.getCover();
            if (cover == null || (str = cover.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            f.b g2 = m.g(str);
            Cover cover2 = subject.getCover();
            if (cover2 == null || (str2 = cover2.getThumbnail()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            g2.l(str2).d(viewOrNull2);
        }
        AppCompatTextView viewOrNull3 = baseViewHolder.getViewOrNull(R$id.tv_desc);
        if (viewOrNull3 != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            String countryName = subject.getCountryName();
            if (countryName != null && countryName.length() != 0) {
                spannableStringBuilder.append((CharSequence) subject.getCountryName());
            }
            String genre = subject.getGenre();
            if (genre != null && genre.length() != 0) {
                spannableStringBuilder.append((CharSequence) " / ").append((CharSequence) subject.getGenre());
            }
            String releaseDate = subject.getReleaseDate();
            if (releaseDate != null && releaseDate.length() != 0) {
                spannableStringBuilder.append((CharSequence) " / ").append((CharSequence) subject.getReleaseDate());
            }
            Integer durationSeconds = subject.getDurationSeconds();
            if (durationSeconds != null) {
                spannableStringBuilder.append((CharSequence) " / ").append((CharSequence) TimeUtilKt.g(durationSeconds.intValue()));
            }
            CharSequence o1 = StringsKt.o1(StringsKt.n1(spannableStringBuilder), new char[]{'/'});
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            spannableStringBuilder2.append((CharSequence) "  ").append(o1);
            int a = com.transsion.flow.h.a(subject.getSubjectType());
            spannableStringBuilder2.setSpan(Build.VERSION.SDK_INT >= 29 ? new ImageSpan(viewOrNull3.getContext(), a, 2) : new ImageSpan(viewOrNull3.getContext(), a, 1), 0, 1, 34);
            viewOrNull3.setText(spannableStringBuilder2);
        }
        AppCompatTextView viewOrNull4 = baseViewHolder.getViewOrNull(R$id.tv_score);
        if (viewOrNull4 != null) {
            viewOrNull4.setText(subject.getImdbRate());
        }
        final DownloadView viewOrNull5 = baseViewHolder.getViewOrNull(R$id.ll_download);
        if (viewOrNull5 != null) {
            viewOrNull5.setPageFrom(this.e);
            if (!Intrinsics.c(subject.getHasResource(), Boolean.TRUE)) {
                uf.c.g(viewOrNull5);
                return;
            }
            viewOrNull5.setOnClickListener(new View.OnClickListener() { // from class: fo.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.A(subject, viewOrNull5, this, subject, valueOf, view);
                }
            });
            uf.c.k(viewOrNull5);
            if (subject.isShortTV()) {
                return;
            }
            if (ij.t.a.b()) {
                viewOrNull5.setShowPlayType();
                return;
            }
            List resourceDetectors = subject.getResourceDetectors();
            if (resourceDetectors != null) {
                if (!resourceDetectors.isEmpty()) {
                    String resourceId = ((ResourceDetectors) resourceDetectors.get(0)).getResourceId();
                    if (resourceId != null) {
                        str3 = resourceId;
                    }
                    Integer type = ((ResourceDetectors) resourceDetectors.get(0)).getType();
                    if (type != null && type.intValue() == 1) {
                        z = true;
                    }
                }
                DownloadView.setShowType$default(viewOrNull5, subject.getSubjectId(), str3, Boolean.valueOf(z), false, 0, 24, (Object) null);
            }
        }
    }
}
