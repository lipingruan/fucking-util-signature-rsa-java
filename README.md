
# fucking-util-signature RSA加解密/签名验签 Java Demo

#### js端全局集成无需多余设置: [fucking-util-signature-rsa-pkcs1padding](https://github.com/lipingruan/fucking-util-signature-rsa-pkcs1padding)

#### 签名算法默认使用 `SHA256withRSA`

#### 前端加密重要设置
```javascript
let rsa = new util.Signature.RSA ( );

// 重要
rsa.keys.setOptions ( { encryptionScheme: 'pkcs1' } );
```

#### 后端加密重要设置
```java
// 重要一致
Cipher cipher = Cipher.getInstance ( "RSA/ECB/PKCS1Padding" );
```