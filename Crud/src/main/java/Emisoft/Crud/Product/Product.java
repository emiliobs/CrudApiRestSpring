package Emisoft.Crud.Product;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  name;
    private float price;
    private LocalDate  date;

    @Transient
    private int antiquity;

    public Product()
    {
    }

    public Product(Long id, String name, float price, LocalDate date)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;

    }

    public Product(String name, float price, LocalDate date)
    {
        this.name = name;
        this.price = price;
        this.date = date;

    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    @Column(unique = true)
    public void setName(String name)
    {
        this.name = name;
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public int getAntiquity()
    {
        return Period.between(this.date, LocalDate.now()).getYears();
    }

    public void setAntiquity(int antiquity)
    {
        this.antiquity = antiquity;
    }
}
