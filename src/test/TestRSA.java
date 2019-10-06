package test;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class TestRSA {

	// 和前端一致的公私钥
	private static String publicKeyStr = ("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDLNMsGTyoNcr3oFbldY9cgtGkS\n" +
			"PDg31hutvkBSKy9y/jhOnuZ8490LAopCn99yvGJa3AlO9c5HqfSNG/zg8cSnVkB+\n" +
			"+iifwNddWU9tIXidZGYnQpGsCQzPVxh3tEurq6hRZJfe/OVQMX0pa0tmtGmn16zn\n" +
			"mM5YggvPD+u0Iinr5wIDAQAB").replaceAll("\n","");
	
	private static String privateKeyStr = ("MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAMs0ywZPKg1yvegV\n" +
			"uV1j1yC0aRI8ODfWG62+QFIrL3L+OE6e5nzj3QsCikKf33K8YlrcCU71zkep9I0b\n" +
			"/ODxxKdWQH76KJ/A111ZT20heJ1kZidCkawJDM9XGHe0S6urqFFkl9785VAxfSlr\n" +
			"S2a0aafXrOeYzliCC88P67QiKevnAgMBAAECgYBjc+wlo1sWh+DQFMnLHlEsrX97\n" +
			"MEPnd//F8gYy8PXhFvDh8b0mxLLrb4vRfcNzuSV+CJD5ty4FPvX0lg0W3tz6lX1U\n" +
			"MVaGJqdhQAfW9AF8BgZMCjReLDMy7I8OnsLDBsL6zWk5B/EJAFRT4MF9nMZ/U+ix\n" +
			"QL3xVIvc6+7KDTxtGQJBAPJnZDDipXgaRQYzbA4sdU8owMiOnnSdji3EfhOZBB6F\n" +
			"YVjpkL5JaZEoE26Wa5K7STk2WDyKI8tYM9Jo/3PLilUCQQDWmpLgHC8H9U7biG4i\n" +
			"DSj08/S3GPVshGVf31Gv0cJhV9NBBQjq8MhLYoRJtyxDJVR4tiE1BVYw+TUhFWDO\n" +
			"NdFLAkEAjGWBzCaZfBSLAepqnVL2puCNuBuSfyx6GtwBwcwQbLUICv1Mjknq0N4L\n" +
			"UzPgHl5HLNHjDT1dOfteGHIj8qdi+QJBAJzqiVq1QO5gwDhlmaHsXXY+q0D2Tv36\n" +
			"EOX5NJGKnsbuoNl6BPtE9C+q6W+9L/Ao64sYIU/ThyJoFiEKsK4XS+ECQQDObqQ8\n" +
			"m2Tz+PKWgqSnRf1UDMXOygO1Gt2gvnUnLV/QZyTH0pI/6PPNqlKB2kp8xWIiNA0G\n" +
			"554YR2gjUGL5dEzg").replaceAll("\n", "");
	
	public static void main (String[] args) {
		
		signTest();
		
		crypTest();
	}
	
	// 签名验签测试
	public static void signTest ( ) {
		try {

			System.out.println ( "\n======签名验签测试中======\n" );
			// 原文
			String source = "hello world";
			
			// JAVA端签名
			// String signBase64 = RSAUtil.privateSign(source.getBytes(), privateKeyStr);
			// 签名结果
			// System.out.println("JAVA私钥签名并Base64编码的结果：" + signBase64);
			
			// 前端的签名字符串
			String signBase64 = "PnlWHhmGIXDnigRL24Rpiw075YMrxruzhoavOm4FLRFMRGPvbf8BZqFQ7pj5jDm80ExlXTgbkvIKa7umJIhT7dGI1KL4HI1+LS8Yp+0Sczv/i1iZgGK9hgGywlERZ2QnwsB8rz5OrWf64d27Kx+hqCv86ompCXyPbsBNV82zHvM=";
			System.out.println("私钥签名并Base64编码的结果：" + signBase64);

			//用公钥验签
			boolean verified = RSAUtil.publicVerify(source.getBytes(), publicKeyStr, signBase64);
			//是否通过
			System.out.println("签名是否正确: " + verified);

			System.out.println ( "\n======签名验签测试结束======\n" );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

	// 加密解密测试
	public static void crypTest(){
		try {
			System.out.println ( "\n======加密解密测试中======\n" );
			//生成RSA公钥和私钥，并Base64编码
			// KeyPair keyPair = RSAUtil.getKeyPair();
			// String publicKeyStr = RSAUtil.getPublicKey(keyPair);
			// String privateKeyStr = RSAUtil.getPrivateKey(keyPair);

			
			System.out.println("RSA公钥Base64编码:" + publicKeyStr);
			System.out.println("RSA私钥Base64编码:" + privateKeyStr);
			
			//=================客户端=================
			//hello, i am infi, good night!加密
			// String message = "hello, i am infi, good night!";
			//将Base64编码后的公钥转换成PublicKey对象
			// PublicKey publicKey = RSAUtil.string2PublicKey(publicKeyStr);
			//用公钥加密
			// byte[] publicEncrypt = RSAUtil.publicEncrypt(message.getBytes(), publicKey);
			//加密后的内容Base64编码
			// String byte2Base64 = RSAUtil.byte2Base64(publicEncrypt);

			// 前端的加密字符串
			String byte2Base64 = "K0yS/5SDrmyjNjWuaSq6YPmDc0IJ+Nl4FeTjK6Yw21C40vhpQH2MCXY2wZ3eS/4U6RGhn/Wwtx+fgTP2/uKe3medYpCoroJyZ+VwCivN0xSJUVTtbq4dEu9zIuH8IiBMvKH2WeBYCR55DvrgkPssfosStEtX88+AoVFN/aZhtRo=";
			System.out.println("公钥加密并Base64编码的结果：" + byte2Base64);
			
			
			
			//===================服务端================
			//将Base64编码后的私钥转换成PrivateKey对象
			PrivateKey privateKey = RSAUtil.string2PrivateKey(privateKeyStr);
			//加密后的内容Base64解码
			byte[] base642Byte = RSAUtil.base642Byte(byte2Base64);
			//用私钥解密
			byte[] privateDecrypt = RSAUtil.privateDecrypt(base642Byte, privateKey);
			//解密后的明文
			System.out.println("解密后的明文: " + new String(privateDecrypt));
			System.out.println ( "\n======加密解密结束======\n" );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
}
