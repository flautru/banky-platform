package com.fabien.account_service.dto;

import java.util.UUID;

public record Customer (UUID id, String firstName, String lastName, String email){
}
