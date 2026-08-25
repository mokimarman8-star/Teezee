package com.blankj.utilcode.util;

import com.blankj.utilcode.util.z;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class ShellUtils$1 extends Utils$Task<z.a> {
    final /* synthetic */ String[] val$commands;
    final /* synthetic */ boolean val$isNeedResultMsg;
    final /* synthetic */ boolean val$isRooted;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShellUtils$1(Utils$b utils$b, String[] strArr, boolean z, boolean z2) {
        super(utils$b);
        this.val$commands = strArr;
        this.val$isRooted = z;
        this.val$isNeedResultMsg = z2;
    }

    @Override // com.blankj.utilcode.util.ThreadUtils$Task
    public z.a doInBackground() {
        return z.b(this.val$commands, this.val$isRooted, this.val$isNeedResultMsg);
    }
}
