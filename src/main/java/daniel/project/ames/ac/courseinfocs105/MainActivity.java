package daniel.project.ames.ac.courseinfocs105;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //////////////////////////////////////////////////////////////////////////////////////////
    //Step 1: Declare a "layout" variable
    private RelativeLayout layout;

    //Step 1: Declare a "courseTitle" variable
    private TextView courseTitle;

    //Step 1: Declare a "myImageView" variable
    private ImageView myImageView;

    //Step 1: Declare  two variables: "myButton" & "nameField";
    private Button myButton;//Button
    private EditText nameField;//EditText


    //////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //When users touch screen, in fact they touch RelativeLyaout, the app will pop up a message “Welcome to CS102 paper”.
        //Step 2: Find the reference of this "layout" variable to UI element ("mainLayout")
        //to make the connection between UI element ("mainLayout") and variable ("layout") in java code
        layout = (RelativeLayout) findViewById(R.id.mainLayout);
        //Step 3: Set "Click Listener" for "layout" variable
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Step 4: When users click or touch layout or screen, pop up at the bottom
                //message "Welcome to CS102 paper"
                Toast.makeText(getApplicationContext(), "Welcome to CS102 paper", Toast.LENGTH_SHORT).show();
            }
        });


        //////////////////////////////////////////////////////////////////////////////
        //When users touch TextView, TextView will change to WHITE color and move to the bottom of screen
        //Step 2: Find the reference of the "courseTitle" variable to UI element ("cs102Title")
        //to make the connection between UI element ("cs102Title") and variable ("courseTitle") in java code
        courseTitle = (TextView) findViewById(R.id.cs102Title);
        //Step 3: Set "Click Listener" for "courseTitle" variable
        courseTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Step 4: When users click TextView has been detected
                //Change the text color to WHITE by calling setTextColor() method
                courseTitle.setTextColor(Color.WHITE);
                //Change the "text" content to "Have a good day!" by calling setText() method
                courseTitle.setText("Have a good day!");
                //Move the TextView to the bottom of screen by addRule RelativeLayout.ALIGN_PARENT_BOTTOM
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
                //Add rule: align "TextView" to the bottom of screen
                params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
                //Add rule: align "TextView" to center horizontal
                params.addRule(RelativeLayout.CENTER_HORIZONTAL);
                //Set above rules to "TextView"
                courseTitle.setLayoutParams(params);
            }
        });

        //////////////////////////////////////////////////////////////////////////////
        //When users touch ImageView, ImageView will display grenoble.jpg image
        //Step 2: Find the reference of the "myImageView" variable to UI element ("collegelogo")
        //to make the connection between UI element ("collegelog") and variable ("myImageView") in java code
        myImageView = (ImageView) findViewById(R.id.collegelogo);
        //Step 3: Set "Click Listener" for "myImageView" variable
        myImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Step 4: When users click ImageView has been detected
                //Change the "src" property to grenoble.jpg image
                myImageView.setImageResource(R.drawable.grenoble);
                //Change the background color to transparent
                myImageView.setBackgroundResource(R.color.transparent);
                /*
                //EXPERIMENT:
                Modify the code a little bit so that when users click ImageView (college logo), the app will:
                 • Change the college logo image to “grenoble” image & set ImageView background color is transparent;
                 • Move the ImageView to center of screen;
                 • Change the TextView content to “Chamrousse is a ski resort in southeastern France, in the Belledonne mountain range near Grenoble in the Isere department.”
                 • Set TextView color to YELLOW;
                 • Move the TextView to be located at the bottom of screen;
                 */
                //-------MODIFY IMAGEVIEW PROPERTIES---------------------
                RelativeLayout.LayoutParams imageViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
                //Add rule: align "ImageView" to the center of screen
                imageViewParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
                //Add rule: align "ImageView" to center horizontal
                imageViewParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
                //Set above rules to "ImageView"
                myImageView.setLayoutParams(imageViewParams);

                //-------MODIFY TEXTVIEW PROPERTIES----------------------
                //Set new "text"
                courseTitle.setText("Chamrousse is a ski resort in southeastern France, in the Belledonne mountain range near Grenoble in the Isere department.");
                //Set textColor to YELLOW
                courseTitle.setTextColor(Color.YELLOW);
                //set textSize to 15dp
                courseTitle.setTextSize(15.0f);
                //Move the TextView to be located right below the ImageView
                RelativeLayout.LayoutParams textViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
                //Add rule: align "TextView" to locate at the bottom of screen
                textViewParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
                //Add rule: align "TextView" to center horizontal
                textViewParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
                //Set above rules to "ImageView"
                courseTitle.setLayoutParams(textViewParams);
            }
        });

        //////////////////////////////////////////////////////////////////////////////
        //When users click the Button, pop up an AlertDialog saying welcome message containing
        // “Hello” & entered name in the EditText
        //Step 2: Find the reference of the "myButton" & "nameField" variables to UI elements
        myButton = (Button) findViewById(R.id.clickMe);
        nameField = (EditText) findViewById(R.id.nameField);
        //Step 3: Set "Click Listener" for "myButton" variable
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Step 4: When users click Button, pop up alertDialog to show the welcome message
                //1: Get the entered name inside EditText by calling getText() method and toString() method
                String enteredName = nameField.getText().toString();
                /*
                //2: Build "welcomeMessage" string containing enteredName
                String welcomeMessage = "Hello " + enteredName + ".\nHave a good day!";
                //3: Create a "dialogBuilder" by using AlertDialog.Builder() method
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                //4: Assign the "welcomeMessage" variable to "dialogBuilder"
                dialogBuilder.setMessage(welcomeMessage);
                //5: Create a "dialog" object from "DialogBuilder"
                AlertDialog dialog = dialogBuilder.create();
                //6: Display "dialog" on screen
                dialog.show();
                */

                //EXPERIMENT
                if (enteredName.isEmpty()) {
                    //If EditText is empty
                    Toast.makeText(getApplicationContext(), "Please enter your name", Toast.LENGTH_SHORT).show();
                } else {
                    //EditText is not empty
                    //2: Build "welcomeMessage" string containing enteredName
                    String welcomeMessage = "Hello " + enteredName + ".\nHave a good day!";
                    //3: Create a "dialogBuilder" by using AlertDialog.Builder() method
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    //4: Assign the "welcomeMessage" variable to "dialogBuilder"
                    dialogBuilder.setMessage(welcomeMessage);
                    //5: Create a "dialog" object from "DialogBuilder"
                    AlertDialog dialog = dialogBuilder.create();
                    //6: Display "dialog" on screen
                    dialog.show();
                }
            }
        });

    }
}
