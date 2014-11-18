package hw4.complexPersistent;
import java.io.Serializable;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.annotations.IndexColumn;
import shared.SetByAttribute;
import shared.AttributeType;

@Entity
public class ComplexDataPersistent implements Serializable {
    
    protected Long id;
    
    @Id
    @GeneratedValue 
    public Long getId() { return id; }

    private void setId(Long id) { this.id = id; }

    protected String secretCode;
    protected int happiness;
    protected String[] extra;
    protected String comments;
    protected double grade;
    protected String[] team;
    
    public ComplexDataPersistent() {
    }
    
    protected String athlete;
    protected String sport;
    protected String item;
    protected double price;
    protected int quantity;
    //protected Logger logger;
    
    @NotNull
    @Pattern(regexp=".*\\S.*", message="cannot be empty")
    public String getAthlete()
    {
        return athlete;
    }
    
    public void setAthlete(String athlete)
    {
        this.athlete = athlete;
    }
    
    @NotNull
    @Pattern(regexp=".*\\S.*", message="cannot be empty")
    public String getSport()
    {
        return sport;
    }
    
    public void setSport(String sport)
    {
        this.sport = sport;
    }
    @NotNull
    @Pattern(regexp="ball|Ball|Shoe|shoe|Jersey|jersey", message="cannot be empty and has to be ball, shoe or jersey")
    public String getItem()
    {
        return item;
    }
    
    public void setItem (String item)
    {
        this.item = item;
    }
    
    @Min(value=1,
            message="have to add an item")
    @Max(value=10,
            message="can only add 10 at most")
    public int getQuantity() {
        
        return this.quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;

    }
    
    @Min(value=(long) 5.00,
            message="has to be over $5")
    @Max(value=(long) 150.00,
            message="has to be under $150")
    public double getPrice() {
        
        return price;
    }

    public void setPrice(double price) {

        this.price = price;

    }
      
    public void setSecretCode(String code) {
        this.secretCode = code;
    }
    
    public String getSecretCode() {
        return secretCode;
    }
        
    public void setExtra(String[] extra) {
        this.extra = extra;
    }
    
    
    public void setGrade(double grade) {
        this.grade = grade;
    }
    
    @SetByAttribute(type=AttributeType.SELECTED)
    public double getGrade() {
        return grade;
    }

    @ElementCollection
    @IndexColumn(name="extra_pos", base=0)
    @SetByAttribute(type=AttributeType.CHECKED)
    @NotNull(message=": must select at least one extra.")
    public String[] getExtra() {
        return extra;
    }
 

}
