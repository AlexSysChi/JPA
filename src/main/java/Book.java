import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllBooks", query = "SELECT b FROM Book b"),
        @NamedQuery(name = "findBookH2G2", query = "SELECT b FROM Book b WHERE b.title ='H2G2'")
        })
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String title;
    private Float price;
    private String description;
    private String isbn;
    private Integer nbOfPage;
    private Boolean illustrations;

    public Book() {
    }

    Book(
            String title,
            String description,
            Float price,
            String isbn,
            Integer nbOfPage,
            Boolean illustrations
    ) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.isbn = isbn;
        this.nbOfPage = nbOfPage;
        this.illustrations = illustrations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNbOfPage() {
        return nbOfPage;
    }

    public void setNbOfPage(Integer nbOfPage) {
        this.nbOfPage = nbOfPage;
    }

    public Boolean getIllustrations() {
        return illustrations;
    }

    public void setIllustrations(Boolean illustrations) {
        this.illustrations = illustrations;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("\nBook:");
        sb.append("{\n\tid=").append(id);
        sb.append(", \n\ttitle='").append(title).append('\'');
        sb.append(", \n\tprice=").append(price);
        sb.append(", \n\tdescription='").append(description).append('\'');
        sb.append(", \n\tisbn='").append(isbn).append('\'');
        sb.append(", \n\tnbOfPage=").append(nbOfPage);
        sb.append(", \n\tillustrations=").append(illustrations);
        sb.append("\n}");
        return sb.toString();
    }
}