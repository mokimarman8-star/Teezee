package com.transsion.home.adapter.suboperate.adapter;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.hisavana.common.bean.TAdNativeInfo;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.R$drawable;
import com.transsion.home.adapter.suboperate.adapter.SubBannerChildPagerAdapter;
import com.transsion.home.adapter.trending.BannerADDataHelper;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.DownloadManagerApi;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubBannerChildPagerAdapter extends RecyclerView.Adapter {
    private List a;
    private final int b;
    private final OperateItem c;
    private final int d;
    private final int e;

    public static final class SubViewPagerViewHolder extends RecyclerView.a0 {
        private final int a;
        private final OperateItem b;
        private final ImageView c;
        private final ImageView d;
        private final TextView e;
        private final TextView f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubViewPagerViewHolder(View view, int i, OperateItem operateItem) {
            super(view);
            Intrinsics.h(view, "itemView");
            Intrinsics.h(operateItem, "operateItem");
            this.a = i;
            this.b = operateItem;
            View findViewById = view.findViewById(R.id.contentIV);
            Intrinsics.g(findViewById, "findViewById(...)");
            this.c = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.playIV);
            Intrinsics.g(findViewById2, "findViewById(...)");
            this.d = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.titleTV);
            Intrinsics.g(findViewById3, "findViewById(...)");
            this.e = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.desTV);
            Intrinsics.g(findViewById4, "findViewById(...)");
            this.f = (TextView) findViewById4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit h(BannerData bannerData, SubViewPagerViewHolder subViewPagerViewHolder, int i, View view) {
            Intrinsics.h(view, "it");
            String deepLink = bannerData.getDeepLink();
            if (deepLink != null) {
                if (!yg.l.a.e()) {
                    fh.b.a.d(com.tn.lib.widget.R.string.no_network_toast);
                    return Unit.a;
                }
                Uri g = com.transsion.baselib.helper.b.a.g(Uri.parse(deepLink + "&module_name=opt_banner_free&autoPlay=true&ops=" + bannerData.getOps()));
                if (g != null) {
                    ij.k.o(g);
                }
                subViewPagerViewHolder.j(bannerData, i, DownloadManagerApi.x0(DownloadManagerApi.j.a(), bannerData.getSubjectId(), (String) null, false, false, 12, (Object) null) ? "play_subject" : "download_subject");
            }
            return Unit.a;
        }

        private final SpannableString i(Subject subject) {
            int indexOf;
            List R0;
            StringBuilder sb = new StringBuilder();
            String releaseDate = subject.getReleaseDate();
            String genre = subject.getGenre();
            String str = (genre == null || (R0 = StringsKt.R0(genre, new char[]{','}, false, 0, 6, (Object) null)) == null) ? null : (String) CollectionsKt.k0(R0);
            if (releaseDate != null && releaseDate.length() != 0) {
                sb.append(" | ");
                sb.append(releaseDate);
            }
            if (str != null) {
                sb.append(" | ");
                sb.append(str);
            }
            SpannableString spannableString = new SpannableString(sb);
            if (releaseDate != null && releaseDate.length() != 0) {
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Utils.a().getResources().getColor(com.tn.lib.widget.R.color.white_20));
                ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(Utils.a().getResources().getColor(com.tn.lib.widget.R.color.white_60));
                spannableString.setSpan(foregroundColorSpan, 0, 3, 17);
                spannableString.setSpan(foregroundColorSpan2, 3, releaseDate.length() + 3, 17);
            }
            if (str != null && (indexOf = sb.indexOf(str)) >= 3) {
                ForegroundColorSpan foregroundColorSpan3 = new ForegroundColorSpan(Utils.a().getResources().getColor(com.tn.lib.widget.R.color.white_20));
                ForegroundColorSpan foregroundColorSpan4 = new ForegroundColorSpan(Utils.a().getResources().getColor(com.tn.lib.widget.R.color.white_60));
                spannableString.setSpan(foregroundColorSpan3, indexOf - 3, indexOf, 17);
                spannableString.setSpan(foregroundColorSpan4, indexOf, sb.length(), 17);
            }
            return spannableString;
        }

        private final void j(BannerData bannerData, int i, String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "click_banner_poster");
            hashMap.put("sequence", String.valueOf(i));
            hashMap.put("module_name", str);
            hashMap.put("tabId", String.valueOf(this.a));
            if (bannerData != null) {
                sk.b.b(bannerData, hashMap);
            }
            sk.b.a(this.b, hashMap);
            com.transsion.baselib.helper.a.a.f(SubTabFragment.INSTANCE.a(this.a), hashMap);
        }

        private final void k(BannerData bannerData, ImageView imageView) {
            if (!(bannerData != null ? Intrinsics.c(bannerData.getHasResource(), Boolean.TRUE) : false)) {
                imageView.setImageResource(R$drawable.ic_trending_arrow);
            } else if (!ij.t.a.b() || bannerData.getSubjectType() == SubjectType.SHORT_TV.getValue()) {
                imageView.setImageResource(R$drawable.ic_trending_download);
            } else {
                imageView.setImageResource(R$drawable.ic_trending_play);
            }
        }

        public final void g(final BannerData bannerData, final int i) {
            String url;
            String thumbnail;
            Cover cover;
            Cover cover2;
            Intrinsics.h(bannerData, "bannerData");
            Subject subject = bannerData.getSubject();
            if (subject == null || (cover2 = subject.getCover()) == null || (url = cover2.getUrl()) == null) {
                Image image = bannerData.getImage();
                url = image != null ? image.getUrl() : null;
            }
            Subject subject2 = bannerData.getSubject();
            if (subject2 == null || (cover = subject2.getCover()) == null || (thumbnail = cover.getThumbnail()) == null) {
                Image image2 = bannerData.getImage();
                thumbnail = image2 != null ? image2.getThumbnail() : null;
            }
            boolean builtIn = bannerData.getBuiltIn();
            String str = BuildConfig.FLAVOR;
            if (builtIn) {
                kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new SubBannerChildPagerAdapter$SubViewPagerViewHolder$bindData$1(url, this, null), 3, (Object) null);
            } else {
                f.a aVar = ni.f.a;
                Context context = this.c.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m = aVar.m(context);
                if (url == null) {
                    url = BuildConfig.FLAVOR;
                }
                f.b g = m.g(url);
                if (thumbnail == null) {
                    thumbnail = BuildConfig.FLAVOR;
                }
                g.l(thumbnail).i(com.tn.lib.widget.R.mipmap.ic_img_placeholder).m(lj.a.b(40)).c(lj.a.b(56)).d(this.c);
            }
            ((RecyclerView.a0) this).itemView.setClickable(false);
            Subject subject3 = bannerData.getSubject();
            if (subject3 != null) {
                TextView textView = this.e;
                String title = subject3.getTitle();
                if (title != null) {
                    str = title;
                }
                textView.setText(str);
                SpannableString i2 = i(subject3);
                if (i2.length() > 0) {
                    this.f.setText(i2);
                    this.f.setCompoundDrawablesWithIntrinsicBounds(com.transsion.flow.h.a(subject3.getSubjectType()), 0, 0, 0);
                }
            }
            if (bannerData.getSubject() == null) {
                this.e.setText(bannerData.getContent());
                this.f.setText((CharSequence) null);
            }
            CharSequence text = this.f.getText();
            if (text == null || text.length() == 0) {
                this.f.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            TextView textView2 = this.f;
            CharSequence text2 = textView2.getText();
            textView2.setVisibility(text2 == null || text2.length() == 0 ? 8 : 0);
            View view = ((RecyclerView.a0) this).itemView;
            Intrinsics.g(view, "itemView");
            uf.c.c(view, 0L, new Function1() { // from class: com.transsion.home.adapter.suboperate.adapter.j
                public final Object invoke(Object obj) {
                    Unit h;
                    h = SubBannerChildPagerAdapter.SubViewPagerViewHolder.h(BannerData.this, this, i, (View) obj);
                    return h;
                }
            }, 1, (Object) null);
            k(bannerData, this.d);
        }

        public final ImageView getImageView() {
            return this.c;
        }
    }

    public static final class a extends RecyclerView.a0 {
        private final ImageView a;
        private final ImageView b;
        private final ImageView c;
        private final TextView d;
        private final TextView e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            Intrinsics.h(view, "itemView");
            View findViewById = view.findViewById(R.id.iconBg);
            Intrinsics.g(findViewById, "findViewById(...)");
            this.a = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.contentIV);
            Intrinsics.g(findViewById2, "findViewById(...)");
            this.b = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.playIV);
            Intrinsics.g(findViewById3, "findViewById(...)");
            this.c = (ImageView) findViewById3;
            View findViewById4 = view.findViewById(R.id.titleTV);
            Intrinsics.g(findViewById4, "findViewById(...)");
            this.d = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.desTV);
            Intrinsics.g(findViewById5, "findViewById(...)");
            this.e = (TextView) findViewById5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit i(View view) {
            Intrinsics.h(view, "it");
            BannerADDataHelper.a.l();
            return Unit.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit j(AdMaterialList adMaterialList, AdPlans adPlans, View view) {
            Intrinsics.h(view, "it");
            com.transsion.ad.strategy.b.a.a(adMaterialList != null ? adMaterialList.getDeeplink() : null, adMaterialList != null ? adMaterialList.getH5Link() : null, adPlans);
            return Unit.a;
        }

        public final void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            final AdPlans plans;
            String str;
            String thumbnail;
            if (biddingIntermediateMaterialBean == null || (plans = biddingIntermediateMaterialBean.getPlans()) == null) {
                return;
            }
            TAdNativeInfo nativeInfo = biddingIntermediateMaterialBean.getNativeInfo();
            if (nativeInfo != null) {
                this.d.setText(nativeInfo.getTitle());
                this.e.setText(nativeInfo.getDescription());
                RequestManager with = Glide.with(this.a.getContext());
                TAdNativeInfo.Image icon = nativeInfo.getIcon();
                with.load(icon != null ? icon.getUrl() : null).transform(new sf.a(50, 8, true)).into(this.a);
                this.b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                RequestManager with2 = Glide.with(this.b.getContext());
                TAdNativeInfo.Image icon2 = nativeInfo.getIcon();
                with2.load(icon2 != null ? icon2.getUrl() : null).placeholder(com.tn.lib.widget.R.mipmap.ic_img_placeholder).into(this.b);
                this.c.setImageResource(R$drawable.ic_trending_arrow);
                View view = ((RecyclerView.a0) this).itemView;
                Intrinsics.g(view, "itemView");
                uf.c.c(view, 0L, new Function1() { // from class: com.transsion.home.adapter.suboperate.adapter.h
                    public final Object invoke(Object obj) {
                        Unit i;
                        i = SubBannerChildPagerAdapter.a.i((View) obj);
                        return i;
                    }
                }, 1, (Object) null);
                return;
            }
            com.transsion.ad.monopoly.plan.c cVar = com.transsion.ad.monopoly.plan.c.a;
            AdMaterialList c = cVar.c(plans);
            MbAdImage a = cVar.a(plans);
            this.b.setImageResource(com.tn.lib.widget.R.mipmap.ic_img_placeholder);
            f.a aVar = ni.f.a;
            Context context = this.b.getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m = aVar.m(context);
            String str2 = BuildConfig.FLAVOR;
            if (a == null || (str = a.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            f.b g = m.g(str);
            if (a != null && (thumbnail = a.getThumbnail()) != null) {
                str2 = thumbnail;
            }
            g.l(str2).i(com.tn.lib.widget.R.mipmap.ic_img_placeholder).m(lj.a.b(40)).c(lj.a.b(56)).d(this.b);
            this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.d.setText(c != null ? c.getTitle() : null);
            this.e.setText(c != null ? c.getDesc() : null);
            this.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            this.c.setImageResource(R$drawable.ic_trending_arrow);
            final AdMaterialList c2 = cVar.c(plans);
            View view2 = ((RecyclerView.a0) this).itemView;
            Intrinsics.g(view2, "itemView");
            uf.c.c(view2, 0L, new Function1() { // from class: com.transsion.home.adapter.suboperate.adapter.i
                public final Object invoke(Object obj) {
                    Unit j;
                    j = SubBannerChildPagerAdapter.a.j(AdMaterialList.this, plans, (View) obj);
                    return j;
                }
            }, 1, (Object) null);
        }
    }

    public SubBannerChildPagerAdapter(List list, int i, OperateItem operateItem) {
        Intrinsics.h(list, "banners");
        Intrinsics.h(operateItem, "operateItem");
        this.a = list;
        this.b = i;
        this.c = operateItem;
        this.e = 1;
    }

    private final BannerData g(int i) {
        int size;
        if (!this.a.isEmpty() && (size = i % this.a.size()) >= 0 && size < this.a.size()) {
            return (BannerData) this.a.get(size);
        }
        return null;
    }

    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    public int getItemViewType(int i) {
        BannerData g = g(i);
        return (g != null ? g.getBiddingAdData() : null) != null ? this.e : this.d;
    }

    public final void h(List list) {
        Intrinsics.h(list, "<set-?>");
        this.a = list;
    }

    public void onBindViewHolder(RecyclerView.a0 a0Var, int i) {
        Intrinsics.h(a0Var, "holder");
        if (this.a.isEmpty()) {
            return;
        }
        int size = i % this.a.size();
        BannerData bannerData = (BannerData) this.a.get(size);
        if (bannerData == null) {
            return;
        }
        if (a0Var instanceof a) {
            ((a) a0Var).h(bannerData.getBiddingAdData());
        } else if (a0Var instanceof SubViewPagerViewHolder) {
            ((SubViewPagerViewHolder) a0Var).g(bannerData, size);
        }
    }

    public RecyclerView.a0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sub_top_banner_card, viewGroup, false);
        if (i == this.e) {
            Intrinsics.e(inflate);
            return new a(inflate);
        }
        Intrinsics.e(inflate);
        return new SubViewPagerViewHolder(inflate, this.b, this.c);
    }
}
