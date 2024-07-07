package com.github.leovd100.infotoken.model;

import com.github.leovd100.infotoken.model.entity.InformationEntity;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;

import java.util.UUID;

@Table(name = "tb_location")
@Entity
@Serdeable.Deserializable
@Serdeable.Serializable
public class ProviderLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(mappedBy = "providerLocation")
    private InformationEntity informationEntity;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "providerLocation", referencedColumnName = "id")
    private ProviderInfo providerInfo;

    public ProviderLocation(){}

    public ProviderLocation(ProviderInfo providerInfo) {
        this.providerInfo = providerInfo;
    }

    public ProviderInfo getProviderInfo() {
        return providerInfo;
    }

    public void setProviderInfo(ProviderInfo providerInfo) {
        this.providerInfo = providerInfo;
    }

    @Override
    public String toString() {
        return "ProviderLocation{" +
                "providerInfo=" + providerInfo +
                '}';
    }
}
