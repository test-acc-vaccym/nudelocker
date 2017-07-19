package io.feuer.jlib.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import io.feuer.jlib.R;
import io.feuer.jlib.util.log.JLog;

/**
 * Diese Klasse behandelt alle Navigationsdrawer Eigenschaften
 * Created by jannik@feuer.io on 19.07.2017.
 */
@SuppressWarnings({"unused", "FieldCanBeLocal"})
public abstract class JNavigationDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //region Fields
    /**
     * Toolbar
     */
    private
    @Nullable
    Toolbar tbMain;

    /**
     * Import FAB
     */
    private
    @Nullable
    FloatingActionButton fab;

    /**
     * Main Layout
     */
    private
    @Nullable
    DrawerLayout dlMain;

    /**
     * DrawerToggle
     */
    private
    @Nullable
    ActionBarDrawerToggle abToggle;

    /**
     * Der Drawer
     */
    private
    @Nullable
    NavigationView nvDrawer;
    //endregion

    //region Lifecycle
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_act_navigation_drawer);
        tbMain = (Toolbar) findViewById(R.id.tbMain);
        nvDrawer = (NavigationView) findViewById(R.id.nvDrawer);
        dlMain = (DrawerLayout) findViewById(R.id.dlMain);
        fab = (FloatingActionButton) findViewById(R.id.fabImport);

        if(tbMain != null && nvDrawer != null && dlMain != null && fab != null) {
            setSupportActionBar(tbMain);
            abToggle = new ActionBarDrawerToggle(this, dlMain, tbMain, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            dlMain.addDrawerListener(abToggle);
            abToggle.syncState();
            nvDrawer.inflateHeaderView(getNavigationDrawerHeaderView());
            nvDrawer.inflateMenu(getNavigationDrawerMenu());
            nvDrawer.setNavigationItemSelectedListener(this);

            onJCreate(savedInstanceState, persistentState);
        } else {
            JLog.wtf(this, "Something went horribly wrong...");
        }
    }

    @Override
    public void onBackPressed() {
        if (dlMain != null) {
            if (dlMain.isDrawerOpen(GravityCompat.START)) {
                dlMain.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        final boolean result = onJNavigationItemSelected(item);
        item.setChecked(true);
        setTitle(item.getTitle());
        if (dlMain != null) {
            dlMain.closeDrawer(GravityCompat.START);
        }
        return result;
    }
    //endregion

    //region Hilfsmethoden
    /**
     * Gibt den FAB zurueck.
     * @return FloatingActionButton oder null
     */
    protected final
    @Nullable
    FloatingActionButton getFloatingActionButton() {
        return fab;
    }

    /**
     * Gibt das Content-FrameLayout zurueck.
     * @return Id-Resource
     */
    @IdRes
    protected int getContentPlaceholderId() {
        return R.id.flContent;
    }

    /**
     * Setzt ein Fragment in das Content-FrameLayout
     * @param fragment Fragment
     */
    protected final void setFragment(final @Nullable Fragment fragment) {
        if(fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(getContentPlaceholderId(), fragment).commit();
        }
    }

    /**
     * Wird im onCreate-Ereigniss nach der Initialisierung des Drawers ausgeführt.
     * Kann für weitere Initialisierungen überschireben werden.
     * @param savedInstanceState savedInstanceState
     * @param persistentState persistentState
     */
    @SuppressWarnings("UnusedParameters")
    public void onJCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        //nothing to do...
    }
    //endregion

    //region Abstrakte Methoden
    /**
     * Ein Navigations-Drawer-Item wurde ausgewählt.
     * @param item Menuitem
     * @return true to display the item as the selected item
     */
    protected abstract boolean onJNavigationItemSelected(MenuItem item);

    /**
     * Gibt das Menu für den Drawer wieder.
     *
     * @return Menu-Resource
     */
    protected abstract
    @MenuRes
    int getNavigationDrawerMenu();

    /**
     * Gibt die Header-Resource für den Drawer wieder.
     *
     * @return Layout-Integer
     */
    protected abstract
    @LayoutRes
    int getNavigationDrawerHeaderView();
    //endregion

}
