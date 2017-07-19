package io.feuer.jlib.util.log;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Behandelt Logging
 * Created by jannik@feuer.io on 19.07.2017.
 */
@SuppressWarnings("unused")
public abstract class JLog {

    /**
     * Erweiterter Debug Log
     * @param tag Als Tag wird der Name der Klasse des tag-Objekts genutzt
     * @param message Die eigentliche Nachricht
     */
    public static void d(final @NonNull Object tag, final @Nullable String message) {
        Log.d(getTag(tag), message);
    }

    /**
     * Erweiterter Error Log
     * @param tag Als Tag wird der Name der Klasse des tag-Objekts genutzt
     * @param message Die eigentliche Nachricht
     */
    public static void e(final @NonNull Object tag, final @Nullable String message) {
        Log.e(getTag(tag), message);
    }

    /**
     * Erweiterter Error Log
     * @param tag Als Tag wird der Name der Klasse des tag-Objekts genutzt
     * @param message Die eigentliche Nachricht
     */
    public static void e(final @NonNull Object tag, final @Nullable Exception message) {
        Log.e(getTag(tag), null, message);
    }

    /**
     * Erweiterter Info Log
     * @param tag Als Tag wird der Name der Klasse des tag-Objekts genutzt
     * @param message Die eigentliche Nachricht
     */
    public static void i(final @NonNull Object tag, final @Nullable String message) {
        Log.i(getTag(tag), message);
    }

    /**
     * Erweiterter WTF Log
     * @param tag Als Tag wird der Name der Klasse des tag-Objekts genutzt
     * @param message Die eigentliche Nachricht
     */
    public static void wtf(final @NonNull Object tag, final @Nullable String message) {
        Log.wtf(getTag(tag), message);
    }

    /**
     * Erweiterter Verbose Log
     * @param tag Als Tag wird der Name der Klasse des tag-Objekts genutzt
     * @param message Die eigentliche Nachricht
     */
    public static void v(final @NonNull Object tag, final @Nullable String message) {
        Log.v(getTag(tag), message);
    }

    /**
     * Erweiterter Warning Log
     * @param tag Als Tag wird der Name der Klasse des tag-Objekts genutzt
     * @param message Die eigentliche Nachricht
     */
    public static void w(final @NonNull Object tag, final @Nullable String message) {
        Log.w(getTag(tag), message);
    }

    /**
     * Macht aus dem Tag-Object einen String
     * @param object das Tag Objekt
     * @return String
     */
    private static @NonNull String getTag(final @NonNull Object object) {
        return object.getClass().getSimpleName();
    }

}
