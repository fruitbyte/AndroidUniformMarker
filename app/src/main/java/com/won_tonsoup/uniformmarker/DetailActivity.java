package com.won_tonsoup.uniformmarker;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;


public class DetailActivity extends AppCompatActivity {

    String score = "16";
    int tempScore;
    String cadetFirst;
    String cadetLast;
    int cadetFlight;
    StringBuilder fixMessage = new StringBuilder();
    String finalFix;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference scoresDatabaseReference;

    int wedgeint = 0;
    int jewelryint = 0;
    int hairint = 0;
    int facialint = 0;
    int badgesint = 0;
    int tieint = 0;
    int ironTopint = 0;
    int dirtyTopint = 0;
    int beltint = 0;
    int ironPantsint = 0;
    int dirtyPantsint = 0;
    int dirtyBootsint = 0;
    int shineint = 0;
    int socksint = 0;
    int otherPantsint = 0;
    int otherBootsint = 0;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marking_fragment);
        TextView scoreText = (TextView) findViewById(R.id.live_score);
        scoreText.setText(score);
        Intent intent = new Intent(this.getIntent());
        cadetFirst = intent.getStringExtra("first");
        cadetLast = intent.getStringExtra("last");
        cadetFlight = Integer.parseInt(intent.getStringExtra("flight"));
        setTitle(cadetLast + ", "+ cadetFirst + "       " + score);
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        scoresDatabaseReference = firebaseDatabase.getReference().child("Scores");
    }

    public void decreasePoints(){
        tempScore = Integer.parseInt(score) - 1;
        score = Integer.toString(tempScore);
        TextView scoreText = (TextView) findViewById(R.id.live_score);
        scoreText.setText(score);
        setTitle(cadetLast + ", " + cadetFirst + "       " + score);
    }

    public void increasePoints() {
        tempScore = Integer.parseInt(score) + 1;
        score = Integer.toString(tempScore);
        TextView scoreText = (TextView) findViewById(R.id.live_score);
        scoreText.setText(score);
        setTitle(cadetLast + ", " + cadetFirst + "       " + score);
    }

    public void wedgeBtnClick(View view) {
        TextView textView = (TextView) findViewById(R.id.wedgeLabel);
        
        if(wedgeint == 0) {
            decreasePoints();
            textView.setTextColor(Color.RED);
            wedgeint++;
        } else {
            increasePoints();
            textView.setTextColor(Color.BLACK);
            wedgeint--;
        }
    }

    public void jewelryBtnClick(View view) {
        TextView textView = (TextView) findViewById(R.id.jewelryLabel);

        if(jewelryint == 0) {
            decreasePoints();
            textView.setTextColor(Color.RED);
            jewelryint++;
        } else {
            increasePoints();
            textView.setTextColor(Color.BLACK);
            jewelryint--;
        }
    }

    public void facialBtnClick(View view) {
        
        TextView textView = (TextView) findViewById(R.id.facialHairLabel);
        if(facialint == 0) {
            decreasePoints();
            textView.setTextColor(Color.RED);
            facialint++;
        } else {
            increasePoints();
            textView.setTextColor(Color.BLACK);
            facialint--;
        }
        
    }

    public void hairBtnClick(View view) {
        
        TextView textView = (TextView) findViewById(R.id.hairLabel);
        if(hairint == 0) {
            decreasePoints();
            textView.setTextColor(Color.RED);
            hairint++;
        } else {
            increasePoints();
            textView.setTextColor(Color.BLACK);
            hairint--;
        }
        
    }

    public void badgesBtnClick(View view) {
        
        TextView textView = (TextView) findViewById(R.id.badgesLabel);
        if(badgesint == 0) {
            decreasePoints();
            textView.setTextColor(Color.RED);
            badgesint++;
        } else {
            increasePoints();
            textView.setTextColor(Color.BLACK);
            badgesint--;
        }
        
    }

    public void tieBtnClick(View view) {
        
        TextView textView = (TextView) findViewById(R.id.tieLabel);
        if(tieint == 0) {
            decreasePoints();
            textView.setTextColor(Color.RED);
            tieint++;
        } else {
            increasePoints();
            textView.setTextColor(Color.BLACK);
            tieint--;
        }
        
    }

    public void ironTopBtnClick(View view) {
        
        TextView textView = (TextView) findViewById(R.id.ironTopLabel);
        if(ironTopint == 0) {
            decreasePoints();
            textView.setTextColor(Color.RED);
            ironTopint++;
        } else {
            increasePoints();
            textView.setTextColor(Color.BLACK);
            ironTopint--;
        }
        
    }

    public void dirtyTopBtnClick(View view) {
        
        TextView textView = (TextView) findViewById(R.id.dirtyTopLabel);
        if(dirtyTopint == 0) {
            decreasePoints();
            textView.setTextColor(Color.RED);
            dirtyTopint++;
        } else {
            increasePoints();
            textView.setTextColor(Color.BLACK);
            dirtyTopint--;
        }
        
    }

    public void beltBtnClick(View view) {
        
        TextView textView = (TextView) findViewById(R.id.beltLabel);
        if(beltint == 0) {
            decreasePoints();
            textView.setTextColor(Color.RED);
            beltint++;
        } else {
            increasePoints();
            textView.setTextColor(Color.BLACK);
            beltint--;
        }
        
    }

    public void ironPantsBtnClick(View view) {
        
        TextView textView = (TextView) findViewById(R.id.ironPantsLabel);
        if(ironPantsint == 0) {
            decreasePoints();
            textView.setTextColor(Color.RED);
            ironPantsint++;
        } else {
            increasePoints();
            textView.setTextColor(Color.BLACK);
            ironPantsint--;
        }
        
    }

    public void dirtyPantsBtnClick(View view) {
        
        TextView textView = (TextView) findViewById(R.id.dirtyPantsLabel);
        if(dirtyPantsint == 0) {
            decreasePoints();
            textView.setTextColor(Color.RED);
            dirtyPantsint++;
        } else {
            increasePoints();
            textView.setTextColor(Color.BLACK);
            dirtyPantsint--;
        }
        
    }

    public void otherPantsBtnClick(View view) {

        if(otherPantsint == 0) {
            decreasePoints();
            otherPantsint++;
        } else {
            increasePoints();
            otherPantsint--;
        }
        
    }

    public void dirtyBootsBtnClick(View view) {
        
        TextView textView = (TextView) findViewById(R.id.dirtyBootsLabel);
        if(dirtyBootsint == 0) {
            decreasePoints();
            textView.setTextColor(Color.RED);
            dirtyBootsint++;
        } else {
            increasePoints();
            textView.setTextColor(Color.BLACK);
            dirtyBootsint--;
        }
        
    }

    public void shineBootsBtnClick(View view) {
        
        TextView textView = (TextView) findViewById(R.id.shineBootsLabel);
        if(shineint == 0) {
            decreasePoints();
            textView.setTextColor(Color.RED);
            shineint++;
        } else {
            increasePoints();
            textView.setTextColor(Color.BLACK);
            shineint--;
        }
        
    }

    public void socksBtnClick(View view) {
        
        TextView textView = (TextView) findViewById(R.id.socksLabel);
        if(socksint == 0) {
            decreasePoints();
            textView.setTextColor(Color.RED);
            socksint++;
        } else {
            increasePoints();
            textView.setTextColor(Color.BLACK);
            socksint--;
        }
        
    }

    public void otherBootsBtnClick(View view) {

        if(otherBootsint == 0) {
            decreasePoints();
            otherBootsint++;
        } else {
            increasePoints();
            otherBootsint--;
        }
        
    }

    public void finishBtnClick(View view) {
        if(Integer.parseInt(score) == 16) {
            fixMessage.append("N/A");
        } else {
            if (wedgeint == 1) {
                fixMessage.append(" Wedge ");
            }
            if (jewelryint == 1) {
                fixMessage.append(" Jewelry/Accessories ");
            }
            if (facialint == 1) {
                fixMessage.append(" Facial Hair ");
            }
            if (hairint == 1) {
                fixMessage.append(" Hair ");
            }
            if (badgesint == 1) {
                fixMessage.append(" Badges ");
            }
            if (tieint == 1) {
                fixMessage.append(" Tie ");
            }
            if (ironTopint == 1) {
                fixMessage.append(" Iron-Top ");
            }
            if (dirtyTopint == 1) {
                fixMessage.append(" Dirty-Top ");
            }
            if (beltint == 1) {
                fixMessage.append(" Belt ");
            }
            if (ironPantsint == 1) {
                fixMessage.append(" Iron-Pants ");
            }
            if (dirtyPantsint == 1) {
                fixMessage.append(" Dirty-Pants ");
            }
            if (otherPantsint == 1) {
                fixMessage.append(" Other-Pants ");
            }
            if (dirtyBootsint == 1) {
                fixMessage.append(" Dirty-Boots ");
            }
            if (shineint == 1) {
                fixMessage.append(" Shine ");
            }
            if (socksint == 1) {
                fixMessage.append(" Socks ");
            }
            if (otherBootsint == 1) {
                fixMessage.append(" Other-Boots ");
            }
            fixMessage.append(".");
        }
        finalFix = fixMessage.toString();
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        month++;
        String date = month + "-" + day + "-" + year;
        DataSender dataSender = new DataSender(cadetFirst, cadetLast, finalFix, Integer.parseInt(score), cadetFlight, date);
        scoresDatabaseReference.push().setValue(dataSender);
        finish();
    }

}
