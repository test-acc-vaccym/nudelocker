package io.feuer.nudelocker.bll;

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
}
