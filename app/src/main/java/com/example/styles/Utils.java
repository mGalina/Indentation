package com.example.styles;

import android.app.Activity;
import android.content.Intent;

class Utils {
    private static int sTheme;

    private final static int THEME_DEFAULT = 0;
    final static int THEME_MAJOR = 1;
    final static int THEME_MIDDLE = 2;
    final static int THEME_MINOR = 3;

    static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    static void onActivityCreateSetTheme(Activity activity) {
        switch (sTheme) {
            default:
            case THEME_DEFAULT:
                activity.setTheme(R.style.AppTheme);
                break;
            case THEME_MAJOR:
                activity.setTheme(R.style.Major);
                break;
            case THEME_MIDDLE:
                activity.setTheme(R.style.Middle);
                break;
            case THEME_MINOR:
                activity.setTheme(R.style.Minor);
                break;
        }
    }
}
