package org.acme;

import jakarta.persistence.*;

@Entity
@Table(name = "gift", catalog = "quarkus", schema = "dbo")
public class Gift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Gift() {
    }

    public Gift(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public static Gift withName(String name) {
        final var gift = new Gift();
        gift.setName(name);
        return gift;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Gift{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}