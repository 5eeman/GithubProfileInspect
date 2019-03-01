package com.morya.gpi.presentation.utils;

import com.squareup.picasso.Picasso;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class BindingUtils {

    @BindingAdapter({"data"})
    public static <T> void setRecyclerViewProperties(RecyclerView recyclerView, T data) {
        if (recyclerView.getAdapter() instanceof BindableAdapter<?>) {
            ((BindableAdapter<T>) recyclerView.getAdapter()).setData(data);
        }
    }

    @BindingAdapter({"url"})
    public static void setImageViewUrl(AppCompatImageView imageView, String url) {
        Picasso.get().load(url).into(imageView);
    }
}
