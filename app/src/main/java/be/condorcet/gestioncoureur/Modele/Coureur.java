package be.condorcet.gestioncoureur.Modele;

import android.os.Parcel;
import android.os.Parcelable;

public class Coureur implements Parcelable
{
    private int time=-1;
    private String name,firstname;

    public Coureur(String n, String fn)
    {
        name=n;
        firstname=fn;
    }

    public int getTime() {
        return time;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getName() {
        return name;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if(time<0)
        {
            return name + " "+ firstname;
        }
        return name + " "+ firstname + " " +time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(this.name);
        dest.writeString(this.firstname);
        dest.writeInt(this.time);

    }
    protected Coureur(Parcel in)
    {
        this.name=in.readString();
        this.firstname=in.readString();
        this.time=in.readInt();
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
