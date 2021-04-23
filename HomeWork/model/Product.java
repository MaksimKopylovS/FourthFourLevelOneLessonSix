package max_sk.HomeWork.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private int cost;

    @Column(name = "create_at")
    @CreationTimestamp
    private Date createAt;

    @Column(name = "update_at")
    @CreationTimestamp
    private Date updateAt;

    @OneToMany
    @JoinTable(name = "orders",
            joinColumns = @JoinColumn(name = "id_product"))
    private Collection<Product> orderCollection;


    public Product(BigInteger id, String title, int cost, Date createAt, Date updateAt) {
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public String toString() {
        return "id: " + id +
                " title: " + title +
                " cost: " + cost +
                " createData: " + createAt +
                " updateData: " + updateAt;
    }
}
