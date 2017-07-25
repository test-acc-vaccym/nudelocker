package io.feuer.nudelocker.bll;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.feuer.nudelocker.dal.AppConstants.FOLDER_DEFAULT;

/**
 * Model eines BrowserElements
 * Created by jannik@feuer.io on 23.07.2017.
 */
public final class BrowserItem {

    /**
     * True falls Element ein Ordner ist.
     */
    private boolean isFolder;

    /**
     * Titel des Elements
     */
    private String title;

    /**
     * Gibt die Liste der Elemente des Default Ordners wieder
     *
     * @param context Cntext
     * @return Liste der Elemente
     */
    public static final
    @NonNull
    List<BrowserItem> getDefaultItems(final @Nullable Context context) {
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

    public boolean isFolder() {
        return isFolder;
    }

    public String getTitle() {
        return title;
    }

    public void setFolder(boolean folder) {
        isFolder = folder;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
