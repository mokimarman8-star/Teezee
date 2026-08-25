package com.transsion.moviedetail.activity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.toast.core.h;
import com.transsion.baselib.helper.a;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.activity.MoviePosterActivity;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.ninegridview.ImageInfo;
import com.transsion.ninegridview.R$string;
import com.transsion.ninegridview.helper.FileHelper;
import com.transsion.ninegridview.preview.ImagePreviewActivity;
import com.transsion.web.R;
import com.transsion.web.share.ImageShareDialog;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import jm.j;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.y0;
import lm.b;
import tf.d;
import zg.c;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0004JI\u0010\u0018\u001a\u00020\u000728\u0010\u0017\u001a4\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00070\u0010H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010!\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0002H\u0016¢\u0006\u0004\b#\u0010$J\u0011\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0011H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0011H\u0016¢\u0006\u0004\b*\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/transsion/moviedetail/activity/MoviePosterActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Llm/b;", "<init>", "()V", "Lcom/transsion/moviedetailapi/bean/Subject;", "info", BuildConfig.FLAVOR, "s0", "(Lcom/transsion/moviedetailapi/bean/Subject;)V", BuildConfig.FLAVOR, "Lcom/transsion/moviedetailapi/bean/Staff;", "staffList", "t0", "(Ljava/util/List;)V", "l0", "Lkotlin/Function2;", BuildConfig.FLAVOR, "Lkotlin/ParameterName;", "name", "exit", "Ljava/io/File;", "imgFile", "callback", "saveToAlbum", "(Lkotlin/jvm/functions/Function2;)V", "imageShareClick", "Landroid/net/Uri;", "imageUri", "shareImage", "(Landroid/net/Uri;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "j0", "()Llm/b;", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "isTranslucent", "()Z", "isStatusDark", "a", "Lcom/transsion/moviedetailapi/bean/Subject;", "mMovieDetailBean", "b", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MoviePosterActivity extends BaseActivity<b> {

    /* renamed from: a, reason: from kotlin metadata */
    private Subject mMovieDetailBean;

    private final void imageShareClick() {
        ((b) getMViewBinding()).e.setEnabled(false);
        final long currentTimeMillis = System.currentTimeMillis();
        saveToAlbum(new Function2() { // from class: jm.g
            public final Object invoke(Object obj, Object obj2) {
                Unit k0;
                k0 = MoviePosterActivity.k0(MoviePosterActivity.this, currentTimeMillis, ((Boolean) obj).booleanValue(), (File) obj2);
                return k0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit k0(MoviePosterActivity moviePosterActivity, long j, boolean z, File file) {
        if (file != null) {
            Uri uriForFile = FileProvider.getUriForFile(moviePosterActivity, moviePosterActivity.getApplication().getPackageName() + ".download.fileprovider", file);
            Intrinsics.e(uriForFile);
            moviePosterActivity.shareImage(uriForFile);
        } else {
            h.a.k(R.string.share_failed_tips);
        }
        ((b) moviePosterActivity.getMViewBinding()).e.setEnabled(true);
        long currentTimeMillis = System.currentTimeMillis() - j;
        StringBuilder sb = new StringBuilder();
        sb.append("share: 耗时=");
        sb.append(currentTimeMillis);
        return Unit.a;
    }

    private final void l0() {
        ((b) getMViewBinding()).c.setOnClickListener(new View.OnClickListener() { // from class: jm.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoviePosterActivity.n0(MoviePosterActivity.this, view);
            }
        });
        ((b) getMViewBinding()).d.setOnClickListener(new View.OnClickListener() { // from class: jm.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoviePosterActivity.o0(MoviePosterActivity.this, view);
            }
        });
        ((b) getMViewBinding()).e.setOnClickListener(new View.OnClickListener() { // from class: jm.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoviePosterActivity.q0(MoviePosterActivity.this, view);
            }
        });
        ((b) getMViewBinding()).b.setOnClickListener(new View.OnClickListener() { // from class: jm.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoviePosterActivity.m0(MoviePosterActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(MoviePosterActivity moviePosterActivity, View view) {
        moviePosterActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void n0(MoviePosterActivity moviePosterActivity, View view) {
        Cover cover;
        Subject subject = moviePosterActivity.mMovieDetailBean;
        if (subject == null || (cover = subject.getCover()) == null) {
            return;
        }
        a.a.h("movie_poster", "preview", (r16 & 4) != 0 ? BuildConfig.FLAVOR : null, (r16 & 8) != 0 ? BuildConfig.FLAVOR : null, (r16 & 16) != 0 ? BuildConfig.FLAVOR : null, (r16 & 32) != 0 ? null : null);
        ImageInfo imageInfo = new ImageInfo();
        imageInfo.bigImageUrl = cover.getUrl();
        imageInfo.thumbnailUrl = cover.getThumbnail();
        imageInfo.imageViewHeight = cover.getHeight() != null ? r2.intValue() : 0.0f;
        imageInfo.imageViewWidth = cover.getWidth() != null ? r0.intValue() : 0.0f;
        ImagePreviewActivity.INSTANCE.a(moviePosterActivity, 0, CollectionsKt.q(new ImageInfo[]{imageInfo}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(MoviePosterActivity moviePosterActivity, View view) {
        a.a.h("movie_poster", "save_picture", (r16 & 4) != 0 ? BuildConfig.FLAVOR : null, (r16 & 8) != 0 ? BuildConfig.FLAVOR : null, (r16 & 16) != 0 ? BuildConfig.FLAVOR : null, (r16 & 32) != 0 ? null : null);
        moviePosterActivity.saveToAlbum(new Function2() { // from class: jm.i
            public final Object invoke(Object obj, Object obj2) {
                Unit p0;
                p0 = MoviePosterActivity.p0(((Boolean) obj).booleanValue(), (File) obj2);
                return p0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(boolean z, File file) {
        if (z) {
            fh.b.a.d(R$string.has_been_saved);
        } else {
            fh.b.a.d(R$string.image_save_success);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(MoviePosterActivity moviePosterActivity, View view) {
        a.a.h("movie_poster", "share", (r16 & 4) != 0 ? BuildConfig.FLAVOR : BuildConfig.FLAVOR, (r16 & 8) != 0 ? BuildConfig.FLAVOR : null, (r16 & 16) != 0 ? BuildConfig.FLAVOR : null, (r16 & 32) != 0 ? null : null);
        moviePosterActivity.imageShareClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r0(MoviePosterActivity moviePosterActivity, j jVar) {
        Intrinsics.h(jVar, "it");
        StringBuilder sb = new StringBuilder();
        sb.append("PostEventPlayRecord: ");
        sb.append(jVar);
        moviePosterActivity.s0(jVar.a());
        return Unit.a;
    }

    private final void s0(Subject info) {
        String str;
        if (info != null) {
            this.mMovieDetailBean = info;
            ((b) getMViewBinding()).k.setText(info.getTitle());
            ((b) getMViewBinding()).j.setText(info.getDescription());
            AppCompatImageView appCompatImageView = ((b) getMViewBinding()).c;
            Intrinsics.g(appCompatImageView, "ivCover");
            Cover cover = info.getCover();
            if (cover == null || (str = cover.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            cp.a.c(appCompatImageView, str, 0.0f, 2, null);
            t0(info.getStaffList());
        }
    }

    private final void saveToAlbum(Function2 callback) {
        Cover cover;
        FileHelper fileHelper = FileHelper.a;
        c.a aVar = c.a;
        AppCompatImageView appCompatImageView = ((b) getMViewBinding()).c;
        Intrinsics.g(appCompatImageView, "ivCover");
        Bitmap a = aVar.a(appCompatImageView);
        Subject subject = this.mMovieDetailBean;
        fileHelper.r(this, a, fileHelper.j((subject == null || (cover = subject.getCover()) == null) ? null : cover.getUrl()), callback);
    }

    private final void shareImage(Uri imageUri) {
        try {
            if (getSupportFragmentManager().k0("ImageShareDialog") != null) {
                return;
            }
            ImageShareDialog a = ImageShareDialog.f.a(imageUri);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
            a.show(supportFragmentManager, "ImageShareDialog");
        } catch (Exception unused) {
            h.a.k(R.string.share_failed_tips);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t0(final List staffList) {
        if (staffList == null) {
            return;
        }
        ((b) getMViewBinding()).l.setText(getString(com.transsion.moviedetail.R$string.starring) + "(" + staffList.size() + ")");
        ((b) getMViewBinding()).g.setLayoutManager(new LinearLayoutManager(this, 0, false));
        ((b) getMViewBinding()).g.addItemDecoration(new d(a0.a(8.0f)));
        com.transsion.moviedetail.adapter.a aVar = new com.transsion.moviedetail.adapter.a(staffList);
        aVar.w1(new r6.d() { // from class: jm.h
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MoviePosterActivity.u0(staffList, this, baseQuickAdapter, view, i);
            }
        });
        ((b) getMViewBinding()).g.setAdapter(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void u0(List list, MoviePosterActivity moviePosterActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String str;
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "<unused var>");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "staff");
        hashMap.put("source", qi.h.a.h());
        Staff staff = (Staff) CollectionsKt.l0(list, i);
        if (staff == null || (str = staff.getStaffId()) == null) {
            str = BuildConfig.FLAVOR;
        }
        hashMap.put("related_staff_id", str);
        a.a.i("movie_poster", hashMap);
        Navigator c = TheRouter.c("/movie/staff");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.f(item, "null cannot be cast to non-null type com.transsion.moviedetailapi.bean.Staff");
        Navigator.x(c.J("staff", (Staff) item), moviePosterActivity, (mf.c) null, 2, (Object) null);
    }

    public boolean isStatusDark() {
        return false;
    }

    public boolean isTranslucent() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public b getViewBinding() {
        b c = b.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public qi.b newLogViewConfig() {
        return new qi.b("movie_poster", false, 2, null);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Function1 function1 = new Function1() { // from class: jm.b
            public final Object invoke(Object obj) {
                Unit r0;
                r0 = MoviePosterActivity.r0(MoviePosterActivity.this, (j) obj);
                return r0;
            }
        };
        a2 p = y0.c().p();
        Lifecycle.State state = Lifecycle.State.STARTED;
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = j.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(this, name, state, p, true, function1);
        l0();
        ViewGroup.LayoutParams layoutParams = ((b) getMViewBinding()).b.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = com.blankj.utilcode.util.d.c();
            ((b) getMViewBinding()).b.setLayoutParams(marginLayoutParams);
        }
    }
}
