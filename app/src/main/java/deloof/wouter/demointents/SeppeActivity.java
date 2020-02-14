package deloof.wouter.demointents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SeppeActivity extends AppCompatActivity {

    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seppe);

        tvName = findViewById(R.id.tv_name);

        Bundle receivedData = getIntent().getExtras();
        if (receivedData != null) {
            String username = receivedData.getString("name", "No data passed");
            tvName.setText(username);
        }
    }
}
