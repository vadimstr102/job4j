package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;


public class ProfilesTest {
    Profiles profiles = new Profiles();
    List<Profile> profileList = new ArrayList<>();
    Address address1 = new Address("Moscow", "Lenina", 20, 15);
    Address address2 = new Address("Novosibirsk", "Koroleva", 36, 68);
    Address address3 = new Address("St.Peterburg", "Polevaya", 98, 24);
    Address address4 = new Address("Sochi", "Mira", 18, 23);
    Address address5 = new Address("Ufa", "Oktyabrya", 83, 80);

    @Before
    public void addresses() {
        profileList.add(new Profile(address1));
        profileList.add(new Profile(address2));
        profileList.add(new Profile(address3));
        profileList.add(new Profile(address4));
        profileList.add(new Profile(address5));
    }

    @Test
    public void whenCollectAddress() {
        List<Address> result = profiles.collect(profileList);
        List<Address> expected = Arrays.asList(address1, address2, address3, address4, address5);
        Assert.assertThat(result, is(expected));
    }
}
