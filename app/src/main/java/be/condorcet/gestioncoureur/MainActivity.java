package be.condorcet.gestioncoureur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

import be.condorcet.gestioncoureur.Modele.Coureur;
import be.condorcet.gestioncoureur.Modele.Course;

public class MainActivity extends AppCompatActivity
{
        private EditText nom=null,prenom=null,time=null;
        private Button select=null,record=null,result=null;
        private ListView lv=null;
        private SeekBar timeSB=null;
        private ArrayAdapter<Coureur> adpt;



        private Coureur cact =null;
        private Coureur cInsert =null;
        private Course course =null;
        //public static final String MAISON = "Maison";

        public static final String PACT = "Coureur actuel";

        public static final String LISTCOUREURS = "liste Coureurs";

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            course = new Course();
            course.populate();
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            if(savedInstanceState!=null)
            {
                cact =(Coureur) savedInstanceState.getParcelable(PACT);

                ArrayList<Coureur> listCoureurs= savedInstanceState.getParcelableArrayList(LISTCOUREURS);
            }
            nom=findViewById(R.id.nom);
            prenom=findViewById(R.id.prenom);
            time=findViewById(R.id.Time);
            time.setText(String.valueOf(0));

            select=findViewById(R.id.selectButton);
            record=findViewById(R.id.idSaveButton);
            record.setEnabled(false);
            result=findViewById(R.id.ShowResButton);
            result.setEnabled(false);

            lv=findViewById(R.id.listView);
            timeSB=findViewById(R.id.seekBar);
            //timeSB.setMin(0);
            //timeSB.setMin(100);

            loadList();
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    cact = course.getListCoureurActif().get(position);

                }
            });
            timeSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                int progress=0;

                @Override
                public void onProgressChanged(SeekBar seekBar,int i, boolean b) {
                    progress=i;
                    time.setText(String.valueOf(progress));
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
        }
    private void loadList()
    {
        adpt= new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, course.getListCoureurActif());

        lv.setAdapter(adpt);
    }
        public void clickSelect(View v)
        {
            if (cact==null)
            {
                Toast.makeText(getApplicationContext(), R.string.errorCoureur,Toast.LENGTH_SHORT).show();
            }
            else
            {
                nom.setText(cact.getName());
                prenom.setText(cact.getFirstname());

                record.setEnabled(true);
            }

        }
        public void clickRecord(View v)
        {
            course.getListCoureurActif().remove(cact);
            cact.setTime(Integer.parseInt(time.getText().toString()));
            course.insertListCoureurResult(cact);
            initText();
            record.setEnabled(false);
            result.setEnabled(true);
            loadList();
            if(course.getListCoureurActif().isEmpty())
            {
                select.setEnabled(false);
            }

        }
        public void clickResult(View v)
        {

        }

        private void initText()
        {
            nom.setText("");
            prenom.setText("");
            time.setText("0");

        }
}