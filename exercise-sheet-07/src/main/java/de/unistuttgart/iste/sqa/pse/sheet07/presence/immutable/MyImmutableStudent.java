package de.unistuttgart.iste.sqa.pse.sheet07.presence.immutable;

public final class MyImmutableStudent {
    private String name;
    private long matrikelnumber;
    private final Address address;

    public MyImmutableStudent(final String name, final long matrikelnumber, final Address address) {
        this.name = name;
        this.matrikelnumber = matrikelnumber;
        this.address = new Address(address.getStreetName(), address.getStreetNumber(), address.getPostalCode(), address.getCityName());
    }

    public String getName() {
        return this.name;
    }

    public long getMatrikelnumber() {
        return this.matrikelnumber;
    }

    public Address getAddress() {
        return new Address(
                this.address.getStreetName(),
                this.address.getStreetNumber(),
                this.address.getPostalCode(),
                this.address.getCityName()
        );
    }
}



