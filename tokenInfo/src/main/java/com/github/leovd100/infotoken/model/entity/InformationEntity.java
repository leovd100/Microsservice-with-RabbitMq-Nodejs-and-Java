package com.github.leovd100.infotoken.model.entity;

import com.github.leovd100.infotoken.model.ProviderInfo;
import com.github.leovd100.infotoken.model.ProviderLocation;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tb_information")
@Serdeable
public class InformationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String token;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "informationEntity", referencedColumnName = "id")
    private ProviderLocation providerLocation;
    private String city;
    private String region;
    private String mailToken;
    private String country;
    private String org;
    private String vpn;
    private String browserInfo;

    public InformationEntity() {}

    public InformationEntity(UUID id, String token, ProviderLocation providerLocation, String city, String region, String mailToken, String country, String org, String vpn, String browserInfo) {
        this.id = id;
        this.token = token;
        this.providerLocation = providerLocation;
        this.city = city;
        this.region = region;
        this.mailToken = mailToken;
        this.country = country;
        this.org = org;
        this.vpn = vpn;
        this.browserInfo = browserInfo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ProviderLocation getProviderLocation() {
        return providerLocation;
    }

    public void setProviderLocation(ProviderLocation providerLocation) {
        this.providerLocation = providerLocation;
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

    public String getMailToken() {
        return mailToken;
    }

    public void setMailToken(String mailToken) {
        this.mailToken = mailToken;
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

    public String getVpn() {
        return vpn;
    }

    public void setVpn(String vpn) {
        this.vpn = vpn;
    }

    public String getBrowserInfo() {
        return browserInfo;
    }

    public void setBrowserInfo(String browserInfo) {
        this.browserInfo = browserInfo;
    }

    @Override
    public String toString() {
        return "InformationEntity{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", providerLocation=" + providerLocation +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", mailToken='" + mailToken + '\'' +
                ", country='" + country + '\'' +
                ", org='" + org + '\'' +
                ", vpn='" + vpn + '\'' +
                ", browserInfo='" + browserInfo + '\'' +
                '}';
    }
}
