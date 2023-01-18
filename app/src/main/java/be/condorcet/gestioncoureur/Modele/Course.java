package be.condorcet.gestioncoureur.Modele;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Course
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

    public void setListCoureurActif(List<Coureur> lc) {
        this.listCoureurActif=lc;
    }
    public List<Coureur> getListCoureurResult()
    {
        return listCoureurResult;
    }

    public void setListCoureurResult(List<Coureur> lc) {
        this.listCoureurResult=lc;
    }

    public void insertListCoureurResult(Coureur c)
    {
        listCoureurResult.add(c);
        listCoureurActif.remove(c);
    }



    }

