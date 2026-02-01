package com.easybytes.accounts.Exception;

public class ResourceNotFoundException extends RuntimeException
{
    public ResourceNotFoundException(String resourceName,String fieldName,String fieldValue) {

      super(String.format("Resource %s not found for the given data %s:%s", resourceName, fieldName, fieldValue));

    }
}
