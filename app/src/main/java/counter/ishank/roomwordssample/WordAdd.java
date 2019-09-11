package counter.ishank.roomwordssample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WordAdd extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.roomwordssample.REPLY";
    private EditText text;
    private Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_add);
        text=findViewById(R.id.text_data);
        btn_add=findViewById(R.id.add_data);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                if (TextUtils.isEmpty(text.getText())) {
                    setResult(RESULT_CANCELED, intent);
                } else {
                    String word = text.getText().toString();
                    intent.putExtra(EXTRA_REPLY, word);
                    setResult(RESULT_OK, intent);
                }
                finish();
            }
        });
    }

}
