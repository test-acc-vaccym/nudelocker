package io.feuer.nudelocker.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.feuer.jlib.ui.fragments.JFragment;
import io.feuer.nudelocker.R;

/**
 * Das Hauptfragment. Beinhaltet den "Dateibrowser"
 * Created by jannik@feuer.io on 19.07.2017.
 */
public class BrowserFragment extends JFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.lay_nav_header, container, false);

        return view;

    }
}
