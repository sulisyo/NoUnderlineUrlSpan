package com.ramodal.gembong.linkspan;

import android.os.Parcel;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.text.util.Linkify;

/**
 * Created by gembong on 11/18/15.
 */

public class LinkSpan extends URLSpan {
    public LinkSpan(String url) {
        super(url);
    }

    public LinkSpan(Parcel src) {
        super(src);
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(ds.linkColor);
    }

    public static SpannableStringBuilder setUrlLinkNoUnderline(SpannableStringBuilder s){

        Linkify.addLinks(s, Linkify.WEB_URLS);
        URLSpan[] inputs = s.getSpans(0, s.length(), URLSpan.class);
        for(URLSpan item : inputs){
            int start = s.getSpanStart(item);
            int end = s.getSpanEnd(item);
            s.removeSpan(item);
            LinkSpan linkSpan = new LinkSpan(item.getURL());
            s.setSpan(linkSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
        }
        return s;
    }
}
