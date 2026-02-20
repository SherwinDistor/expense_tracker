package com.sherwin.expense_tracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sherwin.expense_tracker.domain.dto.ProfileDto;
import com.sherwin.expense_tracker.service.ProfileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

  private final ProfileService profileService;

  @PostMapping("/register")
  public ResponseEntity<ProfileDto> registerProfile(@RequestBody ProfileDto profileDto) {
    ProfileDto registeredProfile = profileService.registerProfile(profileDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(registeredProfile);
  }

  @GetMapping("/activate")
  public ResponseEntity<String> activateProfile(@RequestParam String token) {
    profileService.activateToken(token);
    return ResponseEntity.status(HttpStatus.OK).body("Profile activated successfully");
  }
}
