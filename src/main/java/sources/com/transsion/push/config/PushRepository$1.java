package com.transsion.push.config;

import com.transsion.push.ITopicListener;
import com.transsion.push.PushConstants;
import com.transsion.push.utils.PushLogUtils;
import java.util.HashSet;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class PushRepository$1 implements Runnable {
    final /* synthetic */ PushRepository this$0;
    final /* synthetic */ ITopicListener val$listener;
    final /* synthetic */ String val$topic;

    class a implements ITopicListener {
        final /* synthetic */ HashSet a;

        a(HashSet hashSet) {
            this.a = hashSet;
        }

        @Override // com.transsion.push.ITopicListener
        public void onFail(String str) {
            ITopicListener iTopicListener = PushRepository$1.this.val$listener;
            if (iTopicListener != null) {
                iTopicListener.onFail(str);
            }
        }

        @Override // com.transsion.push.ITopicListener
        public void onSuccess() {
            if (PushRepository$1.this.val$topic.contains(",")) {
                for (String str : PushRepository$1.this.val$topic.split(",")) {
                    this.a.add(str);
                }
            } else {
                this.a.add(PushRepository$1.this.val$topic);
            }
            PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_SUBSCRIBE_TOPICS, this.a);
            ITopicListener iTopicListener = PushRepository$1.this.val$listener;
            if (iTopicListener != null) {
                iTopicListener.onSuccess();
            }
        }
    }

    PushRepository$1(PushRepository pushRepository, String str, ITopicListener iTopicListener) {
        this.this$0 = pushRepository;
        this.val$topic = str;
        this.val$listener = iTopicListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        HashSet hashSet = (HashSet) this.this$0.getSpValue(PushConstants.SP_KEY_SUBSCRIBE_TOPICS, new HashSet());
        if (!hashSet.contains(this.val$topic)) {
            PushRepository.a(this.this$0).g(this.val$topic, PushConstants.TOPIC_SUBSCRIBE, new a(hashSet));
            return;
        }
        PushLogUtils.LOG.g("subscribe topic, " + this.val$topic + " has been subscribed");
        ITopicListener iTopicListener = this.val$listener;
        if (iTopicListener != null) {
            iTopicListener.onSuccess();
        }
    }
}
