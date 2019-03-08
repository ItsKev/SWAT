package ch.hslu.edu.enapp.webshop.converter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

@Converter
public class PasswordConverter implements AttributeConverter<String, String> {
    private static final Logger logger = LogManager.getLogger(PasswordConverter.class);

    @Override
    public String convertToDatabaseColumn(String passwordPlain) {
        try {
            final MessageDigest md = MessageDigest.getInstance("SHA-256");
            final byte[] digest = md.digest(passwordPlain.getBytes(StandardCharsets.UTF_8));
            final String passwordHash = (new HexBinaryAdapter()).marshal(digest);

            logger.info(passwordHash);
            return passwordHash;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String convertToEntityAttribute(String passwordHash) {
        logger.info("hash:" + passwordHash);
        return passwordHash;
    }
}
