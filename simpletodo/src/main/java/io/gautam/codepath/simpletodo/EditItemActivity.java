package io.gautam.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditItemActivity extends ActionBarActivity {

    public static final String ITEM_POSITION = "item_position";

    public static final String ITEM_CONTENT = "item_content";

    EditText etEditItem;
    Button btnSaveItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        // Find views
        etEditItem = (EditText) findViewById(R.id.etEditItem);
        btnSaveItem = (Button) findViewById(R.id.btnSaveItem);

        // Set data
        etEditItem.setText(getIntent().getStringExtra(ITEM_CONTENT));
        etEditItem.setSelection(etEditItem.getText().length());

    }

    public void saveItem(View v) {
        Intent data = new Intent();

        data.putExtra(ITEM_CONTENT, etEditItem.getText().toString());
        data.putExtra(ITEM_POSITION, getIntent().getIntExtra(ITEM_POSITION, 0));

        setResult(RESULT_OK, data);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.edit_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
