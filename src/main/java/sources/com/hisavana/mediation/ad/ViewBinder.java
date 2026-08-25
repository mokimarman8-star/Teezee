package com.hisavana.mediation.ad;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class ViewBinder {
    public final List<Integer> actionIds;
    public View actionView;
    public final int adBadgeView;
    public final int adChoicesView;
    public final int adCloseView;
    public final int adDisclaimerView;
    public final int adStoreMarkView;
    public final int callToActionId;
    public final int descriptionId;
    public final int domainId;
    public final int downloadsId;
    public final int feedbackId;
    public Drawable iconDrawable;
    public final int iconId;
    public View layout;
    public final int layoutId;
    public final int likesId;
    public final int mediaId;
    public final int mode;
    public final int priceId;
    public final int ratingId;
    public final int sourceSizeId;
    public final int sponsoredId;
    public final int titleId;

    public static final class Builder {
        public int a;
        public View actionView;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public Drawable iconDrawable;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public int o;
        public List<Integer> p;
        public View q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;

        public Builder(int i) {
            this.a = i;
        }

        public Builder(@NonNull View view) {
            this.q = view;
        }

        @NonNull
        public final Builder actionIds(Integer... numArr) {
            this.p = Arrays.asList(numArr);
            return this;
        }

        public final Builder adBadgeView(int i) {
            this.m = i;
            return this;
        }

        @NonNull
        public final Builder adChoicesView(int i) {
            this.n = i;
            return this;
        }

        public final Builder adCloseView(int i) {
            this.o = i;
            return this;
        }

        public final Builder adDisclaimerView(int i) {
            this.l = i;
            return this;
        }

        @NonNull
        public final ViewBinder build() {
            return new ViewBinder(this);
        }

        @NonNull
        public final Builder callToActionId(int i) {
            this.d = i;
            return this;
        }

        public final Builder contextMode(int i) {
            this.r = i;
            return this;
        }

        @NonNull
        public final Builder descriptionId(int i) {
            this.f = i;
            return this;
        }

        public final Builder domainView(int i) {
            this.t = i;
            return this;
        }

        @NonNull
        public final Builder downloadsId(int i) {
            this.k = i;
            return this;
        }

        public final Builder feedbackView(int i) {
            this.u = i;
            return this;
        }

        public final Builder iconDrawable(Drawable drawable) {
            this.iconDrawable = drawable;
            return this;
        }

        @NonNull
        public final Builder iconId(int i) {
            this.c = i;
            return this;
        }

        @NonNull
        public final Builder likesId(int i) {
            this.i = i;
            return this;
        }

        @NonNull
        public final Builder mediaId(int i) {
            this.e = i;
            return this;
        }

        @NonNull
        public final Builder priceId(int i) {
            this.j = i;
            return this;
        }

        @NonNull
        public final Builder ratingId(int i) {
            this.h = i;
            return this;
        }

        public Builder setActionView(View view) {
            this.actionView = view;
            return this;
        }

        @NonNull
        public final Builder sourceSizeId(int i) {
            this.v = i;
            return this;
        }

        @NonNull
        public final Builder sponsoredId(int i) {
            this.g = i;
            return this;
        }

        public final Builder storeMarkView(int i) {
            this.s = i;
            return this;
        }

        @NonNull
        public final Builder titleId(int i) {
            this.b = i;
            return this;
        }
    }

    public ViewBinder(@NonNull Builder builder) {
        this.layoutId = builder.a;
        this.layout = builder.q;
        this.titleId = builder.b;
        this.callToActionId = builder.d;
        this.iconId = builder.c;
        this.mediaId = builder.e;
        this.descriptionId = builder.f;
        this.sponsoredId = builder.g;
        this.ratingId = builder.h;
        this.likesId = builder.i;
        this.priceId = builder.j;
        this.downloadsId = builder.k;
        this.actionIds = builder.p;
        this.mode = builder.r;
        this.adDisclaimerView = builder.l;
        this.adBadgeView = builder.m;
        this.adChoicesView = builder.n;
        this.adCloseView = builder.o;
        this.adStoreMarkView = builder.s;
        this.domainId = builder.t;
        this.feedbackId = builder.u;
        this.iconDrawable = builder.iconDrawable;
        this.actionView = builder.actionView;
        this.sourceSizeId = builder.v;
    }
}
