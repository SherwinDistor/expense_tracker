package com.sherwin.expense_tracker.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sherwin.expense_tracker.domain.dto.ProfileDto;
import com.sherwin.expense_tracker.domain.entity.ProfileEntity;
import com.sherwin.expense_tracker.mapper.ProfileMapper;
import com.sherwin.expense_tracker.repository.ProfileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileService {

  private final ProfileRepository profileRepository;
  private final ProfileMapper profileMapper;

  public ProfileDto registerProfile(ProfileDto profileDto) {
    ProfileEntity newProfile = profileMapper.toEntity(profileDto);
    newProfile.setActivationToken(UUID.randomUUID().toString());
    ProfileEntity savedProfile = profileRepository.save(newProfile);

    return profileMapper.toDto(savedProfile);
  }
}
