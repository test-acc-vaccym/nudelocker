package io.feuer.nudelocker.ui.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;

import io.feuer.jlib.ui.fragments.JFragment;
import io.feuer.nudelocker.R;
import io.feuer.nudelocker.bll.Browser;
import io.feuer.nudelocker.bll.BrowserItem;
import io.feuer.nudelocker.ui.adapters.BrowserAdapter;

/**
 * Das Hauptfragment. Beinhaltet den "Dateibrowser"
 * Created by jannik@feuer.io on 19.07.2017.
 */
public class BrowserFragment extends JFragment implements View.OnClickListener {

    /**
     * RecyclerView
     */
    private @Nullable RecyclerView rvBrowser;

    /**
     * LayoutManager für Liste
     */
    private @Nullable LinearLayoutManager lmLinear;

    /**
     * LayoutManager für Grid
     */
    private @Nullable GridLayoutManager lmGrid;

    /**
     * Adapter
     */
    private @Nullable BrowserAdapter adapter;

    /**
     * FAB-Menu
     */
    private @Nullable FloatingActionMenu famAdd;

    /**
     * Fab Neuer Ordner
     */
    private @Nullable FloatingActionButton fabCreateFolder;

    /**
     * Fab Import Bild
     */
    private @Nullable FloatingActionButton fabImportImage;

    /**
     * Liste der Elemente
     */
    private @Nullable List<BrowserItem> items;

    /**
     * Konstruktor
     */
    public BrowserFragment() {
        //
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.lay_fragment_browser, container, false);

        rvBrowser = (RecyclerView) view.findViewById(R.id.rvBrowser);
        famAdd = (FloatingActionMenu) view.findViewById(R.id.famAdd);
        fabCreateFolder = (FloatingActionButton) view.findViewById(R.id.fabCreateFolder);
        fabImportImage = (FloatingActionButton) view.findViewById(R.id.fabImportImage);


        lmLinear = new LinearLayoutManager(getContext());
        lmGrid = new GridLayoutManager(getContext(), GridLayoutManager.DEFAULT_SPAN_COUNT);
        adapter = new BrowserAdapter(); //TODO: Get the data!

        if(rvBrowser != null) {
            rvBrowser.setLayoutManager(lmLinear);
        }

        if(famAdd != null) {
            famAdd.setClosedOnTouchOutside(true);
        }

        if(fabImportImage != null && fabCreateFolder != null) {
            fabImportImage.setOnClickListener(this);
            fabCreateFolder.setOnClickListener(this);
        }

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(items == null) {
            items = new ArrayList<>(Browser.getDefaultItems(getContext()));
        }
    }

    @Override
    public void onClick(View view) {
        if(view != null) {
            if(view == fabCreateFolder) {
                final EditText edtName = new EditText(getContext());

                new AlertDialog.Builder(getContext())
                        .setTitle(R.string.create_folder)
                        .setMessage(R.string.create_folder)
                        .setView(edtName)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Browser.getInstance().createFolder(edtName.getText().toString());
                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .create()
                        .show();
            } else if(view == fabImportImage) {

            }
        }
    }
}
