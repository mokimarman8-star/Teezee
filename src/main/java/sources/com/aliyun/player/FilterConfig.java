package com.aliyun.player;

import com.cloud.tmc.integration.event.EventConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class FilterConfig {
    private JSONArray filters = new JSONArray();

    public static class Filter {
        JSONObject filter;

        public Filter(String str) {
            JSONObject jSONObject = new JSONObject();
            this.filter = jSONObject;
            try {
                jSONObject.put(EventConstants.KEY_TARGET, str);
            } catch (JSONException unused) {
            }
        }

        JSONObject getFilter() {
            return this.filter;
        }

        public void setOptions(FilterOptions filterOptions) {
            if (filterOptions == null || filterOptions.getOptions().length() <= 0) {
                return;
            }
            try {
                this.filter.put("options", filterOptions.getOptions());
            } catch (JSONException unused) {
            }
        }
    }

    public static class FilterOptions {
        JSONObject options = new JSONObject();

        JSONObject getOptions() {
            return this.options;
        }

        public void setOption(String str, Object obj) {
            try {
                this.options.put(str, obj);
            } catch (JSONException unused) {
            }
        }

        public String toString() {
            return this.options.toString();
        }
    }

    public void addFilter(Filter filter) {
        if (filter == null || filter.getFilter() == null) {
            return;
        }
        this.filters.put(filter.getFilter());
    }

    public String toString() {
        return this.filters.toString();
    }
}
