//package com.ankursinha.backend.exception;
//
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//
//@EqualsAndHashCode(callSuper = true)
//@Data
//public class StudentNotFoundException extends RuntimeException{
//    private final String msg;
//}
package com.ankursinha.backend.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message) {
        super(message);
    }
}
