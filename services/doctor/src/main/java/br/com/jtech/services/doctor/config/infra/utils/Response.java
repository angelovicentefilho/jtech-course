package br.com.jtech.services.doctor.config.infra.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static java.util.Objects.isNull;

public class Response<T> {

    public static <T> ResponseEntity<T> okOrNotFound(T body) {
        if (isNull(body)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(body);
    }

    public static <T> ResponseEntity<T> acceptedOrNotFound(T body) {
        if (isNull(body)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.accepted().body(body);
    }

    public static <T> ResponseEntity<T> createdOrBadRequest(String path, T body, Object... uriVariables) {
        if (isNull(body)) {
            return ResponseEntity.badRequest().build();
        }
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(path)
                .buildAndExpand(uriVariables)
                .toUri();
        return ResponseEntity.created(uri).body(body);
    }

    public static <T> ResponseEntity<T> createdOrBadRequest(T body, URI uri) {
        if (isNull(body)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.created(uri).body(body);
    }

    public static <T> ResponseEntity<T> createdOrBadRequest(T body) {
        if (isNull(body)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.created(null).body(body);
    }

    public static <T> ResponseEntity<T> noContentOrNotFound(T body) {
        if (isNull(body)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    public static <T> ResponseEntity<T> noContentOrBadRequest(T body) {
        if (isNull(body)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.noContent().build();
    }

    public static <T> ResponseEntity<T> noContentOrCreated(T body) {
        if (isNull(body)) {
            return ResponseEntity.created(null).build();
        }
        return ResponseEntity.noContent().build();
    }

    public static <T> ResponseEntity<T> noContentOrAccepted(T body) {
        if (isNull(body)) {
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.noContent().build();
    }

    public static <T> ResponseEntity<T> noContentOrOk(T body) {
        if (isNull(body)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }

    public static <T> ResponseEntity<T> noContentOrCreated(T body, URI uri) {
        if (isNull(body)) {
            return ResponseEntity.created(uri).build();
        }
        return ResponseEntity.noContent().build();
    }

}
