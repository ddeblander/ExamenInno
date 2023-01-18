package be.condorcet.gestioncoureur.Modele;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Course implements Parcelable
{
    private List<Coureur> listCoureurActif;
    private List<Coureur> listCoureurResult;
    private Coureur c;

    public Course()
    {
        populate();
    }
    protected Course(Parcel in)
    {
        /*this.listCoureurActif =in.readList();
        this.listCoureurResult=in.readList();*/

    }
    public void populate()
    {
        listCoureurActif = new ArrayList<>();
        listCoureurResult = new ArrayList<>();
        listCoureurActif.add(new Coureur("Durant","Marie"));
        listCoureurActif.add(new Coureur("Lerouge","Carine"));
        listCoureurActif.add(new Coureur("Levert","Pierre"));
        listCoureurActif.add(new Coureur("Dupont","Lenoir"));


    }
    public List<Coureur> getListCoureurActif() {
        return listCoureurActif;
    }
    public List<Coureur> getListCoureurResult() {
        return listCoureurResult;
    }

    public void insertListCoureurResult(Coureur c)
    {
        listCoureurResult.add(c);
        listCoureurActif.remove(c);
    }



    @Override
    public int describeContents() {return 0;}

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.listCoureurActif);
        dest.writeList(this.listCoureurResult);
    }

    public static final Creator<Coureur> CREATOR = new Creator<Coureur>() {
        @Override
        public Coureur createFromParcel(Parcel source) {
            return new Coureur(source);
        }

        @Override
        public Coureur[] newArray(int size) {
            return new Coureur[size];
        }
    };
}
