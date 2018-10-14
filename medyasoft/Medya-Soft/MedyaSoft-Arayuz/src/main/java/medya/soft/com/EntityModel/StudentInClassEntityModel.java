package medya.soft.com.EntityModel;

import zendemFramework.AltyapiEntityModel.entityModel.EntityModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * Hibernate özelliklerinden biri olan onetomany manytomany gibi annotation kullanmadım.
 * Çünkü bağlantıların sistemi yavaşlattığı görülmektedir.
 * Bu ilişkiyi kendi kontrolüm altına aldım.
 * Cascade gibi bağlantılı işlemler biraz yük getirecek ancak daha hızlı çalışacaktır.
 */


@Entity // JPA DB MAP işlemi
@Table(name = "STUDENT_CLASS_IN") // DB Tablo adı değiştirme
public class StudentInClassEntityModel extends EntityModel { // Nesne Yönelimli Programlama Temel Özelliği (Inheritance)
    @Column(name = "STUDENT_UUID") // DB Kolon Adı Değiştirme
    private String studentUuid;

    @Column(name = "STUDENT_CLASS_UUID") // DB Kolon Adı Değiştirme
    private String studentClassUuid;

    public String getStudentUuid() { // Nesne Yönelimli Programlama Temel Özelliği (Encapsulation)
        return studentUuid;
    }

    public void setStudentUuid(String studentUuid) { // Nesne Yönelimli Programlama Temel Özelliği (Encapsulation)
        this.studentUuid = studentUuid;
    }

    public String getStudentClassUuid() { // Nesne Yönelimli Programlama Temel Özelliği (Encapsulation)
        return studentClassUuid;
    }

    public void setStudentClassUuid(String studentClassUuid) { // Nesne Yönelimli Programlama Temel Özelliği (Encapsulation)
        this.studentClassUuid = studentClassUuid;
    }
}
