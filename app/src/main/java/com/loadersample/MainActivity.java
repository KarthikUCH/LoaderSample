package com.loadersample;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int LOADER_IDENTIFIER = 0x01;

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private LoaderAdapter mLoaderAdapter;
    private ArrayList<String> mData = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();

    }


    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mLinearLayoutManager = new LinearLayoutManager(MainActivity.this);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mLoaderAdapter = new LoaderAdapter(mData);
        mRecyclerView.setAdapter(mLoaderAdapter);

    }

    private void initData() {
            getSupportLoaderManager().initLoader(LOADER_IDENTIFIER, null , loaderListner);
    }

    private LoaderManager.LoaderCallbacks<ArrayList<String>> loaderListner = new LoaderManager.LoaderCallbacks<ArrayList<String>>() {
        @Override
        public Loader<ArrayList<String>> onCreateLoader(int id, Bundle args) {
            return new StringLoader(getApplicationContext());
        }

        @Override
        public void onLoadFinished(Loader<ArrayList<String>> loader, ArrayList<String> data) {
            mLoaderAdapter.swapData(data);
        }

        @Override
        public void onLoaderReset(Loader<ArrayList<String>> loader) {

        }
    };
}
