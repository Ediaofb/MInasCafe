package com.minascafe.api.record;

import com.minascafe.api.entities.UserRole;

public record RegisterDTO(String login, String senha, UserRole role) {
}
