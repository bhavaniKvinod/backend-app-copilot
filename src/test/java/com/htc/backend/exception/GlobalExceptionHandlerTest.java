package com.htc.backend.exception;

import com.htc.backend.dto.response.ErrorResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {
    
    private GlobalExceptionHandler exceptionHandler;
    private WebRequest webRequest;
    
    @BeforeEach
    void setUp() {
        exceptionHandler = new GlobalExceptionHandler();
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/api/test");
        webRequest = new ServletWebRequest(request);
    }
    
    @Test
    void testHandleResourceNotFoundException() {
        ResourceNotFoundException exception = new ResourceNotFoundException("User", "id", 1L);
        
        ResponseEntity<ErrorResponse> response = exceptionHandler.handleResourceNotFoundException(exception, webRequest);
        
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(404, response.getBody().getStatus());
        assertEquals("Not Found", response.getBody().getError());
        assertTrue(response.getBody().getMessage().contains("User not found"));
    }
    
    @Test
    void testHandleDuplicateResourceException() {
        DuplicateResourceException exception = new DuplicateResourceException("User", "email", "test@example.com");
        
        ResponseEntity<ErrorResponse> response = exceptionHandler.handleDuplicateResourceException(exception, webRequest);
        
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(409, response.getBody().getStatus());
        assertEquals("Conflict", response.getBody().getError());
        assertTrue(response.getBody().getMessage().contains("already exists"));
    }
    
    @Test
    void testHandleBadRequestException() {
        BadRequestException exception = new BadRequestException("Invalid input data");
        
        ResponseEntity<ErrorResponse> response = exceptionHandler.handleBadRequestException(exception, webRequest);
        
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(400, response.getBody().getStatus());
        assertEquals("Bad Request", response.getBody().getError());
        assertEquals("Invalid input data", response.getBody().getMessage());
    }
    
    @Test
    void testHandleUnauthorizedException() {
        UnauthorizedException exception = new UnauthorizedException("Authentication required");
        
        ResponseEntity<ErrorResponse> response = exceptionHandler.handleUnauthorizedException(exception, webRequest);
        
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(401, response.getBody().getStatus());
        assertEquals("Unauthorized", response.getBody().getError());
        assertEquals("Authentication required", response.getBody().getMessage());
    }
    
    @Test
    void testHandleGlobalException() {
        Exception exception = new Exception("Unexpected error");
        
        ResponseEntity<ErrorResponse> response = exceptionHandler.handleGlobalException(exception, webRequest);
        
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(500, response.getBody().getStatus());
        assertEquals("Internal Server Error", response.getBody().getError());
        assertEquals("Unexpected error", response.getBody().getMessage());
    }
    
    @Test
    void testResourceNotFoundExceptionWithMessage() {
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");
        
        assertEquals("Resource not found", exception.getMessage());
    }
    
    @Test
    void testDuplicateResourceExceptionWithMessage() {
        DuplicateResourceException exception = new DuplicateResourceException("Duplicate entry");
        
        assertEquals("Duplicate entry", exception.getMessage());
    }
}
