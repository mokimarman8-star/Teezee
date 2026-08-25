package com.transsion.ninegridview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.transsion.gslb.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u001f\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\u0018\u0000 e2\u00020\u0001:\u0001CB#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\nB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J'\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0013H\u0002¢\u0006\u0004\b \u0010!J'\u0010#\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0013H\u0002¢\u0006\u0004\b#\u0010$J\u001f\u0010'\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0006H\u0014¢\u0006\u0004\b'\u0010(J7\u0010.\u001a\u00020\u00152\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0014¢\u0006\u0004\b.\u0010/J\u0015\u00102\u001a\u00020\u00152\u0006\u00101\u001a\u000200¢\u0006\u0004\b2\u00103J\u0015\u00105\u001a\u00020\u00152\u0006\u00104\u001a\u00020\u0006¢\u0006\u0004\b5\u00106J\u0015\u00108\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u0006¢\u0006\u0004\b8\u00106J\u0015\u0010;\u001a\u00020\u00152\u0006\u0010:\u001a\u000209¢\u0006\u0004\b;\u0010<J\u0015\u0010>\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u0006¢\u0006\u0004\b>\u00106J\r\u0010?\u001a\u00020\u0006¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0015H\u0014¢\u0006\u0004\bA\u0010BR\u001a\u0010F\u001a\u00020\u00068\u0006X\u0086D¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010@R\u001a\u0010H\u001a\u00020\u00068\u0006X\u0086D¢\u0006\f\n\u0004\b\u0016\u0010D\u001a\u0004\bG\u0010@R\u0016\u0010I\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010DR\u0016\u0010K\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010JR\u0016\u00107\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010DR\u0016\u0010L\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010DR\u0016\u0010M\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010DR\u0016\u0010\u0010\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010DR\u0016\u0010O\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010DR\u0016\u0010P\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010DR\u0016\u0010Q\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010DR\u0016\u0010R\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010DR\u0016\u0010T\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010DR\u0016\u0010V\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010DR\u0016\u0010X\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010DR\u001e\u0010\\\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u001e\u0010_\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010]8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010[R\u0018\u0010a\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010`R\u0014\u0010c\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010JR\u0014\u0010d\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010J¨\u0006f"}, d2 = {"Lcom/transsion/ninegridview/NineGridViewNew;", "Landroid/view/ViewGroup;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "(I)I", "f", "totalWidth", "columnCount", "e", "(II)I", "Lcom/transsion/ninegridview/ImageInfo;", "imageInfo", BuildConfig.FLAVOR, "b", "(Lcom/transsion/ninegridview/ImageInfo;II)V", "c", "d", "position", "Landroid/widget/ImageView;", "g", "(I)Landroid/widget/ImageView;", "imageInfo1", "imageInfo2", "j", "(Lcom/transsion/ninegridview/ImageInfo;Lcom/transsion/ninegridview/ImageInfo;)Lcom/transsion/ninegridview/ImageInfo;", "imageInfo3", "k", "(Lcom/transsion/ninegridview/ImageInfo;Lcom/transsion/ninegridview/ImageInfo;Lcom/transsion/ninegridview/ImageInfo;)Lcom/transsion/ninegridview/ImageInfo;", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", BuildConfig.FLAVOR, "changed", "l", "t", "r", "onLayout", "(ZIIII)V", "Lcom/transsion/ninegridview/NineGridViewAdapter;", "adapter", "setAdapter", "(Lcom/transsion/ninegridview/NineGridViewAdapter;)V", "spacing", "setGridSpacing", "(I)V", "maxImageSize", "setSingleImageSize", BuildConfig.FLAVOR, "ratio", "setSingleImageRatio", "(F)V", "maxSize", "setMaxSize", "getMaxSize", "()I", "onDetachedFromWindow", "()V", "a", "I", "getMODE_FILL", "MODE_FILL", "getMODE_GRID", "MODE_GRID", "singleImageSize", "F", "singleImageRatio", "gridSpacing", "mode", "h", "rowCount", "gridWidth1", "gridHeight1", "gridWidth2", "m", "gridHeight2", "n", "gridWidth3", "o", "gridHeight3", BuildConfig.FLAVOR, "p", "Ljava/util/List;", "imageViews", BuildConfig.FLAVOR, "q", "mImageInfo", "Lcom/transsion/ninegridview/NineGridViewAdapter;", "mAdapter", "s", "ratioMax", "ratioMin", "Companion", "NineGridView_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class NineGridViewNew extends ViewGroup {
    private static vm.b u = new c();

    /* renamed from: a, reason: from kotlin metadata */
    private final int MODE_FILL;

    /* renamed from: b, reason: from kotlin metadata */
    private final int MODE_GRID;

    /* renamed from: c, reason: from kotlin metadata */
    private int singleImageSize;

    /* renamed from: d, reason: from kotlin metadata */
    private float singleImageRatio;

    /* renamed from: e, reason: from kotlin metadata */
    private int maxImageSize;

    /* renamed from: f, reason: from kotlin metadata */
    private int gridSpacing;

    /* renamed from: g, reason: from kotlin metadata */
    private int mode;

    /* renamed from: h, reason: from kotlin metadata */
    private int columnCount;

    /* renamed from: i, reason: from kotlin metadata */
    private int rowCount;

    /* renamed from: j, reason: from kotlin metadata */
    private int gridWidth1;

    /* renamed from: k, reason: from kotlin metadata */
    private int gridHeight1;

    /* renamed from: l, reason: from kotlin metadata */
    private int gridWidth2;

    /* renamed from: m, reason: from kotlin metadata */
    private int gridHeight2;

    /* renamed from: n, reason: from kotlin metadata */
    private int gridWidth3;

    /* renamed from: o, reason: from kotlin metadata */
    private int gridHeight3;

    /* renamed from: p, reason: from kotlin metadata */
    private List imageViews;

    /* renamed from: q, reason: from kotlin metadata */
    private List mImageInfo;

    /* renamed from: r, reason: from kotlin metadata */
    private NineGridViewAdapter mAdapter;

    /* renamed from: s, reason: from kotlin metadata */
    private final float ratioMax;

    /* renamed from: t, reason: from kotlin metadata */
    private final float ratioMin;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NineGridViewNew(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NineGridViewNew(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NineGridViewNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.MODE_GRID = 1;
        this.singleImageSize = 250;
        this.singleImageRatio = 1.0f;
        this.maxImageSize = 9;
        this.gridSpacing = 2;
        this.mode = this.MODE_FILL;
        this.ratioMax = 2.1111112f;
        this.ratioMin = 0.75f;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.gridSpacing = (int) TypedValue.applyDimension(1, this.gridSpacing, displayMetrics);
        this.singleImageSize = (int) TypedValue.applyDimension(1, this.singleImageSize, displayMetrics);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.NineGridView);
        Intrinsics.g(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.gridSpacing = (int) obtainStyledAttributes.getDimension(R$styleable.NineGridView_ngv_gridSpacing, this.gridSpacing);
        this.singleImageSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.NineGridView_ngv_singleImageSize, this.singleImageSize);
        this.singleImageRatio = obtainStyledAttributes.getFloat(R$styleable.NineGridView_ngv_singleImageRatio, this.singleImageRatio);
        this.maxImageSize = obtainStyledAttributes.getInt(R$styleable.NineGridView_ngv_maxSize, this.maxImageSize);
        this.mode = obtainStyledAttributes.getInt(R$styleable.NineGridView_ngv_mode, this.mode);
        obtainStyledAttributes.recycle();
        this.imageViews = new ArrayList();
    }

    private final void b(ImageInfo imageInfo, int totalWidth, int columnCount) {
        int i;
        if (imageInfo.imageViewWidth <= 0.0f || imageInfo.imageViewHeight <= 0.0f) {
            return;
        }
        int e = e(totalWidth, columnCount);
        this.gridWidth1 = e;
        float f = imageInfo.imageViewWidth;
        float f2 = imageInfo.imageViewHeight;
        float f3 = f / f2;
        float f4 = this.ratioMax;
        if (f3 <= f4) {
            float f5 = f / f2;
            f4 = this.ratioMin;
            if (f5 >= f4) {
                i = (int) (((e * 1.0f) / f) * f2);
                this.gridHeight1 = i;
                this.gridHeight2 = 0;
                this.gridHeight3 = 0;
            }
        }
        i = (int) (e / f4);
        this.gridHeight1 = i;
        this.gridHeight2 = 0;
        this.gridHeight3 = 0;
    }

    private final void c(ImageInfo imageInfo, int totalWidth, int columnCount) {
        int i;
        if (imageInfo.imageViewWidth <= 0.0f || imageInfo.imageViewHeight <= 0.0f) {
            return;
        }
        int e = e(totalWidth, columnCount);
        this.gridWidth2 = e;
        float f = imageInfo.imageViewWidth;
        float f2 = imageInfo.imageViewHeight;
        float f3 = f / f2;
        float f4 = this.ratioMax;
        if (f3 <= f4) {
            float f5 = f / f2;
            f4 = this.ratioMin;
            if (f5 >= f4) {
                i = (int) (((e * 1.0f) / f) * f2);
                this.gridHeight2 = i;
                this.gridHeight3 = 0;
            }
        }
        i = (int) (e / f4);
        this.gridHeight2 = i;
        this.gridHeight3 = 0;
    }

    private final void d(ImageInfo imageInfo, int totalWidth, int columnCount) {
        int i;
        if (imageInfo.imageViewWidth <= 0.0f || imageInfo.imageViewHeight <= 0.0f) {
            return;
        }
        int e = e(totalWidth, columnCount);
        this.gridWidth3 = e;
        float f = imageInfo.imageViewWidth;
        float f2 = imageInfo.imageViewHeight;
        float f3 = f / f2;
        float f4 = this.ratioMax;
        if (f3 <= f4) {
            float f5 = f / f2;
            f4 = this.ratioMin;
            if (f5 >= f4) {
                i = (int) (((e * 1.0f) / f) * f2);
                this.gridHeight3 = i;
            }
        }
        i = (int) (e / f4);
        this.gridHeight3 = i;
    }

    private final int e(int totalWidth, int columnCount) {
        return (totalWidth - (this.gridSpacing * (columnCount - 1))) / columnCount;
    }

    private final int f(int i) {
        List list = this.mImageInfo;
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

    private final ImageView g(final int position) {
        List list = this.imageViews;
        Intrinsics.e(list);
        if (position < list.size()) {
            List list2 = this.imageViews;
            Intrinsics.e(list2);
            return (ImageView) list2.get(position);
        }
        NineGridViewAdapter nineGridViewAdapter = this.mAdapter;
        Intrinsics.e(nineGridViewAdapter);
        ImageView generateImageView = nineGridViewAdapter.generateImageView(getContext());
        Intrinsics.g(generateImageView, "generateImageView(...)");
        generateImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ninegridview.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NineGridViewNew.h(NineGridViewNew.this, position, view);
            }
        });
        List list3 = this.imageViews;
        if (list3 != null) {
            list3.add(generateImageView);
        }
        return generateImageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(NineGridViewNew nineGridViewNew, int i, View view) {
        NineGridViewAdapter nineGridViewAdapter = nineGridViewNew.mAdapter;
        Intrinsics.e(nineGridViewAdapter);
        Context context = nineGridViewNew.getContext();
        NineGridViewAdapter nineGridViewAdapter2 = nineGridViewNew.mAdapter;
        Intrinsics.e(nineGridViewAdapter2);
        nineGridViewAdapter.onImageItemClick(context, nineGridViewNew, i, nineGridViewAdapter2.getImageInfo());
    }

    private final int i(int i) {
        List list = this.mImageInfo;
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

    private final ImageInfo j(ImageInfo imageInfo1, ImageInfo imageInfo2) {
        return imageInfo1.imageViewHeight <= imageInfo2.imageViewHeight ? imageInfo1 : imageInfo2;
    }

    private final ImageInfo k(ImageInfo imageInfo1, ImageInfo imageInfo2, ImageInfo imageInfo3) {
        return j(j(imageInfo1, imageInfo2), imageInfo3);
    }

    public final int getMODE_FILL() {
        return this.MODE_FILL;
    }

    public final int getMODE_GRID() {
        return this.MODE_GRID;
    }

    /* renamed from: getMaxSize, reason: from getter */
    public final int getMaxImageSize() {
        return this.maxImageSize;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        List list = this.mImageInfo;
        if (list == null) {
            return;
        }
        Intrinsics.e(list);
        ((ImageInfo) list.get(0)).alreadyShow = 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        List list = this.mImageInfo;
        if (list == null) {
            return;
        }
        int size = list != null ? list.size() : 0;
        List list2 = this.mImageInfo;
        Intrinsics.e(list2);
        if (((ImageInfo) list2.get(0)).alreadyShow == 1) {
            return;
        }
        List list3 = this.mImageInfo;
        Intrinsics.e(list3);
        ((ImageInfo) list3.get(0)).alreadyShow = 1;
        for (int i = 0; i < size; i++) {
            View childAt = getChildAt(i);
            Intrinsics.f(childAt, "null cannot be cast to non-null type android.widget.ImageView");
            ImageView imageView = (ImageView) childAt;
            int i2 = i(i);
            int f = f(i);
            List list4 = this.mImageInfo;
            ImageInfo imageInfo = list4 != null ? (ImageInfo) list4.get(i) : null;
            if (i2 == 1) {
                int paddingLeft = ((this.gridWidth1 + this.gridSpacing) * f) + getPaddingLeft();
                int paddingTop = getPaddingTop();
                imageView.layout(paddingLeft, paddingTop, this.gridWidth1 + paddingLeft, this.gridHeight1 + paddingTop);
                vm.b bVar = u;
                if (bVar != null) {
                    bVar.a(getContext(), imageView, imageInfo != null ? imageInfo.bigImageUrl : null, this.gridWidth1, this.gridHeight1, imageInfo != null ? imageInfo.thumbnailUrl : null);
                }
            } else if (i2 != 2) {
                int paddingLeft2 = ((this.gridWidth3 + this.gridSpacing) * f) + getPaddingLeft();
                int paddingTop2 = (this.gridSpacing * (i2 - 1)) + this.gridHeight1 + this.gridHeight2 + getPaddingTop();
                imageView.layout(paddingLeft2, paddingTop2, this.gridWidth3 + paddingLeft2, this.gridHeight3 + paddingTop2);
                vm.b bVar2 = u;
                if (bVar2 != null) {
                    bVar2.a(getContext(), imageView, imageInfo != null ? imageInfo.bigImageUrl : null, this.gridWidth3, this.gridHeight3, imageInfo != null ? imageInfo.thumbnailUrl : null);
                }
            } else {
                int paddingLeft3 = ((this.gridWidth2 + this.gridSpacing) * f) + getPaddingLeft();
                int paddingTop3 = (this.gridSpacing * (i2 - 1)) + this.gridHeight1 + getPaddingTop();
                imageView.layout(paddingLeft3, paddingTop3, this.gridWidth2 + paddingLeft3, this.gridHeight2 + paddingTop3);
                vm.b bVar3 = u;
                if (bVar3 != null) {
                    bVar3.a(getContext(), imageView, imageInfo != null ? imageInfo.bigImageUrl : null, this.gridWidth2, this.gridHeight2, imageInfo != null ? imageInfo.thumbnailUrl : null);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        List list = this.mImageInfo;
        int i = 0;
        if (list != null && !list.isEmpty()) {
            switch (list.size()) {
                case 1:
                    b((ImageInfo) list.get(0), paddingLeft, 1);
                    break;
                case 2:
                    b(j((ImageInfo) list.get(0), (ImageInfo) list.get(1)), paddingLeft, 2);
                    break;
                case 3:
                    b(j((ImageInfo) list.get(0), (ImageInfo) list.get(1)), paddingLeft, 2);
                    c((ImageInfo) list.get(2), paddingLeft, 1);
                    break;
                case 4:
                    b(j((ImageInfo) list.get(0), (ImageInfo) list.get(1)), paddingLeft, 2);
                    c(j((ImageInfo) list.get(2), (ImageInfo) list.get(3)), paddingLeft, 2);
                    break;
                case 5:
                    b(j((ImageInfo) list.get(0), (ImageInfo) list.get(1)), paddingLeft, 2);
                    c((ImageInfo) list.get(2), paddingLeft, 1);
                    d(j((ImageInfo) list.get(3), (ImageInfo) list.get(4)), paddingLeft, 2);
                    break;
                case 6:
                    b(k((ImageInfo) list.get(0), (ImageInfo) list.get(1), (ImageInfo) list.get(2)), paddingLeft, 3);
                    c(k((ImageInfo) list.get(3), (ImageInfo) list.get(4), (ImageInfo) list.get(5)), paddingLeft, 3);
                    break;
                case 7:
                    b(k((ImageInfo) list.get(0), (ImageInfo) list.get(1), (ImageInfo) list.get(2)), paddingLeft, 3);
                    c((ImageInfo) list.get(3), paddingLeft, 1);
                    d(k((ImageInfo) list.get(4), (ImageInfo) list.get(5), (ImageInfo) list.get(6)), paddingLeft, 3);
                    break;
                case 8:
                    b(k((ImageInfo) list.get(0), (ImageInfo) list.get(1), (ImageInfo) list.get(2)), paddingLeft, 3);
                    c(j((ImageInfo) list.get(3), (ImageInfo) list.get(4)), paddingLeft, 2);
                    d(k((ImageInfo) list.get(5), (ImageInfo) list.get(6), (ImageInfo) list.get(7)), paddingLeft, 3);
                    break;
                case 9:
                    b(k((ImageInfo) list.get(0), (ImageInfo) list.get(1), (ImageInfo) list.get(2)), paddingLeft, 3);
                    c(k((ImageInfo) list.get(3), (ImageInfo) list.get(4), (ImageInfo) list.get(5)), paddingLeft, 3);
                    d(k((ImageInfo) list.get(6), (ImageInfo) list.get(7), (ImageInfo) list.get(8)), paddingLeft, 3);
                    break;
            }
            size = getPaddingRight() + paddingLeft + getPaddingLeft();
            i = this.gridHeight1 + this.gridHeight2 + this.gridHeight3 + (this.gridSpacing * (this.rowCount - 1)) + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(size, i);
    }

    public final void setAdapter(NineGridViewAdapter adapter) {
        Intrinsics.h(adapter, "adapter");
        this.mAdapter = adapter;
        List<ImageInfo> imageInfo = adapter.getImageInfo();
        if (imageInfo == null || imageInfo.isEmpty()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        int size = imageInfo.size();
        int i = this.maxImageSize;
        if (1 <= i && i < size) {
            imageInfo = imageInfo.subList(0, i);
            size = imageInfo.size();
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
        List list = this.mImageInfo;
        if (list == null) {
            while (r1 < size) {
                addView(g(r1), generateDefaultLayoutParams());
                r1++;
            }
        } else {
            r1 = list != null ? list.size() : 0;
            if (r1 > size) {
                removeViews(size, r1 - size);
            } else if (r1 < size) {
                while (r1 < size) {
                    addView(g(r1), generateDefaultLayoutParams());
                    r1++;
                }
            }
        }
        int size2 = adapter.getImageInfo().size();
        int i2 = this.maxImageSize;
        if (size2 > i2) {
            Object childAt = getChildAt(i2 - 1);
            if (childAt instanceof NineGridViewWrapper) {
                ((NineGridViewWrapper) childAt).setMoreNum(adapter.getImageInfo().size() - this.maxImageSize);
            }
        }
        this.mImageInfo = imageInfo;
        requestLayout();
    }

    public final void setGridSpacing(int spacing) {
        this.gridSpacing = spacing;
    }

    public final void setMaxSize(int maxSize) {
        this.maxImageSize = maxSize;
    }

    public final void setSingleImageRatio(float ratio) {
        this.singleImageRatio = ratio;
    }

    public final void setSingleImageSize(int maxImageSize) {
        this.singleImageSize = maxImageSize;
    }
}
