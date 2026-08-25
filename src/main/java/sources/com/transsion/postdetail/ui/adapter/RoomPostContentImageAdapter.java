package com.transsion.postdetail.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import cb.n;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.drawable.DrawableCreator;
import com.tn.lib.widget.R;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.ninegridview.preview.GifImagePreviewActivity;
import com.transsion.postdetail.R$dimen;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ni.f;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B3\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\n\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010&R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010\"R\u0014\u0010,\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010\"R\u0014\u0010.\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010\"¨\u0006/"}, d2 = {"Lcom/transsion/postdetail/ui/adapter/RoomPostContentImageAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/Image;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, "spanCount", BuildConfig.FLAVOR, "isTablet", BuildConfig.FLAVOR, "pageName", "pageFrom", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "item", "<init>", "(IZLjava/lang/String;Ljava/lang/String;Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "Landroid/view/View;", "view", "position", BuildConfig.FLAVOR, "imageList", BuildConfig.FLAVOR, "G1", "(Landroid/view/View;ILjava/util/List;)V", "Landroid/widget/ImageView;", "ivCover", "H1", "(Landroid/widget/ImageView;Lcom/transsion/moviedetailapi/bean/Image;)V", "holder", "Lcom/google/android/material/imageview/ShapeableImageView;", "I1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/google/android/material/imageview/ShapeableImageView;)V", "D1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/Image;)V", "F", "I", "G", "Z", "H", "Ljava/lang/String;", "J", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "K", "rootWidth", "L", "dp78", "M", "dp280", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RoomPostContentImageAdapter extends BaseQuickAdapter {

    /* renamed from: F, reason: from kotlin metadata */
    private final int spanCount;

    /* renamed from: G, reason: from kotlin metadata */
    private final boolean isTablet;

    /* renamed from: H, reason: from kotlin metadata */
    private final String pageName;

    /* renamed from: I, reason: from kotlin metadata */
    private final String pageFrom;

    /* renamed from: J, reason: from kotlin metadata */
    private final PostSubjectItem item;

    /* renamed from: K, reason: from kotlin metadata */
    private final int rootWidth;

    /* renamed from: L, reason: from kotlin metadata */
    private final int dp78;

    /* renamed from: M, reason: from kotlin metadata */
    private final int dp280;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomPostContentImageAdapter(int i, boolean z, String str, String str2, PostSubjectItem postSubjectItem) {
        super(R$layout.item_room_post_content_image, (List) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.h(postSubjectItem, "item");
        this.spanCount = i;
        this.isTablet = z;
        this.pageName = str;
        this.pageFrom = str2;
        this.item = postSubjectItem;
        this.rootWidth = z ? lj.a.b(300) : y.e() - lj.a.b(72);
        this.dp78 = lj.a.b(78);
        this.dp280 = lj.a.b(280);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E1(RoomPostContentImageAdapter roomPostContentImageAdapter, BaseViewHolder baseViewHolder, Image image, ShapeableImageView shapeableImageView) {
        if (roomPostContentImageAdapter.item.getBuiltIn()) {
            kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new RoomPostContentImageAdapter$convert$1$1(image, shapeableImageView, null), 3, (Object) null);
            return;
        }
        f.a aVar = ni.f.a;
        Context context = ((RecyclerView.a0) baseViewHolder).itemView.getContext();
        Intrinsics.g(context, "getContext(...)");
        f.b m = aVar.m(context);
        String url = image.getUrl();
        String str = BuildConfig.FLAVOR;
        if (url == null) {
            url = BuildConfig.FLAVOR;
        }
        f.b g = m.g(url);
        String thumbnail = image.getThumbnail();
        if (thumbnail != null) {
            str = thumbnail;
        }
        g.l(str).d(shapeableImageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F1(RoomPostContentImageAdapter roomPostContentImageAdapter, BaseViewHolder baseViewHolder, View view) {
        Intrinsics.e(view);
        roomPostContentImageAdapter.G1(view, baseViewHolder.getLayoutPosition(), roomPostContentImageAdapter.getData());
    }

    private final void G1(View view, int position, List<Image> imageList) {
        String str = this.pageName;
        if (str != null) {
            com.transsion.postdetail.helper.a.a.n(this.item, str, this.pageFrom);
        }
        try {
            Result.Companion companion = Result.Companion;
            Intent intent = new Intent(view.getContext(), (Class<?>) GifImagePreviewActivity.class);
            Intrinsics.f(imageList, "null cannot be cast to non-null type java.io.Serializable");
            intent.putExtra(GifImagePreviewActivity.IMAGE_LIST, (Serializable) imageList);
            intent.putExtra("CURRENT_ITEM", position);
            intent.putExtra(GifImagePreviewActivity.IS_BUILTIN, this.item.getBuiltIn());
            intent.putExtra(GifImagePreviewActivity.POST_ID, this.item.getPostId());
            view.getContext().startActivity(intent);
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    private final void H1(ImageView ivCover, Image item) {
        ViewGroup.LayoutParams layoutParams = ivCover.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i = this.spanCount;
        if (i == 1) {
            Integer height = item.getHeight();
            int intValue = height != null ? height.intValue() : 0;
            Integer width = item.getWidth();
            int intValue2 = width != null ? width.intValue() : 0;
            if (intValue <= 0 || intValue2 <= 0) {
                marginLayoutParams.width = -1;
                marginLayoutParams.height = this.rootWidth;
            } else {
                int b = intValue2 / intValue < 1 ? this.rootWidth - lj.a.b(38) : this.rootWidth;
                marginLayoutParams.width = b;
                int i2 = (intValue * b) / intValue2;
                if (i2 > (b * 36) / 26) {
                    i2 = (b * 36) / 26;
                }
                marginLayoutParams.height = i2;
            }
        } else if (i != 2) {
            marginLayoutParams.width = -1;
            marginLayoutParams.height = (this.rootWidth - lj.a.b(6)) / 3;
        } else {
            marginLayoutParams.width = -1;
            marginLayoutParams.height = (this.rootWidth - lj.a.b(6)) / 2;
        }
        ivCover.setLayoutParams(marginLayoutParams);
    }

    private final void I1(BaseViewHolder holder, ShapeableImageView ivCover) {
        float f;
        float f2;
        float f3;
        float f4;
        int bindingAdapterPosition = holder.getBindingAdapterPosition();
        float dimension = ((RecyclerView.a0) holder).itemView.getResources().getDimension(R$dimen.corner_radius);
        n.b a = n.a();
        Intrinsics.g(a, "builder(...)");
        int size = getData().size();
        boolean z = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        DrawableCreator.Builder builder = new DrawableCreator.Builder();
        int i = this.spanCount;
        if (i != 1) {
            float f5 = 0.0f;
            if (i != 2) {
                float b = lj.a.b(4);
                if (bindingAdapterPosition != 0) {
                    f = 0.0f;
                    f2 = 0.0f;
                } else if (z) {
                    a.J(0, dimension);
                    f2 = b;
                    f = 0.0f;
                } else {
                    a.E(0, dimension);
                    f = b;
                    f2 = 0.0f;
                }
                if (bindingAdapterPosition == 2) {
                    if (z) {
                        a.E(0, dimension);
                        f = b;
                    } else {
                        a.J(0, dimension);
                        f2 = b;
                    }
                }
                int i2 = size - 1;
                if (bindingAdapterPosition != i2 || size % 3 != 0) {
                    f3 = 0.0f;
                } else if (z) {
                    a.t(0, dimension);
                    f3 = 0.0f;
                    f5 = b;
                } else {
                    a.y(0, dimension);
                    f3 = b;
                }
                int i3 = size % 3;
                if ((i3 != 1 || bindingAdapterPosition != i2) && ((i3 != 2 || bindingAdapterPosition != size - 2) && (i3 != 0 || bindingAdapterPosition != size - 3))) {
                    b = f5;
                } else if (z) {
                    a.y(0, dimension);
                    f4 = b;
                    b = f5;
                    builder.setCornersRadius(b, f4, f, f2);
                } else {
                    a.t(0, dimension);
                }
                f4 = f3;
                builder.setCornersRadius(b, f4, f, f2);
            } else {
                if (bindingAdapterPosition == 0) {
                    if (z) {
                        a.J(0, dimension);
                        builder.setCornersRadius(0.0f, 0.0f, 0.0f, lj.a.b(4));
                    } else {
                        a.E(0, dimension);
                        builder.setCornersRadius(0.0f, 0.0f, lj.a.b(4), 0.0f);
                    }
                }
                if (bindingAdapterPosition == 1) {
                    if (z) {
                        a.E(0, dimension);
                        builder.setCornersRadius(0.0f, 0.0f, lj.a.b(4), 0.0f);
                    } else {
                        a.J(0, dimension);
                        builder.setCornersRadius(0.0f, 0.0f, 0.0f, lj.a.b(4));
                    }
                }
                if (bindingAdapterPosition == size - 1 && size % 2 == 0) {
                    if (z) {
                        a.t(0, dimension);
                        builder.setCornersRadius(lj.a.b(4), 0.0f, 0.0f, 0.0f);
                    } else {
                        a.y(0, dimension);
                        builder.setCornersRadius(0.0f, lj.a.b(4), 0.0f, 0.0f);
                    }
                }
                if (bindingAdapterPosition == size - 2 && size >= 2 && size % 2 == 0) {
                    if (z) {
                        a.y(0, dimension);
                        builder.setCornersRadius(0.0f, lj.a.b(4), 0.0f, 0.0f);
                    } else {
                        a.t(0, dimension);
                        builder.setCornersRadius(lj.a.b(4), 0.0f, 0.0f, 0.0f);
                    }
                }
                Unit unit = Unit.a;
            }
        } else {
            a.q(0, dimension);
            builder.setCornersRadius(lj.a.b(4));
        }
        holder.getView(R$id.v_stroke).setBackground(builder.setStrokeColor(Utils.a().getResources().getColor(R.color.white_10)).setStrokeWidth(lj.a.b(1)).build());
        ivCover.setShapeAppearanceModel(a.m());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    public void F(final BaseViewHolder holder, final Image item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        final ShapeableImageView view = holder.getView(R$id.iv_cover);
        H1(view, item);
        I1(holder, view);
        ((RecyclerView.a0) holder).itemView.post(new Runnable() { // from class: com.transsion.postdetail.ui.adapter.g
            @Override // java.lang.Runnable
            public final void run() {
                RoomPostContentImageAdapter.E1(RoomPostContentImageAdapter.this, holder, item, view);
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.adapter.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RoomPostContentImageAdapter.F1(RoomPostContentImageAdapter.this, holder, view2);
            }
        });
    }
}
