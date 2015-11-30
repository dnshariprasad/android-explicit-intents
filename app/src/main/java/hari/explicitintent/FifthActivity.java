package hari.explicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class FifthActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        (findViewById(R.id.return_result)).setOnClickListener(this);
        (findViewById(R.id.return_cancel)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = new Intent();
        switch (id) {
            case R.id.return_result:
                intent.putExtra("MESSAGE", ((EditText) findViewById(R.id.result_entered_text)).getText().toString());
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.return_cancel:
                setResult(RESULT_CANCELED, intent);
                finish();
                break;
        }

    }
}
