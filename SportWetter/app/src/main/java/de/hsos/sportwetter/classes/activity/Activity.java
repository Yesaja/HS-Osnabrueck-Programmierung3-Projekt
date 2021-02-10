package de.hsos.sportwetter.classes.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.UUID;
import de.hsos.sportwetter.classes.location.Location;
import de.hsos.sportwetter.classes.sport.Sport;
import de.hsos.sportwetter.classes.user.ActivityProvider;
import de.hsos.sportwetter.classes.user.User;

@Entity(tableName = "ACTIVITY")
public class Activity {

    @PrimaryKey(autoGenerate = true) @NonNull
    @ColumnInfo(name = "activity_id")
    private long id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "provider")
    private ActivityProvider provider;
    @ColumnInfo(name = "art")
    private Sport art;
    @ColumnInfo(name = "ziel")
    private Location ziel;
    @ColumnInfo(name = "start")
    private Location start;
    @ColumnInfo(name = "teilnehmer")
    private List<User> teilnehmer = new ArrayList<>();

    /**
     * @author Paul Dieterich
     * @version 3
     * @since 20.01.2021
     * @param name - Narme der aktivität
     * @param provider - name des anbieters der aktivität
     * @param art - sportart der aktivität z.B Joggen
     * @param ziel - Location wo z.B die jogging runde zuende ist
     * @param start - Location wo z.B die jogging runde beginnt
     * */
    @Ignore
    public Activity(String name, ActivityProvider provider, Sport art, Location ziel, Location start) {
        this.name = name;
        this.provider = provider;
        this.art = art;
        this.ziel = ziel;
        this.start = start;

    }
    public Activity() {
        this.name = "unset";
        this.provider = new ActivityProvider();
        this.art = new Sport();
        this.ziel = new Location();
        this.start = new Location();
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ActivityProvider getProvider() {
        return provider;
    }

    public void setProvider(ActivityProvider provider) {
        this.provider = provider;
    }

    public Sport getArt() {
        return art;
    }

    public void setArt(Sport art) {
        this.art = art;
    }

    public Location getZiel() {
        return ziel;
    }

    public void setZiel(Location ziel) {
        this.ziel = ziel;
    }

    public Location getStart() {
        return start;
    }

    public void setStart(Location start) { this.start = start;}

    public List<User> getTeilnehmer() {
        return teilnehmer;
    }

    public void setTeilnehmer(List<User> teilnehmer) {
        this.teilnehmer = teilnehmer;
    }
    public void addTeilnehmer(User newTeilnehmer){
        this.teilnehmer.add(newTeilnehmer);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "name='" + name + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return id == activity.id &&
                Objects.equals(name, activity.name) &&
                Objects.equals(provider, activity.provider) &&
                Objects.equals(art, activity.art) &&
                Objects.equals(ziel, activity.ziel) &&
                Objects.equals(start, activity.start);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, provider, art, ziel, start);
    }
}
