package com.paypal.bfs.test.employeeserv.error;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ErrorsHandler {
    private String field;
    private String errorMessages;
}
