package com.raghucheekatla.notebook.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

public class VaultPreferences {

    private static final String LOGGED_IN = "LOGGEDIN";
    private static final String HASH_STR = "HASH_STR";
    private static final String SYNCED = "SYNCED";
    private static final String HASH_SET = "HASH_SET";

    private static SharedPreferences getUserDetailsPreferences(@NonNull final Context context) {
        return context.getSharedPreferences("com.raghucheekatla.notebook.rVault", Context.MODE_PRIVATE);
    }
    public static boolean getIsLoggedInPref(@NonNull final Context context) {
        final SharedPreferences preferences = getUserDetailsPreferences(context);
        return preferences != null && preferences.getBoolean(LOGGED_IN, false);
    }

    public static void saveIsLoggedInPref(@NonNull final Context context, @NonNull final boolean isLoggedIn) {
        final SharedPreferences preferences = getUserDetailsPreferences(context);
        if (preferences != null) {
            final SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(LOGGED_IN, isLoggedIn);
            editor.apply();
        }
    }
    public static boolean getIsHashSet(@NonNull final Context context) {
        final SharedPreferences preferences = getUserDetailsPreferences(context);
        return preferences != null && preferences.getBoolean(HASH_SET, false);
    }

    public static void saveIsHashSet(@NonNull final Context context, @NonNull final boolean isHashSet) {
        final SharedPreferences preferences = getUserDetailsPreferences(context);
        if (preferences != null) {
            final SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(HASH_SET, isHashSet);
            editor.apply();
        }
    }

    public static String getLoginHashString(@NonNull final Context context) {
        final SharedPreferences preferences = getUserDetailsPreferences(context);
        if(preferences != null)
            return preferences.getString(HASH_STR, "none");
        else
            return "none";
    }

    public static void saveLoginHashString(@NonNull final Context context, @NonNull final String hashString) {
        final SharedPreferences preferences = getUserDetailsPreferences(context);
        if (preferences != null) {
            final SharedPreferences.Editor editor = preferences.edit();
            editor.putString(HASH_STR, hashString);
            editor.apply();
        }
    }


}
