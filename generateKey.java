import java.net.*; 
import java.io.*; 
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import sun.misc.*;
import java.io.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.lang.Exception;

class generateKey{
	public static void main(String[] args){
		try{
		  KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		  kpg.initialize(2048);
		  KeyPair kp = kpg.generateKeyPair();
		  Key pub = kp.getPublic();
		  Key pvt = kp.getPrivate();

		 // System.out.print(pub);
		  //System.out.print(pvt);
		}
		catch(NoSuchAlgorithmException e){

		}
	}
}
