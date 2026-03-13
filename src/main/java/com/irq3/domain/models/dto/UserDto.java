package com.irq3.domain.models.dto;

import java.time.LocalDateTime;

public record UserDto(Long id, String name, LocalDateTime createdAt) {
}
