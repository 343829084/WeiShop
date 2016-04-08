package com.evada.lygshop.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * author： bwl on 2015-01-06.
 * email: bxl049@163.com
 */
public class ActivityCollector {

    public static List<Activity> activities = new ArrayList<>();

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void finishAll() {
        if (activities.isEmpty()) {
            return;
        }
        for (Activity act : activities) {
            if (!act.isFinishing()) {
                act.finish();
            }
        }
    }
}
