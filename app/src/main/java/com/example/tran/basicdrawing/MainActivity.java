package com.example.tran.basicdrawing;



import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by tran on 07/04/2016.
 * App
 */
public class MainActivity extends AppCompatActivity implements MyDrawingViewInterface {

    EditText et;
    Button button_Chuyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_Chuyen = (Button) findViewById(R.id.button_Chuyen);
        button_Chuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        et = (EditText) this.findViewById(R.id.editText);
        assert et != null;
        et.setText("HelloWorld");

        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        assert drawable != null;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight());
        SpannableString spannable = new SpannableString(getText()
                .toString() + "[smile]");
        ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
        spannable.setSpan(span, getText().length(),
                getText().length() + "[smile]".length(),
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        setText(spannable);
    }

    private Editable getText() {
        return et.getText();
    }
    private void setText(SpannableString spannalbe) {
        et.setText(spannalbe);
    }

    @Override
    public void onActionFinished(float movedX, float movedY) {
        Log.i("Chuyen Du lieu", String.valueOf(movedX + movedY));
    }
}
