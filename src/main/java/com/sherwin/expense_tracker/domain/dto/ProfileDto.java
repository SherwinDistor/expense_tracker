package com.sherwin.expense_tracker.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileDto {

  private UUID id;
  private String fullName;
  private String email;
  private String password;
  private String profileImageURL;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
