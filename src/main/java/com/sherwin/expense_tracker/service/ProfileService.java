package com.sherwin.expense_tracker.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sherwin.expense_tracker.domain.dto.ProfileDto;
import com.sherwin.expense_tracker.domain.entity.ProfileEntity;
import com.sherwin.expense_tracker.exception.ProfileNotFoundException;
import com.sherwin.expense_tracker.mapper.ProfileMapper;
import com.sherwin.expense_tracker.repository.ProfileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileService {

  private final ProfileRepository profileRepository;
  private final ProfileMapper profileMapper;
  private final EmailService emailService;

  private String baseUrl = "http://localhost:8080";

  public ProfileDto registerProfile(ProfileDto profileDto) {
    ProfileEntity newProfile = profileMapper.toEntity(profileDto);
    newProfile.setActivationToken(UUID.randomUUID().toString());
    ProfileEntity savedProfile = profileRepository.save(newProfile);

    // Send activation email
    String activationLink = baseUrl + "/api/v1/profile/activate?token=" + savedProfile.getActivationToken();
    String subject = "Activate your Money Manager account";
    String body = "Click on the following link to activate your account: " + activationLink;

    emailService.sendEmail(savedProfile.getEmail(), subject, body);

    return profileMapper.toDto(savedProfile);
  }

  public void activateToken(String activationToken) {
    Optional<ProfileEntity> profileOp = profileRepository.findByActivationToken(activationToken);
    profileOp.map(profile -> {
      profile.setIsActive(true);
      return profileRepository.save(profile);
    }).orElseThrow(() -> new ProfileNotFoundException("Activation token not found or already used"));

  }
}
