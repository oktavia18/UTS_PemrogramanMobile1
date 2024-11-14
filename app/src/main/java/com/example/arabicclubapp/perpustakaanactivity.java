import android.graphics.Color;
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

        RelativeLayout mainLayout = new RelativeLayout(this);
        mainLayout.setLayoutParams(new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        ));
        mainLayout.setBackgroundColor(Color.parseColor("#F3F0FF"));

        // Title Bar Layout
        LinearLayout titleBar = new LinearLayout(this);
        titleBar.setOrientation(LinearLayout.HORIZONTAL);
        titleBar.setBackgroundColor(Color.parseColor("#E8DAFF"));
        titleBar.setPadding(16, 16, 16, 16);
        titleBar.setGravity(android.view.Gravity.CENTER);

        // Title TextView
        TextView title = new TextView(this);
        title.setText("Perpustakaan");
        title.setTextColor(Color.parseColor("#7A52C8"));
        title.setTextSize(32);
        title.setTextAlignment(android.view.Gravity.CENTER);
        titleBar.addView(title);

        // Add title bar to main layout
        RelativeLayout.LayoutParams titleBarParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        mainLayout.addView(titleBar, titleBarParams);

        // ScrollView for the content list
        ScrollView scrollView = new ScrollView(this);
        RelativeLayout.LayoutParams scrollViewParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        scrollViewParams.addRule(RelativeLayout.BELOW, titleBar.getId());
        scrollView.setLayoutParams(scrollViewParams);

        LinearLayout contentLayout = new LinearLayout(this);
        contentLayout.setOrientation(LinearLayout.VERTICAL);
        contentLayout.setPadding(16, 16, 16, 16);

        // Create each item with Indonesian and Arabic text
        addItem(contentLayout, "Perpustakaan", "مَكْتَبَةٌ");
        addItem(contentLayout, "Buku", "كِتَابٌ");
        addItem(contentLayout, "Majalah", "مَجَلَّةٌ");
        addItem(contentLayout, "Rak buku", "رَفُّ الكُتُبِ");
        addItem(contentLayout, "Peminjaman", "مُسْتَعِيرٌ");
        addItem(contentLayout, "Novel", "رِوَايَةٌ");
        addItem(contentLayout, "Jurnal", "دَوْرِيَّةٌ");
        addItem(contentLayout, "Ensiklopedia", "مَوْسُوعَةٌ");

        scrollView.addView(contentLayout);
        mainLayout.addView(scrollView);

        setContentView(mainLayout);
    }

    private void addItem(LinearLayout parent, String textLeft, String textRight) {
        LinearLayout itemLayout = new LinearLayout(this);
        itemLayout.setOrientation(LinearLayout.HORIZONTAL);
        itemLayout.setPadding(16, 16, 16, 16);
        itemLayout.setGravity(android.view.Gravity.CENTER);

        TextView textViewLeft = new TextView(this);
        textViewLeft.setLayoutParams(new LinearLayout.LayoutParams(0,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        textViewLeft.setText(textLeft);
        textViewLeft.setTextColor(Color.parseColor("#7A52C8"));
        textViewLeft.setTextSize(23);
        textViewLeft.setTextAlignment(android.view.Gravity.CENTER);

        TextView textViewRight = new TextView(this);
        textViewRight.setLayoutParams(new LinearLayout.LayoutParams(0,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        textViewRight.setText(textRight);
        textViewRight.setTextColor(Color.parseColor("#7A52C8"));
        textViewRight.setTextSize(25);
        textViewRight.setTextAlignment(android.view.Gravity.CENTER);

        itemLayout.addView(textViewLeft);
        itemLayout.addView(textViewRight);

        parent.addView(itemLayout);
    }
}
