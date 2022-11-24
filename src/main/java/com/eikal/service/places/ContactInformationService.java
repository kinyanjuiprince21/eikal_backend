package com.eikal.service.places;

import com.eikal.models.places.ContactInformation;
import com.eikal.repository.places.ContactInformationRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactInformationService {

    private final ContactInformationRepository contactInformationRepository;

    public ContactInformationService(ContactInformationRepository contactInformationRepository) {
        this.contactInformationRepository = contactInformationRepository;
    }

    public ContactInformation save(ContactInformation contactInformation) {
        return contactInformationRepository.save(contactInformation);
    }
}
