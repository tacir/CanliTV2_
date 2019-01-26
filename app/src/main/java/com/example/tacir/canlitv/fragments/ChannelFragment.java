package com.example.tacir.canlitv.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tacir.canlitv.JsonParser;
import com.example.tacir.canlitv.R;
import com.example.tacir.canlitv.adapter.ChannelAdapter;
import com.example.tacir.canlitv.model.Channel;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.List;

import cz.msebera.android.httpclient.Header;

public class ChannelFragment extends Fragment {
    private RecyclerView recyclerView;
    private EditText searchEditText;
    private ImageButton searchButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_channel, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_channel);
        searchButton= view.findViewById(R.id.image_icon);
        searchEditText= view.findViewById(R.id.edit_Text);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search();
            }
        });

    }

    private void search() {

        String text = searchEditText.getText().toString();
        makeSearch(text);
        if (!text.isEmpty()) {

        }
    }

    private void makeSearch(String text) {
        String url = "http://app-service.cloud/music/youtube2.php?query=" +
                text + "&source=youtube";
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get(url, new AsyncHttpResponseHandler() {
            public void onStart() {
                recyclerView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                String response = new String(responseBody);
                JsonParser parser = new JsonParser();
                List<Channel> items = parser.extract(response);
                setupRecycler(items);


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }

            @Override
            public void onFinish() {
                recyclerView.setVisibility(View.VISIBLE);
            }
        });


    }


    private void setupRecycler(List<Channel> items) {
        ChannelAdapter adapter = new ChannelAdapter(items, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }}