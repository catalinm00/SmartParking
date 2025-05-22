package com.smartparking.smartparking.application.response;

import com.smartparking.smartparking.application.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class VoidResponse implements Response {
}
