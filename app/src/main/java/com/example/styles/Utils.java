package com.example.styles;

import android.app.Activity;
import android.content.Intent;

class Utils {
    private static int sTheme;

    private final static int THEME_DEFAULT = 0;
    final static int THEME_BLACK = 1;
    final static int THEME_BLUE = 2;
    final static int THEME_GREEN = 3;

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
            case THEME_BLACK:
                activity.setTheme(R.style.AppThemeBlack);
                break;
            case THEME_BLUE:
                activity.setTheme(R.style.AppThemeBlue);
                break;
            case THEME_GREEN:
                activity.setTheme(R.style.AppThemeGreen);
                break;
        }
    }
}
