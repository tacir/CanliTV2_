package com.example.tacir.canlitv.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tacir.canlitv.R;
import com.example.tacir.canlitv.fragments.ChannelFragment;
import com.example.tacir.canlitv.model.Channel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.ChannelView> {
    private List<Channel> items;
    private ChannelFragment context;


    public ChannelAdapter(List<Channel> items, ChannelFragment context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ChannelAdapter.ChannelView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context.getContext());
        View view = inflater.inflate(R.layout.item_channel, viewGroup, false);
        return new ChannelView(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ChannelAdapter.ChannelView channelView, int i) {
        Channel item = items.get(i);
        channelView.description.setText(item.getDescription());
        channelView.title.setText(item.getTitle());
        channelView.channelTitle.setText(item.getChannelTitle());
        if (item.getThumbnail() != null && !item.getTitle().isEmpty()) ;
        Picasso.get().load(item.getThumbnail()).into(channelView.icon);
    }

    @Override
    public int getItemCount() {
        if (items == null)
            return 0;
        return items.size();
    }

    public class ChannelView extends RecyclerView.ViewHolder {
        private TextView description, title, channelTitle;
        private ImageView icon;

        public ChannelView(@NonNull View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.textview_description);
            title = itemView.findViewById(R.id.textview_title);
            channelTitle = itemView.findViewById(R.id.textview_channel_title);
            icon = itemView.findViewById(R.id.imageview_icon);
        }
    }
}
