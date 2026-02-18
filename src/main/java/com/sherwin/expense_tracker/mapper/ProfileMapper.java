package com.sherwin.expense_tracker.mapper;

import org.springframework.stereotype.Component;

import com.sherwin.expense_tracker.domain.dto.ProfileDto;
import com.sherwin.expense_tracker.domain.entity.ProfileEntity;

@Component
public class ProfileMapper {
  public ProfileEntity toEntity(ProfileDto profileDto) {
    return ProfileEntity.builder()
        .id(profileDto.getId())
        .fullName(profileDto.getFullName())
        .email(profileDto.getEmail())
        .profileImageURL(profileDto.getProfileImageURL())
        .createdAt(profileDto.getCreatedAt())
        .updatedAt(profileDto.getUpdatedAt())
        .build();
  }
}
