package dev.rivaldi.qnprecruitmenttest;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Value
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
class UsersDto {
    long id;
    String firstname;
    String lastname;
    String email;
    LocalDate birthDate;
    Login login;
    Address address;
    String phone;
    String website;
    Company company;

    @Value
    @NoArgsConstructor(force = true)
    @RequiredArgsConstructor
    static class Address {
        String street;
        String suite;
        String city;
        String zipcode;
        Geo geo;
    }

    @Value
    @NoArgsConstructor(force = true)
    @RequiredArgsConstructor
    static class Geo {
        String lat;
        String lng;
    }

    @Value
    @NoArgsConstructor(force = true)
    @RequiredArgsConstructor
    static class Company {
        String name;
        String catchPhrase;
        String bs;
    }

    @Value
    @NoArgsConstructor(force = true)
    @RequiredArgsConstructor
    static class Login {
        String uuid;
        String username;
        String password;
        String md5;
        String sha1;
        OffsetDateTime registered;
    }
}
