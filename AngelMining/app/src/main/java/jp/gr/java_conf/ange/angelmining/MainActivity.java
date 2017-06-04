package jp.gr.java_conf.ange.angelmining;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;

import javax.inject.Inject;

import jp.gr.java_conf.ange.angelmining.databinding.ContentMainBinding;
import jp.gr.java_conf.ange.angelmining.di.AngelminingApplication;
import jp.gr.java_conf.ange.angelmining.httpclient.MastodonAPIClient;
import jp.gr.java_conf.ange.angelmining.model.MastodonPreferences;
import jp.gr.java_conf.ange.commons.widget.DataBindingListAdapter;
import jp.gr.java_conf.ange.mastodon.model.Status;
import okhttp3.ResponseBody;

/**
 * Mastodon Streaming API Demo.
 */
public class MainActivity extends AppCompatActivity
        implements MastodonAPIClient.StreamingServiceListener{

    private ListView listView;
    private LinkedList<Status> list;
    private DataBindingListAdapter<Status> listAdapter;

    private SwipeRefreshLayout swipreRefresh;

    private FloatingActionButton startStreamingButton;
    private FloatingActionButton stopStreamingButton;
    private FloatingActionButton clearStreamingButton;

    private volatile boolean streamingFlag = false;

    @Inject
    MastodonPreferences currentMastodonPreferences;

    @Inject
    MastodonAPIClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AngelminingApplication.getComponent(this).inject(this);

        ContentMainBinding binding = ContentMainBinding.bind(findViewById(R.id.content_main));
        listAdapter = new DataBindingListAdapter<Status>(this, R.layout.row_mastodon_timeline, BR.status);
        list = new LinkedList<Status>();
        listView = binding.listview;
        listView.setEmptyView(findViewById(R.id.emptyview));
        listView.setAdapter(listAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        swipreRefresh = binding.sr;
        swipreRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (!streamingFlag) {
                    Snackbar.make(listView, "タイムラインのストリーミングを開始中...", Snackbar.LENGTH_LONG).show();
                    streamingFlag = true;
                    client.streamingPublicTimeline(MainActivity.this);
                } else {
                    Snackbar.make(listView, "すでにストリーミング中です.", Snackbar.LENGTH_SHORT).show();
                    swipreRefresh.setRefreshing(false);
                }
            }
        });

        startStreamingButton = (FloatingActionButton) findViewById(R.id.startStreamingButton);
        startStreamingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DEBUG","START");
                if (streamingFlag) {
                    return;
                }
                streamingFlag = true;
                client.streamingPublicTimeline(MainActivity.this);
            }
        });
        stopStreamingButton = (FloatingActionButton) findViewById(R.id.stopStreamingButton);
        stopStreamingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                streamingFlag = false;
            }
        });
        clearStreamingButton = (FloatingActionButton) findViewById(R.id.clearStreamingButton);
        clearStreamingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.clear();
                listAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "タイムラインをクリアしました.", Toast.LENGTH_SHORT).show();
            }
        });

        // TODO FIXする
        client.setBaseUrl(currentMastodonPreferences.getBaseUrl());
        client.setApiToken(currentMastodonPreferences.getToken());
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        if (intent != null && Intent.ACTION_VIEW.equals(intent.getAction())) {
            Uri uri = intent.getData();
            if (uri != null) {
                Log.d("onResume", uri.toString());
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (streamingFlag) {
            streamingFlag = false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override
    public void onStreamingStart(ResponseBody responseBody) {
        Log.d("Streaming", "onStreamingStart");
        startStreamingButton.setVisibility(View.GONE);
        stopStreamingButton.setVisibility(View.VISIBLE);
        streamingFlag = true;
        if (swipreRefresh.isRefreshing()) {
            swipreRefresh.setRefreshing(false);
        }
        Snackbar.make(listView, "ストリーミングが開始されました.", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onStreamingEnd(ResponseBody responseBody) {
        Log.d("Streaming", "onStreamingEnd");
        stopStreamingButton.setVisibility(View.GONE);
        startStreamingButton.setVisibility(View.VISIBLE);
        streamingFlag = false;
        if (swipreRefresh.isRefreshing()) {
            swipreRefresh.setRefreshing(false);
        }
        Snackbar.make(listView, "ストリームを停止しました.", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onReceive(String event, Status status) {
        if ((!"update".equals(event)) || status == null) {
            return;
        }
        list.add(0, status);
        int size = list.size();
        int oversize = (size) - 100;
        if (oversize > 0) {
            list.subList(size - oversize, size).clear();
        }
        int pos = listView.getFirstVisiblePosition();
        View v = listView.getChildAt(0);
        int y = v != null ? v.getTop() : 0;
        listAdapter.setDataList(list);
        listAdapter.notifyDataSetChanged();
        listView.setSelectionFromTop(pos, y);
    }

    @Override
    public boolean isKeepStreaming(ResponseBody responseBody) {
        return streamingFlag;
    }
}
