package com.shellcore.android.asynctaskloader;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shellcore.android.asynctaskloader.adapters.NamesAdapter;
import com.shellcore.android.asynctaskloader.tasks.NamesAsyncTaskLoader;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList> {

    private NamesAdapter adapter;

    private ArrayList<String> namesList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namesList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.rec_names);
        adapter = new NamesAdapter(this, namesList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<ArrayList> onCreateLoader(int id, Bundle args) {
        Loader loader = new NamesAsyncTaskLoader(this);
        return loader;
    }

    @Override
    public void onLoadFinished(Loader<ArrayList> loader, ArrayList data) {
        namesList.clear();
        namesList.addAll(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onLoaderReset(Loader<ArrayList> loader) {
        namesList.clear();
    }
}
