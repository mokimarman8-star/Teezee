package fo;

import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R;
import com.transsion.flow.bean.MediaType;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.FirstFrame;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class v extends BaseItemProvider {
    private final String e;
    private final String f;
    private final RecyclerView.s g;
    private final int h;

    public v(String str, String str2, RecyclerView.s sVar) {
        Intrinsics.h(sVar, "pool");
        this.e = str;
        this.f = str2;
        this.g = sVar;
        this.h = (com.blankj.utilcode.util.y.e() - (a0.a(6.0f) * 3)) / 2;
    }

    private final int A(int i, int i2, int i3) {
        float f = i / i2;
        return f < 0.75f ? (i3 * 4) / 3 : f > 1.3333334f ? (i3 * 3) / 4 : (int) (i3 / f);
    }

    private final void C(BaseViewHolder baseViewHolder, PostSubjectItem postSubjectItem, boolean z) {
        B((AppCompatTextView) baseViewHolder.getViewOrNull(R$id.tv_staggered_post_like), z, postSubjectItem);
    }

    public final void B(AppCompatTextView appCompatTextView, boolean z, PostSubjectItem postSubjectItem) {
        Intrinsics.h(postSubjectItem, "item");
        if (appCompatTextView != null) {
            Stat stat = postSubjectItem.getStat();
            Long likeCount = stat != null ? stat.getLikeCount() : null;
            appCompatTextView.setText((likeCount == null || likeCount.longValue() == 0) ? BuildConfig.FLAVOR : com.transsion.baseui.util.j.a(likeCount.longValue()));
            if (z) {
                appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.room_staggered_like_icon, 0, 0, 0);
            } else {
                appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.room_staggered_unlike_icon, 0, 0, 0);
            }
        }
    }

    public int l() {
        return MediaType.CONTENT_ALL.ordinal();
    }

    public int m() {
        return R$layout.item_provider_post_staggered_layout;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, PostSubjectItem postSubjectItem) {
        String title;
        String str;
        String str2;
        Integer height;
        Integer width;
        List image;
        List image2;
        String str3;
        String str4;
        Integer height2;
        Integer width2;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(postSubjectItem, "item");
        String content = postSubjectItem.getContent();
        String str5 = BuildConfig.FLAVOR;
        if (content == null || content.length() == 0 ? (title = postSubjectItem.getTitle()) == null : (title = postSubjectItem.getContent()) == null) {
            title = BuildConfig.FLAVOR;
        }
        AppCompatTextView viewOrNull = baseViewHolder.getViewOrNull(R$id.tvPicNum);
        AppCompatImageView viewOrNull2 = baseViewHolder.getViewOrNull(R$id.ivPlaying);
        ShapeableImageView viewOrNull3 = baseViewHolder.getViewOrNull(R$id.iv_cover);
        Media media = postSubjectItem.getMedia();
        if (Intrinsics.c(media != null ? media.getMediaType() : null, MediaType.VIDEO.getValue())) {
            if (viewOrNull2 != null) {
                uf.c.k(viewOrNull2);
            }
            if (viewOrNull != null) {
                uf.c.g(viewOrNull);
            }
            Media media2 = postSubjectItem.getMedia();
            FirstFrame firstFrame = media2 != null ? media2.getFirstFrame() : null;
            if (viewOrNull3 != null) {
                viewOrNull3.getLayoutParams().height = A((firstFrame == null || (width2 = firstFrame.getWidth()) == null) ? 0 : width2.intValue(), (firstFrame == null || (height2 = firstFrame.getHeight()) == null) ? 0 : height2.intValue(), this.h);
                f.a aVar = ni.f.a;
                Context context = viewOrNull3.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m = aVar.m(context);
                if (firstFrame == null || (str4 = firstFrame.getUrl()) == null) {
                    str4 = BuildConfig.FLAVOR;
                }
                m.g(str4).d(viewOrNull3);
            }
        } else {
            if (viewOrNull2 != null) {
                uf.c.g(viewOrNull2);
            }
            Media media3 = postSubjectItem.getMedia();
            List image3 = media3 != null ? media3.getImage() : null;
            if (image3 != null && !image3.isEmpty()) {
                Media media4 = postSubjectItem.getMedia();
                Image image4 = (media4 == null || (image2 = media4.getImage()) == null) ? null : (Image) image2.get(0);
                Media media5 = postSubjectItem.getMedia();
                int size = (media5 == null || (image = media5.getImage()) == null) ? 0 : image.size();
                if (viewOrNull3 != null) {
                    viewOrNull3.getLayoutParams().height = A((image4 == null || (width = image4.getWidth()) == null) ? 0 : width.intValue(), (image4 == null || (height = image4.getHeight()) == null) ? 0 : height.intValue(), this.h);
                    f.a aVar2 = ni.f.a;
                    Context context2 = viewOrNull3.getContext();
                    Intrinsics.g(context2, "getContext(...)");
                    f.b m2 = aVar2.m(context2);
                    if (image4 == null || (str = image4.getUrl()) == null) {
                        str = BuildConfig.FLAVOR;
                    }
                    f.b g = m2.g(str);
                    if (image4 == null || (str2 = image4.getThumbnail()) == null) {
                        str2 = BuildConfig.FLAVOR;
                    }
                    g.l(str2).d(viewOrNull3);
                }
                if (size > 1) {
                    if (viewOrNull != null) {
                        uf.c.k(viewOrNull);
                    }
                    if (viewOrNull != null) {
                        viewOrNull.setText(size + " pics");
                    }
                } else if (viewOrNull != null) {
                    uf.c.g(viewOrNull);
                }
            }
        }
        AppCompatTextView viewOrNull4 = baseViewHolder.getViewOrNull(R$id.tv_title);
        if (title.length() == 0) {
            if (viewOrNull4 != null) {
                uf.c.g(viewOrNull4);
            }
        } else if (viewOrNull4 != null) {
            uf.c.k(viewOrNull4);
        }
        if (viewOrNull4 != null) {
            viewOrNull4.setText(title);
        }
        ShapeableImageView viewOrNull5 = baseViewHolder.getViewOrNull(R$id.iv_user_avatar);
        if (viewOrNull5 != null) {
            f.a aVar3 = ni.f.a;
            Context context3 = viewOrNull5.getContext();
            Intrinsics.g(context3, "getContext(...)");
            f.b m3 = aVar3.m(context3);
            User user = postSubjectItem.getUser();
            if (user == null || (str3 = user.getAvatar()) == null) {
                str3 = BuildConfig.FLAVOR;
            }
            m3.g(str3).d(viewOrNull5);
        }
        int i = R$id.tv_user_name;
        User user2 = postSubjectItem.getUser();
        baseViewHolder.setText(i, user2 != null ? user2.getNickname() : null);
        AppCompatTextView viewOrNull6 = baseViewHolder.getViewOrNull(R$id.tv_staggered_post_like);
        if (viewOrNull6 != null) {
            Stat stat = postSubjectItem.getStat();
            Long likeCount = stat != null ? stat.getLikeCount() : null;
            if (likeCount != null && likeCount.longValue() != 0) {
                str5 = com.transsion.baseui.util.j.a(likeCount.longValue());
            }
            viewOrNull6.setText(str5);
            if (Intrinsics.c(postSubjectItem.getHasLike(), Boolean.TRUE)) {
                viewOrNull6.setCompoundDrawablesWithIntrinsicBounds(R.drawable.room_staggered_like_icon, 0, 0, 0);
            } else {
                viewOrNull6.setCompoundDrawablesWithIntrinsicBounds(R.drawable.room_staggered_unlike_icon, 0, 0, 0);
            }
        }
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void f(BaseViewHolder baseViewHolder, PostSubjectItem postSubjectItem, List list) {
        List data;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(postSubjectItem, "item");
        Intrinsics.h(list, "payloads");
        super.f(baseViewHolder, postSubjectItem, list);
        if (list.isEmpty()) {
            return;
        }
        Object v0 = CollectionsKt.v0(list);
        if (v0 instanceof Boolean) {
            try {
                Result.Companion companion = Result.Companion;
                BaseProviderMultiAdapter g = g();
                if (g != null && (data = g.getData()) != null) {
                    int adapterPosition = baseViewHolder.getAdapterPosition();
                    BaseProviderMultiAdapter g2 = g();
                    PostSubjectItem postSubjectItem2 = (PostSubjectItem) data.get(adapterPosition + (g2 != null ? g2.a0() : 0));
                    if (postSubjectItem2 != null) {
                        C(baseViewHolder, postSubjectItem2, ((Boolean) v0).booleanValue());
                    }
                }
                Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
        }
    }
}
