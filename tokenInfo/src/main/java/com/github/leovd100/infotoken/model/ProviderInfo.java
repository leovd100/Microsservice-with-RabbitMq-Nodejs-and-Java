package com.github.leovd100.infotoken.model;

import com.github.leovd100.infotoken.model.entity.InformationEntity;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;

import java.util.UUID;

@Table(name = "tb_provider_info")
@Entity
@Serdeable.Deserializable
@Serdeable.Serializable
public class ProviderInfo {

     @Id
     @GeneratedValue(strategy = GenerationType.UUID)
     private UUID id;
     private String city;
     private String region;
     private String country;
     private String org;

     @OneToOne(mappedBy = "providerInfo")
     private ProviderLocation providerLocation;

     public ProviderInfo(){}

     public ProviderInfo(String city, String region, String country, String org) {
          this.city = city;
          this.region = region;
          this.country = country;
          this.org = org;
     }

     public String getCity() {
          return city;
     }

     public void setCity(String city) {
          this.city = city;
     }

     public String getRegion() {
          return region;
     }

     public void setRegion(String region) {
          this.region = region;
     }

     public String getCountry() {
          return country;
     }

     public void setCountry(String country) {
          this.country = country;
     }

     public String getOrg() {
          return org;
     }

     public void setOrg(String org) {
          this.org = org;
     }

     @Override
     public String toString() {
          return "ProviderInfo{" +
                  ", city='" + city + '\'' +
                  ", region='" + region + '\'' +
                  ", country='" + country + '\'' +
                  ", org='" + org + '\'' +
                  '}';
     }
}
