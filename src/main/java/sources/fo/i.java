package fo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.c0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.ninegridview.video.NineGridVideoView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsnet.downloader.widget.DownloadView;
import java.util.Calendar;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class i extends BaseItemProvider {
    private final void D(BaseViewHolder baseViewHolder, PostSubjectItem postSubjectItem) {
        B((NineGridVideoView) baseViewHolder.getView(R$id.nine_grid), postSubjectItem);
        A((AppCompatImageView) baseViewHolder.getView(R$id.ivCenterIcon), postSubjectItem);
        C((AppCompatTextView) baseViewHolder.getView(R$id.tvTime), postSubjectItem);
    }

    private final void z(BaseViewHolder baseViewHolder, PostSubjectItem postSubjectItem) {
        ResourceDetectors resourceDetector;
        String str;
        Cover cover;
        String thumbnail;
        Cover cover2;
        if (TextUtils.isEmpty(postSubjectItem.getTitle())) {
            baseViewHolder.setText(R$id.tvTitle, postSubjectItem.getContent());
        } else {
            baseViewHolder.setText(R$id.tvTitle, postSubjectItem.getTitle());
        }
        if (postSubjectItem.getSubject() != null) {
            Subject subject = postSubjectItem.getSubject();
            Date l = c0.l(subject != null ? subject.getReleaseDate() : null, "yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(l);
            AppCompatTextView viewOrNull = baseViewHolder.getViewOrNull(R$id.tvSubjectYear);
            if (viewOrNull != null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) String.valueOf(calendar.get(1)));
                Subject subject2 = postSubjectItem.getSubject();
                if (!TextUtils.isEmpty(subject2 != null ? subject2.getCountryName() : null)) {
                    SpannableStringBuilder append = spannableStringBuilder.append((CharSequence) " • ");
                    Subject subject3 = postSubjectItem.getSubject();
                    append.append((CharSequence) (subject3 != null ? subject3.getCountryName() : null));
                }
                viewOrNull.setText(spannableStringBuilder.toString());
                Subject subject4 = postSubjectItem.getSubject();
                Drawable drawable = androidx.core.content.b.getDrawable(viewOrNull.getContext(), com.transsion.flow.h.a(subject4 != null ? subject4.getSubjectType() : null));
                if (drawable != null) {
                    drawable.setTint(androidx.core.content.b.getColor(viewOrNull.getContext(), R.color.gray_40));
                }
                viewOrNull.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            int i = R$id.tvSubject;
            Subject subject5 = postSubjectItem.getSubject();
            baseViewHolder.setText(i, subject5 != null ? subject5.getTitle() : null);
            ShapeableImageView viewOrNull2 = baseViewHolder.getViewOrNull(R$id.ivSubjectCover);
            if (viewOrNull2 != null) {
                f.a aVar = ni.f.a;
                Context context = viewOrNull2.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m = aVar.m(context);
                Subject subject6 = postSubjectItem.getSubject();
                String str2 = BuildConfig.FLAVOR;
                if (subject6 == null || (cover2 = subject6.getCover()) == null || (str = cover2.getUrl()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                f.b c = m.g(str).i(com.transsion.baseui.R.mipmap.home_ic_default_res).m(a0.a(42.0f)).c(a0.a(56.0f));
                Subject subject7 = postSubjectItem.getSubject();
                if (subject7 != null && (cover = subject7.getCover()) != null && (thumbnail = cover.getThumbnail()) != null) {
                    str2 = thumbnail;
                }
                c.l(str2).d(viewOrNull2);
            }
        }
        DownloadView viewOrNull3 = baseViewHolder.getViewOrNull(R$id.llDownload);
        if (viewOrNull3 != null) {
            Subject subject8 = postSubjectItem.getSubject();
            String subjectId = subject8 != null ? subject8.getSubjectId() : null;
            Subject subject9 = postSubjectItem.getSubject();
            String resourceId = (subject9 == null || (resourceDetector = subject9.getResourceDetector()) == null) ? null : resourceDetector.getResourceId();
            Subject subject10 = postSubjectItem.getSubject();
            DownloadView.setShowType$default(viewOrNull3, subjectId, resourceId, subject10 != null ? Boolean.valueOf(subject10.isSeries()) : null, false, 0, 24, (Object) null);
        }
        if (viewOrNull3 != null) {
            viewOrNull3.setPageFrom("TODO pageFrom");
            Subject subject11 = postSubjectItem.getSubject();
            if (subject11 != null ? Intrinsics.c(subject11.getHasResource(), Boolean.TRUE) : false) {
                uf.c.k(viewOrNull3);
            } else {
                uf.c.g(viewOrNull3);
            }
        }
    }

    public abstract void A(AppCompatImageView appCompatImageView, PostSubjectItem postSubjectItem);

    public abstract void B(NineGridVideoView nineGridVideoView, PostSubjectItem postSubjectItem);

    public abstract void C(AppCompatTextView appCompatTextView, PostSubjectItem postSubjectItem);

    public int m() {
        return R$layout.item_provider_recommend_base_layout;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, PostSubjectItem postSubjectItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(postSubjectItem, "item");
        z(baseViewHolder, postSubjectItem);
        D(baseViewHolder, postSubjectItem);
    }
}
