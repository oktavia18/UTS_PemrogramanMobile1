import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the main ConstraintLayout
        ConstraintLayout mainLayout = new ConstraintLayout(this);
        mainLayout.setLayoutParams(new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT));
        mainLayout.setBackgroundColor(0xFFE8DAFF); // Background color

        // Create the title bar
        LinearLayout titleBar = new LinearLayout(this);
        titleBar.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        titleBar.setOrientation(LinearLayout.HORIZONTAL);
        titleBar.setBackgroundColor(0xFFE8DAFF);
        titleBar.setPadding(9, 9, 9, 9);

        // Create the title TextView
        TextView titleTextView = new TextView(this);
        titleTextView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        titleTextView.setTextColor(0xFF7A52C8); // Text color
        titleTextView.setTextSize(33);
        titleTextView.setText("Title"); // Set your title text here
        titleTextView.setGravity(android.view.Gravity.CENTER);

        titleBar.addView(titleTextView);
        mainLayout.addView(titleBar);

        // Create header TextView
        TextView headerText = new TextView(this);
        headerText.setLayoutParams(new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT));
        headerText.setText("Hello\nArabian !");
        headerText.setTextColor(0xFF000000); // Black color
        headerText.setTextSize(20);
        headerText.setId(View.generateViewId()); // Generate a unique ID

        // Add headerText to mainLayout
        mainLayout.addView(headerText);

        // Create grid container
        ConstraintLayout gridContainer = new ConstraintLayout(this);
        gridContainer.setLayoutParams(new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                0)); // Use 0dp for height to allow constraints to work
        gridContainer.setId(View.generateViewId()); // Generate a unique ID
        gridContainer.setBackgroundColor(getResources().getColor(R.color.Bluemuda)); // Set background color

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(gridContainer);
        constraintSet.connect(gridContainer.getId(), ConstraintSet.TOP, headerText.getId(), ConstraintSet.BOTTOM, 95);
        constraintSet.connect(gridContainer.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM);
        constraintSet.applyTo(gridContainer);

        // Create cards
        createCard(gridContainer, "Sekolah", R.drawable.sekolah, 0);
        createCard(gridContainer, "Rumah", R.drawable.rumah, 1);
        createCard(gridContainer, "Perpustakaan", R.drawable.perspustakaan, 2);
        createCard(gridContainer, "Profesi", R.drawable.profesi, 3);

        // Add gridContainer to mainLayout
        mainLayout.addView(gridContainer);

        // Set the main layout as the content view
        setContentView(mainLayout);
    }

    private void createCard(ConstraintLayout parent, String title, int imageResId, int index) {
        MaterialCardView card = new MaterialCardView(this);
        card.setLayoutParams(new ConstraintLayout.LayoutParams(
                0,
                ConstraintLayout.LayoutParams.WRAP_CONTENT));
        card.setCardCornerRadius(12);
        card.setCardElevation(8);
        card.setId(View.generateViewId()); // Generate a unique ID

        // Create inner layout for the card
        LinearLayout cardLayout = new LinearLayout(this);
        cardLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        cardLayout.setOrientation(LinearLayout.VERTICAL);
        cardLayout.setPadding(50, 50, 50, 50);
        cardLayout.setBackgroundColor(0xFFFFFFFF); // White background

        // Create ImageView
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(300, 100));
       