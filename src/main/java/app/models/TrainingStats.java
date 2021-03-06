package app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRAINING_STATS")
public class TrainingStats {
    private long id;
    private Date trainingDate;
    private int trainingTime;
    private Training training;

    public TrainingStats() {
    }

    public TrainingStats(long id) {
        this.id = id;
    }

    public TrainingStats(Date trainingDate, int trainingTime) {
        this.trainingDate = trainingDate;
        this.trainingTime = trainingTime;
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
    @Column(name = "training_date")
    public Date getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(Date trainingDate) {
        this.trainingDate = trainingDate;
    }

    @Basic
    @Column(name = "training_time")
    public int getTrainingTime() {
        return trainingTime;
    }

    public void setTrainingTime(int trainingTime) {
        this.trainingTime = trainingTime;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 67 * hash + Objects.hashCode(this.trainingDate);
        hash = 67 * hash + Objects.hashCode(this.trainingTime);
        return hash;
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
        final TrainingStats other = (TrainingStats) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.trainingDate, other.trainingDate)) {
            return false;
        }
        if (!Objects.equals(this.trainingTime, other.trainingTime)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TrainingStats{" + "id=" + id + ", trainingDate=" + trainingDate + ", trainingTime=" + trainingTime + '}';
    }
}
