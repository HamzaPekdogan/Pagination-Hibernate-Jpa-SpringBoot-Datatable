package medya.soft.com.EntityModel;

import zendemFramework.AltyapiEntityModel.entityModel.EntityModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity // JPA DB MAP işlemi
@Table(name = "STUDENT_CLASS") // DB Tablo adı değiştirme
public class StudentClassEntityModel extends EntityModel { // Nesne Yönelimli Programlama Temel Özelliği (Inheritance)
    @Column(name = "NAME") // DB Kolon Adı Değiştirme
    private String name;

    public String getName() { // Nesne Yönelimli Programlama Temel Özelliği (Encapsulation)
        return name;
    } // Nesne Yönelimli Programlama Temel Özelliği (Encapsulation)

    public void setName(String name) { // Nesne Yönelimli Programlama Temel Özelliği (Encapsulation)
        this.name = name;
    } // Nesne Yönelimli Programlama Temel Özelliği (Encapsulation)
}
