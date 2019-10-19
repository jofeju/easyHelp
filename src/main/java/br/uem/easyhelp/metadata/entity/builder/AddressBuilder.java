package br.uem.easyhelp.metadata.entity.builder;

import br.uem.easyhelp.metadata.entity.Address;

/**
 * @author Douglas
 */
public final class AddressBuilder {
    private Long id;
    private String country;
    private String state;
    private String city;
    private String cep;
    private String neighborhood;
    private String street;
    private String number;
    private String complement;

    private AddressBuilder() {
    }

    public static AddressBuilder anAddress() {
        return new AddressBuilder();
    }

    public AddressBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public AddressBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public AddressBuilder withState(String state) {
        this.state = state;
        return this;
    }

    public AddressBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder withCep(String cep) {
        this.cep = cep;
        return this;
    }

    public AddressBuilder withNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
        return this;
    }

    public AddressBuilder withStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressBuilder withNumber(String number) {
        this.number = number;
        return this;
    }

    public AddressBuilder withComplement(String complement) {
        this.complement = complement;
        return this;
    }

    public Address build() {
        Address address = new Address();
        address.setId(id);
        address.setCountry(country);
        address.setState(state);
        address.setCity(city);
        address.setCep(cep);
        address.setNeighborhood(neighborhood);
        address.setStreet(street);
        address.setNumber(number);
        address.setComplement(complement);
        return address;
    }
}
