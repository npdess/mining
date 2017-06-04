package jp.gr.java_conf.ange.commons.widget.extension;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.TextView;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 */
public class TextViewExtensions {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd, E, HH:mm:ss", Locale.getDefault());
    private static final String[] DATE_FORMATS = {
            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    };

    @BindingAdapter("localTime")
    public static void localTime(TextView textView, String time) {
        Log.d("localTime", time);
        try {
            Date date = DateUtils.parseDate(time, DATE_FORMATS);

            // TODO マストドンのState時刻が9時間前になっている。原因は？
            date.setTime(date.getTime() + (1000 * 60 * 60 * 9));

            String formatTime = sdf.format(date);
            textView.setText(formatTime);
        } catch (ParseException e) {
            e.printStackTrace();
            textView.setText(time);
        }
    }
}
