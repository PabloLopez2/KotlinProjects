import java.security.*
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec
import java.util.*
import javax.crypto.Cipher

const val ALGORITHM = "RSA"

fun main() {

    val n = generateKeys()
    val publica = n.first
    val privada = n.second

    var opcion = 1

    while(opcion != 0) {
        println("Pulsa 1 para encriptar, pulsa 2 para desencriptar o pulsa 3 para salir.")
        opcion = readln().toInt()

        if (opcion == 1) {
            println()
            println("Clave publica: $publica")
            println("escribe mensaje para cifrar")
            val mensaje1 = readln()
            println("Clave publica del destinatario")
            val publica2 = readln()
            val c = encrypt(mensaje1, publica2)
            println("Tu mensaje cifrado: $c")

        }
        if (opcion == 2) {
            println()
            println("Clave publica: $publica")
            println("escribe mensaje cifrado")
            val mensaje2 = readln()
            println(decrypt(mensaje2, privada))
        }
        if (opcion == 3)
            break
    }
}

/**
 * Generates a pair of linked keys.
 *
 * Result: Pair(PublicKey, PrivateKey)
 */
fun generateKeys(): Pair<String, String> {
    val keyGen = KeyPairGenerator.getInstance(ALGORITHM).apply {
        initialize(512)
    }

    // Key generation
    val keys = keyGen.genKeyPair()

    // Transformation to String (well encoded)
    val publicKeyString = Base64.getEncoder().encodeToString(keys.public.encoded)
    val privateKeyString = Base64.getEncoder().encodeToString(keys.private.encoded)

    return Pair(publicKeyString, privateKeyString)
}

/**
 * Given a text message and the PublicKey of the recipient,
 * this function encrypts the message so that only the owner
 * of the PrivateKey can read it.
 *
 * Result: Encrypted(message)
 */
fun encrypt(message: String, publicKey: String): String {
    // From a String, we obtain the Public Key
    val publicBytes = Base64.getDecoder().decode(publicKey)
    val decodedKey = KeyFactory.getInstance(ALGORITHM).generatePublic(X509EncodedKeySpec(publicBytes))

    // With the public, we encrypt the message
    val cipher = Cipher.getInstance(ALGORITHM).apply {
        init(Cipher.ENCRYPT_MODE, decodedKey)
    }
    val bytes = cipher.doFinal(message.encodeToByteArray())
    return String(Base64.getEncoder().encode(bytes))
}

/**
 * This function decrypts the encrypted message. It requires the PrivateKey complementary to
 * the PublicKey used to encrypt the message.
 *
 * Result: The original message
 */
fun decrypt(encryptedMessage: String, privateKey: String): String {
    // From a String, we obtain the Private Key
    val publicBytes = Base64.getDecoder().decode(privateKey)
    val decodedKey = KeyFactory.getInstance(ALGORITHM).generatePrivate(PKCS8EncodedKeySpec(publicBytes))

    // Knowing the Private Key, we can decrypt the message
    val cipher = Cipher.getInstance(ALGORITHM).apply {
        init(Cipher.DECRYPT_MODE, decodedKey)
    }
    val bytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage))
    return String(bytes)
}