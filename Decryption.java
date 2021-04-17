import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class Decryption {

	public static void main(String[] args) {
		try {
			// Đọc file chứa private key
			FileInputStream fis = new FileInputStream("privateKeyDemo");
			byte[] b = new byte[fis.available()];
			fis.read(b);
			fis.close();

			// Tạo private key
			PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b);
			KeyFactory factory = KeyFactory.getInstance("RSA");
			PrivateKey priKey = factory.generatePrivate(spec);

			// Giải mã dữ liệu
			Cipher c = Cipher.getInstance("RSA");
			c.init(Cipher.DECRYPT_MODE, priKey);
			byte decryptOut[] = c.doFinal(Base64.getDecoder().decode(
					"D61hHe+1JkhpjxRM8GtacJOKXfmjFwnfmuhrjjk6OHh6f3AmC8EzLdiooL4kETK93T6vI6zo3Ep/iYuow/efpOGn6+QOQAF+azKmrmTp8nHlDYLA5krFIlV9eRN+zPRWBgwSNCU6LmmczrBt2P7vKJpP0VEGMJ4krzTsvOWc6szl0ROpIvK2loo2y/1qOFp4jLERa58Lc4zwSz+D4/vDmcQXqHfYndoZ9V2bMwe5pfI/VQmCM/CDw5KOQfpwqPSyow4pW7+bOo6iJ2WiM/xxUmXEHs/SDhEbKnePFgzf2bB7EKMN0Xb5YgNW2T8FHm+YdRdIH2rH9R/8k8dS5PmoVQ=="));
			System.out.println("Dữ liệu sau khi giải mã: " + new String(decryptOut));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
