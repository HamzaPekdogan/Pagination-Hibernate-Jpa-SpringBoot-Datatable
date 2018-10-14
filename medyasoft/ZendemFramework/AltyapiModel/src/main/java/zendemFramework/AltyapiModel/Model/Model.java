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
package zendemFramework.AltyapiModel.Model;

import java.util.UUID;

/**
 * Model sınıfı.
 *
 * @author Hamza Pekdoğan
 */
public class Model implements ModelBase {

	protected UUID dbId;

	public UUID getDbId() {
		return dbId;
	}

	public void setDbId(UUID dbId) {
		this.dbId = dbId;
	}

}
