package monprojet.entity;
import javax.persistence.*;

import org.hibernate.annotations.Proxy;

import lombok.*;
import java.util.*;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Proxy(lazy = false)
@Entity // Une entité JPA
public class Country {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String code;
    
    @Column(unique=true)
    @NonNull
    private String name;


    // Dans la classe "Country.java"
    @OneToMany(mappedBy="country")
    // Essayer sans "mappedBy" pour voir le schémma relationnel généré
    // @OneToMany
    @ToString.Exclude
    private List<City> cities = new ArrayList<>();
    
    }