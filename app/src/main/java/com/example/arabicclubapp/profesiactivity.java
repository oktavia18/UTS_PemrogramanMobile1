import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfesiActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Root RelativeLayout
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT));
        relativeLayout.setBackgroundColor(Color.parseColor("#F3F0FF"));

        // Title Bar LinearLayout
        LinearLayout titleBar = new LinearLayout(this);
        titleBar.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        titleBar.setOrientation(LinearLayout.HORIZONTAL);
        titleBar.setBackgroundColor(Color.parseColor("#E8DAFF"));
        titleBar.setPadding(16, 16, 16, 16);

        // Title TextView
        TextView titleText = new TextView(this);
        titleText.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        titleText.setText("Profesi");
        titleText.setTextSize(33);
        titleText.setTextColor(Color.parseColor("#7A52C8"));
        titleText.setGravity(17); // Center text
        titleBar.addView(titleText);
        relativeLayout.addView(titleBar);

        // ScrollView for content
        ScrollView scrollView = new ScrollView(this);
        RelativeLayout.LayoutParams scrollParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        scrollParams.addRule(RelativeLayout.BELOW, titleBar.getId());
        scrollView.setLayoutParams(scrollParams);
        scrollView.setPadding(16, 16, 16, 16);

        // Container LinearLayout
        LinearLayout container = new LinearLayout(this);
        container.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        container.setOrientation(LinearLayout.VERTICAL);

        // Adding profession items to the container
        container.addView(createProfessionItem("Dokter", "طَبِيبٌ"));
        container.addView(createProfessionItem("Guru", "مُدَرِّسٌ"));
        container.addView(createProfessionItem("Insinyur", "مُهَنْدِسٌ"));
        container.addView(createProfessionItem("Pengacara", "مُحَامٍ"));
        container.addView(createProfessionItem("Perawat", "مُمَرِّضٌ"));
        container.addView(createProfessionItem("Petani", "فَلَّاحٌ"));
        container.addView(createProfessionItem("Polisi", "شُرْطِيٌّ"));
        container.addView(createProfessionItem("Pedagang", "تَاجِرٌ"));

        // Add container to ScrollView, and ScrollView to RelativeLayout
        scrollView.addView(container);
        relativeLayout.addView(scrollView);

        // Set the RelativeLayout as the main layout
        setContentView(relativeLayout);
    }

    // Helper method to create each profession item layout
    private LinearLayout createProfessionItem(String profession, String arabic) {
        // Item LinearLayout
        LinearLayout itemLayout = new LinearLayout(this);
        itemLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        itemLayout.setOrientation(LinearLayout.HORIZONTAL);
        itemLayout.setPadding(15, 15, 15, 15);
        itemLayout.setBackgroundResource(R.drawable.rounded_background);

        // Left TextView
        TextView leftText = new TextView(this);
        leftText.setLayoutParams(new LinearLayout.LayoutParams(0,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        leftText.setText(profession);
        leftText.setTextColor(Color.parseColor("#7A52C8"));
        leftText.setTextSize(22);
        leftText.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        // Right TextView (Arabic)
        TextView rightText = new TextView(this);
        rightText.setLayoutParams(new LinearLayout.LayoutParams(0,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        rightText.setText(arabic);
        rightText.setTextColor(Color.parseColor("#7A52C8"));
        rightText.setTextSize(25);
        rightText.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        // Add TextViews to the item layout
        itemLayout.addView(leftText);
        itemLayout.addView(rightText);

        return itemLayout;
    }
}
