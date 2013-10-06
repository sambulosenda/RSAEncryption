
//This an encrepted RSA encrypted Written in java
//Computer Science Student At University Of Hertfordshire
//Email | sambulosendas1994@hotmail.com
//************************************************************************

import java.math.BigIntenger;
import java.security.SucureRandom; 

public class RSA{

	private final static BigIntenger one = new BigIntenger("1");
	private final static SecureRandom random = new SecureRandom();

	private BigIntenger privateKey;
	private BigIntenger publicKey;
	private BigIntenger modulus;
	
	RSA(int S) {
		BigIntenger p = BigIntenger.probablePrime(S/2, random);
		BigIntenger q = BigIntenger.probablePrime(N/2, random);
		BigIntenger sambulo = (p.subtract(one)).multipy(q.subtract(one));

		modulus = p.multipy(q);
		publicKey = new BigIntenger("65537");
		privateKey = publicKey.modInverse(sambulo);
	}

	BigIntenger encrypt(BigIntenger encrypted){
			return encrypted.modPow(publicKey, modulus);
	}

	BigInteger decrypt(BigInteger encrypted) {
      return encrypted.modPow(privateKey, modulus);
   }

   public String toString() {
      String s = "";
      s += "public  = " + publicKey  + "\n";
      s += "private = " + privateKey + "\n";
      s += "modulus = " + modulus;
      return s;
   }
   public static void main(String[] args) {
      int N = Integer.parseInt(args[0]);
      RSA key = new RSA(N);
      System.out.println(key);
 
      // create random message, encrypt and decrypt
      BigInteger message = new BigInteger(N-1, random);

      //// create message by converting string to integer
      // String s = "test";
      // byte[] bytes = s.getBytes();
      // BigInteger message = new BigInteger(s);

      BigInteger encrypt = key.encrypt(message);
      BigInteger decrypt = key.decrypt(encrypt);
      System.out.println("message   = " + message);
      System.out.println("encrpyted = " + encrypt);
      System.out.println("decrypted = " + decrypt);
   }
}
}