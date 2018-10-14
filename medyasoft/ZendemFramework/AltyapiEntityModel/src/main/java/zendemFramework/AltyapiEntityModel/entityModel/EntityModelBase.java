/*
* Telif hakkı 2018 Türkiye Bilimsel ve Teknolojik Araştrıma Kurumu. 
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

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * The Class EntityModelBase.
 * @author Batuhan Çağlayan
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class EntityModelBase implements Serializable {

	/** The silindi. */
	@Column(name = "SILINDI_MI", nullable = false)
	protected boolean silindi;
	
	/** The olusma zamani. */
	@CreatedDate
	@Column(name = "OLUSMA_ZAMANI", nullable = false, updatable = false)
	protected long olusmaZamani;

	/** The son guncelleyen. */
	@LastModifiedBy
    @Column(name = "SON_GUNCELLEYEN")
	protected String sonGuncelleyenKullanici;
	
	/** The olusturan kullanici. */
	@CreatedBy
	@Column(name = "OLUSTURAN")
	protected String olusturanKullanici;	

	public boolean isSilindi() {
		return silindi;
	}

	public void setSilindi(boolean silindi) {
		this.silindi = silindi;
	}

	public long getOlusmaZamani() {
		return olusmaZamani;
	}

	public void setOlusmaZamani(long olusmaZamani) {
		this.olusmaZamani = olusmaZamani;
	}
	
	public String getSonGuncelleyenKullanici() {
		return sonGuncelleyenKullanici;
	}
	
	public void setSonGuncelleyenKullanici(String sonGuncelleyenKullanici) {
		this.sonGuncelleyenKullanici = sonGuncelleyenKullanici;
	}	

	public String getOlusturanKullanici() {
		return olusturanKullanici;
	}

	public void setOlusturanKullanici(String olusturanKullanici) {
		this.olusturanKullanici = olusturanKullanici;
	}
	
}
