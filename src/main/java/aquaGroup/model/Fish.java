package aquaGroup.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Fish implements Serializable {
    
    @Column
    private String name;

    @Column
    private String species;

    @Column
    private Integer speed;

    @Column
    private Integer weight;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getName(){
        return name;
    }
    public void setName(String name){ this.name = name; }

    public String getSpecies(){
        return species;
    }
    public void setSpecies(String species){
        this.species = species;
    }

    public Integer getSpeed(){ return speed; }
    public void setSpeed(Integer speed){ this.speed = speed; }

    public Integer getWeight(){ return weight; }
    public void setWeight(Integer weight){ this.weight = weight; }

    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }

    @Override
    public String toString() {
        return "Fish{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", speed=" + speed +
                ", weight=" + weight +
                ", id=" + id +
                '}';
    }
}
