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
