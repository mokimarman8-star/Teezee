package com.transsion.usercenter.profile.see.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.R;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.StaffType;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$mipmap;
import com.transsion.usercenter.profile.see.adapter.a;
import com.transsion.usercenter.profile.see.bean.ProfileSeeStaffItem;
import com.transsion.usercenter.profile.see.bean.ProfileSeeSubjectItem;
import com.transsion.usercenter.profile.see.bean.ProfileSeeTimeItem;
import com.transsnet.downloader.DownloadManagerApi;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ni.f;
import okhttp3.HttpUrl;
import sm.e;
import t6.h;
import t6.i;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004\r\u000e\u000f\u0010B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\n\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/transsion/usercenter/profile/see/adapter/a;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lp6/a;", "Lt6/i;", "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "data", HttpUrl.FRAGMENT_ENCODE_SET, "position", "N1", "(Ljava/util/List;I)I", "G", "a", "d", "b", "c", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a extends BaseProviderMultiAdapter<p6.a> implements i {
    public static final int H = 1;
    public static final int I = 2;
    public static final int J = 3;

    public static final class b extends BaseItemProvider {
        private final int e = a0.a(72.0f);
        private final int f = a0.a(98.0f);

        private final void A(final BaseViewHolder baseViewHolder, final ProfileSeeSubjectItem profileSeeSubjectItem) {
            uf.c.g(baseViewHolder.getView(R$id.desTv));
            ((RecyclerView.a0) baseViewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.profile.see.adapter.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.b.B(ProfileSeeSubjectItem.this, this, baseViewHolder, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void B(ProfileSeeSubjectItem profileSeeSubjectItem, b bVar, BaseViewHolder baseViewHolder, View view) {
            if (com.transsion.baseui.util.c.a.a(view.getId(), 1000L)) {
                return;
            }
            Integer subjectType = profileSeeSubjectItem.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType == null || subjectType.intValue() != value) {
                Navigator c = TheRouter.c("/movie/detail");
                Integer subjectType2 = profileSeeSubjectItem.getSubjectType();
                Navigator.x(c.F("subject_type", subjectType2 != null ? subjectType2.intValue() : SubjectType.MOVIE.getValue()).K("id", profileSeeSubjectItem.getSubjectId()).K("ops", profileSeeSubjectItem.getOps()), ((RecyclerView.a0) baseViewHolder).itemView.getContext(), (mf.c) null, 2, (Object) null);
            } else {
                DownloadManagerApi a = DownloadManagerApi.j.a();
                FragmentActivity k = bVar.k();
                Intrinsics.f(k, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                DownloadManagerApi.e0(a, k, "movie_audio_archies", HttpUrl.FRAGMENT_ENCODE_SET, profileSeeSubjectItem.getOps(), "download_subject", false, profileSeeSubjectItem, (String) null, (Boolean) null, 384, (Object) null);
            }
        }

        private final void C(BaseViewHolder baseViewHolder, ProfileSeeSubjectItem profileSeeSubjectItem) {
            String str;
            String thumbnail;
            ImageView imageView = (ImageView) baseViewHolder.getView(R$id.coverIv);
            f.a aVar = f.a;
            Context context = imageView.getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m = aVar.m(context);
            Cover cover = profileSeeSubjectItem.getCover();
            String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
            if (cover == null || (str = cover.getUrl()) == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            f.b c = m.g(str).m(this.e).c(this.f);
            Cover cover2 = profileSeeSubjectItem.getCover();
            if (cover2 != null && (thumbnail = cover2.getThumbnail()) != null) {
                str2 = thumbnail;
            }
            c.l(str2).d(imageView);
            baseViewHolder.setText(R$id.nameTv, profileSeeSubjectItem.getTitle());
            baseViewHolder.setText(R$id.maskTv, profileSeeSubjectItem.getCorner());
            View view = baseViewHolder.getView(R$id.maskTv);
            String corner = profileSeeSubjectItem.getCorner();
            view.setVisibility(corner == null || corner.length() == 0 ? 8 : 0);
            baseViewHolder.getView(R$id.tagTv).setText(e.a.f(profileSeeSubjectItem));
            uf.c.g(baseViewHolder.getView(R$id.desTv));
        }

        public int l() {
            return 2;
        }

        public int m() {
            return R$layout.profile_item_see_content;
        }

        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public void b(BaseViewHolder helper, p6.a item) {
            Intrinsics.h(helper, "helper");
            Intrinsics.h(item, "item");
            ProfileSeeSubjectItem profileSeeSubjectItem = (ProfileSeeSubjectItem) item;
            C(helper, profileSeeSubjectItem);
            A(helper, profileSeeSubjectItem);
        }
    }

    public static final class c extends BaseItemProvider {
        private final int e = a0.a(72.0f);
        private final int f = a0.a(98.0f);

        private final void A(final BaseViewHolder baseViewHolder, final ProfileSeeStaffItem profileSeeStaffItem) {
            ((ImageView) baseViewHolder.getView(R$id.jumpTv)).setImageResource(R.mipmap.ic_btn_arrow_transparent);
            ((RecyclerView.a0) baseViewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.profile.see.adapter.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.c.B(ProfileSeeStaffItem.this, baseViewHolder, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void B(ProfileSeeStaffItem profileSeeStaffItem, BaseViewHolder baseViewHolder, View view) {
            if (com.transsion.baseui.util.c.a.a(view.getId(), 1000L)) {
                return;
            }
            Navigator.x(TheRouter.c("/movie/staff").J("staff", profileSeeStaffItem), ((RecyclerView.a0) baseViewHolder).itemView.getContext(), (mf.c) null, 2, (Object) null);
        }

        private final void C(BaseViewHolder baseViewHolder, ProfileSeeStaffItem profileSeeStaffItem) {
            ImageView imageView = (ImageView) baseViewHolder.getView(R$id.coverIv);
            f.a aVar = f.a;
            Context context = imageView.getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m = aVar.m(context);
            String avatarUrl = profileSeeStaffItem.getAvatarUrl();
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (avatarUrl == null) {
                avatarUrl = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            m.g(avatarUrl).i(R$mipmap.profile_staff_default_avatar).m(this.e).c(this.f).d(imageView);
            baseViewHolder.setText(R$id.nameTv, profileSeeStaffItem.getName());
            baseViewHolder.getView(R$id.maskTv).setVisibility(8);
            AppCompatTextView view = baseViewHolder.getView(R$id.tagTv);
            List<StaffType> staffTypes = profileSeeStaffItem.getStaffTypes();
            if (staffTypes != null) {
                for (StaffType staffType : staffTypes) {
                    if (str.length() > 0) {
                        str = ((Object) str) + " I ";
                    }
                    str = ((Object) str) + staffType.getName();
                }
            }
            view.setTextColor(k().getResources().getColor(R.color.white_60));
            view.setText(str);
            view.setCompoundDrawablesRelativeWithIntrinsicBounds(R$mipmap.profile_ic_staff, 0, 0, 0);
            AppCompatTextView view2 = baseViewHolder.getView(R$id.desTv);
            view2.setText(profileSeeStaffItem.getDescription());
            String description = profileSeeStaffItem.getDescription();
            view2.setVisibility(description == null || description.length() == 0 ? 8 : 0);
        }

        public int l() {
            return 3;
        }

        public int m() {
            return R$layout.profile_item_see_content;
        }

        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public void b(BaseViewHolder helper, p6.a item) {
            Intrinsics.h(helper, "helper");
            Intrinsics.h(item, "item");
            ProfileSeeStaffItem profileSeeStaffItem = (ProfileSeeStaffItem) item;
            C(helper, profileSeeStaffItem);
            A(helper, profileSeeStaffItem);
        }
    }

    public static final class d extends BaseItemProvider {
        public int l() {
            return 1;
        }

        public int m() {
            return R$layout.profile_item_see_time;
        }

        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public void b(BaseViewHolder helper, p6.a item) {
            Intrinsics.h(helper, "helper");
            Intrinsics.h(item, "item");
            ((TextView) helper.getView(R$id.tv_time)).setText(((ProfileSeeTimeItem) item).getDate());
        }
    }

    public a() {
        super((List) null, 1, (DefaultConstructorMarker) null);
        F1(new d());
        F1(new b());
        F1(new c());
    }

    protected int N1(List<? extends p6.a> data, int position) {
        Intrinsics.h(data, "data");
        return data.get(position).getItemType();
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return h.a(this, baseQuickAdapter);
    }
}
