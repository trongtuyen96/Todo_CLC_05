package quoc.android.todo_clc_05;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


// Activity Task dùng để add note, khi nhấn floating button trong main thì sẽ chuyển qua activity này
public class TaskActivity extends AppCompatActivity {
    Toolbar toolbar;
    Spinner spinner;
    EditText title;// editText nhập title
    EditText content;// editText nhập content
    Button color;// button chọn màu
    Button date;// button chọn ngày
    Button time;// button chọn giờ
    String[] items = new String[]{"Notify Once", "Notify Everyday"};
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        title = (EditText)findViewById(R.id.input_title);
        content = (EditText)findViewById(R.id.input_content);
        color = (Button) findViewById(R.id.btnColor);
        date = (Button)findViewById(R.id.btnDate);
        time = (Button)findViewById(R.id.btnTime);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add Note");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        spinner = (Spinner)findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        int spinnerPosition = adapter.getPosition("Once");
        spinner.setSelection(spinnerPosition);
        spinner.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // xử lí sự kiện nhấn done (save) sau khi add note
        if (id == R.id.action_done) {
            return true;
        }

        // xử lí sự kiện nhấn back từ activity này
        if (id == R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }



        return super.onOptionsItemSelected(item);
    }
}
