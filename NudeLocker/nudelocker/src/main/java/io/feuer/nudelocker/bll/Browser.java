package io.feuer.nudelocker.bll;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.feuer.nudelocker.dal.AppConstants.FOLDER_DEFAULT;

/**
 * Manger-Singleton
 * Created by jannik@feuer.io on 28.07.2017.
 */
public final class Browser {

    /**
     * Singleton
     */
    private static Browser INSTANCE;

    /**
     * Singleton getter
     * @return Browser Instanz
     */
    public final static @NonNull Browser getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Browser();
        }
        return INSTANCE;
    }

    /**
     * Konstruktor
     */
    private Browser() {
        //
    }

    /**
     * Gibt die Liste der Elemente des Default Ordners wieder
     * @param context Cntext
     * @param path relativer Pfad ab dem default Ordner. Beispiel "/urlaub/italien/
     * @return Liste der Elemente
     */
    private final static @NonNull List<BrowserItem> getItems(final @Nullable Context context, final String path) {
        final List<BrowserItem> result = new ArrayList<>();
        return result;
    }


    /**
     * Gibt die Liste der Elemente des Default Ordners wieder
     * @param context Cntext
     * @return Liste der Elemente
     */
    public static final @NonNull List<BrowserItem> getDefaultItems(final @Nullable Context context) {
        final List<BrowserItem> result = new ArrayList<>();
        if(context != null) {
            final File appFolder = context.getFilesDir();
            if(appFolder != null) {
                final File defaultFolder = new File(appFolder.getPath() + File.separator + FOLDER_DEFAULT);
                boolean success = true;
                if(!defaultFolder.exists()) {
                    success = defaultFolder.mkdirs();
                }
                if(success) {
                    final File[] relevantFiles = defaultFolder.listFiles();
                    if(relevantFiles != null) {
                        for(final File file : relevantFiles) {
                            final BrowserItem item = new BrowserItem();
                            item.setFolder(file.isDirectory());
                            item.setTitle(file.getName());
                            result.add(item);
                        }
                    }
                }
            }
        }
        return result;
    }


    /**
     * Erstellt einen neuen Ordner
     * @param name Name des neuen Ordners
     */
    public void createFolder(final @Nullable String name) {
        //TODO:
    }
}
