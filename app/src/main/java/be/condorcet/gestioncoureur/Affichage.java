package be.condorcet.gestioncoureur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import be.condorcet.gestioncoureur.Modele.Coureur;
import be.condorcet.gestioncoureur.Modele.Course;

public class Affichage extends AppCompatActivity
{
    private ListView lvResult=null;
    private RadioButton rbByName=null,rbByTime=null;
    private ArrayAdapter adpt;
    private List<Coureur> lC=null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        lC= i.getParcelableArrayListExtra(MainActivity.LISTCOUREURSRES);
        setContentView(R.layout.activity_affichage);
        lvResult.findViewById(R.id.ListCoureurView);
        rbByName.findViewById(R.id.radioButtonByName);
        rbByTime.findViewById(R.id.radioButtonByTime);


    }
    private void loadList()
    {
        adpt= new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, lC);

        lvResult.setAdapter(adpt);
    }


    }
