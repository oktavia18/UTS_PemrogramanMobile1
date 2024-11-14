import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the main RelativeLayout
        RelativeLayout mainLayout = new RelativeLayout(this);
        mainLayout.setLayoutParams(new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT));
        mainLayout.setBackgroundColor(0xFFF3F0FF); // Background color

        // Create the title bar
        LinearLayout titleBar = new LinearLayout(this);
        titleBar.setId(View.generateViewId());
        titleBar.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        titleBar.setOrientation(LinearLayout.HORIZONTAL);
        titleBar.setPadding(16, 16, 16, 16);
        titleBar.setGravity(Gravity.CENTER_VERTICAL);

        // Create the title TextView
        TextView titleTextView = new TextView(this);
        titleTextView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        titleTextView.setText("Sekolah");
        titleTextView.setTextColor(0xFF7A52C8); // Text color
        titleTextView.setTextSize(33);
        titleTextView.setTextStyle(Typeface.BOLD);
        titleTextView.setGravity(Gravity.CENTER);

        titleBar.addView(titleTextView);
        mainLayout.addView(titleBar);

        // Create ScrollView
        ScrollView scrollView = new ScrollView(this);
        RelativeLayout.LayoutParams scrollLayoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        scrollLayoutParams.addRule(RelativeLayout.BELOW, titleBar.getId());
        scrollView.setLayoutParams(scrollLayoutParams);
        scrollView.setPadding(16, 16, 16, 16);

        // Create a vertical LinearLayout inside the ScrollView
        LinearLayout contentLayout = new LinearLayout(this);
        contentLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        contentLayout.setOrientation(LinearLayout.VERTICAL);

        // Add items to the content layout
        addItem(contentLayout, "Kelas", "فَصْلٌ");
        addItem(contentLayout, "Meja", "مَكْتَبٌٌّ");
        addItem(contentLayout, "Kursi", "كُرْسِيٌٌّّ");
        addItem(contentLayout, "Buku", "كِتَابٌٌّ");
        addItem(contentLayout, "Pensil", "قَلَمٌ رَصَاصٍ");
        addItem(contentLayout, "Penghapus", "مِمْحَاةٌ");
        addItem(contentLayout, "Peta", "خَرِيطَةٌٌّ");
        addItem(contentLayout, "Papan Tulis", "سَبُّورَةٌٌّ");

        // Add content layout to ScrollView
        scrollView.addView(contentLayout);
        mainLayout.addView(scrollView);

        // Set the main layout as the content view
        setContentView(mainLayout);
    }

    private void addItem(LinearLayout parent, String leftText, String rightText) {
        // Create a horizontal LinearLayout for each item
        LinearLayout itemLayout = new LinearLayout(this);
        itemLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        itemLayout.setOrientation(LinearLayout.HORIZONTAL);
        itemLayout.setBackgroundResource(R.drawable.rounded_background);
        itemLayout.setPadding(15, 15, 15, 15);
        itemLayout.setGravity(Gravity.CENTER);
        itemLayout.setLayoutMarginBottom(8);

        // Create left TextView
        TextView leftTextView = new TextView(this);
        leftTextView.setLayoutParams(new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1f)); // Weight 1
        leftTextView.setText(leftText);
        leftTextView.setTextColor(0xFF7A52C8); // Text color
        leftTextView.setTextSize(22);
        leftTextView.setTextStyle(Typeface.BOLD);
        leftTextView.setGravity(Gravity.CENTER);

        // Create right TextView
        TextView rightTextView =