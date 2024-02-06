package org.example.mafiawebsocket.commonutil;


import com.google.common.hash.Hashing;
import org.springframework.context.annotation.Bean;

import java.nio.charset.StandardCharsets;

public class ShaUtil {

    public String sha256Encode(String password){

        return Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8).toString();
    }
}
