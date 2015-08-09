package com.parse.starter;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.dropbox.chooser.android.DbxChooser;
import com.dropbox.chooser.android.DbxChooser;

import java.util.Map;


public class DropboxActivity extends Activity {
    static final int DBX_CHOOSER_REQUEST = 0;  // You can change this if needed
    String APP_KEY = "hi93b42bzgw5qs5";
    private Button mChooserButton;
    private DbxChooser mChooser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dropbox);
        mChooser = new DbxChooser(APP_KEY);

        mChooserButton = (Button) findViewById(R.id.chooser_button);
        mChooserButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mChooser.forResultType(DbxChooser.ResultType.PREVIEW_LINK)
                        .launch(DropboxActivity.this, DBX_CHOOSER_REQUEST);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dropbox, menu);
        return true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == DBX_CHOOSER_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                DbxChooser.Result result = new DbxChooser.Result(data);
                Log.d("main", "Link to selected file: " + result.getLink());

                // Handle the result
            } else {
                // Failed or was cancelled by the user.
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

