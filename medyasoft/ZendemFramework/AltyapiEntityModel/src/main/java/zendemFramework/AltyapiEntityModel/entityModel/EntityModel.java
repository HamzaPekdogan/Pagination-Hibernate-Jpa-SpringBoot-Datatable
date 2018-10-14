/*
* Telif hakkı 2017 Türkiye Bilimsel ve Teknolojik Araştrıma Kurumu. 
* Tüm haklar saklıdır.
* 
* BU TELİF HAKKI DOSYA ÜST BİLGİSİNİ DEĞİŞTİRMEYİNİZ VEYA SİLMEYİNİZ.
*
* Bu kaynak kod sadece TÜBİTAK için TYBS Projesi kapsamında geliştirilmiştir; 
* değişiklik yapma, başka amaçlarda kullanılmak üzere kısmen veya tamamını 
* kopyalama ve/veya dağıtım yapma hakkınız bulunmamaktadır.
* 
* Daha fazla bilgi ve sorularınız için TÜBİTAK ile iletişime geçiniz.
*/
package zendemFramework.AltyapiEntityModel.entityModel;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class EntityModel extends EntityModelBase {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	/** guncelleme zamani. */
	@LastModifiedDate
	@Column(name = "GUNCELLEME_ZAMANI", nullable =  false)
	protected long guncellemeZamani;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getGuncellemeZamani() {
		return guncellemeZamani;
	}

	public void setGuncellemeZamani(long guncellemeZamani) {
		this.guncellemeZamani = guncellemeZamani;
	}
	
}
