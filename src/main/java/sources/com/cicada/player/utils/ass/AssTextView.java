package com.cicada.player.utils.ass;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class AssTextView extends TextView {
    private String mContent;
    private Long mId;

    public AssTextView(Context context) {
        super(context);
        this.mContent = null;
        this.mId = null;
    }

    public AssTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContent = null;
        this.mId = null;
    }

    public AssTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContent = null;
        this.mId = null;
    }

    public String getContent() {
        return this.mContent;
    }

    public Long getSubtitleId() {
        return this.mId;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void setSubtitleId(Long l) {
        this.mId = l;
    }
}
