package kr.nurniyazov.shopsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
    @SequenceGenerator(name="product_generator", sequenceName = "product_id_seq", allocationSize = 1, initialValue = 9)
    private int id;

    @Column
    private String name;

    @Column
    private int count;

    @Column
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
