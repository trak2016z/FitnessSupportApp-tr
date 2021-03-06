package app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EXERCISE")
public class Exercise {

    private long id;
    private String name;
    private int setsNumber;
    private int repsNumber;
    private int enduranceTime;
    private int breakTime;
    private Training training;
    private Set<ExerciseStats> exerciseStats;

    public Exercise() {
    }
    
    public Exercise(long id) {
        this.id = id;
    }

    public Exercise(String name, int setsNumber, int repsNumber, int enduranceTime, int breakTime) {
        this.name = name;
        this.setsNumber = setsNumber;
        this.repsNumber = repsNumber;
        this.enduranceTime = enduranceTime;
        this.breakTime = breakTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sets_number")
    public int getSetsNumber() {
        return setsNumber;
    }

    public void setSetsNumber(int setsNumber) {
        this.setsNumber = setsNumber;
    }

    @Basic
    @Column(name = "reps_number")
    public int getRepsNumber() {
        return repsNumber;
    }

    public void setRepsNumber(int repsNumber) {
        this.repsNumber = repsNumber;
    }

    @Basic
    @Column(name = "endurance_time")
    public int getEnduranceTime() {
        return enduranceTime;
    }

    public void setEnduranceTime(int enduranceTime) {
        this.enduranceTime = enduranceTime;
    }

    @Basic
    @Column(name = "break_time")
    public int getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(int breakTime) {
        this.breakTime = breakTime;
    }

    @Basic
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "training_fk")
    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    @Basic
    @JsonIgnore
    @OneToMany(mappedBy = "exercise")
    public Set<ExerciseStats> getExerciseStats() {
        return exerciseStats;
    }

    public void setExerciseStats(Set<ExerciseStats> exerciseStats) {
        this.exerciseStats = exerciseStats;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + this.setsNumber;
        hash = 53 * hash + this.repsNumber;
        hash = 53 * hash + Objects.hashCode(this.enduranceTime);
        hash = 53 * hash + Objects.hashCode(this.breakTime);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Exercise other = (Exercise) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.setsNumber != other.setsNumber) {
            return false;
        }
        if (this.repsNumber != other.repsNumber) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.enduranceTime, other.enduranceTime)) {
            return false;
        }
        if (!Objects.equals(this.breakTime, other.breakTime)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Exercise{" + "id=" + id + ", name=" + name + ", setsNumber=" + setsNumber + ", repsNumber=" + repsNumber + ", enduranceTime=" + enduranceTime + ", breakTime=" + breakTime + '}';
    }
    
}
