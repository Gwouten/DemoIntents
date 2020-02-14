package deloof.wouter.demointents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // UI
    private Button btnCall;
    private EditText etName;

    // Listeners
    private View.OnClickListener callListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Uri callUri = Uri.parse("tel:0492827218");
            Intent callIntent = new Intent(Intent.ACTION_CALL, callUri);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    askPermission();
                    return;
                }
            }
            startActivity(callIntent);
        }
    };

    private void askPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 0);
    }

    // methode om in layout naar te verwijzen
    public void openSite(View v){
        Uri siteUri = Uri.parse("https://www.google.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, siteUri);
        startActivity(webIntent);
    }

    public void navToSeppe(View v){
        Intent navIntent = new Intent(this, SeppeActivity.class);

        // Data doorgeven
        navIntent.putExtra("name", etName.getText().toString());

        startActivity(navIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        askPermission();

        // verwijzing naar UI
        btnCall = findViewById(R.id.btn_call);
        etName = findViewById((R.id.et_name));

        // Koppelen listeners aan view
        btnCall.setOnClickListener(callListener);

    }
}
