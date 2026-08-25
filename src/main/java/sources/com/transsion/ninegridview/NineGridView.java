package com.transsion.ninegridview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.blankj.utilcode.util.a0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class NineGridView extends ViewGroup {
    public static final int MODE_FILL = 0;
    public static final int MODE_GRID = 1;
    private static vm.b m;
    private int a;
    private float b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private List j;
    private List k;
    private NineGridViewAdapter l;

    class a implements View.OnClickListener {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NineGridViewAdapter nineGridViewAdapter = NineGridView.this.l;
            Context context = NineGridView.this.getContext();
            NineGridView nineGridView = NineGridView.this;
            nineGridViewAdapter.onImageItemClick(context, nineGridView, this.a, nineGridView.l.getImageInfo());
        }
    }

    public NineGridView(Context context) {
        this(context, null);
    }

    public NineGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NineGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 250;
        this.b = 1.0f;
        this.c = 9;
        this.d = 3;
        this.e = 0;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.d = (int) TypedValue.applyDimension(1, this.d, displayMetrics);
        this.a = (int) TypedValue.applyDimension(1, this.a, displayMetrics);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.NineGridView);
        this.d = (int) obtainStyledAttributes.getDimension(R$styleable.NineGridView_ngv_gridSpacing, this.d);
        this.a = obtainStyledAttributes.getDimensionPixelSize(R$styleable.NineGridView_ngv_singleImageSize, this.a);
        this.b = obtainStyledAttributes.getFloat(R$styleable.NineGridView_ngv_singleImageRatio, this.b);
        this.c = obtainStyledAttributes.getInt(R$styleable.NineGridView_ngv_maxSize, this.c);
        this.e = obtainStyledAttributes.getInt(R$styleable.NineGridView_ngv_mode, this.e);
        obtainStyledAttributes.recycle();
        this.j = new ArrayList();
    }

    private ImageView b(int i) {
        if (i < this.j.size()) {
            return (ImageView) this.j.get(i);
        }
        ImageView generateImageView = this.l.generateImageView(getContext());
        generateImageView.setOnClickListener(new a(i));
        this.j.add(generateImageView);
        return generateImageView;
    }

    public static vm.b getImageLoader() {
        return m;
    }

    public static void setImageLoader(vm.b bVar) {
        m = bVar;
    }

    public int getMaxSize() {
        return this.c;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        List list = this.k;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            ImageView imageView = (ImageView) getChildAt(i5);
            int i6 = this.f;
            int paddingLeft = ((this.h + this.d) * (i5 % i6)) + getPaddingLeft();
            int paddingTop = ((this.i + this.d) * (i5 / i6)) + getPaddingTop();
            imageView.layout(paddingLeft, paddingTop, this.h + paddingLeft, this.i + paddingTop);
            vm.b bVar = m;
            if (bVar != null) {
                bVar.a(getContext(), imageView, ((ImageInfo) this.k.get(i5)).bigImageUrl, this.h, this.i, ((ImageInfo) this.k.get(i5)).thumbnailUrl);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        List list = this.k;
        int i3 = 0;
        if (list != null && list.size() > 0) {
            if (this.k.size() == 1) {
                ImageInfo imageInfo = (ImageInfo) this.k.get(0);
                float f = imageInfo.imageViewWidth;
                if (f > 0.0f) {
                    float f2 = imageInfo.imageViewHeight;
                    if (f2 > 0.0f) {
                        if (f > f2) {
                            int min = Math.min(a0.a(216.0f), (int) imageInfo.imageViewWidth);
                            this.h = min;
                            this.i = (min * ((int) imageInfo.imageViewHeight)) / ((int) imageInfo.imageViewWidth);
                        } else {
                            int min2 = Math.min(a0.a(216.0f), (int) imageInfo.imageViewHeight);
                            this.i = min2;
                            this.h = (min2 * ((int) imageInfo.imageViewWidth)) / ((int) imageInfo.imageViewHeight);
                        }
                    }
                }
                int min3 = Math.min(this.a, paddingLeft);
                this.h = min3;
                int i4 = (int) (min3 / this.b);
                this.i = i4;
                int i5 = this.a;
                if (i4 > i5) {
                    this.h = (int) (min3 * ((i5 * 1.0f) / i4));
                    this.i = i5;
                }
            } else {
                int i6 = (paddingLeft - (this.d * 2)) / 3;
                this.i = i6;
                this.h = i6;
            }
            int i7 = this.h;
            int i8 = this.f;
            size = (i7 * i8) + (this.d * (i8 - 1)) + getPaddingLeft() + getPaddingRight();
            int i9 = this.i;
            int i10 = this.g;
            i3 = (i9 * i10) + (this.d * (i10 - 1)) + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(size, i3);
    }

    public void setAdapter(@NonNull NineGridViewAdapter nineGridViewAdapter) {
        this.l = nineGridViewAdapter;
        List<ImageInfo> imageInfo = nineGridViewAdapter.getImageInfo();
        if (imageInfo == null || imageInfo.isEmpty()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        int size = imageInfo.size();
        int i = this.c;
        if (i > 0 && size > i) {
            imageInfo = imageInfo.subList(0, i);
            size = imageInfo.size();
        }
        this.g = (size / 3) + (size % 3 == 0 ? 0 : 1);
        this.f = 3;
        if (this.e == 1 && size == 4) {
            this.g = 2;
            this.f = 2;
        }
        List list = this.k;
        if (list == null) {
            for (int i2 = 0; i2 < size; i2++) {
                ImageView b = b(i2);
                if (b == null) {
                    return;
                }
                addView(b, generateDefaultLayoutParams());
            }
        } else {
            int size2 = list.size();
            if (size2 > size) {
                removeViews(size, size2 - size);
            } else if (size2 < size) {
                while (size2 < size) {
                    ImageView b2 = b(size2);
                    if (b2 == null) {
                        return;
                    }
                    addView(b2, generateDefaultLayoutParams());
                    size2++;
                }
            }
        }
        int size3 = nineGridViewAdapter.getImageInfo().size();
        int i3 = this.c;
        if (size3 > i3) {
            Object childAt = getChildAt(i3 - 1);
            if (childAt instanceof NineGridViewWrapper) {
                ((NineGridViewWrapper) childAt).setMoreNum(nineGridViewAdapter.getImageInfo().size() - this.c);
            }
        }
        this.k = imageInfo;
        requestLayout();
    }

    public void setGridSpacing(int i) {
        this.d = i;
    }

    public void setMaxSize(int i) {
        this.c = i;
    }

    public void setSingleImageRatio(float f) {
        this.b = f;
    }

    public void setSingleImageSize(int i) {
        this.a = i;
    }
}
