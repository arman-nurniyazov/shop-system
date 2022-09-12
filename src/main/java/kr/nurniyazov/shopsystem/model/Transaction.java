package kr.nurniyazov.shopsystem.model;

import kr.nurniyazov.shopsystem.enums.OperationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactions_generator")
    @SequenceGenerator(name="transactions_generator", sequenceName = "transactions_id_seq", allocationSize = 1, initialValue = 7)
    private int id;

    @Column(name = "product_id")
    private int productId;

    @Column
    private int count;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private OperationType type;

    public Transaction(int productId, int count, OperationType type) {
        this.productId = productId;
        this.count = count;
        this.type = type;
    }
}
