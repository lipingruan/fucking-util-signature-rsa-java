
# fucking-util-signature RSA加解密 Java Demo

#### 前端重要设置
```javascript
let rsa = new util.Signature.RSA ( );

// 重要
rsa.keys.setOptions ( { encryptionScheme: 'pkcs1' } );
```

#### 后端重要设置
```java
// 重要一致
Cipher cipher = Cipher.getInstance ( "RSA/ECB/PKCS1Padding" );
```