import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Root RelativeLayout
        RelativeLayout rootLayout = new RelativeLayout(this);
        rootLayout.setLayoutParams(new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        rootLayout.setBackgroundColor(Color.parseColor("#F3F0FF"));

        // Title Bar
        LinearLayout titleBar = new LinearLayout(this);
        titleBar.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        titleBar.setOrientation(LinearLayout.HORIZONTAL);
        titleBar.setBackgroundColor(Color.parseColor("#E8DAFF"));
        titleBar.setPadding(9, 9, 9, 9);
        titleBar.setGravity(Gravity.CENTER);

        TextView titleText = new TextView(this);
        titleText.setText("Rumah");
        titleText.setTextColor(Color.parseColor("#7A52C8"));
        titleText.setTextSize(33);
        titleText.setGravity(Gravity.CENTER);
        titleText.setTypeface(null, android.graphics.Typeface.BOLD);
        titleBar.addView(titleText);

        rootLayout.addView(titleBar);

        // Scrollable Content List
        ScrollView scrollView = new ScrollView(this);
        RelativeLayout.LayoutParams scrollViewParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        scrollViewParams.addRule(RelativeLayout.BELOW, titleBar.getId());
        scrollView.setLayoutParams(scrollViewParams);
        scrollView.setPadding(16, 16, 16, 16);

        LinearLayout contentLayout = new LinearLayout(this);
        contentLayout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        contentLayout.setOrientation(LinearLayout.VERTICAL);

        // Adding Items to the Content List
        addContentItem(contentLayout, "Kamar Tidur", "غُرْفَةُ النَّوْمٌِّ");
        addContentItem(contentLayout, "Dapur", "مَطْبَخٌ");
        addContentItem(contentLayout, "Kamar Mandi", "حَمَّامٌ");
        addContentItem(contentLayout, "Ruang Tamu", "غُرْفَةُ الجُلُوسِ");
        addContentItem(contentLayout, "Meja", "طَاوِلَةٌ");
        addContentItem(contentLayout, "Kasur", "سَرِيرٌ");
        addContentItem(contentLayout, "Pintu", "بَابٌ");
        addContentItem(contentLayout, "Televisi", "تِلْفَازٌ");

        scrollView.addView(contentLayout);
        rootLayout.addView(scrollView);

        setContentView(rootLayout);
    }

    private void addContentItem(LinearLayout parentLayout, String leftText, String rightText) {
        LinearLayout itemLayout = new LinearLayout(this);
        itemLayout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        itemLayout.setOrientation(LinearLayout.HORIZONTAL);
        itemLayout.setPadding(15, 15, 15, 15);
        itemLayout.setBackgroundResource(R.drawable.rounded_background);
        itemLayout.setGravity(Gravity.CENTER);

        TextView leftTextView = new TextView(this);
        leftTextView.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        leftTextView.setText(leftText);
        leftTextView.setTextColor(Color.parseColor("#7A52C8"));
        leftTextView.setTextSize(22);
        leftTextView.setTypeface(null, android.graphics.Typeface.BOLD);
        leftTextView.setGravity(Gravity.CENTER);

        TextView rightTextView = new TextView(this);
        rightTextView.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        rightTextView.setText(rightText);
        rightTextView.setTextColor(Color.parseColor("#7A52C8"));
        rightTextView.setTextSize(25);
        rightTextView.setTypeface(null, android.graphics.Typeface.BOLD);
        rightTextView.setGravity(Gravity.CENTER);

        itemLayout.addView(leftTextView);
        itemLayout.addView(rightTextView);
        parentLayout.addView(itemLayout);
    }
}
