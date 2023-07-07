import java.security.SecureRandom;
import java.util.Base64;

public class Gen256RandomKey {
  //
  public static void main(String[] args) throws Exception {
    // make instance of SecureRandom
    SecureRandom random = new SecureRandom();

    // make byte array of 256 bits
    byte[] bytes = new byte[256];

    // fill the byte array with random bytes
    random.nextBytes(bytes);

    // make encodedKey string using Base64 encoding
    String encodedKey = Base64.getEncoder().encodeToString(bytes);

    // print the encodedKey
    System.out.println(encodedKey);

    // 9+iDFK/Xw9qnJp5R0hh6T5ZJ1S0JR0xBimOypI+AlJcf4s3Tbtrk7IQfxXZeeyh4bBt8J+S51LsikXZaLJ4TgoUZTsIJPzb8T95+dxGSJz2gzyV2kOTWK6Kdkmq33pThir5HVWcPhh0jDRubk/yn3jK/Dx0O/1jqxDqfcGgbI8Eh5wH3EUXQ2CnRt55bMPUl4qlmInLIMn7gHT/0hqjh21X86H0iSq0UqAPd29Ho0DhF7JMD60BzPg0IB5NCfmE2pXiKCTGv0qv3d2T4TOF4PMJWYnA9/Rc9Ze6NPlDXIGuLbwjF/mTbXIcw+8HS0FmzCI4FpoRQ8Rex2oEOsRPUVA==
  }
}
