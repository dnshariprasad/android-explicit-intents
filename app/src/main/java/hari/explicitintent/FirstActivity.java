package hari.explicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

//Topics:
//Explicit Intent
//onClick form  XML and different ways to write listeners
//screenOrientation
//view visibility
//validation


public class FirstActivity extends AppCompatActivity {
    public static final int TEST_RESULT_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == TEST_RESULT_CODE) {
                findViewById(R.id.result_text).setVisibility(View.VISIBLE);
                ((TextView) findViewById(R.id.result_text)).setText(data.getStringExtra("MESSAGE"));
            } else {
                findViewById(R.id.result_text).setVisibility(View.GONE);
                Toast.makeText(this, "Wrong Request code", Toast.LENGTH_LONG).show();
            }

        } else {
            findViewById(R.id.result_text).setVisibility(View.GONE);
            Toast.makeText(this, "Request canceled", Toast.LENGTH_LONG).show();
        }

    }

    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.explicit_intent_one:
                Intent oneIntent = new Intent(this, SecondActivity.class);
                oneIntent.putExtra("MY_DATA", "Hi am so ans so..");
                startActivity(oneIntent);
                break;
            case R.id.explicit_intent_two:
                Intent twoIntent = new Intent("PleaseStartThirdActivity");
                startActivity(twoIntent);
                break;
            case R.id.explicit_intent_three:
                Intent thirdIntent = new Intent();
                thirdIntent.setClassName("hari.explicitintent", "hari.explicitintent.FourthActivity");
                startActivity(thirdIntent);
                break;
            case R.id.explicit_intent_result:
                Intent resultIntent = new Intent(this, FifthActivity.class);
                startActivityForResult(resultIntent, TEST_RESULT_CODE);
                break;

        }
    }
}
