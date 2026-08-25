package com.transsion.publish.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class MatchParentVideoView extends VideoView {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;

    public MatchParentVideoView(Context context) {
        this(context, null);
    }

    public MatchParentVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MatchParentVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
    }

    public int getVideoHeight() {
        return this.b;
    }

    public int getVideoWidth() {
        return this.a;
    }

    @Override // android.widget.VideoView
    public void setVideoPath(String str) {
        super.setVideoPath(str);
    }
}
