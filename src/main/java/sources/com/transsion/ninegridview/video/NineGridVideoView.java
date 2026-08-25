package com.transsion.ninegridview.video;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.GifBean;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.ninegridview.R$id;
import com.transsion.ninegridview.R$styleable;
import com.transsion.ninegridview.c;
import com.transsion.ninegridview.video.NineGridVideoView;
import com.transsion.player.ui.ORPlayerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import vm.b;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0014\u0018\u0000 o2\u00020\u0001:\u0001FB!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0019J'\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJG\u0010&\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0017H\u0002¢\u0006\u0004\b(\u0010)J\u0019\u0010+\u001a\u0004\u0018\u00010\u001e2\u0006\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b0\u0010/J\u001f\u00103\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006H\u0014¢\u0006\u0004\b3\u00104J7\u00109\u001a\u00020\u00172\u0006\u00106\u001a\u0002052\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0014¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u000205¢\u0006\u0004\b;\u0010<J\u0015\u0010>\u001a\u0002052\u0006\u0010=\u001a\u00020\u0006¢\u0006\u0004\b>\u0010?J\u0015\u0010B\u001a\u00020\u00172\u0006\u0010A\u001a\u00020@¢\u0006\u0004\bB\u0010CJ\r\u0010D\u001a\u00020\u0017¢\u0006\u0004\bD\u0010)R\u001e\u0010H\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\"\u0010N\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010Q\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010I\u001a\u0004\bO\u0010K\"\u0004\bP\u0010MR\"\u0010X\u001a\u00020R8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010[\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010I\u001a\u0004\bY\u0010K\"\u0004\bZ\u0010MR\u001c\u0010]\u001a\b\u0012\u0004\u0012\u00020\u001e0\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010GR\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010IR\u0016\u0010^\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010IR\u0016\u0010_\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010IR\u0016\u0010`\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010IR\u0016\u0010a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010IR\u0016\u0010b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010IR\u0016\u0010c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010IR\u0016\u0010e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010IR\u0014\u0010g\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010SR\u0014\u0010i\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010SR\u0018\u0010l\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010n\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010m¨\u0006p"}, d2 = {"Lcom/transsion/ninegridview/video/NineGridVideoView;", "Landroid/view/ViewGroup;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "Lcom/transsion/moviedetailapi/bean/Image;", "image1", "image2", "k", "(Lcom/transsion/moviedetailapi/bean/Image;Lcom/transsion/moviedetailapi/bean/Image;)Lcom/transsion/moviedetailapi/bean/Image;", "image3", "l", "(Lcom/transsion/moviedetailapi/bean/Image;Lcom/transsion/moviedetailapi/bean/Image;Lcom/transsion/moviedetailapi/bean/Image;)Lcom/transsion/moviedetailapi/bean/Image;", "image", "totalWidth", "columnCount", BuildConfig.FLAVOR, "b", "(Lcom/transsion/moviedetailapi/bean/Image;II)V", "c", "d", "f", "(II)I", "Lcom/transsion/ninegridview/video/NineGridItemView;", "itemView", "left", "top", "right", "bottom", "gridWidth", "gridHeight", "m", "(Lcom/transsion/ninegridview/video/NineGridItemView;IIIIII)V", "e", "()V", "position", "h", "(I)Lcom/transsion/ninegridview/video/NineGridItemView;", "i", "j", "(I)I", "g", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", BuildConfig.FLAVOR, "changed", "t", "r", "onLayout", "(ZIIII)V", "hasGifVisible", "()Z", "innerPlayPos", "currentGifVisible", "(I)Z", "Lcom/transsion/ninegridview/video/NineGridVideoViewAdapter;", "adapter", "setAdapter", "(Lcom/transsion/ninegridview/video/NineGridVideoViewAdapter;)V", "loadImage", BuildConfig.FLAVOR, "a", "Ljava/util/List;", "imageList", "I", "getGridSpacing", "()I", "setGridSpacing", "(I)V", "gridSpacing", "getSingleImageSize", "setSingleImageSize", "singleImageSize", BuildConfig.FLAVOR, "F", "getSingleImageRatio", "()F", "setSingleImageRatio", "(F)V", "singleImageRatio", "getMaxImageSize", "setMaxImageSize", "maxImageSize", BuildConfig.FLAVOR, "itemViewList", "rowCount", "gridWidth1", "gridHeight1", "gridWidth2", "gridHeight2", "gridWidth3", "n", "gridHeight3", "o", "ratioMax", "p", "ratioMin", "q", "Lcom/transsion/ninegridview/video/NineGridVideoViewAdapter;", "mAdapter", "Z", "enableClick", "Companion", "NineGridView_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class NineGridVideoView extends ViewGroup {
    private static b s = new c();

    /* renamed from: a, reason: from kotlin metadata */
    private List imageList;

    /* renamed from: b, reason: from kotlin metadata */
    private int gridSpacing;

    /* renamed from: c, reason: from kotlin metadata */
    private int singleImageSize;

    /* renamed from: d, reason: from kotlin metadata */
    private float singleImageRatio;

    /* renamed from: e, reason: from kotlin metadata */
    private int maxImageSize;

    /* renamed from: f, reason: from kotlin metadata */
    private List itemViewList;

    /* renamed from: g, reason: from kotlin metadata */
    private int columnCount;

    /* renamed from: h, reason: from kotlin metadata */
    private int rowCount;

    /* renamed from: i, reason: from kotlin metadata */
    private int gridWidth1;

    /* renamed from: j, reason: from kotlin metadata */
    private int gridHeight1;

    /* renamed from: k, reason: from kotlin metadata */
    private int gridWidth2;

    /* renamed from: l, reason: from kotlin metadata */
    private int gridHeight2;

    /* renamed from: m, reason: from kotlin metadata */
    private int gridWidth3;

    /* renamed from: n, reason: from kotlin metadata */
    private int gridHeight3;

    /* renamed from: o, reason: from kotlin metadata */
    private final float ratioMax;

    /* renamed from: p, reason: from kotlin metadata */
    private final float ratioMin;

    /* renamed from: q, reason: from kotlin metadata */
    private NineGridVideoViewAdapter mAdapter;

    /* renamed from: r, reason: from kotlin metadata */
    private boolean enableClick;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NineGridVideoView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NineGridVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NineGridVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.gridSpacing = 4;
        this.singleImageSize = 250;
        this.singleImageRatio = 1.0f;
        this.maxImageSize = 9;
        this.itemViewList = new ArrayList();
        this.ratioMax = 2.1111112f;
        this.ratioMin = 0.75f;
        this.enableClick = true;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.gridSpacing = (int) TypedValue.applyDimension(1, this.gridSpacing, displayMetrics);
        this.singleImageSize = (int) TypedValue.applyDimension(1, this.singleImageSize, displayMetrics);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.NineGridView);
        Intrinsics.g(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.gridSpacing = (int) obtainStyledAttributes.getDimension(R$styleable.NineGridView_ngv_gridSpacing, this.gridSpacing);
        this.singleImageSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.NineGridView_ngv_singleImageSize, this.singleImageSize);
        this.singleImageRatio = obtainStyledAttributes.getFloat(R$styleable.NineGridView_ngv_singleImageRatio, this.singleImageRatio);
        this.maxImageSize = obtainStyledAttributes.getInt(R$styleable.NineGridView_ngv_maxSize, this.maxImageSize);
        this.enableClick = obtainStyledAttributes.getBoolean(R$styleable.NineGridView_enable_click, true);
        obtainStyledAttributes.recycle();
        setId(R$id.nine_grid);
    }

    private final void b(Image image, int totalWidth, int columnCount) {
        int i;
        Integer width = image.getWidth();
        int intValue = width != null ? width.intValue() : 0;
        Integer height = image.getHeight();
        int intValue2 = height != null ? height.intValue() : 0;
        if (intValue <= 0 || intValue2 <= 0) {
            return;
        }
        int f = f(totalWidth, columnCount);
        this.gridWidth1 = f;
        float f2 = intValue / intValue2;
        float f3 = this.ratioMax;
        if (f2 <= f3) {
            f3 = this.ratioMin;
            if (f2 >= f3) {
                i = (int) (((f * 1.0f) / intValue) * intValue2);
                this.gridHeight1 = i;
                this.gridHeight2 = 0;
                this.gridHeight3 = 0;
            }
        }
        i = (int) (f / f3);
        this.gridHeight1 = i;
        this.gridHeight2 = 0;
        this.gridHeight3 = 0;
    }

    private final void c(Image image, int totalWidth, int columnCount) {
        int i;
        Integer width = image.getWidth();
        int intValue = width != null ? width.intValue() : 0;
        Integer height = image.getHeight();
        int intValue2 = height != null ? height.intValue() : 0;
        if (intValue <= 0 || intValue2 <= 0) {
            return;
        }
        int f = f(totalWidth, columnCount);
        this.gridWidth2 = f;
        float f2 = intValue / intValue2;
        float f3 = this.ratioMax;
        if (f2 <= f3) {
            f3 = this.ratioMin;
            if (f2 >= f3) {
                i = (int) (((f * 1.0f) / intValue) * intValue2);
                this.gridHeight2 = i;
                this.gridHeight3 = 0;
            }
        }
        i = (int) (f / f3);
        this.gridHeight2 = i;
        this.gridHeight3 = 0;
    }

    private final void d(Image image, int totalWidth, int columnCount) {
        float f;
        Integer width = image.getWidth();
        int intValue = width != null ? width.intValue() : 0;
        Integer height = image.getHeight();
        int intValue2 = height != null ? height.intValue() : 0;
        if (intValue <= 0 || intValue2 <= 0) {
            return;
        }
        int f2 = f(totalWidth, columnCount);
        this.gridWidth3 = f2;
        float f3 = intValue / intValue2;
        float f4 = this.ratioMax;
        if (f3 <= f4) {
            f4 = this.ratioMin;
            if (f3 >= f4) {
                f = ((f2 * 1.0f) / intValue) * intValue2;
                this.gridHeight3 = (int) f;
            }
        }
        f = f2 / f4;
        this.gridHeight3 = (int) f;
    }

    private final void e() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof NineGridItemView)) {
                FrameLayout frameLayout = (FrameLayout) childAt.findViewById(R$id.video_container);
                if (frameLayout != null) {
                    frameLayout.removeAllViews();
                }
                ShapeableImageView findViewById = childAt.findViewById(R$id.video_cover);
                if (findViewById != null) {
                    uf.c.k(findViewById);
                    findViewById.setImageResource(0);
                }
                AppCompatImageView findViewById2 = childAt.findViewById(R$id.label_gif);
                if (findViewById2 != null) {
                    uf.c.g(findViewById2);
                }
            }
        }
    }

    private final int f(int totalWidth, int columnCount) {
        return (totalWidth - (this.gridSpacing * (columnCount - 1))) / columnCount;
    }

    private final int g(int i) {
        List list = this.imageList;
        if (list != null) {
            switch (list.size()) {
                case 1:
                case 2:
                case 6:
                case 9:
                    return i % 3;
                case 3:
                case 4:
                    return i % 2 == 0 ? 0 : 1;
                case 5:
                    return i < 3 ? i % 2 : (i - 1) % 2;
                case 7:
                    return i < 4 ? i % 3 : (i - 1) % 3;
                case 8:
                    return i < 5 ? i % 3 : (i - 2) % 3;
            }
        }
        return 0;
    }

    private final NineGridItemView h(final int position) {
        NineGridVideoViewAdapter nineGridVideoViewAdapter = this.mAdapter;
        if (nineGridVideoViewAdapter == null) {
            return null;
        }
        if (position >= this.itemViewList.size()) {
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            final NineGridItemView generateItemView = nineGridVideoViewAdapter.generateItemView(context);
            if (this.enableClick) {
                generateItemView.setOnClickListener(new View.OnClickListener() { // from class: wm.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NineGridVideoView.i(NineGridVideoView.this, generateItemView, position, view);
                    }
                });
                this.itemViewList.add(generateItemView);
            }
            return generateItemView;
        }
        NineGridItemView nineGridItemView = (NineGridItemView) this.itemViewList.get(position);
        FrameLayout frameLayout = (FrameLayout) nineGridItemView.findViewById(R$id.video_container);
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        ShapeableImageView findViewById = nineGridItemView.findViewById(R$id.video_cover);
        if (findViewById != null) {
            findViewById.setImageResource(0);
            uf.c.k(findViewById);
        }
        AppCompatImageView findViewById2 = nineGridItemView.findViewById(R$id.label_gif);
        if (findViewById2 == null) {
            return nineGridItemView;
        }
        uf.c.g(findViewById2);
        return nineGridItemView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(NineGridVideoView nineGridVideoView, NineGridItemView nineGridItemView, int i, View view) {
        NineGridVideoViewAdapter nineGridVideoViewAdapter = nineGridVideoView.mAdapter;
        if (nineGridVideoViewAdapter != null) {
            Context context = nineGridItemView.getContext();
            Intrinsics.g(context, "getContext(...)");
            NineGridVideoViewAdapter nineGridVideoViewAdapter2 = nineGridVideoView.mAdapter;
            nineGridVideoViewAdapter.onItemClick(context, nineGridVideoView, i, nineGridVideoViewAdapter2 != null ? nineGridVideoViewAdapter2.getImageList() : null);
        }
    }

    private final int j(int i) {
        List list = this.imageList;
        if (list == null) {
            return 0;
        }
        switch (list.size()) {
            case 3:
            case 4:
                if (i >= 2) {
                    break;
                }
                break;
            case 5:
                if (i >= 2) {
                    if (i != 2) {
                        break;
                    } else {
                        break;
                    }
                }
                break;
            case 6:
                if (i >= 3) {
                    break;
                }
                break;
            case 7:
                if (i >= 3) {
                    if (i != 3) {
                        break;
                    } else {
                        break;
                    }
                }
                break;
            case 8:
                if (i >= 3) {
                    if (3 <= i && i < 5) {
                        break;
                    } else {
                        break;
                    }
                }
                break;
            case 9:
                if (i >= 3) {
                    if (3 <= i && i < 6) {
                        break;
                    } else {
                        break;
                    }
                }
                break;
        }
        return 3;
    }

    private final Image k(Image image1, Image image2) {
        Integer height = image1.getHeight();
        int intValue = height != null ? height.intValue() : 0;
        Integer height2 = image2.getHeight();
        return intValue <= (height2 != null ? height2.intValue() : 0) ? image1 : image2;
    }

    private final Image l(Image image1, Image image2, Image image3) {
        return k(k(image1, image2), image3);
    }

    private final void m(NineGridItemView itemView, int left, int top, int right, int bottom, int gridWidth, int gridHeight) {
        itemView.layout(left, top, right, bottom);
        itemView.findViewById(R$id.video_cover).layout(0, 0, gridWidth, gridHeight);
        ((FrameLayout) itemView.findViewById(R$id.video_container)).layout(0, 0, gridWidth, gridHeight);
        ORPlayerView oRPlayerView = (ORPlayerView) itemView.findViewById(R$id.player_view);
        if (oRPlayerView != null) {
            oRPlayerView.layout(0, 0, gridWidth, gridHeight);
        }
    }

    public final boolean currentGifVisible(int innerPlayPos) {
        String videoUrl;
        List list = this.imageList;
        if (list != null) {
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.u();
                }
                GifBean gifBean = ((Image) obj).getGifBean();
                if (gifBean != null && (videoUrl = gifBean.getVideoUrl()) != null && videoUrl.length() > 0 && innerPlayPos == i) {
                    View childAt = getChildAt(i);
                    if (!Intrinsics.c(childAt != null ? Boolean.valueOf(childAt.getGlobalVisibleRect(new Rect())) : null, Boolean.TRUE)) {
                        continue;
                    } else if ((r3.height() * 1.0f) / (childAt.getHeight() * 1.0f) > 0.5f) {
                        return true;
                    }
                }
                i = i2;
            }
        }
        return false;
    }

    public final int getGridSpacing() {
        return this.gridSpacing;
    }

    public final int getMaxImageSize() {
        return this.maxImageSize;
    }

    public final float getSingleImageRatio() {
        return this.singleImageRatio;
    }

    public final int getSingleImageSize() {
        return this.singleImageSize;
    }

    public final boolean hasGifVisible() {
        String videoUrl;
        List list = this.imageList;
        if (list != null) {
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.u();
                }
                GifBean gifBean = ((Image) obj).getGifBean();
                if (gifBean != null && (videoUrl = gifBean.getVideoUrl()) != null && videoUrl.length() > 0) {
                    View childAt = getChildAt(i);
                    if (!Intrinsics.c(childAt != null ? Boolean.valueOf(childAt.getGlobalVisibleRect(new Rect())) : null, Boolean.TRUE)) {
                        continue;
                    } else if ((r3.height() * 1.0f) / (childAt.getHeight() * 1.0f) > 0.5f) {
                        return true;
                    }
                }
                i = i2;
            }
        }
        return false;
    }

    public final void loadImage() {
        String url;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.f(childAt, "null cannot be cast to non-null type com.transsion.ninegridview.video.NineGridItemView");
            NineGridItemView nineGridItemView = (NineGridItemView) childAt;
            List list = this.imageList;
            Image image = list != null ? (Image) list.get(i) : null;
            s.b(getContext(), nineGridItemView, image, nineGridItemView.getWidth(), nineGridItemView.getHeight());
            AppCompatImageView findViewById = nineGridItemView.findViewById(R$id.label_gif);
            if (findViewById != null) {
                if (image == null || (url = image.getUrl()) == null || !StringsKt.G(url, ".gif", false, 2, (Object) null)) {
                    uf.c.g(findViewById);
                } else {
                    uf.c.k(findViewById);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        List list = this.imageList;
        if (list != null) {
            if (list == null || list.size() != 0) {
                List list2 = this.imageList;
                int size = list2 != null ? list2.size() : 0;
                for (int i = 0; i < size; i++) {
                    View childAt = getChildAt(i);
                    Intrinsics.f(childAt, "null cannot be cast to non-null type com.transsion.ninegridview.video.NineGridItemView");
                    NineGridItemView nineGridItemView = (NineGridItemView) childAt;
                    int j = j(i);
                    int g = g(i);
                    if (j == 1) {
                        int paddingLeft = ((this.gridWidth1 + this.gridSpacing) * g) + getPaddingLeft();
                        int paddingTop = getPaddingTop();
                        int i2 = this.gridWidth1;
                        int i3 = this.gridHeight1;
                        m(nineGridItemView, paddingLeft, paddingTop, paddingLeft + i2, paddingTop + i3, i2, i3);
                    } else if (j == 2) {
                        int paddingLeft2 = ((this.gridWidth2 + this.gridSpacing) * g) + getPaddingLeft();
                        int paddingTop2 = (this.gridSpacing * (j - 1)) + this.gridHeight1 + getPaddingTop();
                        int i4 = this.gridWidth2;
                        int i5 = this.gridHeight2;
                        m(nineGridItemView, paddingLeft2, paddingTop2, paddingLeft2 + i4, paddingTop2 + i5, i4, i5);
                    } else if (j == 3) {
                        int paddingLeft3 = ((this.gridWidth3 + this.gridSpacing) * g) + getPaddingLeft();
                        int paddingTop3 = (this.gridSpacing * (j - 1)) + this.gridHeight1 + this.gridHeight2 + getPaddingTop();
                        int i6 = this.gridWidth3;
                        int i7 = this.gridHeight3;
                        m(nineGridItemView, paddingLeft3, paddingTop3, paddingLeft3 + i6, paddingTop3 + i7, i6, i7);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        List list = this.imageList;
        int i = 0;
        if (list != null) {
            switch (list.size()) {
                case 1:
                    b((Image) list.get(0), paddingLeft, 1);
                    break;
                case 2:
                    b(k((Image) list.get(0), (Image) list.get(1)), paddingLeft, 2);
                    break;
                case 3:
                    b(k((Image) list.get(0), (Image) list.get(1)), paddingLeft, 2);
                    c((Image) list.get(2), paddingLeft, 1);
                    break;
                case 4:
                    b(k((Image) list.get(0), (Image) list.get(1)), paddingLeft, 2);
                    c(k((Image) list.get(2), (Image) list.get(3)), paddingLeft, 2);
                    break;
                case 5:
                    b(k((Image) list.get(0), (Image) list.get(1)), paddingLeft, 2);
                    c((Image) list.get(2), paddingLeft, 1);
                    d(k((Image) list.get(3), (Image) list.get(4)), paddingLeft, 2);
                    break;
                case 6:
                    b(l((Image) list.get(0), (Image) list.get(1), (Image) list.get(2)), paddingLeft, 3);
                    c(l((Image) list.get(3), (Image) list.get(4), (Image) list.get(5)), paddingLeft, 3);
                    break;
                case 7:
                    b(l((Image) list.get(0), (Image) list.get(1), (Image) list.get(2)), paddingLeft, 3);
                    c((Image) list.get(3), paddingLeft, 1);
                    d(l((Image) list.get(4), (Image) list.get(5), (Image) list.get(6)), paddingLeft, 3);
                    break;
                case 8:
                    b(l((Image) list.get(0), (Image) list.get(1), (Image) list.get(2)), paddingLeft, 3);
                    c(k((Image) list.get(3), (Image) list.get(4)), paddingLeft, 2);
                    d(l((Image) list.get(5), (Image) list.get(6), (Image) list.get(7)), paddingLeft, 3);
                    break;
                case 9:
                    b(l((Image) list.get(0), (Image) list.get(1), (Image) list.get(2)), paddingLeft, 3);
                    c(l((Image) list.get(3), (Image) list.get(4), (Image) list.get(5)), paddingLeft, 3);
                    d(l((Image) list.get(6), (Image) list.get(7), (Image) list.get(8)), paddingLeft, 3);
                    break;
            }
            size = paddingLeft + getPaddingLeft() + getPaddingRight();
            i = getPaddingBottom() + this.gridHeight1 + this.gridHeight2 + this.gridHeight3 + (this.gridSpacing * (this.rowCount - 1)) + getPaddingTop();
        }
        setMeasuredDimension(size, i);
    }

    public final void setAdapter(NineGridVideoViewAdapter adapter) {
        Intrinsics.h(adapter, "adapter");
        this.mAdapter = adapter;
        List<Image> imageList = adapter.getImageList();
        if (imageList.isEmpty()) {
            uf.c.g(this);
            return;
        }
        uf.c.k(this);
        int size = imageList.size();
        if (this.maxImageSize < size) {
            imageList = imageList.subList(0, imageList.size());
            size = imageList.size();
        }
        if (size == 1) {
            this.columnCount = 1;
            this.rowCount = 1;
        } else if (2 <= size && size < 6) {
            this.columnCount = 2;
            this.rowCount = (size / 2) + (size % 2 == 0 ? 0 : 1);
        } else if (6 <= size && size < 10) {
            this.columnCount = 3;
            this.rowCount = (size / 3) + (size % 3 == 0 ? 0 : 1);
        }
        List list = this.imageList;
        if (list == null) {
            while (r2 < size) {
                addView(h(r2), generateDefaultLayoutParams());
                r2++;
            }
        } else {
            r2 = list != null ? list.size() : 0;
            if (r2 > size) {
                removeViews(size, r2 - size);
                e();
            } else if (r2 < size) {
                e();
                while (r2 < size) {
                    addView(h(r2), generateDefaultLayoutParams());
                    r2++;
                }
            } else {
                e();
            }
        }
        this.imageList = imageList;
        requestLayout();
    }

    public final void setGridSpacing(int i) {
        this.gridSpacing = i;
    }

    public final void setMaxImageSize(int i) {
        this.maxImageSize = i;
    }

    public final void setSingleImageRatio(float f) {
        this.singleImageRatio = f;
    }

    public final void setSingleImageSize(int i) {
        this.singleImageSize = i;
    }
}
