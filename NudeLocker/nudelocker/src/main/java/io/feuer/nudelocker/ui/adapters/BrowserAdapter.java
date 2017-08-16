package io.feuer.nudelocker.ui.adapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.feuer.nudelocker.R;
import io.feuer.nudelocker.bll.BrowserItem;

/**
 * RecyclerView Adapter für den Browser
 * Created by jannik@feuer.io on 23.07.2017.
 */
public class BrowserAdapter extends RecyclerView.Adapter<BrowserAdapter.ItemHolder> {

    /**
     * Liste der Browser-Elemente
     */
    private @Nullable List<BrowserItem> items;

    /**
     * Konstruktor
     */
    public BrowserAdapter() {
        //
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_browser_item, parent, false);
        return new ItemHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        if(items != null) {
            holder.bindItem(items.get(position));
        }
    }

    @Override
    public int getItemCount() {
        if(items != null) {
            return items.size();
        }
        return 0;
    }

    /**
     * {@link android.support.v7.widget.RecyclerView.ViewHolder}
     */
    static class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        /**
         * Vorschau- oder Ordner- Bild
         */
        private
        @Nullable
        ImageView ivPreview;

        /**
         * Titel
         */
        private
        @Nullable
        TextView tvTitle;

        /**
         * Das abzubildende Objekt
         */
        private BrowserItem item;

        /**
         * Konstruktor
         *
         * @param v View
         */
        ItemHolder(View v) {
            super(v);
            ivPreview = (ImageView) v.findViewById(R.id.ivPreview);
            tvTitle = (TextView) v.findViewById(R.id.tvTitle);
            v.setOnClickListener(this);
        }

        /**
         * Setzt die Oberfläche anhand eines Elements.
         *
         * @param item Element
         */
        void bindItem(final @NonNull BrowserItem item) {
            this.item = item;
            if(ivPreview != null && tvTitle != null) {
                if(item.isFolder()) {
//                    ivPreview.setImageResource(R.drawable.folder);TODO: Folder drawable importieren.
                    tvTitle.setText(item.getTitle());
                }
            }
        }

        @Override
        public void onClick(View view) {
            if(view != null && item != null) {
                if(item.isFolder()) {

                } else {

                }
            }
        }
    }

}
